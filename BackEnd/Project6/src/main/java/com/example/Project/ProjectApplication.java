package com.example.Project;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.example.Project.Entity.User;
//import com.example.Project.Entity.Role;
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = "com.example.Project")
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
//	@Bean 
//	BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
	
//	}
//	@Bean 
//	CommandLineRunner run (UserService userService) {
//		return args->{
//			userService.saveUser(new User(null, "taxuantue", "tue@2001", null, null, null, null, null));
//			userService.saveUser(new User(null, "nguyentranbinhan", "an@2001", null, null, null, null, null));
//			userService.saveUser(new User(null, "nguyentuandung", "dung@2001", null, null, null, null, null));
//			userService.saveUser(new User(null, "dinhtiendat", "dat@2001", null, null, null, null, null));
//			
//			userService.saveRole(new Role(null, 1, "Role_User", null, null, null, null, null));
//			userService.saveRole(new Role(null, 2, "Role_Manage", null, null, null, null, null));
//			userService.saveRole(new Role(null, 3, "Role_Admin", null, null, null, null, null));
//			userService.saveRole(new Role(null, 4, "Role_Super_Admin", null, null, null, null, null));
//			
//			userService.addToUser("dinhtiendat", "Role_User");
//			userService.addToUser("nguyentuandung", "Role_User");
//			userService.addToUser("nguyentranbinhan",  "Role_User");
//			userService.addToUser("nguyentranbinhan", "Role_Manage");
//			userService.addToUser("nguyentranbinhan", "Role_Admin");
//			userService.addToUser("taxuantue","Role_User");
//			userService.addToUser("taxuantue", "Role_Super_Admin");	
//		};
//	}
}
