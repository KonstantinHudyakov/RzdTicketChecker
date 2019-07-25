package org.khudyakov.rzd.server;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static final String GOOGLE_TOKEN_FILE = "rzdticketchecker-d1a30-firebase-adminsdk-02kdy-df4ef772ca.json";

    public static void main(String[] args) throws IOException {
        InputStream tokenStream = Main.class.getClassLoader().getResource(GOOGLE_TOKEN_FILE).openStream();
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(tokenStream))
                .setDatabaseUrl("https://rzdticketchecker-d1a30.firebaseio.com")
                .build();
        tokenStream.close();

        FirebaseApp.initializeApp(options);
    }
}
