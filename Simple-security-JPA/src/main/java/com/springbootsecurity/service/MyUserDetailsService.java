package com.springbootsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootsecurity.model.MyUserDetails;
import com.springbootsecurity.model.User;
import com.springbootsecurity.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// return new MyUserDetails(username);

		Optional<User> user = userRepository.findUserByUserName(username);

		System.out.println("USER IS " + user.toString());
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found " + username));
		return user.map(MyUserDetails::new).get();
	}

}
