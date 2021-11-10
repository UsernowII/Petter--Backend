package com.web.petter.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "db_customer")
public class Customer {

    @Id
    private int customerId;
    private String customerAddress;
    private String customerEmail;
    private String customerName;
    private String customerPhone;

}
