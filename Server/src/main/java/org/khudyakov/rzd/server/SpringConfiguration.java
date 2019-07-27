package org.khudyakov.rzd.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@ComponentScan("org.khudyakov.rzd.server")
public class SpringConfiguration {
    private static final String GOOGLE_TOKEN_FILE = "rzdticketchecker-d1a30-firebase-adminsdk-02kdy-df4ef772ca.json";

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter jacksonConverter =
                new MappingJackson2HttpMessageConverter(new ObjectMapper());
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(new MediaType("text", "javascript", Charset.forName("UTF-8")));
        mediaTypes.add(new MediaType("text", "html", Charset.forName("UTF-8")));
        jacksonConverter.setSupportedMediaTypes(mediaTypes);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(jacksonConverter);
    //    messageConverters.add(new FormHttpMessageConverter());

        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    @Bean
    FirebaseMessaging firebaseMessaging() {
        try {
            InputStream tokenStream = Main.class.getClassLoader().getResource(GOOGLE_TOKEN_FILE).openStream();
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(tokenStream))
                    .setDatabaseUrl("https://rzdticketchecker-d1a30.firebaseio.com")
                    .build();
            tokenStream.close();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            throw new RuntimeException("Error with Google token file", e);
        }

        return FirebaseMessaging.getInstance();
    }
}
