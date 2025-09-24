package ar.edu.unlam.pb2.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.*;
;


public class GestionDeSalaDeCine {

 private static Scanner scanner = new Scanner(System.in); 
 private static SalaCine sala;
 private static Pelicula[] peliculas = new Pelicula[10];
//Códigos de color ANSI
 private static final String ROJO = "\u001B[31m";
 private static final String VERDE = "\u001B[32m";
 private static final String RESET = "\u001B[0m";
		    
     public static void main(String[] args) {
    	 
		        inicializarSistema();
		        mostrarMenuPrincipal();
		    }
		    
		    private static void inicializarSistema() {
		        System.out.println("🎬 BIENVENIDOS AL SISTEMA DE GESTIÓN DE CINEMA 🎬");
		        System.out.print("Ingrese el número de filas de la sala: ");
		        int filas = scanner.nextInt();
		        System.out.print("Ingrese el número de columnas de la sala: ");
		        int columnas = scanner.nextInt();
		        
		        sala = new SalaCine(filas, columnas);
		        
		        // Cargar las 10 películas por defecto
		        cargarPeliculasDefault();
		        
		        System.out.println("\n✅ Sistema inicializado correctamente!");
		        System.out.println("Sala de " + filas + "x" + columnas + " creada exitosamente.");
		        System.out.println("📽️  " + peliculas.length + " películas cargadas en el sistema.\n");
		    }
		    
		    private static void cargarPeliculasDefault() {
		        // Películas de Acción
		        peliculas[0] = new PeliculaAccion("Misión Imposible", 150, 13);
		        peliculas[0].setSinopsis("Un espía hace misiones muy difíciles para salvar al mundo. Hay mucha acción y peligro.");
		        peliculas[1] = new PeliculaAccion("John Wick 4", 169, 16);
		        peliculas[1].setSinopsis("John Wick pelea contra muchos enemigos para ser libre. Hay mucha acción y peleas.");
		        peliculas[2] = new PeliculaAccion("Top Gun: Maverick", 130, 13);
		        peliculas[2].setSinopsis("Un piloto vuela aviones muy rápido y hace misiones peligrosas. Hay emoción y velocidad.");
		        
		        // Películas de Comedia
		        peliculas[3] = new PeliculaComedia("La Máscara", 120, 7);
		        peliculas[3].setSinopsis("Un hombre se pone una máscara mágica y se vuelve muy loco y divertido.");
		        peliculas[4] = new PeliculaComedia("Shrek", 90, 0);
		        peliculas[4].setSinopsis("Shrek es un ogro que vive solo. Conoce amigos y vive aventuras divertidas.");
		        // Películas de Drama
		        peliculas[5] = new PeliculaDrama("Forrest Gump", 142, 13);
		        peliculas[5].setSinopsis("Forrest Gump es un hombre bueno que vive muchas aventuras sin buscarlo.");
		        peliculas[6] = new PeliculaDrama("El Padrino", 175, 16);
		        peliculas[6].setSinopsis("Un padre y su hijo están en una familia mafiosa. Hay peleas, secretos y poder.");
		        
		        // Películas de Terror
		        peliculas[7] = new PeliculaTerror("El Conjuro", 112, 16);
		        peliculas[7].setSinopsis("Una familia tiene fantasmas en su casa. Dos personas van a ayudarlos.");
		        peliculas[8] = new PeliculaTerror("Scream", 111, 16);
		        peliculas[8].setSinopsis("Un asesino con máscara ataca gente. Todos tienen miedo.");
		        
		        // Película Infantil
		        peliculas[9] = new PeliculaInfantil("Frozen", 102, 0);
		        peliculas[9].setSinopsis("Dos hermanas viven en un reino con nieve. Una tiene poderes de hielo.");
		    }
		    
// LOGICA DEL MENU
		    
