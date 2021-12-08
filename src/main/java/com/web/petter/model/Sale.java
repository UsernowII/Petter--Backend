package com.web.petter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@ToString
@Document(collection = "db_sales")
public class Sale {

    private int customerId;
    @Id
    private int saleId;
    private List<salesDetail> salesDetail;
    private double ivaSale;
    private double totalSaleProduct;
    private double totalSale;

}
