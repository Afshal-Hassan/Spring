package com.example.restapis.Service;

import com.example.restapis.Model.ShareContainer;

import java.util.List;

public interface ShareContainerService {

    String saveContainer(ShareContainer shareContainer);
    List<String> getAllShareContainerLoads();
}
