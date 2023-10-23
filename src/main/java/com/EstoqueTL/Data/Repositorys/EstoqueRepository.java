package com.EstoqueTL.Data.Repositorys;

import com.EstoqueTL.Data.Models.Estoque;
import org.springframework.data.repository.CrudRepository;


public interface EstoqueRepository extends CrudRepository<Estoque, Long> {
    Estoque findBySigla(String sigla);
}
