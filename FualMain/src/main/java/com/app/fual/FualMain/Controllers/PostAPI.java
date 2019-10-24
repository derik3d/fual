package com.app.fual.FualMain.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.PostDTO;
import com.app.fual.FualMain.DTO.UserDTO;

@RestController
@RequestMapping("post")
public class PostAPI extends GeneralAPI<PostDTO>{

}
