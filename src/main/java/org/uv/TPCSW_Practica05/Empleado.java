package org.uv.TPCSW_Practica05;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "empleado2")
public class Empleado implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado2_clave_seq")
    @SequenceGenerator(name = "empleado2_clave_seq", sequenceName = "empleado2_clave_seq", allocationSize = 1)
    @Column
    private long clave;
    
    @Column
    private String nombre;
    
    @Column
    private String direccion;
    
    @Column
    private String telefono;
  
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "departamento_clave")
    @JsonIgnore
    private Departamento depto;

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }
    
    public String getDepartamento() {
        return depto != null ? depto.getNombre() : null;
    }
}
