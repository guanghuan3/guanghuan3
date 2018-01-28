package com.guanghuan3.web.servlet;

import com.zwb.core.utils.ApplicationContextFactory;
import com.zwb.core.utils.LoggerUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator
 * on 2018/1/28.
 */
@WebServlet(loadOnStartup = 2, name = "initServlet", value = "")
//@WebServlet(loadOnStartup = 2, name = "initServlet")
public class InitServlet extends HttpServlet
{
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        // 初始化spring容器工具类
        ApplicationContextFactory.init(config.getServletContext());
    }
}
