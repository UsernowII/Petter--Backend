package com.web.petter.service.implement;

import com.web.petter.commons.GenericServiceImpl;
import com.web.petter.model.Sale;
import com.web.petter.repository.SaleRepo;
import com.web.petter.service.api.SaleServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class SaleServiceImpl extends GenericServiceImpl<Sale,Integer> implements SaleServiceApi {

    @Autowired
    private SaleRepo saleRepo;

    @Override
    public CrudRepository<Sale, Integer> getRepository() {
        return saleRepo;
    }
}
