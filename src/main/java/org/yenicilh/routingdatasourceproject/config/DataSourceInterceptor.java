package org.yenicilh.routingdatasourceproject.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

@Component
public class DataSourceInterceptor extends WebRequestHandlerInterceptorAdapter {


    public DataSourceInterceptor(WebRequestInterceptor requestInterceptor) {
        super(requestInterceptor);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String branch = request.getHeader("branch");
        if(ClientDatabase.KILIS.toString().equalsIgnoreCase(branch))
            ClientDatabaseContextHolder.set(ClientDatabase.KILIS);
        else
            ClientDatabaseContextHolder.set(ClientDatabase.ANTEP);

        return super.preHandle(request, response, handler);
    }
}
