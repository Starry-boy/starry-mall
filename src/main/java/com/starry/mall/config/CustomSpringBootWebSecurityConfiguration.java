package com.starry.mall.config;

import com.starry.mall.security.CustomAjaxAdminAuthenticationProcessingFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/6/16 1:26
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomSpringBootWebSecurityConfiguration{


    @Configuration
    static class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
        @Value("{server.context-path}")
        private String contextPath;

        /**
         * 重点！常用的配置都是通过 HttpSecurity 来指定
         * @param http
         * @throws Exception
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    //开启跨域
                    .csrf().disable().cors()
                    .and().authorizeRequests().antMatchers(contextPath + "/login",contextPath + "/logout").permitAll()
                    .and().authorizeRequests().anyRequest().authenticated()
                    .and().addFilterAt(new CustomAjaxAdminAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class).
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            super.configure(auth);
            auth.inMemoryAuthentication().passwordEncoder()
        }
    }





}
