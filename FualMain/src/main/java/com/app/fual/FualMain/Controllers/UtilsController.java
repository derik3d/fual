package com.app.fual.FualMain.Controllers;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
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


	@Value("${ftp.credentials.url}")
    private String FTP_ADDRESS;
	@Value("${ftp.credentials.user}")
	private String LOGIN;
	@Value("${ftp.credentials.pass}")
	private String PSW;
	
	

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
									@RequestParam("rename") String rename,
	                               RedirectAttributes redirectAttributes) {
		
	

	    FTPClient con = null;

	    System.out.print("preparing step");
	    
	    try {
	        con = new FTPClient();
	        con.connect(FTP_ADDRESS);
	        

		    System.out.print("stepaaaaa 35");

	        if (con.login(LOGIN, PSW)) {
	            con.enterLocalPassiveMode(); // important!
	            con.setFileType(FTP.BINARY_FILE_TYPE);
	            //
	            boolean result = con.storeFile("artificialreasongames.c1.biz/datafual/"+rename, file.getInputStream());
	            con.logout();
	            con.disconnect();
	            
	            System.out.println(result+ " result");

	            redirectAttributes.addFlashAttribute("message",
	                    "You successfully uploaded " + file.getOriginalFilename() + "!");
	            
	            return "ok";
	            
	        }
	    } catch (Exception e) {
	    	
	    	
	    	
	    	e.printStackTrace();
	        redirectAttributes.addFlashAttribute("message",
	                "Could not upload " + file.getOriginalFilename() + "!");
	        
	        //return "failed";
	    }
	       
	    

	    return "false";
	    //return "redirect:/";
	}

	
	
	public String getFTP_ADDRESS() {
		return FTP_ADDRESS;
	}




	public void setFTP_ADDRESS(String fTP_ADDRESS) {
		FTP_ADDRESS = fTP_ADDRESS;
	}




	public String getLOGIN() {
		return LOGIN;
	}




	public void setLOGIN(String lOGIN) {
		LOGIN = lOGIN;
	}




	public String getPSW() {
		return PSW;
	}




	public void setPSW(String pSW) {
		PSW = pSW;
	}



}
