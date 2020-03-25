package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.TagMapper;
import com.example.util.UserUtils;
import com.example.vo.TagVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ckx
 * @date: 2020/3/12
 * @description:
 */
@Service
public class TagService extends ServiceImpl<TagMapper, TagVO> {

    public boolean addTag(String tag){
        TagVO tagVO=new TagVO();
        tagVO.setTag(tag);
        tagVO.setAddTime(DateUtil.currentSeconds());
        return this.save(tagVO);
    }

    public List<TagVO> getList(){
        return this.list(wrapper());
    }

    public LambdaQueryWrapper<TagVO> wrapper(){
        LambdaQueryWrapper<TagVO> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(TagVO::getUserId, UserUtils.getCurrentUser().getId());
        return wrapper;
    }
}
