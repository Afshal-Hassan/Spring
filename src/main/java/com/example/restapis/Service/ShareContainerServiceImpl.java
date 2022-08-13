package com.example.restapis.Service;

import com.example.restapis.Model.ShareContainer;
import com.example.restapis.Repository.ShareContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShareContainerServiceImpl implements ShareContainerService{

    @Autowired
    private ShareContainerRepository shareContainerRepository;

    @Override
    public String saveContainer(ShareContainer shareContainer) {
        shareContainerRepository.save(shareContainer);
        return "Successfully Saved";
    }

    @Override
    public List<String> getAllShareContainerLoads() {
        List<String>shareContainer = shareContainerRepository.findAllShareContainers();
        if(shareContainer.isEmpty()){
            return Arrays.asList("Not Found");
        }
        else {
            return shareContainerRepository.findAllShareContainers();
        }
    }
}
