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

  public int findIdByName(String name) {
    Symbol symbol = symbolRepository.findByName(name);

    return (symbol == null ? -1 : symbol.getId());
  }

  public Symbol findById(long id) {
    return symbolRepository.findById(id).get();
  }
}
