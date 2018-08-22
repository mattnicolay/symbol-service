package com.solstice.symbolservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import com.solstice.symbolservice.model.Symbol;
import com.solstice.symbolservice.service.SymbolService;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(SymbolController.class)
public class SymbolControllerTest {
  @Mock
  private SymbolService symbolService;

  @InjectMocks
  private SymbolController symbolController;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(symbolController).build();
  }

  @Test
  public void testGetSymbols() throws Exception {
    Symbol mockSymbolGoog = new Symbol("GOOG");
    Symbol mockSymbolAapl = new Symbol("AAPL");

    when(symbolService.findAll()).thenReturn(Arrays.asList(mockSymbolAapl, mockSymbolGoog));
    mockMvc.perform(get("/symbols")).andExpect(status().isOk());
  }

  @Test
  public void testGetSymbolsNotFound() throws Exception {
    mockMvc.perform(get("/symbols")).andExpect(status().isNotFound());
  }

  @Test
  public void testGetSymbolByName() throws Exception {
    Symbol mockSymbolGoog = new Symbol("GOOG");

    when(symbolService.findByName(any(String.class))).thenReturn(mockSymbolGoog);
    mockMvc.perform(get("/symbols/GOOG")).andExpect(status().isOk());
  }

  @Test
  public void testGetSymbolByNameNotFound() throws Exception {
    mockMvc.perform(get("/symbols/FAIL")).andExpect(status().isNotFound());
  }


}
