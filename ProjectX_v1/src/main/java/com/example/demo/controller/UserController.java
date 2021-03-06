package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;


@Controller
@CrossOrigin(origins = {"*"})
public class UserController {
	
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAll() {
        List<User> list = userService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
    public User save(@RequestBody User user) {
		return userService.save(user);
    }
	
	@RequestMapping(value = "/user/email/{email}", method = RequestMethod.GET)
	@ResponseBody
    public User findByEmail(@PathVariable("email") String email) {
		return userService.findByEmail(email);
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
    public User update(@RequestBody User user) {
		return userService.update(user);
    }
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@ResponseBody
    public void delete(@PathVariable String id) {
		userService.delete(id);
    }
	
	
}
