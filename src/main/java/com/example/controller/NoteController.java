package com.example.controller;

import com.example.enmu.CodeStatus;
import com.example.service.NoteService;
import com.example.vo.NoteVO;
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
@RequestMapping("/note")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResultDTO addNote(NoteVO noteVO) {
        return new ResultDTO(service.addNote(noteVO));
    }

    @RequestMapping("/rand")
    @ResponseBody
    public ResultDTO randNote() {
        return new ResultDTO(service.getRandNote(), CodeStatus.SUCCESS);
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultDTO list() {
        return new ResultDTO(service.getList(), CodeStatus.SUCCESS);
    }
}
