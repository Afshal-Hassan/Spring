package com.example.restapis.Controllers;


import com.example.restapis.Model.PostLoad;
import com.example.restapis.Service.PostLoadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class PostLoadController {

        @Autowired
        PostLoadServiceImpl postLoadService;

        @CrossOrigin
        @PostMapping("/postload/{pn}/{dp}/{lp}/{pw}/{time}/{tov}/{sh}/{date}")
        public String addLoad(@PathVariable("pn")String phoneNo,@PathVariable("dp")String deliveryPoint,@PathVariable("lp")String loadingPoint,@PathVariable("pw")String productWeight,@PathVariable("time")String time,@PathVariable("tov")String typeOfVehicle,@PathVariable("sh")String shipper,@PathVariable("date")String date){
           // model.addAttribute("postload",postLoad);
            return postLoadService.addLoad(phoneNo,deliveryPoint,loadingPoint,productWeight,time,typeOfVehicle,shipper,date);


        }

        @CrossOrigin
        @GetMapping("/postload")
        public List<PostLoad> getLoad(){
            return postLoadService.getLoad();
        }

        @CrossOrigin
        @GetMapping("/postload/{productWeight}/{vehicleType}/{phoneNo}")
        public PostLoad findLoad(@PathVariable("productWeight")String productWeight,@PathVariable("vehicleType") String vehicleType,@PathVariable("phoneNo") String phoneNo){
            return postLoadService.getLoadByProductWeightVehicleTypeAndPhoneNo(productWeight,vehicleType,phoneNo);
        }

        @CrossOrigin
        @PutMapping("/postload")
        public String updateLoad(@RequestBody PostLoad postLoad){
            return postLoadService.updateLoad(postLoad);
        }

        @CrossOrigin
        @DeleteMapping("/postload/{postLoadId}")
        public String deleteLoad(@PathVariable("postLoadId") int postLoadId){
            return postLoadService.deleteLoad(postLoadId);
        }

        @CrossOrigin
        @GetMapping("/postload/{pod}/{pol}")
        public List<String> findContainer(@PathVariable("pod")String pointOfDelivery,@PathVariable("pol")String pointOfLoading){
               
                return postLoadService.findContainer(pointOfDelivery,pointOfLoading);
        }

        @CrossOrigin
        @GetMapping("/filterpostload/{pod}/{pol}/{date}")
        public List<String> findFilterPostLoad(@PathVariable("pod")String pointOfDelivery, @PathVariable("pol")String pointOfLoading, @PathVariable("date")String date){
               return postLoadService.findFilterPostLoad(pointOfDelivery,pointOfLoading,date);
        }

}
