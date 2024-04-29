package co.edu.upb.proyecto_bienestar_integral.estructuras;

public class Pila<T> {
    
    // Atributos de la Clase Pila:
    private Nodo<T> cima;
    private int tamano;

    // Construcotr de la Clase Pila:
    public Pila() {
        cima = null;
        tamano = 0;
    }

    // Método para agregar un elemento en la cima de la pila:
    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamano++;
    } // public void push(T elemento) 
    
    // Método para eliminar y retornar el elemento superior de la pila:
    public T pop() {
        if (estaVacia()) {
            throw new IllegalStateException("ERROR: La pila está vacía.");
        }
        T elemento = cima.valor;
        cima = cima.siguiente;
        tamano--;
        return elemento;
    } // public T pop()
    
    // Método para ver el elemento que se encuentra en la cima de la pila, sin eliminarlo:
    public T peek() {
        if (estaVacia()) {
            throw new IllegalStateException("ERROR: La pila está vacía.");
        }
        return cima.valor;
    } // public T peek() 

    // Método para verificar si la pila está vacía:
    public boolean estaVacia() {
        return tamano == 0;
    } // public boolean estaVacia() 
    
    // Método para obtener el tamaño de la pila:
    public int getTamano(){
        return tamano;
    } // public int getTamano()

    // Clase interna Nodo:
    private static class Nodo<T> {

        T valor;
        Nodo<T> siguiente;

        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }
    
} // public class Pila<T>

