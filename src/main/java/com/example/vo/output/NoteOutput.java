package com.example.vo.output;

import cn.hutool.core.bean.BeanUtil;
import com.example.vo.NoteVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: ckx
 * @date: 2020/7/17
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteOutput {


    private Integer id;

    private Integer userId;

    private Integer tagId;

    private String title;

    private String content;

    private Long addTime;
    
    private String addTimeStr;

    public NoteOutput convert(NoteVO NoteVO) {
        NoteOutput.InsertConvert courseInsertConvert = new NoteOutput.InsertConvert();
        return courseInsertConvert.convert(NoteVO);
    }

    public List<NoteOutput> convert(List<NoteVO> list) {
        NoteOutput.InsertConvert courseInsertConvert = new NoteOutput.InsertConvert();
        return courseInsertConvert.convert(list);
    }

    private static class InsertConvert implements BeanConvert<NoteVO, NoteOutput> {

        @Override
        public NoteOutput convert(NoteVO NoteVO) {
            NoteOutput NoteOutput = new NoteOutput();
            BeanUtil.copyProperties(NoteVO, NoteOutput);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newDate = sdf.format(new Date(Long.valueOf(NoteOutput.getAddTime() + "000")));
            NoteOutput.setAddTimeStr(newDate);
            return NoteOutput;
        }

        @Override
        public List<NoteOutput> convert(List<NoteVO> list) {
            List<NoteOutput> outputList = new ArrayList<>();
            for (NoteVO NoteVO : list) {
                outputList.add(this.convert(NoteVO));
            }
            return outputList;
        }
    }
}