		    private static void mostrarMenuPrincipal() {
		        int opcion;
		        
		        do {
		            System.out.println("=".repeat(50));
		            System.out.println("🎭 MENU PRINCIPAL - GESTIÓN DE SALA DE CINE 🎭");
		            System.out.println("=".repeat(50));
		            System.out.println("1. 🎬 Gestionar películas");
		            System.out.println("2. 🎫 Vender boleto");
		            System.out.println("3. 🔓 Liberar asiento");
		            System.out.println("4. 👀 Ver estado de la sala");
		            System.out.println("5. 📋 Ver información de película actual");
		            System.out.println("6. 👥 Ver detalle de compradores");
		            System.out.println("7. 🎪 Reiniciar sala (liberar todos los asientos)");
		            System.out.println("0. 🚪 Salir del sistema");
		            System.out.println("=".repeat(50));
		            System.out.print("Seleccione una opción: ");
		            
		            opcion = scanner.nextInt();
		            
		            switch (opcion) {
		                case 1:
		                    gestionarPeliculas();
		                    break;
		                case 2:
		                    venderBoleto();
		                    break;
		                case 3:
		                    liberarAsiento();
		                    break;
		                case 4:
		                    mostrarButacas();

		                    break;
		                case 5:
		                    mostrarInfoPelicula();
		                    break;
		                case 6:
		                    mostrarDetalleDeButacasCompradas();
		                    break;
		                case 7:
		                    reiniciarSala();
		                    break;
		                case 0:
		                    System.out.println("¡Gracias por usar nuestro sistema de cinema! 🍿");
		                    break;
		                default:
		                    System.out.println("❌ Opción inválida. Intente de nuevo.");
		            }
		            
		            if (opcion != 0) {
		                System.out.println("\nPresione Enter para continuar...");
		                scanner.nextLine();
		                scanner.nextLine();
		            }
		            
		        } while (opcion != 0);
		    }
		    


// OPCION 1 : GESTIONAR PELICULA
		    
		    private static void gestionarPeliculas() {
		        System.out.println("\n🎬 CATÁLOGO DE PELÍCULAS DISPONIBLES");
		        System.out.println("=".repeat(50));
		        
		        for (int i = 0; i < peliculas.length; i++) {
		            String genero = obtenerGenero(peliculas[i]);
		            System.out.printf("%2d. [%s] %s (%d años+)\n", 
		                (i + 1), genero, peliculas[i].getTitulo(), peliculas[i].getEdadMinima());
		        }
		        
		        System.out.println("11. 📋 Ver sinopsis de película actual");
		        System.out.println("=".repeat(50));
		        System.out.print("Seleccione una película (1-11): ");
		        
		        int opcion = scanner.nextInt();
		        
		        if (opcion >= 1 && opcion <= 10) {
		            Pelicula peliculaSeleccionada = peliculas[opcion - 1];
		            cambiarPelicula(peliculaSeleccionada);
		            System.out.println(peliculaSeleccionada.mostrarSinopsis());
		        } else if (opcion == 11) {
		            if (sala.getPeliculaActual() != null) {
		            	System.out.println(sala.getPeliculaActual().mostrarSinopsis());
		            } else {
		                System.out.println("❌ No hay película en cartelera actualmente.");
		            }
		        } else {
		            System.out.println("❌ Opción inválida.");
		        }
		    }
		    
		    private static String obtenerGenero(Pelicula pelicula) {
		        if (pelicula instanceof PeliculaAccion) return "ACCIÓN";
		        if (pelicula instanceof PeliculaComedia) return "COMEDIA";
		        if (pelicula instanceof PeliculaDrama) return "DRAMA";
		        if (pelicula instanceof PeliculaTerror) return "TERROR";
		        if (pelicula instanceof PeliculaInfantil) return "INFANTIL";
		        return "GENERAL";
		    }
		    
// OPCION 2: VENDER BOLETO
		    
		    private static void venderBoleto() {
		        if (sala.getPeliculaActual() == null) {
		            System.out.println("❌ No hay película en cartelera. Primero seleccione una película.");
		            return;
		        }
		        
		        System.out.println("\n🎫 VENTA DE BOLETOS");
		        System.out.println("Película actual: " + sala.getPeliculaActual().getTitulo());
		        System.out.println("Edad mínima requerida: " + sala.getPeliculaActual().getEdadMinima() + " años");
		        
		        mostrarButacas();
		        
		        System.out.print("Ingrese el nombre del comprador: ");
		        scanner.nextLine(); // Limpiar buffer
		        String nombreComprador = scanner.nextLine();
		        
		        System.out.print("Ingrese la fila del asiento: ");
		        int fila = scanner.nextInt();
		        System.out.print("Ingrese la columna del asiento: ");
		        int columna = scanner.nextInt();
		        System.out.print("Ingrese la edad del cliente: ");
		        int edad = scanner.nextInt();
		        
		        boolean exito = sala.venderBoleto(fila, columna, new Cliente(nombreComprador, edad));
		        
		        if (exito) {
		            System.out.println("🎉 ¡Boleto vendido exitosamente!");
		            mostrarButacas();
		        } else {
		            System.out.println("❌ No se pudo vender el boleto.");
		        }
		    }
		    
// OPCION 3: LIBERAR ASIENTOS
		    
