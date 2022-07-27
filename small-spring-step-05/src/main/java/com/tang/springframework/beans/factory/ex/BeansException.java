package com.tang.springframework.beans.factory.ex;

/**
 * Bean异常
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/19 12:03
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
    
}
