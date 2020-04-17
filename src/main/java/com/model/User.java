/**
 *
 */
package com.model;

/**
 * @author jesus.fernandez
 *
 */

public class User {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Boolean soltero;
    private String dni;
    private String telefono;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getSoltero() {
        return soltero;
    }

    public void setSoltero(Boolean soltero) {
        this.soltero = soltero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id = " + id + ", " + "nombre = " + nombre + ", " + "apellido = " + apellido + ", " + " edad = " + edad
                + ", " + "soltero = " + getSoltero() + ", " + "dni = " + dni + ", " + "telefono = " + telefono + ", "
                + "email = " + email + "]";
    }

}
