package com.Herve01.App.Restful.API.Controller;

import com.Herve01.App.Restful.API.Model.User;
import com.Herve01.App.Restful.API.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class ApiControllers {
    @Autowired
    private UserRepository userRepository;

@GetMapping(value ="/")
    public String getPage() {
        return "I Will Be Back!";
    }
@GetMapping(value = "/users")
    public List<User> getUser() {
    return userRepository.findAll();

    }
@PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
    userRepository.save(user);
    return "Saved Successfully.. ";
}
@PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){

    User updateUser = userRepository.findById(id).get();
    updateUser.setId(id);
    updateUser.setFirstname(user.getFirstname());
    updateUser.setLastname(user.getLastname());
    updateUser.setEmail(user.getEmail());
    updateUser.setOccupation(user.getOccupation());
    userRepository.save(updateUser);
    return "Updated Successfully..";
    }

    @DeleteMapping("/Delete/{id}")
    public String deleteUser(@PathVariable long id){
    userRepository.deleteById(id);

    return "User at position"+ id+" "+ "Was Deleted Successfully.";

}
}
