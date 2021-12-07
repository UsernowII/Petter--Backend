package com.web.petter.controller;


import com.web.petter.model.Sale;
import com.web.petter.service.api.SaleServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleServiceApi saleServiceApi;

    @PostMapping("/add")
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale){
    	int consec = 0;
    	List<Sale> ventas = saleServiceApi.getAll();
    	
    	if(!ventas.isEmpty()) {
    		Sale maxSale = Collections.max(ventas, Comparator.comparing(c -> c.getSaleId()));
    		consec = maxSale.getSaleId();
    	}
    	
    	
    	sale.setSaleId(consec + 1);
        Sale obj = saleServiceApi.save(sale);
        return new ResponseEntity<Sale>(obj, HttpStatus.CREATED);

    }

    @GetMapping("/find/all")
    public List<Sale> readSales(){
        return saleServiceApi.getAll();
    }

    @GetMapping("/find/{id}")
    public Sale readSale(@PathVariable int id){
        return saleServiceApi.get(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sale> deleteCustomer(@PathVariable int id){
        Sale obj = saleServiceApi.get(id);
        if (obj != null){
            saleServiceApi.delete(id);
        }else{
            return new ResponseEntity<Sale>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Sale>(obj, HttpStatus.OK);
    }



}
