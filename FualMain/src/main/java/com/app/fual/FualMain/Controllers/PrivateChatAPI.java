package com.app.fual.FualMain.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.PrivateChatDTO;
import com.app.fual.FualMain.DTO.UserDTO;

@RestController
@RequestMapping("personalChat")
public class PrivateChatAPI extends GeneralAPI<PrivateChatDTO>{

}
