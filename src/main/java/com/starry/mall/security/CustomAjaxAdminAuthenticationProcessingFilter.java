//package com.starry.mall.security;
//
//import com.starry.mall.utils.JsonUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.IOUtils;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//
///**
// * @author ratel
// * @version 1.0
// * @description:
// * @date 2021/6/16 21:41
// */
//@Slf4j
//public class CustomAjaxAdminAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter{
//    private static final String PRINCIPAL = "username";
//    private static final String CREDENTIALS = "password";
//    public CustomAjaxAdminAuthenticationProcessingFilter() {
//        super(new AntPathRequestMatcher("/login", "POST"));
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
//        log.info("attemptAuthentication start");
//        Map<String, String> principal = getPrincipal(httpServletRequest);
//        log.info("attemptAuthentication login param:{}",principal);
//        return new UsernamePasswordAuthenticationToken(principal.get(PRINCIPAL), principal.get(CREDENTIALS));
//    }
//
//    private Map<String,String> getPrincipal(HttpServletRequest request){
//        try {
//            String requestBody = IOUtils.toString(request.getReader());
//            Map<String,String> principal = JsonUtil.toObject(requestBody, Map.class);
//            return principal;
//        } catch (IOException e) {
//            throw new BadCredentialsException("认证失败");
//        }
//    }
//
//}
