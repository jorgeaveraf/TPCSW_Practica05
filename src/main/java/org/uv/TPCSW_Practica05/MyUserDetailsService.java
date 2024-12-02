/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.TPCSW_Practica05;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author j_dev
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
        @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aquí se debe implementar la lógica para cargar el usuario desde la base de datos
        if (username.equals("user")) { // Solo como ejemplo
            return new org.springframework.security.core.userdetails.User(
                    "user", // Nombre de usuario
                    "{noop}password", // Contraseña sin cifrar (por ahora)
                    new ArrayList<>() // Lista de roles vacía
            );
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
    
}
