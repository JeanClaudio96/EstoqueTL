package com.EstoqueTL.Data.Repositorys;

import com.EstoqueTL.Data.Models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    UserDetails findByUsername(String username);
}
