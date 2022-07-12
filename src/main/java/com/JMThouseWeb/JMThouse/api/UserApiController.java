package com.JMThouseWeb.JMThouse.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JMThouseWeb.JMThouse.dto.ResponseDto;
import com.JMThouseWeb.JMThouse.model.User;
import com.JMThouseWeb.JMThouse.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession httpSession){
//		System.out.println("login 호출됨");
//		// 서비스한테 요청
//		User principal = userService.login(user);
//		// 접근 주체가 정상적으로 username, password 확인! (세션이라는 거대한 메모리에 저장)
//		if (principal != null) {
//			httpSession.setAttribute("principal", principal);
//			System.out.println("세션 정보가 저장되었습니다");
//		}
//		
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}

	@PutMapping("/user/info")
	public ResponseDto<Integer> updateUserInfo(@RequestBody User user) {
		userService.updateUserInfo(user);
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}