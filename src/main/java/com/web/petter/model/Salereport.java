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


public class Salereport {
	
	private int customerId;
	private String customerName;
	private double totalSale;

}
