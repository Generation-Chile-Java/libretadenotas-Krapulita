import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase para gestionar alumnos y sus notas
class Alumno {
    private String nombre; //Nombre del alumno.
    private List<Double> notas; //Lista de notas del alumno.
    private static final double NOTA_APROBACION = 4.0; //Nota mínima de aprobación.

    //Cnstructor que recibe el nombre del alumno e inicializa una lista de notas vacía.
    public Alumno(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    //Método para obtener el nombre del alumno.
    public String getNombre() {
        return nombre;
    }

    //Método para agregar notas por alumno.
    public void  agregarNota(double nota){
        while (nota < 0 || nota > 7.0){
            //Muestra mensaje de error si la nota no es válida y la pide nuevamente.
            System.out.println("La nota debe estar entre 0.0 y 7.0. Intenta nuevamente");
        } notas.add(nota);
        System.out.println("Se agregó la nota");
    }



    //Método para calcular el promedio de las notas.
    public double calcularPromedio() {
        // Si la lista de notas está vacía, retorna 0.0 para evitar la división por cero.
        if (notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0; // Almacena la suma de las notas
        for (double nota : notas) {
            suma += nota; // Suma cada nota a la variable suma
        }
        return suma / notas.size(); // Calcula el promedio dividiendo la suma entre el número de notas
    }


    //Método para obtener la nota máxima.
    public double getNotaMaxima() {
        return Collections.max(notas); //Devuelve la nota mas alta de la lista.
    }

    //Método para obtener la nota mínima.
    public double getNotaMinima() {
        return Collections.min(notas); //Devuelve la nota mas baja de la lista.
    }

    //Método par verificar si una nota es aprobatoria.
    public boolean esAprobatoria(double nota) {
        return nota >= NOTA_APROBACION; //Compara si la nota es mayor o igual a la nota de aprobacion.
    }

    //Método para obtener la lista de notas.
    public List<Double> getNotas() {
        return notas; //Devuelve la lista de notas del alumno.
    }
}