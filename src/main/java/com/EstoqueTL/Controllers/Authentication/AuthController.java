package com.EstoqueTL.Controllers.Authentication;

import com.EstoqueTL.Data.DTO.AuthenticationDTO;
import com.EstoqueTL.Data.DTO.RegisterDTO;
import com.EstoqueTL.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authenticationManager, UsuarioService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO usuario) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(usuario.username(), usuario.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO usuario) {
        if(usuarioService.findUsuario(usuario.username()) != null) return ResponseEntity.badRequest().build();
        usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok().build();
    }
}
