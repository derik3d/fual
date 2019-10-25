package com.app.fual.FualMain.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.UserDTO;
import com.app.fual.FualMain.DTO.UserDataDTO;

@RestController
@RequestMapping("userData")
public class UserDataAPI extends GeneralAPI<UserDataDTO>{

}
