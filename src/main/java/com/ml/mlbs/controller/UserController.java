package com.ml.mlbs.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ml.mlbs.controller.request.CreateUserDTO;
import com.ml.mlbs.enums.ERole;
import com.ml.mlbs.model.LoginForm;
import com.ml.mlbs.model.RoleEntity;
import com.ml.mlbs.model.UserEntity;
import com.ml.mlbs.service.IUserService;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://e-commerce-f.web.app")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService iuserService;

    @PostMapping ("/registrarse")
    // public ResponseEntity<?> register(@RequestBody UserEntity user) {
    public ResponseEntity<?> register(@RequestBody CreateUserDTO createUserDTO) {
        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .nombre(createUserDTO.getNombre())
                .roles(roles)
                .build();
        
        iuserService.saveUser(userEntity);

        return ResponseEntity.ok(userEntity);




        // boolean error  = false;
        // List<UserEntity> listaUsers = iuserService.getUsers();
        // for (UserEntity usuario : listaUsers) {
        //     if (user.getUsername().equals(usuario.getUsername()) || user.getEmail().equals(usuario.getEmail())) {
        //         error = true;
        //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email o username existentes");
        //     }
        // }
        // if (!error) {
        //     iuserService.saveUser(user);
        // }
        // return ResponseEntity.ok("Registro exitoso");
    }

    // @PostMapping("/login")
    // public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {
    //     // Validar el nombre de usuario y contraseña
    //     List<UserEntity> listaUsers = iuserService.getUsers();
    //     for (UserEntity usuario : listaUsers) {
    //         if (loginForm.getUsername().equals(usuario.getUsername()) && loginForm.getPassword().equals(usuario.getPassword())) {
    //             return ResponseEntity.ok("Inicio de sesión exitoso");
    //         }
    //     }
    //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    // }

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

    @GetMapping ("/usuarios")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<UserEntity> getUsers() {
        return iuserService.getUsers();
    }

    // @GetMapping ("/hola")
    // @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    // public String hola() {
    //     return "hola";
    // }

    // @GetMapping ("/hola2")
    // @PreAuthorize("hasRole('ADMIN')")
    // public String hola2() {
    //     return "hola";
    // }
    
}


