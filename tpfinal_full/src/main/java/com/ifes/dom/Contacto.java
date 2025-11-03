
package com.ifes.dom;
import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Contacto {
    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
    private Long id;
    private String telefono;
    private String email;

    public Contacto() {}
    public Contacto(String telefono, String email) {
        this.telefono = telefono;
        this.email = email;
    }
    public Long getId() { return id; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
