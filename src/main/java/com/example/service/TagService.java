package com.example.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.TagMapper;
import com.example.util.UserUtils;
import com.example.vo.NoteVO;
import com.example.vo.TagVO;
import com.example.vo.output.TagOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ckx
 * @date: 2020/3/12
 * @description:
 */
@Service
public class TagService extends ServiceImpl<TagMapper, TagVO> {

    @Autowired
    private NoteService noteService;


    public boolean addTag(String tag){
        TagVO tagVO=new TagVO();
        tagVO.setTag(tag);
        tagVO.setAddTime(DateUtil.currentSeconds());
        return this.save(tagVO);
    }

    public List<TagOutput> getList(){
        List<TagOutput> list =new TagOutput().convert(this.list(wrapper()));
        for (TagOutput top:list){
            List<NoteVO> noteList = noteService.tagByNoteSize(top.getId());
            if (CollUtil.isNotEmpty(noteList)){
                top.setTagSize(noteList.size());
            }
        }
        return list;
    }

    public LambdaQueryWrapper<TagVO> wrapper(){
        LambdaQueryWrapper<TagVO> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(TagVO::getUserId, UserUtils.getCurrentUser().getId());
        return wrapper;
    }
}
