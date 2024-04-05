package co.edu.upb.proyecto_bienestar_integral.estructuras;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class ListaDoblementeEnlazada<T> implements Lista<T> {

    // Atributos de la Clase ListaDoblementeEnlazada
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;

    // Constructor de la Clase ListaDoblementeEnlazada
    public ListaDoblementeEnlazada() {
        cabeza = null;
        cola = null;
        tamano = 0;
    }

    // Método void para agregar elemento al inicio de la lista:
    @Override
    public void agregarAlInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
        tamano++;
    } // public void agregarAlInicio(T valor) 

    // Método void para agregar elemento al final de la lista:
    @Override
    public void agregarAlFinal(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
        tamano++;
    } // public void agregarAlFinal(T valor) 

    // Método void para agregar elemento en una posición específica de la lista:
    @Override
    public void insertar(T valor, int indice) {
        if (indice < 0 || indice > tamano) {
            throw new IndexOutOfBoundsException("ERROR: El índice ingresado está fuera de rango.");
        }
        if (indice == 0) {
            agregarAlInicio(valor);
        } else if (indice == tamano) {
            agregarAlFinal(valor);
        } else {
            Nodo nuevoNodo = new Nodo(valor);
            Nodo nodoActual;
            if (indice <= tamano / 2) { // Recorremos la lista desde la cabeza
                nodoActual = cabeza;
                for (int ii = 0; ii < indice; ii++) {
                    nodoActual = nodoActual.siguiente;
                }
            } else { // Recorremos desde la cola
                nodoActual = cola;
                for (int jj = tamano - 1; jj > indice; jj--) {
                    nodoActual = nodoActual.anterior;
                }
            }
            nuevoNodo.anterior = nodoActual.anterior;
            nuevoNodo.siguiente = nodoActual;
            nodoActual.anterior.siguiente = nuevoNodo;
            nodoActual.anterior = nuevoNodo;
            tamano++;
        }
    } // public void insertar(T valor, int indice)

    // Método para eliminar el primer elemento de la lista y retornar dicho elemento:
    @Override
    public T eliminarDelInicio() {
        if (estaVacia()) {
            throw new NoSuchElementException("ERROR: La lista está vacía.");
        }
        T valorEliminado = cabeza.valor;
        if (tamano == 1) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
        tamano--;
        return valorEliminado;
    } // public T eliminarDelInicio() 

    // Método para eliminar el último elemento de la lista y retornar dicho elemento:
    @Override
    public T eliminarDelFinal() {
        if (estaVacia()) {
            throw new NoSuchElementException("ERROR: La lista está vacía.");
        }
        T valorEliminado = cola.valor;
        if (tamano == 1) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }
        tamano--;
        return valorEliminado;
    } // public T eliminarDelFinal()
    
    // Método para eliminar un elemento de la lista, con base a un índice especificado:
    @Override
    public T eliminarPorIndice(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("ERROR: El índice ingresado está fuera de rango.");
        }
        T valorEliminado;
        if (indice == 0) {
            valorEliminado = eliminarDelInicio();
        } else if (indice == tamano - 1) {
            valorEliminado = eliminarDelFinal();
        } else {
            // Determinar desde dónde empezar a recorrer la lista:
            Nodo<T> nodoActual;
            int mitad = tamano / 2;
            if (indice < mitad) {
                // Recorrer desde la cabeza:
                nodoActual = cabeza;
                for (int ii = 0; ii < indice; ii++) {
                    nodoActual = nodoActual.siguiente;
                }
            } else {
                // Recorrer desde la cola:
                nodoActual = cola;
                for (int jj = tamano - 1; jj > indice; jj--) {
                    nodoActual = nodoActual.anterior;
                }
            }
            // Eliminar el nodo:
            valorEliminado = nodoActual.valor;
            nodoActual.anterior.siguiente = nodoActual.siguiente;
            nodoActual.siguiente.anterior = nodoActual.anterior;
            tamano--;
        }
        return valorEliminado;
    } // public T eliminarPorIndice(int indice)

    // Método para buscar la primera ocurrencia de un elemento y retornar su índice. Si no lo encuentra, retorna -1:
    @Override
    public int buscarPrimeraOcurrencia(T valor) {
        if (estaVacia()) {
            throw new NoSuchElementException("ERROR: La lista está vacía.");
        }
        Nodo nodoActual = cabeza;
        int posicion = 0;
        while (nodoActual != null) {
            if (nodoActual.valor.equals(valor)) {
                return posicion;
            }
            nodoActual = nodoActual.siguiente;
            posicion++;
        }
        return -1;
    } // public int buscarPrimeraOcurrencia(T valor) 

    // Método para eliminar la primera ocurrencia de un elemento en la lista y retornar dicho elemento:
    @Override
    public T eliminarPrimeraOcurrencia(T valor) {
        if (estaVacia()) {
            throw new NoSuchElementException("ERROR: La lista está vacía.");
        }
        Nodo<T> nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.valor.equals(valor)) {
                if (nodoActual == cabeza) {
                    return eliminarDelInicio();
                } else if (nodoActual == cola) {
                    return eliminarDelFinal();
                } else {
                    nodoActual.anterior.siguiente = nodoActual.siguiente;
                    nodoActual.siguiente.anterior = nodoActual.anterior;
                    tamano--;
                    return nodoActual.valor;
                }
            }
            nodoActual = nodoActual.siguiente;
        }
        return null; // No se encontró la ocurrencia
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
        sb.append("{");

        Nodo<T> nodoActual = cabeza;
        while (nodoActual != null) {
            sb.append(nodoActual.valor);
            if (nodoActual != cola) {
                sb.append("\n");
            }
            nodoActual = nodoActual.siguiente;
        }

        sb.append("}");
        return sb.toString();
    } // public String representarComoString()

    // Método para retornar el primer elemento de la lista:
    @Override
    public T obtenerCabeza() {
        return cabeza.valor;
    } // public T obtenerCabeza() 

    // Método para retornar el último elemento de la lista:
    @Override
    public T obtenerCola() {
        return cola.valor;
    } // public T obtenerCola() 

    // Método para revertir el orden los elementos de la lista:
    @Override
    public void revertir() {
        if (estaVacia() || cabeza == cola) {
            return; // No es necesario revertir
        }
        Nodo<T> nodoActual = cabeza;
        Nodo<T> temp = null;
        while (nodoActual != null) {
            // Intercambiar punteros siguiente y anterior:
            temp = nodoActual.siguiente;
            nodoActual.siguiente = nodoActual.anterior;
            nodoActual.anterior = temp;

            // Mover al siguiente nodo:
            nodoActual = temp;
        }
        // Actualizar cabeza y cola
        temp = cabeza;
        cabeza = cola;
        cola = temp;
    } // public void revertir()
    
    // Método void para ordenar una lista según criterio de Comparator:
    @Override
    public void ordenar(Comparator<T> comparator) {
        if (tamano <= 1) {
            return; // La lista ya está ordenada o es vacía
        }
        Nodo<T> actual = cabeza.siguiente;
        while (actual != null) {
            Nodo<T> prev = actual.anterior;
            Nodo<T> temp = actual;
            while (prev != null && comparator.compare(temp.valor, prev.valor) < 0) {
                // Intercambiar nodos
                T tempData = temp.valor;
                temp.valor = prev.valor;
                prev.valor = tempData;

                // Avanzar al nodo anterior:
                temp = prev;
                prev = prev.anterior;
            }
            actual = actual.siguiente;
        }
    } // public void ordenar(Comparator<T> comparator)
    
    // Método para obtener un elemento de la lista, según un índice dado:
    @Override
    public T obtenerElemento(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("ERROR: El índice ingresado está fuera de rango.");
        }

        Nodo<T> nodoActual;
        if (indice <= tamano / 2) {
            // Recorrer desde la cabeza:
            nodoActual = cabeza;
            for (int i = 0; i < indice; i++) {
                nodoActual = nodoActual.siguiente;
            }
        } else {
            // Recorrer desde la cola:
            nodoActual = cola;
            for (int i = tamano - 1; i > indice; i--) {
                nodoActual = nodoActual.anterior;
            }
        }

        return nodoActual.valor;
    }

    // Clase interna Nodo
    private static class Nodo<T> {

        T valor;
        Nodo<T> siguiente;
        Nodo<T> anterior;

        public Nodo(T valor) {
            this(valor, null, null);
        }

        public Nodo(T valor, Nodo<T> siguiente, Nodo<T> anterior) {
            this.valor = valor;
            this.siguiente = siguiente;
            this.anterior = anterior;
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

        public Nodo<T> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<T> anterior) {
            this.anterior = anterior;
        }

    } // private static class Nodo<T>

} // public class ListaDoblementeEnlazada<T> implements Lista<T> 

