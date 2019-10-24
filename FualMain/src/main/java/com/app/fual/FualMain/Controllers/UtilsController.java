package com.app.fual.FualMain.Controllers;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("utils")
public class UtilsController {
	
	
	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
	                               RedirectAttributes redirectAttributes) {
	    String FTP_ADDRESS = "ftp://artificialreasongames.c1.biz";
	    String LOGIN = "3085298";
	    String PSW = "Putavida666";

	    FTPClient con = null;

	    try {
	        con = new FTPClient();
	        con.connect(FTP_ADDRESS);

	        if (con.login(LOGIN, PSW)) {
	            con.enterLocalPassiveMode(); // important!
	            con.setFileType(FTP.BINARY_FILE_TYPE);

	            boolean result = con.storeFile(file.getOriginalFilename(), file.getInputStream());
	            con.logout();
	            con.disconnect();
	            redirectAttributes.addFlashAttribute("message",
	                    "You successfully uploaded " + file.getOriginalFilename() + "!");
	            
	            System.out.println("all is well "+ result);
	        }
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("message",
	                "Could not upload " + file.getOriginalFilename() + "!");
	    }

	    return "redirect:/";
	}
	
}
