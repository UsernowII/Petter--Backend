package com.web.petter.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "db_sales")
public class salesDetail {


    private int quantity;
    private int petId;
    private double salePrice;
    private double ivaPrice;
    private double totalPrice;

}
