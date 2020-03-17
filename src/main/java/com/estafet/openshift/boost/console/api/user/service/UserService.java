package com.estafet.openshift.boost.console.api.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estafet.openshift.boost.console.api.user.model.User;
import com.estafet.openshift.boost.console.api.user.openshift.OpenShiftClient;
import com.openshift.restclient.model.user.IUser;

@Service
public class UserService {

	@Autowired
	private OpenShiftClient client;

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();;
		List<IUser> iusers = client.getUsers();
		for (IUser iuser : iusers) {
		    System.out.println(iuser); 
		    User user = new User();
		    user.setName(iuser.getFullName());
			users.add(user);
		}		
		return users;
	}
}