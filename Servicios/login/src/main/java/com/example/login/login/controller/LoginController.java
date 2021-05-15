package com.example.login.login.controller;

import com.example.login.login.dto.request.AuthenticationRequest;
import com.example.login.login.dto.response.AuthenticationResponse;
import com.example.login.login.dto.response.GeneralAPIResponse;
import com.example.login.login.service.MyUserDetailService;
import com.example.login.login.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailService myUserDetailsService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello message!!!";
    }

    @PostMapping("/authenticate")
    @ApiOperation(value = "Servicio de Login")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Respuesta éxitosa {code: RESP_LOGIN_01}"),
                    @ApiResponse(code = 401, message = "Error {code: Credenciales incorrectas "),
                    @ApiResponse(code = 500, message = "Error {code: Error en el servicio de Login.")
            }
    )
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException b) {
            throw new Exception("Usuario o contraseña incorrectas. Vuelve a intentar.");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwtUtil.generateToken(userDetails));

        GeneralAPIResponse generalAPIResponse = new GeneralAPIResponse(
                messageSource.getMessage("response.user.login", null, LocaleContextHolder.getLocale()),
                messageSource.getMessage("response.user.login.msg.200", null, LocaleContextHolder.getLocale()),
                authenticationResponse
        );

        return new ResponseEntity<>(generalAPIResponse, HttpStatus.OK);
    }
}