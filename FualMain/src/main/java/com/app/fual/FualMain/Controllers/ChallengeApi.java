package com.app.fual.FualMain.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.fual.FualMain.DTO.ChallengeDTO;

@RestController
@RequestMapping("challenge")
public class ChallengeApi extends GeneralAPI<ChallengeDTO>{

}
