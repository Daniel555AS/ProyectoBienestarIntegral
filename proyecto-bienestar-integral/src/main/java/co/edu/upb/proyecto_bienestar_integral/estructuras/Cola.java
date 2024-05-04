package co.edu.upb.proyecto_bienestar_integral.estructuras;

public class Cola<T> {
    
    // Atributos de la Clase Cola:
    private Nodo<T> inicio;
    private Nodo<T> ultimo;
    private int tamano;

    // Constructor de la clase Cola:
    public Cola() {
        inicio = null;
        ultimo = null;
        tamano = 0;
    }

    // Método para agregar un elemento al final de la cola:
    public void enqueue(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (estaVacia()) {
            inicio = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
        }
        ultimo = nuevoNodo;
        tamano++;
    } // public void enqueue(T elemento) 

    // Método para eliminar y retornar el elemento del frente de la cola:
    public T dequeue() {
        if (estaVacia()) {
            throw new IllegalStateException("ERROR: La cola está vacía.");
        }
        T elemento = inicio.valor;
        inicio = inicio.siguiente;
        if (inicio == null) {
            ultimo = null;
        }
        tamano--;
        return elemento;
    } // public T dequeue()

    // Método para ver el elemento del frente de la cola, sin eliminarlo:
    public T peek() {
        if (estaVacia()) {
            throw new IllegalStateException("ERROR: La cola está vacía.");
        }
        return inicio.valor;
    } // public T peek() 

    // Método para verificar si la cola está vacía:
    public boolean estaVacia() {
        return tamano == 0;
    } // public boolean estaVacia() 

    // Método para obtener el tamaño de la cola:
    public int getTamano() {
        return tamano;
    } // public int getTamano() 

    // Clase interna Nodo:
    private static class Nodo<T> {

        private T valor;
        private Nodo<T> siguiente;

        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    } // private static class Nodo<T>
    
} // public class Cola<T>

