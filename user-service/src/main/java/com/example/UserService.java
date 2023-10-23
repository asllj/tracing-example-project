package com.example;

import com.example.client.Operation;
import com.example.client.ReportingWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
public class UserService {

    private ReportingWebClient client;
    private UserRepository repository;


    public UserService(UserRepository userRepository){
        this.repository=userRepository;
    }

    public User getUser(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User does not exists"));
    }

    public User saveUser(User user){
        User savedUser = repository.save(user);
        client.createUserReporting(savedUser.getId(),user.getName(), Operation.CREATE);
        return savedUser;
    }

    public User updateUser(Long id,User user){
        User oldUser = repository.findById(id).orElseThrow(() -> new RuntimeException("User does not exists"));
        oldUser.setName(user.getName());
        oldUser.setAddress(Objects.isNull(user.getAddress())?oldUser.getAddress():user.getAddress());
        User newUser = repository.save(user);
        client.createUserReporting(newUser.getId(),user.getName(), Operation.UPDATE);
        return newUser;
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
        client.createUserReporting(id,null, Operation.DELETE);
    }

}
