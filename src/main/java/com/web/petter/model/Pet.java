package com.web.petter.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@ToString
@Document(collection = "db_pets")
public class Pet {

    @Id
    private int petId;
    private String petName;
    private Long nitProvider;
    private double buyPrice;
    private double ivaPrice;
    private double salePrice;

}
