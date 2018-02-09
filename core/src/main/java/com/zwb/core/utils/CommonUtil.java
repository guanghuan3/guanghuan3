package com.zwb.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator
 * on 2017/12/31.
 */
public class CommonUtil
{
    /**
     * 判断对象是否为空：null
     * @param obj 目标对象
     * @return true=空，false=非空
     */
    public static Boolean isNull(Object obj)
    {
        return obj == null;
    }

    /**
     * 判断对象是否非空：!=null
     * @param obj 目标对象
     * @return true!=null非空，false==null空
     */
    public static Boolean isNotNull(Object obj)
    {
        return !isNull(obj);
    }

    /**
     * 判断对象是否含有元素
     * 适用于string, collection, map, 数组是否包含子元素
     * string != null 并且 string != ""
     * collection != null 并且size 大于0
     * map != null 并且size大于0
     * 数组不等于null并且length大于0
     * @param obj 判断目标
     * @return true=为空或不包含元素，false=不为空且包含元素
     */
    public static Boolean isEmpty(Object obj)
    {
        if (isNotNull(obj))
        {
            if (obj instanceof Collection)
            {
                return ((Collection) obj).size() == 0;
            }
            else if (obj instanceof Map)
            {
                return ((Map) obj).size() == 0;
            }
            else if (obj instanceof String)
            {
                return ((String) obj).length() == 0;
            }
            else if (obj instanceof Object[])
            {
                return ((Object[]) obj).length == 0;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return true;
        }
    }

    /**
     * isEmpty的反向判断
     * @param obj
     * @return
     */
    public static Boolean isNotEmpty(Object obj)
    {
        return !isEmpty(obj);
    }

    /**
     * 判断字符串去除头尾空格后是否为空
     * @param str 目标字符串
     * @return true=为空，false=非空
     */
    public static Boolean isEmptyAfterTrim(String str)
    {
        if (isNotEmpty(str))
        {
            return str.trim().length() == 0 ? true : false;
        }
        else
        {
            return true;
        }
    }

    /**
     * 获取指定长度的随机数字字符串
     * @param length
     * @return
     */
    public static String getRandNum(Integer length)
    {
        return getRandNum(length, null);
    }

    private static String getRandNum(Integer length, String source)
    {
        if (isNull(length))
        {
            return null;
        }

        String str = (Math.random() + (isNull(source) ? "" : source)).substring(2);
        if (str.length() >= length)
        {
            return str.substring(0, length);
        }
        else
        {
            return getRandNum(length, str);
        }
    }

    /**
     * 将对象序列化成json字符串
     * @param obj
     * @return
     */
    public static String objectToJsonString(Object obj)
    {
        if (isNotEmpty(obj))
        {
            try
            {
                return new ObjectMapper().writeValueAsString(obj);
            }
            catch (JsonProcessingException e)
            {
                LoggerUtil.error(CommonUtil.class, e);
            }
        }
        return "";
    }

    public static void main(String[] args)
    {
        for (int j =0; j < 100; j ++)
        {
            for (int i = 0; i < 100; i++)
            {
                System.err.println(getRandNum(i, null));
            }
        }
    }

}
