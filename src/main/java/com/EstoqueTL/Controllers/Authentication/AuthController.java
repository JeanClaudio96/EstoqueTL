package com.EstoqueTL.Controllers.Authentication;

import com.EstoqueTL.Data.DTO.AuthenticationDTO;
import com.EstoqueTL.Data.DTO.RegisterDTO;
import com.EstoqueTL.Data.Models.Usuario;
import com.EstoqueTL.Services.TokenService;
import com.EstoqueTL.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, UsuarioService usuarioService, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
        this.tokenService = tokenService;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO usuario) {

        UsernamePasswordAuthenticationToken authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(usuario.username(), usuario.password());
        Authentication authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);

        var token = tokenService.generateToken((Usuario) authenticationResponse.getPrincipal());

        return ResponseEntity.ok(token);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO usuario) {
        if(usuarioService.findUsuario(usuario.username()) != null) return ResponseEntity.badRequest().build();
        usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok().build();
    }
}
