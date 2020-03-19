package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.UserMapper;
import com.example.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:
 */
@Service
public class UserService extends ServiceImpl<UserMapper,UserVO> {


    public UserVO getUser(String username){
        LambdaQueryWrapper<UserVO> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(UserVO::getUsername,username);
        return this.getOne(wrapper);
    }
}
