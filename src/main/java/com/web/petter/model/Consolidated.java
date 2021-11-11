package com.web.petter.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@Document(collection ="db_consolidated")
public class Consolidated {

    private int id;
    private String city;
    private double totalSales;
}
