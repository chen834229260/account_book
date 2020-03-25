package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.NoteMapper;
import com.example.util.UserUtils;
import com.example.vo.NoteVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ckx
 * @date: 2020/3/12
 * @description:
 */
@Service
public class NoteService extends ServiceImpl<NoteMapper, NoteVO> {
    private final NoteMapper mapper;

    public NoteService(NoteMapper mapper) {
        this.mapper = mapper;
    }

    public boolean addNote(NoteVO noteVO) {
        noteVO.setUserId(UserUtils.getCurrentUser().getId());
        noteVO.setAddTime(DateUtil.currentSeconds());
        return this.save(noteVO);
    }

    public NoteVO getRandNote(){
        return mapper.getRandNote(UserUtils.getCurrentUser().getId());
    }

    public List<NoteVO> getList(){
        return this.list();
    }

}
