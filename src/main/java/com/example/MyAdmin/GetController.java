package com.example.MyAdmin;

import com.example.MyAdmin.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api")
@RestController
public class GetController {

    @GetMapping("/getMethod")
    public String getController(@RequestParam String id, String password){

        return id+password;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;

    }



}
