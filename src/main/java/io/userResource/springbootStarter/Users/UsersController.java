package io.userResource.springbootStarter.Users;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.userResource.resources.UserDetails;

@RestController
public class UsersController {

	
	@Autowired
	private UsersService userService;
	
	
	@RequestMapping("/Allusers")
	public ResponseEntity<List<UserDetails>> getAllUsers()
	{
		List userList= userService.getAllUsers();
		return ResponseEntity.ok(userList);
	}
	@RequestMapping("/users")
	public ResponseEntity<List<UserDetails>> getActiveUsers()
	{
		List userList=userService.getActiveUsers();
		return ResponseEntity.ok(userList);
		
	}
	
	@RequestMapping("/users/{id}")
	public ResponseEntity<UserDetails> getUser(@PathVariable String id)
	{
		return ResponseEntity.ok(userService.getUser(id));
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/users")
	public ResponseEntity<String> addUser(@RequestBody UserDetails user)
	{
		return ResponseEntity.ok("Successfully added user :"+userService.addUser(user));

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/users/{id}")
	public ResponseEntity < String > deleteUser(@PathVariable String id)
	{
		 return ResponseEntity.ok("Successfully deleted user :"+userService.deleteTopic(id)); 
		 
	}
	
	/*TODO update this*/
	@RequestMapping(method = RequestMethod.PUT, value="/users/{id}")
	public ResponseEntity < String > updateUser(@RequestBody UserDetails topic, @PathVariable String id)
	{
		return(ResponseEntity.ok("Successfully updated user : "+userService.updateUser(topic,id))); 
		//return new ResponseEntity<String>(userService.updateUser(topic,id), HttpStatus.OK);
	}
	
	@ExceptionHandler
	void handleException(Exception e, HttpServletResponse response) throws IOException {
	    response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
}
