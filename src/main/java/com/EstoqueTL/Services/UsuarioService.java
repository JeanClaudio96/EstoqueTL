package com.EstoqueTL.Services;

import com.EstoqueTL.Data.DTO.RegisterDTO;
import com.EstoqueTL.Data.Models.Usuario;
import com.EstoqueTL.Data.Repositorys.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findUsuario (String username) {
        UserDetails usuarioEncontrado = usuarioRepository.findByUsername(username);
        return (Usuario) usuarioEncontrado;
    }

    public void saveUsuario (RegisterDTO novoUsuario) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(novoUsuario.password());
        Usuario usuario = new Usuario(novoUsuario.username(), encryptedPassword, novoUsuario.role());
        usuarioRepository.save(usuario);
    }
}
