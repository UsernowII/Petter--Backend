package com.web.petter.service.implement;



import com.web.petter.commons.GenericServiceImpl;
import com.web.petter.model.Consolidated;
import com.web.petter.repository.ConsolidatedRepo;
import com.web.petter.service.api.ConsolidatedServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class ConsolidatedServiceImpl extends GenericServiceImpl<Consolidated, Integer> implements ConsolidatedServiceAPI {

    @Autowired
    private ConsolidatedRepo consolidatedRepo;

    @Override
    public CrudRepository<Consolidated, Integer> getRepository() {
        return consolidatedRepo;
    }
}
