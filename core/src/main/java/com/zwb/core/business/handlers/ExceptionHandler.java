package com.zwb.core.business.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * Created by Administrator
 * on 2018/1/28.
 */
public interface ExceptionHandler<T>
{
    T handleException(HttpServletRequest request, HttpServletResponse response, Exception e);
}
