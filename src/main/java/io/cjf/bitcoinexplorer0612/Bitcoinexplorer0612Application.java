package io.cjf.bitcoinexplorer0612;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("io.cjf.bitcoinexplorer0612.dao")
@EnableFeignClients
@EnableScheduling
public class Bitcoinexplorer0612Application {

    public static void main(String[] args) {
        SpringApplication.run(Bitcoinexplorer0612Application.class, args);
    }

}
