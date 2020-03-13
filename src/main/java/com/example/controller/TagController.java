package com.example.controller;

import com.example.enmu.CodeStatus;
import com.example.service.TagService;
import com.example.vo.ResultDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ckx
 * @date: 2020/3/12
 * @description:
 */

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService service;

    public TagController(TagService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResultDTO addTag(String tag) {
        service.addTag(tag);
        return new ResultDTO(CodeStatus.SUCCESS);
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultDTO addList() {
        return new ResultDTO(service.getList(),CodeStatus.SUCCESS);
    }
}
