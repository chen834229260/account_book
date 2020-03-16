package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.enmu.ExpenditureEnum;
import com.example.mapper.ExpenditureMapper;
import com.example.vo.ExpenditureVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ckx
 * @date: 2020/3/2
 * @description:
 */
@Service
public class ExpenditureService extends ServiceImpl<ExpenditureMapper, ExpenditureVO> {
    /**
     * 添加
     * @param expenditureVO
     */
    public Boolean addExpenditure(ExpenditureVO expenditureVO) {
        expenditureVO.setUserId(1);
        expenditureVO.setAddTime(DateUtil.currentSeconds());
        expenditureVO.setCategory(ExpenditureEnum.getCode(Integer.valueOf(expenditureVO.getCategory())));
        return this.save(expenditureVO);
    }

    /**
     * 获取所有
     * @return
     */
    public List<ExpenditureVO> getList(){
        return this.list();
    }

}
