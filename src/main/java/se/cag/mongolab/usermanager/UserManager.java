package se.cag.mongolab.usermanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserManager {
    @Autowired
    private UserRepository repository;


    public boolean registerNewUser(String name, String email, String password){
        User user = new User(name, email, password);
        repository.insert(user);
        return true;
    }

    public User login(String email, String password){
        return repository.login(email,password);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }
}
