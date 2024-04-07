package co.edu.upb.proyecto_bienestar_integral.estructuras;

import java.util.Comparator;

public class ListaEnlazada<T> implements Lista<T> {

    // Atributos de la Clase ListaEnlazada:
    private Nodo<T> cabeza;
    private int tamano;

    // Constructor de la Clase ListaEnlazada:
    public ListaEnlazada() {
        this.cabeza = null;
        tamano = 0;
    }

    // Método void para agregar elemento al inicio de la lista:
    @Override
    public void agregarAlInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamano++;
    } // public void agregarAlInicio(T valor)

    // Método void para agregar elemento al final de la lista:
    @Override
    public void agregarAlFinal(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
        tamano++;
    } // public void agregarAlFinal(T valor)

    // Método void para agregar elemento en una posición específica de la lista:
    @Override
    public void insertar(T valor, int indice) {
        if (indice < 0 || indice > tamano) {
            throw new IndexOutOfBoundsException("ERROR: Índice fuera de los límites de la lista.");
        }
        if (indice == 0) {
            agregarAlInicio(valor);
        } else if (indice == tamano) {
            agregarAlFinal(valor);
        } else {
            Nodo<T> nuevoNodo = new Nodo<>(valor);
            Nodo<T> temp = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                temp = temp.siguiente;
            }
            nuevoNodo.siguiente = temp.siguiente;
            temp.siguiente = nuevoNodo;
            tamano++;
        }
    } // public void insertar(T valor, int indice)

    // Método para eliminar el primer elemento de la lista y retornar dicho elemento:
    @Override
    public T eliminarDelInicio() {
        if (estaVacia()) {
            throw new RuntimeException("ERROR: La lista está vacía.");
        }
        T valorEliminado = cabeza.valor;
        cabeza = cabeza.siguiente;
        tamano--;
        return valorEliminado;
    } // public T eliminarDelInicio()

    // Método para eliminar el último elemento de la lista y retornar dicho elemento:
    @Override
    public T eliminarDelFinal() {
        if (estaVacia()) {
            throw new RuntimeException("ERROR: La lista está vacía.");
        }
        if (cabeza.siguiente == null) {
            T valorEliminado = cabeza.valor;
            cabeza = null;
            tamano--;
            return valorEliminado;
        }
        Nodo<T> temp = cabeza;
        while (temp.siguiente.siguiente != null) {
            temp = temp.siguiente;
        }
        T valorEliminado = temp.siguiente.valor;
        temp.siguiente = null;
        tamano--;
        return valorEliminado;
    } // public T eliminarDelFinal()

    // Método para eliminar un elemento de la lista, con base a un índice especificado:
    @Override
    public T eliminarPorIndice(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("ERROR: Índice fuera de los límites de la lista.");
        }
        if (indice == 0) {
            return eliminarDelInicio();
        } else if (indice == tamano - 1) {
            return eliminarDelFinal();
        } else {
            Nodo<T> temp = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                temp = temp.siguiente;
            }
            T valorEliminado = temp.siguiente.valor;
            temp.siguiente = temp.siguiente.siguiente;
            tamano--;
            return valorEliminado;
        }
    } // public T eliminarPorIndice(int indice)

    // Método para buscar la primera ocurrencia de un elemento y retornar su índice. Si no lo encuentra, retorna -1:
    @Override
    public int buscarPrimeraOcurrencia(T valor) {
        Nodo<T> temp = cabeza;
        int indice = 0;
        while (temp != null) {
            if (temp.valor.equals(valor)) {
                return indice;
            }
            temp = temp.siguiente;
            indice++;
        }
        return -1;
    } // public int buscarPrimeraOcurrencia(T valor)

    // Método para eliminar la primera ocurrencia de un elemento en la lista y retornar dicho elemento:
    @Override
    public T eliminarPrimeraOcurrencia(T valor) {
        int indice = buscarPrimeraOcurrencia(valor);
        if (indice != -1) {
            return eliminarPorIndice(indice);
        }
        return null;
    } // public T eliminarPrimeraOcurrencia(T valor)

    // Método para retornar el tamaño de la lista:
    @Override
    public int getTamano() {
        return tamano;
    } // public int getTamano()

    // Método que verifica si la lista está vacía y retorna un valor boolean:
    @Override
    public boolean estaVacia() {
        return tamano == 0;
    } // public boolean estaVacia() 

    // Método para retornar una representación de la lista como String:
    @Override
    public String representarComoString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> temp = cabeza;
        while (temp != null) {
            sb.append(temp.valor).append(" -> ");
            temp = temp.siguiente;
        }
        sb.append("null");
        return sb.toString();
    } // public String representarComoString()

    // Método para retornar el primer elemento de la lista:
    @Override
    public T obtenerCabeza() {
        if (estaVacia()) {
            throw new RuntimeException("ERROR: La lista está vacía.");
        }
        return cabeza.valor;
    } // public T obtenerCabeza() 

    // Método para retornar el último elemento de la lista:
    @Override
    public T obtenerCola() {
        if (estaVacia()) {
            throw new RuntimeException("ERROR: La lista está vacía.");
        }
        Nodo<T> temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        return temp.valor;
    } // public T obtenerCola() 

    // Método para revertir el orden los elementos de la lista:
    @Override
    public void revertir() {
        Nodo<T> previo = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente = null;
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = previo;
            previo = actual;
            actual = siguiente;
        }
        cabeza = previo;
    } // public void revertir() 

    // Método void para ordenar una lista según criterio de Comparator:
    @Override
    public void ordenar(Comparator<T> comparator) {
        if (tamano <= 1) {
            return;
        }

        boolean intercambio = true;
        while (intercambio) {
            intercambio = false;
            Nodo<T> temp = cabeza;
            while (temp.siguiente != null) {
                if (comparator.compare(temp.valor, temp.siguiente.valor) > 0) {
                    T aux = temp.valor;
                    temp.valor = temp.siguiente.valor;
                    temp.siguiente.valor = aux;
                    intercambio = true;
                }
                temp = temp.siguiente;
            }
        }
    } // public void ordenar(Comparator<T> comparator)

    // Método para obtener un elemento de la lista, según un índice dado:
    @Override
    public T obtenerElemento(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("ERROR: Índice fuera de los límites de la lista.");
        }
        Nodo<T> temp = cabeza;
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }
        return temp.valor;
    } // public T obtenerElemento(int indice)

    // Clase interna Nodo
    private static class Nodo<T> {

        private T valor;
        private Nodo<T> siguiente;

        public Nodo(T valor) {
            this(valor, null);
        }

        public Nodo(T valor, Nodo<T> siguiente) {
            this.valor = valor;
            this.siguiente = siguiente;
        }

        public T getValor() {
            return valor;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }

    } // private static class Nodo<T>

} // public class ListaEnlazada<T> implements Lista<T> 

