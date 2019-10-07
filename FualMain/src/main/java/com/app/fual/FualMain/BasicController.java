package com.app.fual.FualMain;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class BasicController {
	
	

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public DataResponse home(Model model) {
        return new DataResponse();
    }
/*
    @GetMapping("/getTestJson")
    public String testendpoint(Model model) {
        return "hol";
    }
    */
    @RequestMapping(value = "/getTestJson",
    	      method = RequestMethod.GET, 
    	      produces = MediaType.APPLICATION_JSON_VALUE
    	      )
    public String home(@RequestParam(name="name", required=false, defaultValue="no") String name) {
    	
        return "json/"+name+".json";

    }

}