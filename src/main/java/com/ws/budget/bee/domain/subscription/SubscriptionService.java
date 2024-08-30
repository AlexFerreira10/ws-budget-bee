package com.ws.budget.bee.domain.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscription(Long id) {
        if(!subscriptionRepository.existsById(id)) {
            throw new RuntimeException("Subscription with id " + id + " not found!");
        }
        return subscriptionRepository.getReferenceById(id);
    }
}