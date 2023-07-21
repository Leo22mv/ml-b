package com.ml.mlbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ml.mlbs.model.LoginForm;
import com.ml.mlbs.model.User;
import com.ml.mlbs.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private IUserService iuserService;

    @PostMapping ("/registrarse")
    public ResponseEntity<String> register(@RequestBody User user) {
        boolean error  = false;
        List<User> listaUsers = iuserService.getUsers();
        for (User usuario : listaUsers) {
            if (user.getUsername().equals(usuario.getUsername()) || user.getEmail().equals(usuario.getEmail())) {
                error = true;
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email o username existentes");
            }
        }
        if (!error) {
            iuserService.saveUser(user);
        }
        return ResponseEntity.ok("Registro exitoso");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
        // Validar el nombre de usuario y contraseña
        List<User> listaUsers = iuserService.getUsers();
        for (User usuario : listaUsers) {
            if (loginForm.getUsername().equals(usuario.getUsername()) && loginForm.getPassword().equals(usuario.getPassword())) {
                return ResponseEntity.ok("Inicio de sesión exitoso");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }

//     @PostMapping("/login")
//     public void login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
//         // Lógica de autenticación y verificación de credenciales
        
//         if (/* credenciales válidas */) {
//             // Autenticación exitosa
//             response.setStatus(HttpServletResponse.SC_OK);
//             // Puedes establecer el contenido de la respuesta si lo deseas
//             // response.setContentType("application/json");
//             // response.getWriter().write("Autenticación exitosa");
//         } else {
//             // Autenticación fallida
//             response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//             // Puedes establecer el contenido de la respuesta si lo deseas
//             // response.setContentType("application/json");
//             // response.getWriter().write("Autenticación fallida");
//         }
//     }
// }
    
}


