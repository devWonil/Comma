package com.JMThouseWeb.JMThouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.JMThouseWeb.JMThouse.dto.KakaoProfile;
import com.JMThouseWeb.JMThouse.dto.KakaoProfile.KakaoAccount;
import com.JMThouseWeb.JMThouse.dto.NaverProfile;
import com.JMThouseWeb.JMThouse.dto.NaverProfile.NaverAccount;
import com.JMThouseWeb.JMThouse.dto.OAuthToken;
import com.JMThouseWeb.JMThouse.dto.OAuthTokenNaver;
import com.JMThouseWeb.JMThouse.model.User;
import com.JMThouseWeb.JMThouse.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Value("${tenco.key}")
	private String tencoKey;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@GetMapping({"", "/"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/auth/login_form")
	public String loginForm() {
		return "user/login_form";
	}

	@GetMapping("/auth/join_form")
	public String joinForm(User user) {
		return "user/join_form";
	}
	
	@GetMapping("/user/update_form")
	public String updateForm() {
		return "user/update_form";
	}

	@GetMapping("/logout")
	public String logout() {
		return "redirect:/";
	}

	@PostMapping("/auth/joinProc")
	public String saveUser(User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@PostMapping("/auth/hostJoinProc")
	public String saveHost(User user) {
		userService.saveHost(user);
		return "redirect:/";
	}
	
	@GetMapping("/reservation-history/{guestId}")
	public String reservationHistory(@PathVariable int guestId) {
		return "user/reservation_history";
	}
	
	// test
	@GetMapping("/reservation-info")
	public String reservationHistory() {
		return "user/history_form";
	}
	
	// 카카오 로그인 api
	@GetMapping("/auth/kakao/callback")
	public String kakaoCallback(@RequestParam String code) {
		// HTTPURLConnect ...
		// Retrofit2
		// OkHttp
		// RestTemplate
		RestTemplate rt = new RestTemplate();
		
		// http 메시지 -> POST
		
		// 시작줄
		// http header
		// http body
		
		// header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// body 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		
		params.add("grant_type", "authorization_code");
		params.add("client_id", "5364d58a9b4f08506ac63105133f69bb");
		params.add("redirect_uri", "http://localhost:9090/auth/kakao/callback");
		params.add("code", code);
		
		// header와 body를 하나의 object로 담아야한다.
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);
		
		// 준비 끝 Http 요청 - post 방식 - 응답
		ResponseEntity<String> response = 
				rt.exchange("https://kauth.kakao.com/oauth/token", 
						HttpMethod.POST, kakaoTokenRequest, String.class);
		
		// response -> object 타입으로 변환 (Gson, Json Simple, ObjectMapper)
		OAuthToken authToken = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		// String --> Object (클래스 생성)
		try {
			authToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 액세스 토큰 사용
		RestTemplate rt2 = new RestTemplate();
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + authToken.getAccessToken()); // Bearer 무조건 한 칸 띄움
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8 ");		
		
		// body
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers2);
		
		ResponseEntity<KakaoProfile> kakaoProfileResponse = rt2.exchange("https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST,
				kakaoProfileRequest,
				KakaoProfile.class);
		
		// 소셜로인 처리 --> 
		// 사용자가 로그인 했을 경우 최초 사용자라면
		// -> 회원가입 처리 한다.
		// -> 한번이라도 가입 진행이 된 사용자면 로그인 처리를 해주면 된다. 
		// -> 만약 회원 가입시 필요한 정보 더 있어야 된다면 추가로 사용자 한테 정보를 받아서 가입 진행 처리를 
		// 해야 한다. 
		
		KakaoAccount account = kakaoProfileResponse.getBody().getKakaoAccount();
		
		System.out.println("카카오 아이디 : " + kakaoProfileResponse.getBody().getId());
		System.out.println("카카오 이메일 : " + account.getEmail());
		
		System.out.println("블로그에서 사용 될 유저네임 " + account.getEmail() + "_" +  kakaoProfileResponse.getBody().getId());
		System.out.println("블로그에서 사용 될 이메일 " + account.getEmail());
		
		User kakaoUser = User.builder()
				.username(account.getEmail() + "_" +  kakaoProfileResponse.getBody().getId())
				.password(tencoKey)
				.email(account.getEmail())
				.oauth("kakao")
				.build();
		
		System.out.println(kakaoUser);
		
		// 1. UserService 호출해서 저장 진행 
		// 단, 소셜 로그인 요청자가 이미 가입된 유저라면 저장(x) 
		
		User originUser = userService.searchUser(kakaoUser.getUsername());
		
		if(originUser.getUsername() == null) {
			System.out.println("신규 회원이 아니기 때문에 회원가입을 진행");
			userService.saveUser(kakaoUser);
		}
		
		// 자동 로그인 처리 -> 시큐리티 세션에다가 강제 저장   
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(), tencoKey));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/";
	}
	
	
	
	// 네이버 로그인 api
	@GetMapping("/auth/naver/callback")
	public String naverCallback(@RequestParam String code) {
		// HTTPURLConnect ...
		// Retrofit2
		// OkHttp
		// RestTemplate
		RestTemplate rt = new RestTemplate();
		
		// http 메시지 -> POST
		
		// 시작줄
		// http header
		// http body
		
		// header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// body 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		
		params.add("grant_type", "authorization_code");
		params.add("client_id", "2cK0pKD9po4g6u193Yto");
		params.add("redirect_uri", "http://localhost:9090/auth/naver/callback");
		params.add("code", code);
		
		// header와 body를 하나의 object로 담아야한다.
		HttpEntity<MultiValueMap<String, String>> naverTokenRequest = new HttpEntity<>(params, headers);
		
		// 준비 끝 Http 요청 - post 방식 - 응답
		ResponseEntity<String> response = 
				rt.exchange("https://nauth.naver.com/oauth/token", 
						HttpMethod.POST, naverTokenRequest, String.class);
		
		// response -> object 타입으로 변환 (Gson, Json Simple, ObjectMapper)
		OAuthTokenNaver authTokenNaver = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		// String --> Object (클래스 생성)
		try {
			authTokenNaver = objectMapper.readValue(response.getBody(), OAuthTokenNaver.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 액세스 토큰 사용
		RestTemplate rt2 = new RestTemplate();
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer " + authTokenNaver.getAccessToken()); // Bearer 무조건 한 칸 띄움
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8 ");		
		
		// body
		HttpEntity<MultiValueMap<String, String>> naverProfileRequest = new HttpEntity<>(headers2);
		
		ResponseEntity<NaverProfile> naverProfileResponse = rt2.exchange("https://openapi.naver.com/v1/nid/me",
				HttpMethod.POST,
				naverProfileRequest,
				NaverProfile.class);
		
		// 소셜로인 처리 --> 
		// 사용자가 로그인 했을 경우 최초 사용자라면
		// -> 회원가입 처리 한다.
		// -> 한번이라도 가입 진행이 된 사용자면 로그인 처리를 해주면 된다. 
		// -> 만약 회원 가입시 필요한 정보 더 있어야 된다면 추가로 사용자 한테 정보를 받아서 가입 진행 처리를 
		// 해야 한다. 
		
		NaverAccount account = naverProfileResponse.getBody().getNaverAccount();
		
		System.out.println("네이버 아이디 : " + naverProfileResponse.getBody().getId());
		System.out.println("네이버 이메일 : " + account.getEmail());
		
		System.out.println("블로그에서 사용 될 유저네임 " + account.getEmail() + "_" +  naverProfileResponse.getBody().getId());
		System.out.println("블로그에서 사용 될 이메일 " + account.getEmail());
		
		User naverUser = User.builder()
				.username(account.getEmail() + "_" +  naverProfileResponse.getBody().getId())
				.password(tencoKey)
				.email(account.getEmail())
				.oauth("naver")
				.build();
		
		System.out.println(naverUser);
		
		// 1. UserService 호출해서 저장 진행 
		// 단, 소셜 로그인 요청자가 이미 가입된 유저라면 저장(x) 
		
		User originUser = userService.searchUser(naverUser.getUsername());
		
		if(originUser.getUsername() == null) {
			System.out.println("신규 회원이 아니기 때문에 회원가입을 진행");
			userService.saveUser(naverUser);
		}
		
		// 자동 로그인 처리 -> 시큐리티 세션에다가 강제 저장   
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(naverUser.getUsername(), tencoKey));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/";
	}
}
