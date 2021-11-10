package com.web.petter.service.implement;



import com.web.petter.commons.GenericServiceImpl;
import com.web.petter.model.Customer;
import com.web.petter.repository.CustomerRepo;
import com.web.petter.service.api.CustomerServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Integer> implements CustomerServiceAPI {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CrudRepository<Customer, Integer> getRepository() {
        return customerRepo;
    }
}
