package com.solstice.symbolservice.repository;

import com.solstice.symbolservice.model.Symbol;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SymbolRepository extends CrudRepository<Symbol, Long>{
  Symbol findByName(String name);

  List<Symbol> findAll();
}
