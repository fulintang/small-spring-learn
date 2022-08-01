package com.tang.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载接口定义
 */
public interface Resource {

    /**
     * 获取资源
     *
     * @return 输入流
     * @throws IOException 获取资源失败的IO异常
     */
    InputStream getInputStream() throws IOException;

}
