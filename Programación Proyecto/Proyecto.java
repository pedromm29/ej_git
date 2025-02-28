import java.util.Scanner;

public class Proyecto {
    // Definición de constantes para el tamaño máximo de los arrays
    static final int MAX_USUARIOS = 100;
    static final int MAX_EVENTOS = 100;
    static final int MAX_INSCRIPCIONES = 100;
    
    // Arrays para almacenar información de los usuarios
    static String[] nombresUsuarios = new String[MAX_USUARIOS];
    static String[] usuarios = new String[MAX_USUARIOS];
    static String[] contrasenias = new String[MAX_USUARIOS];
    static int contadorUsuarios = 0;
    
    // Arrays para almacenar información de los eventos
    static String[] eventos = new String[MAX_EVENTOS];
    static String[] fechas = new String[MAX_EVENTOS];
    static String[] ubicaciones = new String[MAX_EVENTOS];
    static int contadorEventos = 0;
    
    // Arrays para almacenar las inscripciones (relación usuario-evento)
    static int[] inscripcionesUsuarios = new int[MAX_INSCRIPCIONES];
    static int[] inscripcionesEventos = new int[MAX_INSCRIPCIONES];
    static int contadorInscripciones = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        // Bucle principal del menú de opciones
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    registrarUsuario(scanner);
                    break;
                case 2:
                    agregarEvento(scanner);
                    break;
                case 3:
                    listarEventos();
                    break;
                case 4:
                    inscribirUsuarioEvento(scanner);
                    break;
                case 5:
                    listarInscripciones();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
        
        scanner.close();
    }
    
    // Función para mostrar el menú de opciones
    public static void mostrarMenu() {
        System.out.println("\n--- Gestión de Eventos ---");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Agregar evento");
        System.out.println("3. Listar eventos");
        System.out.println("4. Inscribir usuario a evento");
        System.out.println("5. Listar inscripciones");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    // Función para registrar un nuevo usuario
    public static void registrarUsuario(Scanner scanner) {
        if (contadorUsuarios < MAX_USUARIOS) {
            System.out.print("Ingrese el nombre del usuario: ");
            nombresUsuarios[contadorUsuarios] = scanner.nextLine();
            System.out.print("Ingrese el nombre de usuario: ");
            usuarios[contadorUsuarios] = scanner.nextLine();
            System.out.print("Ingrese la contraseña: ");
            contrasenias[contadorUsuarios] = scanner.nextLine();
            contadorUsuarios++;
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("No se pueden registrar más usuarios.");
        }
    }
    
    // Función para agregar un nuevo evento
    public static void agregarEvento(Scanner scanner) {
        if (contadorEventos < MAX_EVENTOS) {
            System.out.print("Ingrese el nombre del evento: ");
            eventos[contadorEventos] = scanner.nextLine();
            System.out.print("Ingrese la fecha del evento: ");
            fechas[contadorEventos] = scanner.nextLine();
            System.out.print("Ingrese la ubicación del evento: ");
            ubicaciones[contadorEventos] = scanner.nextLine();
            contadorEventos++;
            System.out.println("Evento agregado exitosamente.");
        } else {
            System.out.println("No se pueden agregar más eventos.");
        }
    }
    
    // Función para listar los eventos registrados
    public static void listarEventos() {
        System.out.println("\nLista de eventos:");
        if (contadorEventos == 0) {
            System.out.println("No hay eventos registrados.");
        } else {
            for (int i = 0; i < contadorEventos; i++) {
                System.out.println((i + 1) + ". " + eventos[i] + " - " + fechas[i] + " - " + ubicaciones[i]);
            }
        }
    }
    
    // Función para inscribir un usuario a un evento
    public static void inscribirUsuarioEvento(Scanner scanner) {
        if (contadorInscripciones < MAX_INSCRIPCIONES) {
            System.out.print("Ingrese el índice del usuario (1 a " + contadorUsuarios + "): ");
            int usuarioIdx = scanner.nextInt() - 1;
            System.out.print("Ingrese el índice del evento (1 a " + contadorEventos + "): ");
            int eventoIdx = scanner.nextInt() - 1;
            
            if (usuarioIdx >= 0 && usuarioIdx < contadorUsuarios && eventoIdx >= 0 && eventoIdx < contadorEventos) {
                inscripcionesUsuarios[contadorInscripciones] = usuarioIdx;
                inscripcionesEventos[contadorInscripciones] = eventoIdx;
                contadorInscripciones++;
                System.out.println("Inscripción realizada exitosamente.");
            } else {
                System.out.println("Índices inválidos.");
            }
        } else {
            System.out.println("No se pueden registrar más inscripciones.");
        }
    }
    
    // Función para listar las inscripciones registradas
    public static void listarInscripciones() {
        System.out.println("\nLista de inscripciones:");
        if (contadorInscripciones == 0) {
            System.out.println("No hay inscripciones registradas.");
        } else {
            for (int i = 0; i < contadorInscripciones; i++) {
                System.out.println(nombresUsuarios[inscripcionesUsuarios[i]] + " está inscrito en " + eventos[inscripcionesEventos[i]]);
            }
        }
    }
}