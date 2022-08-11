package com.example.restapis.Service;

import com.example.restapis.Model.PostLoad;
import com.example.restapis.Model.UserData;

import java.util.List;

public interface PostLoadService {

    String  addLoad(PostLoad postLoad);

    List<String> findContainer(String pointOfDelivery,String pointOfLoading);
    List<PostLoad> getLoad();

    PostLoad getLoadByProductWeightVehicleTypeAndPhoneNo(String productWeight,String vehicleType,String phoneNo);
    String updateLoad(PostLoad postLoad);

    String deleteLoad(int postLoadId);
    String addLoad(String phoneNo, String deliveryPoint, String loadingPoint, String productWeight, String time, String typeOfVehicle, String shipper,String date);
    List<String> findFilterPostLoad(String pointOfDelivery,String pointOfLoading,String date);
}
