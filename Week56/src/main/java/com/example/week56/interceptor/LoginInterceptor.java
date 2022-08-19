package com.example.week56.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.week56.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录检查
 */
@Slf4j
public class LoginInterceptor  implements HandlerInterceptor {

    /**
     * 登录检查
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String token = request.getHeader("token");
        log.info("拦截的请求路径是{}",requestURI);
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            try {
                JWTUtils.verify(token);
                return true;
            } catch (TokenExpiredException e) {
                request.setAttribute("msg", "Token已经过期");
                return false;
            } catch (SignatureVerificationException e){
                request.setAttribute("msg", "签名错误");
                return false;
            } catch (AlgorithmMismatchException e){
                request.setAttribute("msg", "加密算法不匹配");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "无效token");
                return false;
            }
        }
        //拦截后返回登录页面
        request.setAttribute("msg","请先登录");
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }
}
