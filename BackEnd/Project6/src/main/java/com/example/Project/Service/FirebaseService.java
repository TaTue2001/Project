//package com.example.Project.Service;
//
//import org.springframework.stereotype.Service;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.UserRecord;
//
//@Service
//public class FirebaseService {
//	public void sendEmailVerification(String email) {
//        try {
//            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);
//            FirebaseAuth.getInstance().generateEmailVerificationLink(userRecord.getEmail());
//        } catch (FirebaseAuthException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void sendPasswordResetEmail(String email) {
//        try {
//            FirebaseAuth.getInstance().generatePasswordResetLink(email);
//        } catch (FirebaseAuthException e) {
//            e.printStackTrace();
//        }
//    }
//}
