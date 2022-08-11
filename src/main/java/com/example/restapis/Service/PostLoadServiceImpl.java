package com.example.restapis.Service;

import com.example.restapis.Model.PostLoad;
import com.example.restapis.Model.UserData;
import com.example.restapis.Repository.PostLoadRepository;
import com.example.restapis.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@Service
public class PostLoadServiceImpl implements PostLoadService{


    @Autowired
    private PostLoadRepository postLoadRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public String addLoad(String phoneNo, String deliveryPoint, String loadingPoint, String productWeight, String time, String typeOfVehicle, String shipper,String date) {
        String carrierEmail= userRepository.findEmail(shipper);
        if(carrierEmail==null){
            return "Enter correct Email";
        }
        else{
            postLoadRepository.savePostLoad(phoneNo,deliveryPoint,loadingPoint,productWeight,time,typeOfVehicle,shipper,date);
            return "Saved Successfully";
        }

    }

    @Override
    public String addLoad(PostLoad postLoad) {
        postLoadRepository.save(postLoad);
        return "Saved Successfully" ;
    }

    @Override
    public List<PostLoad> getLoad() {
        return postLoadRepository.findAll();
    }

    @Override
    public PostLoad getLoadByProductWeightVehicleTypeAndPhoneNo(String productWeight, String vehicleType, String phoneNo) {
        return postLoadRepository.findByProductWeightAndTypeOfVehicleAndPhoneNo(productWeight,vehicleType,phoneNo);
    }

    @Override
    public String updateLoad(PostLoad postLoad) {
        postLoadRepository.save(postLoad);
        return "Update Successfully";
    }

    @Override
    public String deleteLoad(int postLoadId) {

        PostLoad postLoad = postLoadRepository.findByPostLoadId(postLoadId);
        if(postLoad==null){
            System.out.println("This type of load is not present");
            return "Not Deleted";
        }
       else{
           postLoadRepository.deleteById(postLoadId);
           System.out.println("Deleted");
            return "Delete Successfully";
       }

    }

    @Override
    public List<String> findContainer(String pointOfDelivery, String pointOfLoading) {
         List<String> data = postLoadRepository.findContainer(pointOfDelivery,pointOfLoading);
        if(data.isEmpty()){
            return Arrays.asList("Requirements you send doesn't match") ;
        }
        else {
            return postLoadRepository.findContainer(pointOfDelivery,pointOfLoading);
        }
    }

    @Transactional
    @Override
    public List<String> findFilterPostLoad(String pointOfDelivery, String pointOfLoading,String date) {
        System.out.println(date.toString());
        List<String> filter = postLoadRepository.findFilterPostLoad(pointOfDelivery,pointOfLoading,date);
        if(filter.isEmpty()){
            return Arrays.asList("Not Found");
        }
        else{
            return postLoadRepository.findFilterPostLoad(pointOfDelivery,pointOfLoading,date);
        }
    }
}
