package com.guanghuan3.customer;

import com.guanghuan3.configurations.ApiListProperties;
import com.zwb.core.business.httprequest.BasicModel;
import com.zwb.core.business.httpresponse.ResponseData;
import com.zwb.core.utils.ApplicationContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        Object obj = ApplicationContextFactory.getBean("apiListProperties");
        System.err.println(obj);

        System.err.println(path);
        System.err.println(apiListProperties.getGet());
        return apiListProperties;
    }

    @RequestMapping(value = "{api_path}", method = RequestMethod.POST)
    public Object post(HttpServletRequest request, HttpServletResponse response, BasicModel model, @PathVariable("api_path") String path)
    {
        System.err.println(path);
        System.err.println(apiListProperties.getPost());
        return apiListProperties;
    }
}
