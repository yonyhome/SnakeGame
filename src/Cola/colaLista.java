/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

import Game.Nodo;

/**
 *
 * @author HOME
 */
public class colaLista {

    private Nodo inicio;
    private Nodo termino;
//Codigo por www.DesarrollarAplicaciones.com

    public colaLista() {
        inicio = null;
        termino = null;
    }

    public void insertar(String dato) {
        Nodo i = new Nodo(dato);
        i.setNext(null);
        if (inicio == null & termino == null) {
            inicio = i;
            termino = i;
        }
        termino.setNext(i);
        termino = termino.getNext();
    }

    public String extraer() {
        String dato;
        dato = inicio.getRegistro();
        inicio = inicio.getNext();
        return dato;
    }

    public boolean estaVacia() {
        boolean cola = false;
        if (inicio == null & termino == null) {
            cola = true;
            System.out.println("La cola esta vacia");
        } else {
            System.out.println("La cola no esta vacia");
            cola = false;
        }
        return cola;
    }

    public int contar() {
        int contador = 0;
        Nodo c = this.inicio;
        while (c != null) {
            contador++;
            c = c.getNext();
        }
        System.out.println("Numero de datos en la cola: " + contador);
        return contador;
    }

    public String toString() {
        Nodo c = this.inicio;
        String s = "";
        while (c != null) {
            s = s +";"+ c.registro;
            c = c.getNext();
        }
        return s;
    }

    public static void main(String[] args) {
        colaLista cola1 = new colaLista();
        cola1.insertar("yony");
        cola1.insertar("yeseth");
        cola1.insertar("hoyos");
        cola1.insertar("meza");
        cola1.insertar("hola");
       // System.out.println(cola1.extraer());
        
        cola1.estaVacia();
        cola1.contar();
        System.out.println(cola1.toString());
    }
}
