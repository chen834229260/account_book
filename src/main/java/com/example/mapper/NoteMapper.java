package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.NoteVO;
import org.springframework.stereotype.Repository;

/**
 * @author: ckx
 * @date: 2020/3/12
 * @description:
 */
@Repository
public interface NoteMapper extends BaseMapper<NoteVO> {

    NoteVO getRandNote();
}
