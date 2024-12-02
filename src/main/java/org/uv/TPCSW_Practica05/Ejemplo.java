/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/RestController.java to edit this template
 */
package org.uv.TPCSW_Practica05;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author j_dev
 */
@RestController
@RequestMapping("/url")
public class Ejemplo {
    
    @GetMapping
    public String sayHello(){
        return "Hello Lu";
    }
    
}
