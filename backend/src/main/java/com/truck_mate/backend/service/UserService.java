package com.truck_mate.backend.service;

import com.truck_mate.backend.Model.User;
import com.truck_mate.backend.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser( String fname, String lname,String email, String pw ){

        User user = repo.findByEmail(email);

       User use=new User();
        use.setFname(fname);
        use.setLname(lname);
        use.setEmail(email);
        use.setPw(pw);

       return repo.save(use);

    }

    public List<User> showAll(){

        return repo.findAll();
    }

    public User showUser(String email){

        return repo.findByEmail(email);
    }
}
