package com.solstice.symbolservice;

import com.solstice.symbolservice.controller.SymbolControllerTest;
import com.solstice.symbolservice.repository.SymbolRepository;
import com.solstice.symbolservice.repository.SymbolRepositoryTest;
import com.solstice.symbolservice.service.SymbolServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SymbolControllerTest.class,
    SymbolRepositoryTest.class,
    SymbolServiceTest.class
})
public class SymbolServiceApplicationTests {

  @Test
  public void contextLoads() {
  }

}
