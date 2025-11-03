
package com.ifes.dom;
import javax.jdo.annotations.*;
import java.util.List;

@PersistenceCapable(detachable="true")
public class Concesionaria {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    private Long id;

    private String nombre;
    private String domicilio;

    @Persistent(defaultFetchGroup="true")
    private Contacto contacto;

    @Persistent(defaultFetchGroup="true")
    private List<Rodado> rodados;

    public Concesionaria() {}
    public Concesionaria(String nombre, String domicilio, Contacto contacto, List<Rodado> rodados) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.contacto = contacto;
        this.rodados = rodados;
    }
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDomicilio() { return domicilio; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
    public Contacto getContacto() { return contacto; }
    public void setContacto(Contacto contacto) { this.contacto = contacto; }
    public List<Rodado> getRodados() { return rodados; }
    public void setRodados(List<Rodado> rodados) { this.rodados = rodados; }
}
