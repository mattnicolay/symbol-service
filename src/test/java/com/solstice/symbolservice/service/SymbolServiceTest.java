package com.solstice.symbolservice.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import com.solstice.symbolservice.model.Symbol;
import com.solstice.symbolservice.repository.SymbolRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class SymbolServiceTest {

  @Mock
  private SymbolRepository symbolRepository;

  @InjectMocks
  private SymbolService symbolService;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testFindAll() {
    Symbol mockSymbolGoog = new Symbol("GOOG");
    Symbol mockSymbolAapl = new Symbol("AAPL");
    List<Symbol> mockSymbols = Arrays.asList(mockSymbolAapl, mockSymbolGoog);

    when(symbolRepository.findAll()).thenReturn(mockSymbols);
    List<Symbol> symbols = symbolService.findAll();

    assertThat(symbols, is(equalTo(mockSymbols)));
  }

  @Test
  public void testFindAllNotFound() {
    List<Symbol> symbols = symbolService.findAll();

    assertTrue(symbols.isEmpty());
  }

  @Test
  public void testFindByName() {
    Symbol mockSymbol = new Symbol("GOOG");

    when(symbolRepository.findByName(any(String.class))).thenReturn(mockSymbol);
    Symbol symbol = symbolService.findByName("GOOG");

    assertThat(symbol, is(equalTo(mockSymbol)));
  }

  @Test
  public void testFindByNameNotFound() {
    Symbol symbol = symbolService.findByName("GOOG");

    assertThat(symbol, is(nullValue()));
  }
}
