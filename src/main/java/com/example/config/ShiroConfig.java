package com.example.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author: ckx
 * @date: 2020/3/3
 * @description:支出消费
 */
@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        System.out.println("执行 ShiroFilterFactoryBean.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //必须设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //如果不是前后端分离，则不必设置下面的sessionManager
        securityManager.setSessionManager(sessionManager());

        //设置realm（推荐放到最后，不然某些情况会不生效）
        securityManager.setRealm(customRealm());

        return securityManager;
    }

    /**
     * 自定义realm
     * @return
     */
    @Bean
    public CustomRealm customRealm(){
        CustomRealm customRealm = new CustomRealm();

        //customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return customRealm;
    }

    /**
     * 密码加解密规则
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();

        //设置散列算法：这里使用的MD5算法
        credentialsMatcher.setHashAlgorithmName("md5");

        //散列次数，好比散列2次，相当于md5(md5(xxxx))
        credentialsMatcher.setHashIterations(2);

        return credentialsMatcher;
    }

    //自定义sessionManager
    @Bean
    public SessionManager sessionManager(){

        CustomSessionManager customSessionManager = new CustomSessionManager();

        //超时时间，默认 30分钟，会话超时；方法里面的单位是毫秒
        //customSessionManager.setGlobalSessionTimeout(20000);

        return customSessionManager;
    }
}
