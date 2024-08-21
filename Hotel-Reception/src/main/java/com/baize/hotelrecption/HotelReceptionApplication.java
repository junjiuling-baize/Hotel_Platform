package com.baize.hotelrecption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//前台
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HotelReceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelReceptionApplication.class, args);
    }
}
