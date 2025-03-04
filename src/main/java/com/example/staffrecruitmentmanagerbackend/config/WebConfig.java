package com.example.staffrecruitmentmanagerbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // すべてのエンドポイントに適用
                .allowedOrigins("*") // ワイルドカードを使用可能
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 許可するHTTPメソッド
                .allowCredentials(false) // クレデンシャルを許可しない
                .allowedHeaders("*"); // すべてのヘッダーを許可
    }
}

