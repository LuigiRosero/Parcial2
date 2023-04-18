package com.example.parcial2.model;

public class Empleado {


    private Long id;

    private String nombre;

    private String password;

    private String email;


    public Empleado(String s, String s1, String s2, String s3) {
    }

    public Empleado(String nombre) {


        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;

    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {

        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email+'\''+
                '}';
    }



}
