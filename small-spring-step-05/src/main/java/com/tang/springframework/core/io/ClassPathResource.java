package com.tang.springframework.core.io;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassLoaderUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 通过 ClassLoader 读取ClassPath 下的文件信息
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/26 17:20
 */
public class ClassPathResource implements Resource {

    // 文件路径
    private final String path;

    // 类加载器
    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassLoaderUtil.getClassLoader();
    }

    /**
     * 获取资源
     *
     * @return 输入流
     * @throws IOException 获取
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return inputStream;
    }

}
