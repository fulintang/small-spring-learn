package com.tang.springframework.util;

/**
 * TODO: 该类作用
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/26 17:27
 */
public class ClassUtils {
    
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable throwable) {
            System.err.println("Cannot access thread context ClassLoader - falling back to system class loader...");
        }
        if (classLoader == null) {
            // No thread context class loader -> use class loader of this class.
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
    
}
