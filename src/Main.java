public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(); //Crea la instancia de menú para interactuar con el usuario
        menu.ingresarDatos(); //Solicita y guarda la informacion de alumnos y notas.
        menu.mostrarMenu(); //Muestra el menú de opciones y permite al usuario interactuar
    }
}