package com.web.petter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.petter.model.Customer;
import com.web.petter.model.Sale;
import com.web.petter.model.SaleReport;
import com.web.petter.service.api.CustomerServiceAPI;
import com.web.petter.service.api.SaleServiceApi;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/reports")

public class ReportsController {
	 @Autowired
	    private SaleServiceApi  saleServiceAPI;
	 @Autowired
	    private CustomerServiceAPI  customerserviceapi;

	
	@GetMapping("customer/sales")
    public List<SaleReport> getcustomersalereport(){
		Map<Integer, SaleReport> map = new HashMap<Integer, SaleReport>();
		List<Sale> ventas= saleServiceAPI.getAll();
		for (int i = 0; i< ventas.size();i++) {
			Sale venta =ventas.get(i);
			
			if (!map.containsKey(venta.getCustomerId())) {
				Customer cliente= customerserviceapi.get(venta.getCustomerId());
				SaleReport sale = new SaleReport();
				sale.setCustomerId(venta.getCustomerId());
				sale.setCustomerName(cliente.getCustomerName());
				sale.setTotalSale(0);
				map.put(venta.getCustomerId(),  sale);
			}
			SaleReport clienteVenta =map.get(venta.getCustomerId());
			clienteVenta.setTotalSale(clienteVenta.getTotalSale()+venta.getTotalSale());
		}
		return new ArrayList<SaleReport>(map.values());
    }
}
