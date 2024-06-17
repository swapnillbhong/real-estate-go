//package com.example.realestatego.service.impl;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.example.realestatego.entity.Users;
//import com.example.realestatego.repository.UserRepository;
//
//@Component
//public class UserDetailService implements UserDetailsService {
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		If the user is not found, it throws a UsernameNotFoundException
//
////		now this will Loads a user by the given username.
//		Optional<Users> user = userRepository.findByUsername(username);
//		return user.map(UserPrincipal::new).orElseThrow(() -> new
//				 UsernameNotFoundException("user not found"));
////		if (user == null)
////			throw new UsernameNotFoundException("User not found " + username);
////		return new UserPrincipal(user);
//
//	}
//
//}
