package com.example.restapis.Model;


import javax.persistence.*;

@Entity
@Table(name = "PostLoad")
public class PostLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postLoadId;
    @Column(name = "vehicle_type")
    private String typeOfVehicle;

    private String pointOfLoading;

    private String pointOfDelivery;

    private String productWeight;
    private String time1;
    private String phoneNo;
    @Column(name = "date1")
    private String date1;
    @Column(name = "date_of_uploading")
    private String dateOfUploading;


    @ManyToOne
    @JoinColumn(name = "user_data",referencedColumnName = "email")
    private UserData userData;


    public String getDateOfUploading() {
        return dateOfUploading;
    }

    public void setDateOfUploading(String dateOfUploading) {
        this.dateOfUploading = dateOfUploading;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public int getPostLoadId() {
        return postLoadId;
    }

    public void setPostLoadId(int postLoadId) {
        this.postLoadId = postLoadId;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getPointOfLoading() {
        return pointOfLoading;
    }

    public void setPointOfLoading(String pointOfLoading) {
        this.pointOfLoading = pointOfLoading;
    }

    public String getPointOfDelivery() {
        return pointOfDelivery;
    }

    public void setPointOfDelivery(String pointOfDelivery) {
        this.pointOfDelivery = pointOfDelivery;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getTime() {
        return time1;
    }

    public void setTime(String time) {
        this.time1 = time;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
