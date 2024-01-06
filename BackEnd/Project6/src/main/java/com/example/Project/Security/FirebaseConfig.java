//package com.example.Project.Security;
//
//import java.io.IOException;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//
//import java.io.FileInputStream;
//
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
//@Configuration
//public class FirebaseConfig {
//	@Bean
//    public static FirebaseApp initializeFirebaseApp() throws IOException {
//        FileInputStream serviceAccount = new FileInputStream("firebase-adminsdk.json");
//
//
//        		FirebaseOptions options = new FirebaseOptions.Builder()
//        		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//        		  .build();
//
//        		FirebaseApp.initializeApp(options);
//
//        return FirebaseApp.initializeApp(options);
//    }
//}
