package com.example.staffrecruitmentmanagerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StaffRecruitmentManagerBackendApplication {
    public static void main(String[] args) {
        // 必須環境変数が設定されているか確認
        String datasourceUrl = System.getenv("SPRING_DATASOURCE_URL");
        String datasourceUsername = System.getenv("SPRING_DATASOURCE_USERNAME");
        String datasourcePassword = System.getenv("SPRING_DATASOURCE_PASSWORD");

        if (datasourceUrl == null || datasourceUsername == null || datasourcePassword == null) {
            throw new RuntimeException("Required environment variables are not set: SPRING_DATASOURCE_URL, SPRING_DATASOURCE_USERNAME, SPRING_DATASOURCE_PASSWORD");
        }

        // 環境変数をシステムプロパティとして設定
        System.setProperty("SPRING_DATASOURCE_URL", datasourceUrl);
        System.setProperty("SPRING_DATASOURCE_USERNAME", datasourceUsername);
        System.setProperty("SPRING_DATASOURCE_PASSWORD", datasourcePassword);

        SpringApplication.run(StaffRecruitmentManagerBackendApplication.class, args);
    }
}
