package com.ws.budget.bee.controller;

import com.ws.budget.bee.domain.subscription.Subscription;
import com.ws.budget.bee.domain.subscription.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping(name = "/subscription")
@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping()
    public ResponseEntity<Page<Subscription>> findAll (Pageable paginacao) {
        List<Subscription> subscriptions = subscriptionService.findAll();
        Page<Subscription> page = new PageImpl<>(subscriptions, paginacao, subscriptions.size());

        return ResponseEntity.ok(page);
    }
}