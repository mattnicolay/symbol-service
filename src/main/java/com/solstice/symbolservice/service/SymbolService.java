package com.solstice.symbolservice.service;

import com.solstice.symbolservice.model.Symbol;
import com.solstice.symbolservice.repository.SymbolRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SymbolService {

  private SymbolRepository symbolRepository;

  public SymbolService(SymbolRepository symbolRepository) {
    this.symbolRepository = symbolRepository;
  }

  public List<Symbol> findAll() {
    return symbolRepository.findAll();
  }

  public Symbol findByName(String name) {
    return symbolRepository.findByName(name);
  }
}
