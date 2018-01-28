package com.guanghuan3.configurations;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator
 * on 2018/1/28.
 */
//@Configuration
@Component
@ConfigurationProperties(prefix = "api-list")
//@PropertySource(value = "classpath:api-list.yml")
@PropertySource(value = "classpath:api-list.properties")
public class ApiListProperties
{
    private Properties get;

    private Properties post;

    public Properties getGet()
    {
        return get;
    }

    public void setGet(Properties get)
    {
        this.get = get;
    }

    public Properties getPost()
    {
        return post;
    }

    public void setPost(Properties post)
    {
        this.post = post;
    }

    /*Map<String, Object> get;

    Map<String, Object> post;

    private String test;

    public Map<String, Object> getGet()
    {
        return get;
    }

    public void setGet(Map<String, Object> get)
    {
        this.get = get;
    }

    public Map<String, Object> getPost()
    {
        return post;
    }

    public void setPost(Map<String, Object> post)
    {
        this.post = post;
    }

    public String getTest()
    {
        return test;
    }

    public void setTest(String test)
    {
        this.test = test;
    }*/
}
