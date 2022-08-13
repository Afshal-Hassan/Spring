package com.example.restapis.Model;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Shared_Container")
@Getter
@Setter
public class ShareContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int container_Id;
    private String name;
    private String pointOfDelivery;
    private String pointOfLoading;
    private String productWeight;
    private String phoneNo;

    private String dateOfUploading;

}
