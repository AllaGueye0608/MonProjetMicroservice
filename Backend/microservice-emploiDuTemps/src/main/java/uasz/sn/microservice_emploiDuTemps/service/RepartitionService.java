package uasz.sn.microservice_emploiDuTemps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uasz.sn.microservice_emploiDuTemps.model.RepartitionClient;
import uasz.sn.microservice_emploiDuTemps.repository.RepartitionRepository;

@Service
public class RepartitionService {
    @Autowired
    private RepartitionClient repartitionClient;
    @Autowired
    private RepartitionRepository repartitionRepository;

    
}
