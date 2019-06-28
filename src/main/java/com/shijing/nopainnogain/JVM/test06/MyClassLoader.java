package com.shijing.nopainnogain.JVM.test06;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Auther: Founder
 * @Date: 19/4/23 17 42
 * @Description:
 */
public class MyClassLoader extends ClassLoader {
    private final static Path DEFAULT_CLASS_DIR = Paths.get("E:\\my\\jvmDemo\\src", "");
    private final Path classDir;
    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }
    public MyClassLoader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);
    }
    public MyClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    //重写父类的findClass方法, 这是至关重要的步骤
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //读取class的二进制数据
        byte[] classBytes = this.readClassByte(name);
        if (null == classBytes || classBytes.length ==0) {
            throw new ClassNotFoundException();
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] readClassByte(String name) throws ClassNotFoundException {
        //将包名分隔符转换为文件路径分隔符
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists())
            throw new ClassNotFoundException("The class " + name + " not found.");
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("load the class " + name + " occur error.", e);
        }
    }

    @Override
    public String toString() {
        return "My ClassLoader.";
    }
}
