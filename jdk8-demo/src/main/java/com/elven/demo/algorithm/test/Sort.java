package com.elven.demo.algorithm.test;

import java.util.Random;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Sort {
    public static void main(String[] args) {
        int n = 5;
        int[] array = random(n);
//        int[] array = {2, 1, 3, 4};
        System.out.println("::::::before::::::");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.println("::::::sort::::::");

//        sortTest(array);
//        sortInsert(array);
        sortSelect(array);
//        sortBubble(array);

        System.out.println("::::::after::::::");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] random(int n) {
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = new Random().nextInt(1000);
        }

        return array;
    }

    public static void sortTest(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

    }

    /**
     * 插入排序：
     * 插入排序的基本思想是在遍历数组的过程中，
     * 假设在序号 i 之前的元素即 [0..i-1] 都已经排好序，
     * 本趟需要找到 i 对应的元素 x 的正确位置 k ，
     * 并且在寻找这个位置 k 的过程中逐个将比较过的元素往后移一位，
     * 为元素 x “腾位置”，最后将 k 对应的元素值赋为 x ，
     * 一般情况下，插入排序的时间复杂度和空间复杂度分别为 O(n2 ) 和 O(1)。
     *
     * @param array
     * @return
     */
    public static int[] sortInsert(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];

            int j;
            for (j = i - 1; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;

        }
        return array;
    }

    /**
     * 选择排序：
     * 选择排序的基本思想是遍历数组的过程中，
     * 以 i 代表当前需要排序的序号，则需要在剩余的 [i…n-1] 中找出其中的最小值，
     * 然后将找到的最小值与 i 指向的值进行交换。
     * 因为每一趟确定元素的过程中都会有一个选择最大值的子流程，
     * 所以人们形象地称之为选择排序。
     * 选择排序的时间复杂度和空间复杂度分别为 O(n2 ) 和 O(1) 。
     *
     * @param array
     * @return
     */
    public static int[] sortSelect(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int miniPost = i;
            for (int m = i + 1; m < length; m++) {
                if (array[m] < array[miniPost]) {
                    miniPost = m;
                }
            }

//            if (array[i] > array[miniPost]) {
            if (i != miniPost) {
                int temp;
                temp = array[i];
                array[i] = array[miniPost];
                array[miniPost] = temp;
//            }
            }
        }
        return array;
    }

    /**
     * 冒泡排序：
     * 冒泡排序是將比較大的數字沉在最下面，较小的浮在上面
     *
     * @param array
     * @return
     */
    public static int[] sortBubble(int[] array) {
        int length = array.length;
        int temp;
        // 第一层循环:表明比较的次数, 比如 length 个元素,比较次数为 length-1 次（肯定不需和自己比）
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 快速排序：
     * 通过一趟排序将待排记录分割成独立的两部分,
     * 其中一部分记录的关键字均比另一部分的关键字小,
     * 则可以分别对这两部分记录继续进行排序,已达到整个序列有序的目的，
     * 本质就是,找一个基位(枢轴,分水岭,作用是左边的都比它小,右边的都比它大.
     * 可随机,取名base，首先从序列最右边开始找比base小的,如果小,换位置,
     * 从而base移到刚才右边(比较时比base小)的位置(记为临时的high位),* 这样base右边的都比base大。
     * 然后,从序列的最左边开始找比base大的，如果大,换位置,
     * 从而base移动到刚才左边(比较时比base大)的位置(记为临时的low位),这样base左边的都比base小，
     * 循环以上两步,直到 low == heigh, 这使才真正的找到了枢轴,分水岭. 返回这个位置,分水岭左边和右边的序列,分别再来递归。
     * @param int[] 未排序数组
     * @return int[] 排完序数组
     */
    public int[] sortQuick(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    private int[] quickSort(int[] arr, int low, int heigh) {
        if (low < heigh) {
            int division = partition(arr, low, heigh);
            quickSort(arr, low, division - 1);
            quickSort(arr, division + 1, heigh);
        }
        return arr;
    }

    // 分水岭,基位,左边的都比这个位置小,右边的都大
    private int partition(int[] arr, int low, int heigh) {
        int base = arr[low]; //用子表的第一个记录做枢轴(分水岭)记录
        while (low < heigh) { //从表的两端交替向中间扫描
            while (low < heigh && arr[heigh] >= base) {
                heigh--;
            }
            // base 赋值给 当前 heigh 位,base 挪到(互换)到了这里,heigh位右边的都比base大
            swap(arr, heigh, low);
            while (low < heigh && arr[low] <= base) {
                low++;
            }
            // 遇到左边比base值大的了,换位置
            swap(arr, heigh, low);
        }
        // now low = heigh;
        return low;
    }

    private void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
