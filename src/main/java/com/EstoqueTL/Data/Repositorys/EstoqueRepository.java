package com.EstoqueTL.Data.Repositorys;

import com.EstoqueTL.Data.Models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Estoque findBySigla(String sigla);
}
