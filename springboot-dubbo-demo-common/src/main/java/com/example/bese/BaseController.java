package com.example.bese;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public  class BaseController {
    protected  final Logger logger=LoggerFactory.getLogger(BaseController.class);
    /**
     * ThreadLocal确保高并发下每个请求的request，response都是独立的
     */
    private static ThreadLocal<ServletRequest> currentRequest = new ThreadLocal<ServletRequest>();
    private static ThreadLocal<ServletResponse> currentResponse = new ThreadLocal<ServletResponse>();
    private static ThreadLocal<HttpSession> currentSession = new ThreadLocal<HttpSession>();
    private static ThreadLocal<HashMap<Object,Object>> currentParams = new ThreadLocal<HashMap<Object,Object>>();

    /**
     * 获得request
     * @return
     */
    protected ServletRequest getRequest(){
        currentRequest.set(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
        return currentRequest.get();
    }



    /**
     * 获得session
     * @return
     */
    protected HttpSession getSession(){
        currentSession.set(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession());
        return currentSession.get();
    }

    /**
     * 获得请求参数HashMap
     * @return
     */
    protected HashMap<Object,Object> getParameter(){
        currentParams.set(getParams(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest()));
        return currentParams.get();
    }

    /**
     * 请求参数转换成HashMap
     * @param request
     * @return
     */
    protected HashMap<Object,Object> getParams(HttpServletRequest request){
        HashMap<Object, Object> conditions = new HashMap<Object, Object>();
        Map map = request.getParameterMap();
        for (Object o : map.keySet()) {
            String key = (String) o;
            Object value=map.get(key);
            if(value==null){
                value="";
            }
            conditions.put(key, value);
        }
        return conditions;
    }
}
