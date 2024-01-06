package com.example.Project.Controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Auth.AuthenticationRequest;
import com.example.Project.Auth.AuthenticationResponse;
import com.example.Project.Entity.Account;
import com.example.Project.Entity.RequestSignUp;
import com.example.Project.Interface.Service.IAccountService;
import com.example.Project.Interface.Service.IAdminService;
import com.example.Project.Repository.RoleAccountRepository;
import com.example.Project.Response.MyDataObject;
import com.example.Project.Response.ResponseAPI;
import com.example.Project.Response.StatusResponse;
import com.example.Project.Security.AccountUserDetail;
import com.example.Project.Security.JwtAuthenticationFilter;

import com.example.Project.Security.JwtTokenProvider;
import com.example.Project.Service.AccountService;
import com.example.Project.Service.AdminService;

//@Slf4j
@RestController
public class AdminController {
	private static final HttpServletRequest HttpServletRequest = null;

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	@Autowired
	private IAdminService iAdminService;
	@Autowired
	private IAccountService iAccountService;
	@Autowired
	private RoleAccountRepository roleAccountRepository;
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/login")
	public ResponseEntity<?> authenticateAccount(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), 
					authenticationRequest.getPassword()
					));
			String accessToken = tokenProvider.generateToken((AccountUserDetail) authentication.getPrincipal());
			String refreshToken= tokenProvider.generateRefreshToken((AccountUserDetail) authentication.getPrincipal());
			AuthenticationResponse authenticationResponse=new AuthenticationResponse(accessToken,refreshToken, userDetailsService.loadUserByUsername(authenticationRequest.getUsername()) );
			return ResponseEntity.ok(authenticationResponse);
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
		}

	}
    @GetMapping("/me")
    public Object randomStuff(HttpServletRequest request ){
        return jwtAuthenticationFilter.getUser(request);
    }
    @GetMapping("/logout-once")
    public ResponseEntity<?> logout(){
    	try {
			SecurityContextHolder.clearContext();
			ResponseAPI response =new ResponseAPI(StatusResponse.SUCCESS, null, null);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Logout failed: ");
		}
    }
    @GetMapping("/random")
    public Object random(HttpServletRequest request ){
        return jwtAuthenticationFilter.getCustomer();
    }
    @PostMapping("/set-condition-of-order")
    public String SetCondition(@RequestParam String OrderId, @RequestParam String conditionId) {
    	try {
    		String rs=iAdminService.SetConditionOfOrder(OrderId, conditionId);
    		if(conditionId.equals("f9a8462f-86b3-4c76-b66e-017b8a225d1f"))
    			iAdminService.isComplete(OrderId);
			return "set condition of order success";
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
//    @PostMapping("/sign-up-employee")
//    public String signUp(@RequestBody RequestSignUp requestSignUp) {
//    	iAccountService.SignUpEmployee(requestSignUp);
//    	return "SignUp Employee success";
//    }
    @GetMapping("/test/{Id}")
    public Account getSingleAccount(@PathVariable String Id) {
    	return accountService.getAccountn(Id);
    }
    
}
