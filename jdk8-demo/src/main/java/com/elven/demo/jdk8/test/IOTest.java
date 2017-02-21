package com.elven.demo.jdk8.test;

import java.io.*;

/**
 * Created by elven on 2016/10/5.
 */
public class IOTest {
    public static void main(String[] args) throws IOException {
//        testfile();
//        fileInputStreamTest2(new File("E:\\temp\\20161014\\20150504.log"));
//        readFileByBufferedInputStream(new File("E:\\temp\\20161014\\20150504.log"));
//        copyFileByFileOutputStream(new File("E:\\temp\\20161014\\20150504.log"));
//        copyFile(new File("E:\\temp\\20161014\\20150504.log"));
        testfile();
    }

    public static void testfile() throws IOException {
        File file1 = new File(".\\test1.txt");
        File file2 = new File("E:\\code\\IdeaProjects\\spring-boot-demo\\.\\test1.txt");
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getCanonicalPath());
        System.out.println(file2.getPath());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getCanonicalPath());
    }

    public static void fileInputStreamTest1(File file) {
        FileInputStream fis = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            fis = new FileInputStream(file);

            byte[] buffer = new byte[1024];

            int bytesRead = 0;

            while ((bytesRead = fis.read(buffer, 0, buffer.length)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileInputStreamTest2(File file) {
        FileInputStream fis = null;
        try {
            StringBuilder sb = new StringBuilder("");
            fis = new FileInputStream(file);

            byte[] buffer = new byte[1024];

            int bytesRead = 0;

            while ((bytesRead = fis.read(buffer, 0, buffer.length)) != -1) {
                sb.append(new String(buffer));
            }

            System.out.println(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFileByBufferedInputStream(File file) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;

        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];

            int bytesRead = 0;

            while((bytesRead = bis.read(buffer, 0, buffer.length)) != -1){
                baos.write(buffer, 0, bytesRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
                bis.close();
                if(baos != null) baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void copyFileByFileOutputStream(File file) throws IOException {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream(file.getCanonicalPath() + ".bak");
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int bytesRead = 0;

            while((bytesRead = bis.read(buffer, 0, buffer.length)) != -1){
                bos.write(buffer, 0, bytesRead);
            }

            bos.flush();

            System.out.println(":::::end");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fis != null) fis.close();
            if(fos != null) fos.close();
        }
    }

    public static void copyFile(File file){
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(file));
//            bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()+".bak1"));
            bw = new BufferedWriter(new FileWriter(file.getCanonicalPath()+".bak2"));
//            bw = new BufferedWriter(new FileWriter("E:\\temp\\20161014\\20150504.log.bak"));

            String line = null;
            while((line = br.readLine()) != null){
                bw.write(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
