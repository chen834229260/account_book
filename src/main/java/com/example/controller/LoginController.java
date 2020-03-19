package com.example.controller;

import com.example.vo.ResultDTO;
import com.example.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ckx
 * @date: 2020/3/3
 * @description:
 */
@Controller
public class LoginController {
    /**
     * 登录接口
     * @param userVO
     * @return
     */
    @PostMapping("login")
    @ResponseBody
    public ResultDTO login(UserVO userVO){
        Subject subject = SecurityUtils.getSubject();
        Map<String,Object> info = new HashMap<>();
        try {
            String hashName="md5";
            String pwd=new SimpleHash(hashName,userVO.getPassword(),null,2).toString();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userVO.getUsername(), pwd);
            subject.login(usernamePasswordToken);
            info.put("session_id", subject.getSession().getId());
            return new ResultDTO(info,"登录成功!");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultDTO("登录失败");
        }
    }

}
