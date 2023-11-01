package com.EstoqueTL.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServices implements UserDetailsService {

    private final UsuarioService usuarioService;

    public AuthorizationServices(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails usuarioEncontrado = usuarioService.findUsuario(username);
        return null;
    }
}