		    private static void liberarAsiento() {
		        System.out.println("\n🔓 LIBERAR ASIENTO");
		        mostrarButacas();
		        
		        System.out.print("Ingrese la fila del asiento a liberar: ");
		        int fila = scanner.nextInt();
		        System.out.print("Ingrese la columna del asiento a liberar: ");
		        int columna = scanner.nextInt();
		        
		        boolean exito = sala.liberarAsiento(fila, columna);
		        
		        if (exito) {
		            System.out.println("🎉 ¡Asiento liberado exitosamente!");
		           mostrarButacas();
		        }
		    }
		    
//OPCION 5: MOSTRAR INFO PELICULA
		    
		    private static void mostrarInfoPelicula() {
		    	
		        if (sala.getPeliculaActual() != null) {
		            System.out.println("\n📋 INFORMACIÓN DE LA PELÍCULA ACTUAL");
		            System.out.println(sala.getPeliculaActual().mostrarDetalleDePelicula());
		            System.err.println("Genero: " + obtenerGenero(sala.getPeliculaActual()));
		        } else {
		            System.out.println("❌ No hay película en cartelera actualmente.");
		        }
		    }
		    
// OPCION 7: REINICIAR SALA
		    
		    private static void reiniciarSala() {
		        System.out.print("⚠️  ¿Está seguro que desea liberar todos los asientos? (s/n): ");
		        scanner.nextLine(); // Limpiar buffer
		        String confirmacion = scanner.nextLine();
		        
		        if (confirmacion.equalsIgnoreCase("s") || confirmacion.equalsIgnoreCase("si")) {
		            sala.reiniciarSala();
		            mostrarButacas();
		        } else {
		            System.out.println("❌ Operación cancelada.");
		        }
		    }

// OPCION 4: MOSTRAR BUTACAS
		    	public static void mostrarButacas() {
		        Asiento[][] butacas = sala.getButacas();

		        System.out.println("\n=== ESTADO DE LA SALA ===");
		        if (sala.getPeliculaActual() != null) {
		            System.out.println("🎬 Película: " + sala.getPeliculaActual().getTitulo());
		        }
		        System.out.println("📊 Ocupación: " + sala.contarAsientosOcupados() + "/" + sala.getTotalAsientos() + " asientos");

		        // Encabezado con números de columna
		        System.out.print("   ");
		        for (int j = 0; j < butacas[0].length; j++) {
		            System.out.printf("%3d", j);
		        }
		        System.out.println();

		        // Filas de butacas
		        for (int i = 0; i < butacas.length; i++) {
		            System.out.printf("%2d ", i);
		            for (int j = 0; j < butacas[i].length; j++) {
		                if (butacas[i][j] != null && butacas[i][j].estaOcupado()) {
		                    System.out.printf("%s%3c%s", ROJO, 'X', RESET); // Rojo para ocupadas
		                } else {
		                    System.out.printf("%s%3c%s", VERDE, 'O', RESET); // Verde para libres
		                }
		            }
		            System.out.println();
		        }

		        System.out.println("🟢 O = Libre, 🔴 X = Ocupado\n");
		    }
		    	
		   

		    public static void cambiarPelicula(Pelicula nuevaPelicula) {
		    	sala.cambiarPelicula(nuevaPelicula);
		    	System.out.println("Pelicula cambiada a: " + nuevaPelicula.getTitulo());
		    }
		    
		    private static void mostrarDetalleDeButacasCompradas() {
		    	System.out.println(sala.mostrarButacasDetalle());
		    			    	
		    }

	}


