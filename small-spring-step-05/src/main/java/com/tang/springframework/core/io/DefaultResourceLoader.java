package com.tang.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * TODO: 该类作用
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/26 18:05
 */
public class DefaultResourceLoader implements ResourceLoader {

    /**
     * 虽然 DefaultResourceLoader 类实现的过程简单，但这也是设计模式约定的具体结果
     * ，像是这里不会让外部调用放知道过多的细节，而是仅关心具体调用结果即可。
     *
     * @param location
     * @return
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }

}
