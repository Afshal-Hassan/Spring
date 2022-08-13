package com.example.restapis.Controllers;

import com.example.restapis.Model.ShareContainer;
import com.example.restapis.Service.ShareContainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShareContainerController {

    @Autowired
    private ShareContainerServiceImpl shareContainerService;

    @CrossOrigin
    @PostMapping("/savecontainer")
    public String saveContainer(@RequestBody ShareContainer shareContainer){
        return shareContainerService.saveContainer(shareContainer);
    }
    @CrossOrigin
    @GetMapping("/getAllShareContainerLoads")
    public List<String> getAllShareContainerLoads(){
        return shareContainerService.getAllShareContainerLoads();
    }
}
