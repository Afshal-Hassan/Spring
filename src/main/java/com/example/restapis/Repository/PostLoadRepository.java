package com.example.restapis.Repository;


import com.example.restapis.Model.PostLoad;
import com.example.restapis.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PostLoadRepository extends JpaRepository<PostLoad,Integer> {

    PostLoad findByProductWeightAndTypeOfVehicleAndPhoneNo(String productWeight,String vehicleType,String phoneNo);
    PostLoad findByPostLoadId(int id);
    @Modifying
    @Query(value = "insert into post_load(phone_no,point_of_delivery,point_of_loading,product_weight,time1,vehicle_type,user_data,date1) values (:phoneNo,:dp,:lp,:pw,:time1,:tow,:sh,:date)",nativeQuery = true)
    void savePostLoad(@Param("phoneNo")String phoneNo,@Param("dp")String deliveryPoint,@Param("lp")String loadingPoint,@Param("pw")String productWeight,@Param("time1")String time,@Param("tow")String typeOfVehicle,@Param("sh")String shipper,@Param("date")String date);

    @Query("select pd.typeOfVehicle,pd.pointOfDelivery,pd.pointOfLoading,pd.phoneNo,pd.userData.email,pd.userData.phoneNo from PostLoad pd where pd.pointOfDelivery =:pod and pd.pointOfLoading =:pol")
    List<String> findContainer(@Param("pod")String pointOfDelivery,@Param("pol")String pointOfLoading);
    @Modifying
    @Query("select pd.typeOfVehicle,pd.pointOfDelivery,pd.pointOfLoading,pd.phoneNo,pd.userData.email,pd.userData.phoneNo from PostLoad pd where pd.pointOfDelivery =:pod and pd.pointOfLoading =:pol and pd.date1= :dte")
    List<String> findFilterPostLoad(@Param("pod")String pointOfDelivery,@Param("pol")String pointOfLoading,@Param("dte")String date);
}
