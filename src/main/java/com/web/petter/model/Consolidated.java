package com.web.petter.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@Document(collection ="db_consolidated")
public class Consolidated {

    @Id
    private String _id;
    private String city;
    private BigDecimal totalSales;
}
