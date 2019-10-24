package com.app.fual.FualMain.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.PublicChatDTO;
import com.app.fual.FualMain.DTO.UserDTO;

@RestController
@RequestMapping("publicChat")
public class PublicChatAPI extends GeneralAPI<PublicChatDTO>{

}
