package org.konkvistador.rest.controller;

import org.konkvistador.rest.exception.InvalidCredentials;
import org.konkvistador.rest.service.Authorities;
import org.konkvistador.rest.service.AuthorizationService;
import org.konkvistador.rest.exception.UnauthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(
            @RequestParam("user") String user,
            @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    //@ExceptionHandler. Аннотация, которая помещается над методом, умеющем обрабатывать ошибки контроллера.
    //InvalidCredentials должен обратно клиенту отсылать http статус с кодом 400 и телом в виде сообщения из exception'а
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler (InvalidCredentials e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    //UnauthorizedUser должен обратно клиенту отсылать http статус с кодом 401 и телом в виде сообщения из exception'а
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler (UnauthorizedUser e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}