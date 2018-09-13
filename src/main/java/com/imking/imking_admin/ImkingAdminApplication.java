package com.imking.imking_admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.imking.imking_admin.mapper")
@SpringBootApplication
public class ImkingAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImkingAdminApplication.class, args);
    }
}
