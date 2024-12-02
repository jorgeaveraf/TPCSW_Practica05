package org.uv.TPCSW_Practica05;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Controller for managing department-related API requests.
 * 
 */
@RestController
@RequestMapping("/api/departamentos")
public class ControllerDepartamentos {
    
    @Autowired
    private RepositoryDepartamentos repositoryDepartamentos;
    
    // Obtener todos los departamentos
    @GetMapping
    public ResponseEntity<List<Departamento>> list() {
        List<Departamento> departamentos = repositoryDepartamentos.findAll();
        return ResponseEntity.ok(departamentos);
    }
    
    // Obtener un departamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> get(@PathVariable Long id) {
        Optional<Departamento> res = repositoryDepartamentos.findById(id);
        if (res.isPresent()) {
            return ResponseEntity.ok(res.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    // Crear un nuevo departamento
    @PostMapping
    public ResponseEntity<Departamento> post(@RequestBody Departamento input) {
        Departamento newDepartamento = repositoryDepartamentos.save(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDepartamento);
    }
    
    // Actualizar un departamento existente
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Departamento input) {
        Optional<Departamento> existingDepartamento = repositoryDepartamentos.findById(id);
        if (existingDepartamento.isPresent()) {
            Departamento updatedDepartamento = existingDepartamento.get();
            updatedDepartamento.setNombre(input.getNombre()); // Aquí puedes añadir otros campos que quieras actualizar
            repositoryDepartamentos.save(updatedDepartamento);
            return ResponseEntity.ok(updatedDepartamento);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
    }
    
    // Eliminar un departamento
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Departamento> existingDepartamento = repositoryDepartamentos.findById(id);
        if (existingDepartamento.isPresent()) {
            repositoryDepartamentos.delete(existingDepartamento.get());
            return ResponseEntity.ok("Department deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
    }
}
