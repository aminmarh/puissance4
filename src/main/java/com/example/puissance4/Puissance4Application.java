package com.example.puissance4;

import com.example.puissance4.game.Table;
import com.example.puissance4.hci.HumanComputerInterface;
import com.example.puissance4.hci.IOutput;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.io.InputStream;
import java.io.OutputStream;

@SpringBootApplication
public class Puissance4Application implements CommandLineRunner {
    private final Table table;
    public Puissance4Application(Table table) {
        this.table = table;
    }

    public static void main(String[] args) {
        SpringApplication.run(Puissance4Application.class, args);
    }

    @Override
    public void run(final String... strings) throws Exception {
        table.play();
    }
}
