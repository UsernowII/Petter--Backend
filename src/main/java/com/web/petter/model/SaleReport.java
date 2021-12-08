package com.web.petter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class SaleReport {
	
	private int customerId;
	private String customerName;
	private double totalSale;

}
