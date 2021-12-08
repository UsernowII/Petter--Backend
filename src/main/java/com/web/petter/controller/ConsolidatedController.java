package com.web.petter.controller;

import com.web.petter.model.Consolidated;
import com.web.petter.service.api.ConsolidatedServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consolidated")
@CrossOrigin(origins="*")
public class ConsolidatedController {

    @Autowired
    private ConsolidatedServiceAPI consolidatedServiceAPI;

    @PostMapping("/add")
    public ResponseEntity<Consolidated> createConsolidated(@RequestBody Consolidated consolidated){
    	List<Consolidated> consolidados = consolidatedServiceAPI.getAll();
    	
    	Consolidated consolidado = null;
    	for(int cont = 0; cont < consolidados.size(); cont++) {
    		if (consolidados.get(cont).getCity() == consolidated.getCity()) {
    			consolidado = consolidados.get(cont);
    			break;
    		}
    	}
    	
    	if (consolidado==null)
    		consolidado = consolidated;
    	else
    		consolidado.setTotalSales(consolidated.getTotalSales());
    	
        Consolidated obj = consolidatedServiceAPI.save(consolidated);
        return new ResponseEntity<Consolidated>(obj, HttpStatus.CREATED);

    }

    @GetMapping("/find/all")
    public List<Consolidated> readConsolidated(){
        return consolidatedServiceAPI.getAll();
    }


}
