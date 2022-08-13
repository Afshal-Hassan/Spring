package com.example.restapis.Repository;

import com.example.restapis.Model.ShareContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareContainerRepository extends JpaRepository<ShareContainer,Integer> {


    @Query("select sc.container_Id,sc.name,sc.pointOfDelivery,sc.pointOfLoading,sc.productWeight,sc.phoneNo,sc.dateOfUploading from ShareContainer sc")
    List<String> findAllShareContainers();
}
