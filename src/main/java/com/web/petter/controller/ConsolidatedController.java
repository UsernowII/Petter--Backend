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
public class ConsolidatedController {

    @Autowired
    private ConsolidatedServiceAPI consolidatedServiceAPI;

    @PostMapping("/add")
    public ResponseEntity<Consolidated> createConsolidated(@RequestBody Consolidated consolidated){
        Consolidated obj = consolidatedServiceAPI.save(consolidated);
        return new ResponseEntity<Consolidated>(obj, HttpStatus.CREATED);

    }

    @GetMapping("/find/all")
    public List<Consolidated> readConsolidated(){
        return consolidatedServiceAPI.getAll();
    }

    @GetMapping("/find/{id}")
    public Consolidated readConsolidated(@PathVariable int id){
        return consolidatedServiceAPI.get(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Consolidated> deleteCustomer(@PathVariable int id){
        Consolidated consolidated = consolidatedServiceAPI.get(id);
        if (consolidated != null){
            consolidatedServiceAPI.delete(id);
        }else{
            return new ResponseEntity<Consolidated>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Consolidated>(consolidated, HttpStatus.OK);
    }



}
