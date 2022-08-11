package com.example.restapis.Controllers;

import com.example.restapis.Model.ShareContainer;
import com.example.restapis.Service.ShareContainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShareContainerController {

    @Autowired
    private ShareContainerServiceImpl shareContainerService;

    @CrossOrigin
    @PostMapping("/savecontainer")
    public String saveContainer(@RequestBody ShareContainer shareContainer){
        return shareContainerService.saveContainer(shareContainer);
    }
}
