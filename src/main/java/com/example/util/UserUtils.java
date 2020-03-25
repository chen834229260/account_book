package com.example.util;

import com.example.vo.UserVO;
import org.apache.shiro.SecurityUtils;

/**
 * @author: ckx
 * @date: 2020/3/25
 * @description:获取当前登录用户信息
 */
public class UserUtils {
    public static UserVO getCurrentUser() {
        UserVO user = (UserVO) SecurityUtils.getSubject().getPrincipal();
        return user;
    }
}
