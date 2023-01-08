package com.project.secrettalk.config;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class SdkConfig {
    private FirebaseOptions option;
    private Firestore db; 
    
    //아마도 firebase 호스팅 할 앱위치에 json 파일 위치로 변경되어야 할..듯?
    private final static String PATH = "C:/secrettalk-firebase-adminsdk-dmys2-3a56c67046.json";
    private final static String COLLECTION_NAME = "컬렉션";

    @PostConstruct
    public void init(){
        try{
            FileInputStream serviceAccount = 
            	new FileInputStream(PATH);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://SecretTalk.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
