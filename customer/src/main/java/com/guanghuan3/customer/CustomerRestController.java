package com.guanghuan3.customer;

import com.guanghuan3.configurations.ApiListProperties;
import com.zwb.core.business.BusinessExecutor;
import com.zwb.core.business.httprequest.BasicModel;
import com.zwb.core.utils.ApplicationContextFactory;
import com.zwb.core.utils.CommonUtil;
import com.zwb.core.utils.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * Created by Administrator
 * on 2018/1/28.
 */
@RestController
@RequestMapping("customer")
public class CustomerRestController
{
    @Autowired
    private ApiListProperties apiListProperties;

    @RequestMapping(value = "{api_path}", method = RequestMethod.GET)
    public Object get(HttpServletRequest request, HttpServletResponse response, BasicModel model, @PathVariable("api_path") String path)
    {
        // 执行业务
        BusinessExecutor<?> executor = getExecutor(path, RequestMethod.GET);
        return  executor.execute(request, response, model);
    }

    @RequestMapping(value = "{api_path}", method = RequestMethod.POST)
    public Object post(HttpServletRequest request, HttpServletResponse response, BasicModel model, @PathVariable("api_path") String path)
    {
        BusinessExecutor<?> executor = getExecutor(path, RequestMethod.POST);
        return executor.execute(request, response, model);
    }

    /**
     * 根据请求路径获取匹配的接口业务执行器
     * @param path
     * @param method
     * @return
     */
    private BusinessExecutor<?> getExecutor(String path, RequestMethod method)
    {
        // 获取接口列表映射
        ApiListProperties properties = (ApiListProperties) ApplicationContextFactory.getBean("apiListProperties");
        if (CommonUtil.isNull(properties))
        {
            LoggerUtil.warn(CustomerRestController.class, "没有获取到配置的接口列表：{}", new Object[]{apiListProperties});
            return null;
        }

        // 获取get方法的api列表
        Properties apiList = getPropertiesByRequestMethod(method, properties);
        if (CommonUtil.isEmpty(apiList))
        {
            LoggerUtil.warn(CustomerRestController.class, "没有配置Get方法对应的API列表");
            return null;
        }

        // 获取业务处理类
        String executorId = apiList.getProperty(path);
        if (CommonUtil.isEmpty(executorId))
        {
            LoggerUtil.warn(CustomerRestController.class, "没有匹配到Executor：{}", new Object[]{executorId});
            return null;
        }

        BusinessExecutor<?> executor = (BusinessExecutor<?>) ApplicationContextFactory.getBean(executorId);
        return executor;
    }

    /**
     * 根据请求方法获对应的取接口列表
     * @param method
     * @param properties
     * @return
     */
    private Properties getPropertiesByRequestMethod(RequestMethod method, ApiListProperties properties)
    {
        switch (method)
        {
            case GET:
                return properties.getGet();
            case POST:
                return properties.getPost();
            case PUT:
                return properties.getPut();
            case DELETE:
                return properties.getDelete();
            default:
                return null;
        }
    }
}
