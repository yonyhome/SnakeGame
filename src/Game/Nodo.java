/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author JUAN FELIPE
 */
public class Nodo {

    Nodo lLink, rLink;
    public String user;
    public String password;
    public String nombre;
    public String apellido;
    public String Score;
    public int dato;
    public Nodo next;
    public String registro;
    public String moneda;

    public Nodo(String registro) {
        this.registro = registro;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

   

    public Nodo(int dato) {
        this.dato = dato;
    }

    public Nodo(Nodo lLink, Nodo rLink, String nombre, String apellido, String user, String password, String Score, String m) {
        this.lLink = lLink;
        this.rLink = rLink;
        this.user = user;
        this.password = password;
        this.apellido = apellido;
        this.nombre = nombre;
        this.Score = Score;
        this.moneda=m;

    }

    public String getScore() {
        return Score;
    }

    public void setScore(String Score) {
        this.Score = Score;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Nodo getlLink() {
        return lLink;
    }

    public void setlLink(Nodo lLink) {
        this.lLink = lLink;
    }

    public Nodo getrLink() {
        return rLink;
    }

    public void setrLink(Nodo rLink) {
        this.rLink = rLink;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public String toString() {
        String s = " " + dato + " ";
        return s;
    }

}
