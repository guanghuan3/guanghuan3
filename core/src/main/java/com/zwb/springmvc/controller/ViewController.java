package com.zwb.springmvc.controller;

import com.zwb.core.business.httpresponse.ResponseConstant;
import com.zwb.core.business.httpresponse.Result;
import com.zwb.core.utils.CommonUtil;
import com.zwb.springmvc.BasicController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator
 * on 2018/1/31.
 */
public class ViewController extends BasicController<ModelAndView>
{
    @Value("${server.error.path}")
    private String errorPath;

    @Override
    public ModelAndView handleException(Exception e)
    {
        ModelAndView view = new ModelAndView(errorPath);

        if (CommonUtil.isNotEmpty(e))
        {
            Result result = new Result(ResponseConstant.RESULT_CODE_SYS_EXCEPTION, ResponseConstant.RESULT_DESCRIPTION_EXCEPTION);

            // 对业务异常进行处理
            handleResponse(e, result);

            view.getModelMap().put("resultInfo", result);
        }

        return view;
    }

}
