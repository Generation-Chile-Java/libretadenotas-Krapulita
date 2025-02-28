import java.util.HashMap;
import java.util.Map;

// Clase que gestiona el conjunto de alumnos
class LibretaDeNotas {

    // Mapa donde se almacenan los alumnos, utilizando el nombre como clave.
    private Map<String, Alumno> alumnos;

    // Constructor que inicializa el mapa de alumnos.
    public LibretaDeNotas() {
        this.alumnos = new HashMap<>();
    }

    // Método para agregar un nuevo alumno a la libreta.
    public void agregarAlumno(String nombre) {
        alumnos.put(nombre, new Alumno(nombre));
    }

    // Método para agregar una nota a un alumno específico.
    public void agregarNota(String nombre, double nota) {
        // Verifica si el alumno existe antes de agregar la nota.
        if (alumnos.containsKey(nombre)) {
            alumnos.get(nombre).agregarNota(nota);
        } else {
            System.out.println("Alumno no encontrado");// Mensaje de error si el alumno no existe.
        }
    }

    // Método que calcula el prmedio de notas de todos los alumnos.
    public double calcularPromedioCurso() {
        return alumnos.values().stream()
                .mapToDouble(Alumno::calcularPromedio)// Obtiene el promedio de cada alumno.
                .average()// Calcula el promedio general del curso.
                .orElse(0.0);// Retorna 0.0 si no hay alumnos.
    }

    // Método que obtiene un alumno por su nombre.
    public Alumno getAlumno(String nombre) {
        return alumnos.get(nombre);// Retorna el alumno si existe o null si no se encuentra.
    }

    // Método que muestra los promedios de todos los alumnos en la libreta.
    public void mostrarPromedios() {
        System.out.println("\nPromedios de los estudiantes:");
        // Recorre la lista de alumnos e imprime su promedio.
        alumnos.forEach((nombre, alumno) ->
                System.out.println(nombre + ": " + alumno.calcularPromedio()));
    }
}
