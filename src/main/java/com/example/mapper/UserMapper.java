package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.UserVO;
import org.springframework.stereotype.Repository;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:
 */
@Repository
public interface UserMapper extends BaseMapper<UserVO> {
}
