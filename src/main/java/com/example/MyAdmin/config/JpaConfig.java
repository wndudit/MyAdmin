package com.example.MyAdmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //JPA관련해서 감시를 활성화 시키겠다. (감시자 설정)

public class JpaConfig {
}
