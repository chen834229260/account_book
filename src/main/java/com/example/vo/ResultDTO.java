package com.example.vo;

import com.example.enmu.CodeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: ckx
 * @date: 2020/3/9
 * @description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO implements Serializable {
    private Object data;
    private String code;
    private String message;


    public ResultDTO(Object data) {
        this.data = data;
    }

    public ResultDTO(CodeStatus code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public ResultDTO(Object data, CodeStatus code) {
        this.data = data;
        this.code = code.getCode();
        this.message = code.getMessage();
    }

}
