/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

import Game.Nodo;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class PilaLista {

    private Nodo Tope;

    public PilaLista() {
        this.Tope = null;
    }

    public Nodo getCima() {
        return Tope;
    }

    public void setCima(Nodo cima) {
        this.Tope = cima;
    }

    public void insertar(int dato) {
        Nodo i = new Nodo(dato);
        i.setNext(this.Tope);
        this.Tope = i;
    }

    public int extraer() {
        int dato = Tope.getDato();
        this.Tope = Tope.getNext();
        return dato;
    }

    public boolean estaVacia() {
        if (Tope == null) {
            System.out.println("La pila esta vacia");
            return true;
        } else {
            System.out.println("La pila no esta vacia");
            return false;
        }
    }

    public int contarDatos() {
        int contador = 0;
        Nodo h = Tope;
        while (h != null) {
            contador++;
            h = h.getNext();
        }
        System.out.println("Numero de datos en la pila: " + contador);
        return contador;
    }

    public int sacar(int p) {
        int borrado = 0;
        Nodo h = Tope;
        Nodo q = Tope;
        if (p == Tope.getDato()) {
            this.Tope = Tope.getNext();
        } else {
            while (!(h == null)) {
                if (p == h.getDato()) {
                    q.setNext(h.getNext());
                    h.setNext(null);
                    borrado = 1;
                }
                q = h;
                h = h.getNext();
            }
        }
        return borrado;
    }

    public String toString() {
        String s = "";
        Nodo i = this.Tope;
        while (i != null) {
            s = s + i.toString();
            i = i.getNext();
        }
        return s;
    }

    public static void main(String[] args) {
        boolean first = true;
        Scanner sc = new Scanner(System.in);
        int tam = 0;
        int au=0;
        int i=1;
        PilaLista mipila = new PilaLista();
        int continuar = 0;
        while (continuar == 0) {
            System.out.println("");
            System.out.println("Bienvenido");
            if (first) {
                System.out.println("Para crear una nueva pila ingresa 1");
            } else {
                System.out.println("Para ingresar un nuevo elemento en la pila ingresa 1");
            }
            System.out.println("Para cancelar un elemento de la pila ingresa 2");
            System.out.println("Para sacar un elemento de la pila ingresa 3");
            System.out.println("para ver el numero de elementos de la pila preciona 4");
            System.out.println("para salir preciona 5");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    
                    if (first) {
                        first=false;
                        System.out.println("Por favor ingresa el tamaño de la Pila ");
                        tam = sc.nextInt();
                        au=tam;
                    }
                    while (tam != 0) {
                        System.out.println("Ingresa el elemento " + i + " de la pila");
                        mipila.insertar(sc.nextInt());
                        System.out.println("Desea ingresar otro elemento? preciona 1");
                        if (!(sc.nextInt() == 1)) {
                            break;
                        } else {
                            if (i == au) {
                                System.out.println("Ya no puede ingresar mas elementos a la pila");
                                break;
                            }
                        }
                        i++;
                        tam--;
                    }
                    
                    System.out.println("Esta es su pila: ");
                    System.out.print(mipila.toString());
                    break;
                case 2:
                    System.out.println("");
                    if (mipila.estaVacia()) {

                    } else {
                        System.out.println("se extrajo el elemento: " + mipila.extraer());
                        System.out.println("La pila quedo asì: ");
                        System.out.print(mipila.toString());
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("La pila esta asì");
                    System.out.print(mipila.toString());
                    System.out.println("Que elemento desea sacar?");
                    if (mipila.sacar(sc.nextInt()) == 1) {
                        System.out.println("Borrado con exito");
                    } else {
                        System.out.println("El elemento no se encontro");
                    }
                    System.out.println("La pila quedo asi: ");
                    System.out.print(mipila.toString());
                    System.out.println("");
                    break;
                case 4:
                    mipila.contarDatos();
                    break;
                case 5:
                    continuar = 2;
                    break;
            }
        }
    }
}
