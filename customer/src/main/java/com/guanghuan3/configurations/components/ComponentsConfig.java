package com.guanghuan3.configurations.components;

import net.sf.ehcache.CacheManager;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by Administrator
 * on 2018/1/30.
 */
@Configuration
// core包中的内置实现，基础框架使用时可以使用，也可以自己实现接口定制
@MapperScan(basePackages = {"com.zwb.common.business", "com.guanghuan3.customer"})
@ComponentScan(basePackages = "com.zwb.common.business")
@ServletComponentScan("com.guanghuan3.web")
public class ComponentsConfig
{
    /*@Bean
    public EhCacheCacheManager cacheManager(CacheManager ehCacheManager)
    {
        return new EhCacheCacheManager(ehCacheManager);
    }*/
}
