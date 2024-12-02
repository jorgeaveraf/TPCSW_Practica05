/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Repository.java to edit this template
 */
package org.uv.TPCSW_Practica05;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author josegtz
 */
public interface RepositoryEmpleados extends JpaRepository<Empleado, Long> {
    
}
