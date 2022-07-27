package com.tang.springframework.core.io.impl;

import cn.hutool.core.lang.Assert;
import com.tang.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * HTTP 的方式读取云服务的文件,
 * 我们也可以把配置文件放到 GitHub 或者 Gitee 上
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/26 17:50
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = this.url.openConnection();
        try {
            return connection.getInputStream();
        } catch (IOException e) {
            if (connection instanceof HttpURLConnection) {
                ((HttpURLConnection) connection).disconnect();
            }
            throw e;
        }
    }

}
