package com.solstice.symbolservice.controller;

import com.solstice.symbolservice.model.Symbol;
import com.solstice.symbolservice.service.SymbolService;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SymbolController {

  private SymbolService symbolService;

  public SymbolController(SymbolService symbolService) {
    this.symbolService = symbolService;
  }

  @GetMapping("/symbols")
  public ResponseEntity<List<Symbol>> getSymbols() {
    List<Symbol> symbols = symbolService.findAll();
    return new ResponseEntity<>(
        symbols,
        new HttpHeaders(),
        symbols.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }

  @GetMapping("/symbols/{name}")
  public ResponseEntity<Symbol> getSymbol(@PathVariable("name") String name) {
    Symbol symbol = symbolService.findByName(name);
    return new ResponseEntity<>(
        symbol,
        new HttpHeaders(),
        symbol == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }

  @GetMapping("/symbols/{name}/id")
  public ResponseEntity<Integer> getSymbolId(@PathVariable("name") String name) {
    int symbolId = symbolService.findIdByName(name);
    return new ResponseEntity<>(
        symbolId,
        new HttpHeaders(),
        symbolId < 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }
}
