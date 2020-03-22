package com.example.config;

import com.example.service.UserService;
import com.example.vo.UserVO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: ckx
 * @date: 2020/3/3
 * @description:支出消费
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 进行权限校验的时候回调用
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权 doGetAuthorizationInfo");
        return null;
    }


    /**
     * 用户登录的时候会调用
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证 doGetAuthenticationInfo");
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());


        // 通过同hum到数据库查询用户信息
        UserVO userVO = userService.getUser(userName);
        // 虽然我们可以准确的获取异常信息，并根据这些信息给用户提示具体错误
        // 但最安全的做法是在登录失败时仅向用户显示通用错误提示信息，例如“用户名或密码错误”。这样可以防止数据库被恶意扫描。
        if (userVO == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        return new SimpleAuthenticationInfo(userVO, password, getName());
    }
}
