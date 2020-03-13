package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.TagMapper;
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

    public void addTag(String tag){
        TagVO tagVO=new TagVO();
        tagVO.setTag(tag);
        tagVO.setAddTime(DateUtil.currentSeconds());
        this.save(tagVO);
    }

    public List<TagVO> getList(){
        return this.list();
    }
}
