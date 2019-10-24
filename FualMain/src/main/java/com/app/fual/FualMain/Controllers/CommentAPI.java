package com.app.fual.FualMain.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.CommentDTO;
import com.app.fual.FualMain.DTO.UserDTO;

@RestController
@RequestMapping("comment")
public class CommentAPI extends GeneralAPI<CommentDTO>{

}
