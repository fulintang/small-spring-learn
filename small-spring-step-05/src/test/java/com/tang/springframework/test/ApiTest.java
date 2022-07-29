package com.tang.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.tang.springframework.core.io.Resource;
import com.tang.springframework.core.io.ResourceLoader;
import com.tang.springframework.core.io.impl.DefaultResourceLoader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 测试类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/29 10:51
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClasspath() throws IOException {
        Resource resource = resourceLoader.getResource(ResourceLoader.CLASSPATH_URL_PREFIX + "important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testFile() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testUrl() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fulintang/small-spring-learn/blob/main/small-spring-step-05/src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

}
