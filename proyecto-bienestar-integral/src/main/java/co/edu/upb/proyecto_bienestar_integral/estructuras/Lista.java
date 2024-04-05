package co.edu.upb.proyecto_bienestar_integral.estructuras;

import java.util.Comparator;

public interface Lista<T> {
    
    void agregarAlInicio(T valor); // Agregar elemento al inicio de la lista
    void agregarAlFinal(T valor); // Agregar elemento al final de la lista
    void insertar(T valor, int indice); // Agregar elemento en una posición específica de la lista
    T eliminarDelInicio(); // Eliminar el primer elemento de la lista y retornar dicho elemento
    T eliminarDelFinal(); // Eliminar el último elemento de la lista y retornar dicho elemento
    T eliminarPorIndice(int indice); // Eliminar elemento de la lista según un índice especificado y retornar dicho elemento
    int buscarPrimeraOcurrencia(T valor); // Buscar la primera ocurrencia de un elemento y retornar su índice. Si no lo encuentra, retorna -1
    T eliminarPrimeraOcurrencia(T valor); // Eliminar la primera ocurrencia de un elemento en la lista y retornar dicho elemento
    int getTamano(); // Retornar el tamaño de la lista
    boolean estaVacia(); // Verificar si la lista está vacía
    String representarComoString(); // Retornar una representación de la lista como String
    T obtenerCabeza(); // Retornar el primer elemento de la lista
    T obtenerCola(); // Retornar el último elemento de la lista
    void revertir(); // Revertir el orden los elementos de la lista
    void ordenar(Comparator<T> comparator); // Ordenar una lista según un comparator
    T obtenerElemento(int indice); // Obtener el elemento de una lista en un índice específico
    
} // public interface Lista<T> 
