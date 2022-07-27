package com.tang.springframework.beans.factory.xml;

import cn.hutool.core.util.XmlUtil;
import com.tang.springframework.beans.factory.ex.BeansException;
import com.tang.springframework.beans.factory.support.reader.impl.AbstractBeanDefinitionReader;
import com.tang.springframework.beans.factory.support.registory.BeanDefinitionRegistry;
import com.tang.springframework.core.io.Resource;
import com.tang.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 解析XML处理Bean注册
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/27 12:15
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    protected XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    protected XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            InputStream inputStream = resource.getInputStream();
            doLoadBeanDefinitions(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }
    
    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = super.getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            // 判断元素
            if (!(childNodes.item(i) instanceof Element)) continue;
            // 判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;
            
            // 解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
        }

    }


}
