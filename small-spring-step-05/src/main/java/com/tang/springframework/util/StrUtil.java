package com.tang.springframework.util;

/**
 * 字符串工具类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/28 10:37
 */
public class StrUtil {

    boolean isNotBlank(String str) {
        return str != null && !str.trim().equals("");
    }

}
