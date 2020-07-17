package com.example.vo.output;

import cn.hutool.core.bean.BeanUtil;
import com.example.vo.TagVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ckx
 * @date: 2020/7/17
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagOutput {

    private Integer id;

    private Integer userId;

    private String tag;

    private Long addTime;
    
    private Integer tagSize;

    public TagOutput convert(TagVO TagVO) {
        TagOutput.InsertConvert courseInsertConvert = new TagOutput.InsertConvert();
        return courseInsertConvert.convert(TagVO);
    }

    public List<TagOutput> convert(List<TagVO> list) {
        TagOutput.InsertConvert courseInsertConvert = new TagOutput.InsertConvert();
        return courseInsertConvert.convert(list);
    }

    private static class InsertConvert implements BeanConvert<TagVO, TagOutput> {

        @Override
        public TagOutput convert(TagVO TagVO) {
            TagOutput TagOutput = new TagOutput();
            BeanUtil.copyProperties(TagVO, TagOutput);
            return TagOutput;
        }

        @Override
        public List<TagOutput> convert(List<TagVO> list) {
            List<TagOutput> outputList = new ArrayList<>();
            for (TagVO TagVO : list) {
                outputList.add(this.convert(TagVO));
            }
            return outputList;
        }
    }
}
