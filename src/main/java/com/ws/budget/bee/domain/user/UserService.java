package com.ws.budget.bee.domain.user;

import com.ws.budget.bee.domain.subscription.SubscriptionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private SubscriptionService subscriptionService;

    public User create (User user) {
        if(userRepository.existsById(user.getId())) {
            throw new RuntimeException("User with id " + user.getId() + " already exists");
        }
        subscriptionService.getSubscription(user.getSubscriptions().getId());
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        if(userRepository.existsById(id)) {
            throw new RuntimeException("User with id " + id + " not found");
        }
        return userRepository.getReferenceById(id);
    }

    public User update(User user) {
        User userToUpdate = findById(user.getId());
        userToUpdate.update(userToUpdate);
        return userToUpdate;
    }
}