package com.solstice.symbolservice;

import com.solstice.symbolservice.model.Symbol;
import com.solstice.symbolservice.repository.SymbolRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableDiscoveryClient
public class SymbolServiceApplication implements CommandLineRunner{

  private SymbolRepository symbolRepository;

  public SymbolServiceApplication(
      SymbolRepository symbolRepository) {
    this.symbolRepository = symbolRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(SymbolServiceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<Symbol> symbols = Arrays.asList(
        new Symbol("AAPL"),
        new Symbol("GOOG"),
        new Symbol("MSFT"),
        new Symbol("PVTL"),
        new Symbol("AMZN")
    );
    symbolRepository.saveAll(symbols);
  }
}
