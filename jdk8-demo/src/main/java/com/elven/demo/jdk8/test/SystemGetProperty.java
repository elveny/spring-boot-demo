package com.elven.demo.jdk8.test;

/**
 * Created by elven on 2016/10/5.
 */
public class SystemGetProperty {
    public static void main(String[] args) {
        String[] keys = new String[] { "java.version", "java.vendor",
                "java.vendor.url", "java.home",
                "java.vm.specification.version",
                "java.vm.specification.vendor", "java.vm.specification.name",
                "java.vm.version", "java.vm.vendor", "java.vm.name",
                "java.specification.version", "java.specification.vendor",
                "java.specification.name", "java.class.version",
                "java.class.path", "java.library.path", "java.io.tmpdir",
                "java.compiler", "java.ext.dirs", "os.name", "os.arch",
                "os.version", "file.separator", "path.separator",
                "line.separator", "user.name", "user.home", "user.dir" };

        int size = keys.length;

        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + ": " + System.getProperty(keys[i]));
        }
        System.out.println(System.getProperty("sun.boot.class.path"));

    }
}
