package io.userResource.springbootStarter.Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import io.userResource.resources.UserDetails;

@Service
public class UsersService {

	Map<String,UserDetails> userMap = new HashMap<String,UserDetails>() {
        {
            put("1",new UserDetails("1","Prashant","Singh","singh.prashant1603@gmail.com","411007","16-03-991"));
            put("2",new UserDetails("2","Jhon","Singh","singh.jhon@gmail.com","411256","14-10-1992"));
            put("3",new UserDetails("3","Alex","Baraon","baraon.alex@gmail.com","425669","17-02-1889"));
           	put("4",new UserDetails("4","Alex","Baraon","baraon.alex@gmail.com","425669","17-02-1889",false));
        }
        };
		
			
        /**
         * Return List of all the Active and Non-Active users
         * */
	public List<UserDetails> getAllUsers() {
	
		
		List<UserDetails> userList =userMap.values().stream().filter(u -> u.isActive()) .collect(Collectors.toList());
		
		if(userList ==null || userList.isEmpty() )
		{
			throw new  NullPointerException("There is no user present in the table");
			
		}
		return userMap.values().stream().collect(Collectors.toList());
	}
	/**
     * Return List of all the Active users.
     * */
	public List<UserDetails> getActiveUsers() {
		
		List<UserDetails> userList =userMap.values().stream().filter(u -> u.isActive()) .collect(Collectors.toList());
		
		if(userList ==null || userList.isEmpty() )
		{
			throw new  NullPointerException("There is no active user present in the table");
			
		}
		return userList;
	}

	/**
     * Adds the give user in the table.
     * */
	public String addUser(UserDetails user) {
		
		
		if((user.getId()==null || user.getId().isEmpty()) ||
				(user.getfName() ==null || user.getfName().isEmpty())  ||
				(user.getlName() ==null || user.getlName().isEmpty())  ||
				(user.getEmail() ==null || user.getEmail().isEmpty())
			)
		{
			/*Report Invalid Obeject*/
			throw new IllegalArgumentException("The \"id\", \"fname\",\"lname\" and/or \"email\"  parameter must not be null or empty fo the Create request");
		}		
		boolean idExists = userMap.containsKey(user.getId());
		if(!idExists) {
			userMap.put(user.getId(),user);
		}else
		{
			UserDetails u = userMap.get(user.getId());
			/*If the user is already there in table, but is invactive, then mark is as active and
			 * update the birthdate and pincode
			 * */
			if(!u.isActive())
			{ 
				u.setActive(true);
				u.setBirthDate(user.getBirthDate());
				u.setPinCode(user.getPinCode());
				
			}else
			{
				throw new IllegalArgumentException("Entered \"id\" is already present in the table \n Please note, the \"id\" for a every user shlould be unique");	
			}
		}

		return user.getId();
	}

	/**
     * Deletes the given user in the table
     * Basically the entry is present in the table, but the user is marked as inactive 
     * */
	public String deleteTopic(String id) {
		// TODO Auto-generated method stub
		
			if(id==null || id.isEmpty()) {
				throw new IllegalArgumentException("The \"id\" value cannot be NULL or Empty");
			}
			UserDetails user= userMap.get(id);
			if(user !=null && user.isActive())
			{
				user.setActive(false);
				
			}
			else
			{
				throw new IllegalArgumentException("Invalid User \"id\"");
			}
		
		return id;
	}
	
	/**
	 * Updates the existing user the table.
	 * */

	public String updateUser(UserDetails user, String id) {
				
			if((user.getBirthDate()==null || user.getBirthDate().isEmpty()) ||
					(user.getPinCode() ==null || user.getPinCode().isEmpty())
				)
			{
				throw new IllegalArgumentException("The \"birthDate\" and/or \"pinCode\"  parameter must not be null or empty for the update request");
			}
			UserDetails u= userMap.get(id);
			if(u!=null)
			{
				//userList.set(i, topic);
				u.setBirthDate(user.getBirthDate());
				u.setPinCode(user.getPinCode());
				
			}else
			{
				throw new NullPointerException("Invalid user id, no such user exists in the table");
			}
		
			return id;
		
	}

	/**Returns details of the specific user*/
	public UserDetails getUser(String id) {
		// TODO Auto-generated method stub
		UserDetails user =userMap.get(id); 
		if(user== null)
		{
			throw new NullPointerException("Invalid user id, no such user exists in the table");
			
		}
		return user;
	}
	
}
