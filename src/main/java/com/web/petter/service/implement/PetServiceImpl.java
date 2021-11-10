package com.web.petter.service.implement;



import com.web.petter.commons.GenericServiceImpl;
import com.web.petter.model.Pet;
import com.web.petter.repository.PetRepo;
import com.web.petter.service.api.PetServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class PetServiceImpl extends GenericServiceImpl<Pet, Integer> implements PetServiceAPI {

    @Autowired
    private PetRepo petRepo;

    @Override
    public CrudRepository<Pet, Integer> getRepository() {
        return petRepo;
    }
}
