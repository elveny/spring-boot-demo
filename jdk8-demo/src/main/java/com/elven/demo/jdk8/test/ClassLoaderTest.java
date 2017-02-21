package com.elven.demo.jdk8.test;

import java.net.URL;

/**
 * Created by Administrator on 2016/10/12.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
