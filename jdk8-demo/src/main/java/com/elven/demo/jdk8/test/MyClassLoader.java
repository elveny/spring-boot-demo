package com.elven.demo.jdk8.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLStreamHandlerFactory;

/**
 * Created by Administrator on 2016/10/12.
 */
public class MyClassLoader extends java.net.URLClassLoader {
    public MyClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    public MyClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }


//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        byte[] data = loadClassData(name);
//        return defineClass(name, data, 0, data.length);
//    }
//
//    private byte[] readFileByBufferedInputStream(File file) {
//        FileInputStream fis = null;
//        BufferedInputStream bis = null;
//        ByteArrayOutputStream baos = null;
//
//        try {
//            fis = new FileInputStream(file);
//            bis = new BufferedInputStream(fis);
//            baos = new ByteArrayOutputStream();
//
//            byte[] buffer = new byte[1024];
//
//            int bytesRead = 0;
//
//            while((bytesRead = bis.read(buffer, 0, buffer.length)) != -1){
//                baos.write(buffer, 0, bytesRead);
//            }
//
//            return baos.toByteArray();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                fis.close();
//                bis.close();
//                if(baos != null) baos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return null;
//    }
//
//
//    private byte[] loadClassData(String name){
//        byte[] data = readFileByBufferedInputStream(new File(name));
//        return data;
//    }

    private static URL buildClassLoaderUrl(File file) throws MalformedURLException {
        // Could be a directory or a file
        String fileUrlString = file.toURI().toString();
        fileUrlString = fileUrlString.replaceAll("!/", "%21/");
        return new URL(fileUrlString);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        URL[] urls = new URL[1];
        File file = new File("E:\\tools\\maven\\repository\\com\\elven\\demo\\maven-demo-quickstart\\0.0.1-SNAPSHOT\\maven-demo-quickstart-0.0.1-SNAPSHOT.jar");
        URL url = buildClassLoaderUrl(file.getCanonicalFile());
        urls[0] = url;
        MyClassLoader loader = new MyClassLoader(urls);
//        MyClassLoader loader = doPrivileged(
//                new PrivilegedAction<URLClassLoader>() {
//                    @Override
//                    public URLClassLoader run() {
//                            return new URLClassLoader(urls);
//                    }
//                });
//        Class<?> _class = loader.findClass("com.elven.demo.jdk8.test.SystemGetProperty");
        Class<?> _class =loader.loadClass("com.elven.demo.maven_demo_quickstart.Tools");
//        Class<?> _class = Class.forName("com.elven.demo.jdk8.test.SystemGetProperty");
        System.out.println(_class.getClassLoader());
        Object obj = _class.newInstance();

        Method method = _class.getMethod("fn", new Class[]{long.class});
        long r = (long) method.invoke(obj, 10);
        System.out.println(r);
    }
}
