package com.zwb.springmvc;

import com.zwb.core.business.BusinessException;
import com.zwb.core.business.httpresponse.ResponseConstant;
import com.zwb.core.business.httpresponse.Result;
import com.zwb.core.utils.CommonUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator
 * on 2018/1/31.
 */
public abstract class BasicController<T>
{
    @ExceptionHandler
    protected abstract  T handleException(Exception e);

    protected void handleResponse(Exception e, Result result)
    {
        if (CommonUtil.isNotEmpty(e)  && e instanceof BusinessException)
        {
            BusinessException be = (BusinessException) e;
            result.setCode(be.getErrorCode());
            result.setDescription(ResponseConstant.RESULT_DESCRIPTION_FAILED);
            result.setMessage(ResponseConstant.RESULT_MESSAGE_FAILED);
        }
    }
}
