import java.util.List;
import java.util.Scanner;

// Clase que representa la interfaz a través de un menú
class Menu {
    // Objeto que gestiona los alumnos y sus notas.
    private LibretaDeNotas libreta;

    // Scanner para la entrada de datos del usuario.
    private Scanner sc;

    // Constructor que inicializa la libreta de notas y el scanner.
    public Menu() {
        this.libreta = new LibretaDeNotas();
        this.sc = new Scanner(System.in);
    }

    // Método que permite ingresar alumnos y sus notas.
    public void ingresarDatos() {
        System.out.print("Ingrese la cantidad de alumnos: ");
        int numAlumnos = sc.nextInt();
        while (numAlumnos <= 0) { // Validación para asegurarse de que el número de alumnos sea positivo.
            System.out.print("Debe ingresar un número positivo: ");
            numAlumnos = sc.nextInt();
        }

        System.out.print("Ingrese la cantidad de notas por alumno: ");
        int numNotas = sc.nextInt();
        while (numNotas <= 0) { // Validación para asegurarse de que el número de notas sea positivo.
            System.out.print("Debe ingresar un número positivo: ");
            numNotas = sc.nextInt();
        }

        sc.nextLine(); // Limpiar buffer

        // Bucle para ingresar los datos de cada alumno.
        for (int i = 0; i < numAlumnos; i++) {
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = sc.nextLine();
            libreta.agregarAlumno(nombre);
            // Bucle para ingresar las notas del alumno.
            for (int j = 0; j < numNotas; j++) {
                double nota;
                // Validación para que la nota esté dentro del rango permitido (0.0 - 7.0).
                do {
                    System.out.print("Ingrese la nota " + (j + 1) + " para " + nombre + " en formato (0,0 - 7,0): ");
                    nota = sc.nextDouble();
                } while (nota < 0.0 || nota > 7.0);
                libreta.agregarNota(nombre, nota);
            }
            sc.nextLine(); // Limpiar buffer
        }
    }

    // Método que muestra el menú de opciones y permite al usuario interactuar con el programa.
    public void mostrarMenu() {
        int opcion;
        do {
            // Despliega las opciones del menú.
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Mostrar el Promedio de Notas por Estudiante");
            System.out.println("2. Mostrar si la Nota es Aprobatoria o Reprobatoria por Estudiante");
            System.out.println("3. Mostrar si la Nota está por Sobre o por Debajo del Promedio del Curso por Estudiante");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); //Limpiar buffer

            //Maneja las diferentes opciones del menú.
            switch (opcion) {
                case 1:
                    libreta.mostrarPromedios();
                    break;
                case 2:
                    evaluarNota();
                    break;
                case 3:
                    compararConPromedioCurso();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0); // Repite el menú hasta que el usuario decida salir.
    }

    // Método para evaluar si las notas de un estudiante son aprobatorias o reprobatorias.
    private void evaluarNota() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();
        Alumno alumno = libreta.getAlumno(nombre);

        // Verifica si el alumno existe en la libreta.
        if (alumno == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.println("\nEvaluación de notas de " + nombre + ":");
        // Recorre todas las notas del alumno y las clasifica como aprobatorias o reprobatorias.
        for (double nota : alumno.getNotas()) {
            if (alumno.esAprobatoria(nota)) {
                System.out.println("Nota " + nota + ": APROBATORIA.");
            } else {
                System.out.println("Nota " + nota + ": REPROBATORIA.");
            }
        }
    }

    // Método para comparar las notas de un estudiante con el promedio del curso.
    private void compararConPromedioCurso() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();
        Alumno alumno = libreta.getAlumno(nombre);
        // Verifica si el alumno existe en la libreta.
        if (alumno == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.println("\n Comparar nota de " + nombre + " versus promedio del curso: ");
        // Recorre todas las notas del alumno y las compara con el promedio del curso.
        for (double nota : alumno.getNotas()) {
            if (alumno.calcularPromedio() < libreta.calcularPromedioCurso()) {
                System.out.println("La nota está POR DEBAJO del promedio del curso.");
            } else {
                System.out.println("La nota está POR SOBRE el promedio del curso.");
            }
        }
    }
}


