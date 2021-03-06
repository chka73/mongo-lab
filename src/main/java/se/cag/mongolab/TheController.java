package se.cag.mongolab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.cag.mongolab.usermanager.User;
import se.cag.mongolab.usermanager.UserManager;

import java.util.List;
import java.util.Map;

@RestController
public class TheController {
    @Autowired
    private UserManager userManager;

    @RequestMapping("/getusers")
    public List<User> getUsers() {
        return userManager.getUsers();
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        return userManager.registerNewUser(user.getName(), user.getEmail(), user.getPassword());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody Map<String, String> payload) {
        return userManager.login(payload.get("username"), payload.get("password"));
    }
}
