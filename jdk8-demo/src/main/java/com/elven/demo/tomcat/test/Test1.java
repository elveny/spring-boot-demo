package com.elven.demo.tomcat.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Administrator on 2016/10/8.
 */
public class Test1 {
    /**
     * System property replacement in the given string.
     *
     * @param str The original string
     * @return the modified string
     */
    protected static String replace(String str) {
        // Implementation is copied from ClassLoaderLogManager.replace(),
        // but added special processing for catalina.home and catalina.base.
        String result = str;
        int pos_start = str.indexOf("${");
        if (pos_start >= 0) {
            StringBuilder builder = new StringBuilder();
            int pos_end = -1;
            while (pos_start >= 0) {
                builder.append(str, pos_end + 1, pos_start);
                pos_end = str.indexOf('}', pos_start + 2);
                if (pos_end < 0) {
                    pos_end = pos_start - 1;
                    break;
                }
                String propName = str.substring(pos_start + 2, pos_end);
                String replacement;
                if (propName.length() == 0) {
                    replacement = null;
                } else if ("catalina.home".equals(propName)) {
                    replacement = "getCatalinaHome()";
                } else if ("catalina.base".equals(propName)) {
                    replacement = "getCatalinaBase()";
                } else {
                    replacement = System.getProperty(propName);
                }
                if (replacement != null) {
                    builder.append(replacement);
                } else {
                    builder.append(str, pos_start, pos_end + 1);
                }
                pos_start = str.indexOf("${", pos_end + 1);
            }
            builder.append(str, pos_end + 1, str.length());
            result = builder.toString();
        }
        return result;
    }



    public static void main(String[] args) throws MalformedURLException {
//        System.out.println(replace("\"${catalina.base}/lib\",\"${catalina.base}/lib/*.jar\",\"${catalina.home}/lib\",\"${catalina.home}/lib/*.jar\""));

        System.out.println(Thread.currentThread().getName());
        URL[] urls = new URL[10];
        urls[0]= new URL("E:\\Program Files\\apache-tomcat-8.0.9\\lib\\catalina.jar");
        Thread.currentThread().setContextClassLoader(new URLClassLoader(urls));
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
