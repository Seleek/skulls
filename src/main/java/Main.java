import java.util.Scanner;

public class Main {
    // Pirámide de calaveras con 3 niveles
    // Cada carta puede contener calaveras: reyes, criminales, sacerdotes, campesinos, enamorados
    
    static class Carta {
        String mitadSuperior;
        String mitadInferior;
        
        public Carta() {
            this.mitadSuperior = "."; // Vacía inicialmente
            this.mitadInferior = "."; // Vacía inicialmente
        }
        
        public void agregarCalavera(String tipo, boolean esMitadSuperior) {
            if (esMitadSuperior) {
                this.mitadSuperior = tipo;
            } else {
                this.mitadInferior = tipo;
            }
        }
        
        public boolean estaVacia(boolean esMitadSuperior) {
            if (esMitadSuperior) {
                return this.mitadSuperior.equals(".");
            } else {
                return this.mitadInferior.equals(".");
            }
        }
    }
    
    static class Piramide {
        Carta[][] niveles;
        String[] tiposCalaveras = {"Rey", "Criminal", "Sacerdote", "Campesino", "Enamorado"};
        
        public Piramide() {
            // Inicializar la pirámide: Nivel 1=2 cartas, Nivel 2=3 cartas, Nivel 3=4 cartas
            niveles = new Carta[3][];
            niveles[0] = new Carta[2]; // Nivel 1
            niveles[1] = new Carta[3]; // Nivel 2
            niveles[2] = new Carta[4]; // Nivel 3
            
            inicializarCartas();
        }
        
        private void inicializarCartas() {
            // Crear todas las cartas vacías
            for (int nivel = 0; nivel < 3; nivel++) {
                for (int carta = 0; carta < niveles[nivel].length; carta++) {
                    niveles[nivel][carta] = new Carta();
                }
            }
        }
        
        public void mostrarPiramide() {
            System.out.println("\n=== PIRÁMIDE DE CALAVERAS ===");
            System.out.println("Tipos: Rey, Criminal, Sacerdote, Campesino, Enamorado");
            System.out.println();
            
            // Subnivel 1: Nivel 1 - Mitad Superior (2 cartas)
            System.out.print("SUBNIVEL 1:   ");
            for (int carta = 0; carta < 2; carta++) {
                System.out.printf("[] ", niveles[0][carta].mitadSuperior);
            }
            System.out.println();
            
            // Subnivel 2: Nivel 1 - Mitad Inferior (2 cartas)  
            System.out.print("SUBNIVEL 2:   ");
            for (int carta = 0; carta < 2; carta++) {
                System.out.printf("[] ", niveles[0][carta].mitadInferior);
            }
            System.out.println();
            System.out.println();
            
            // Subnivel 3: Nivel 2 - Mitad Superior (3 cartas)
            System.out.print("SUBNIVEL 3:  ");
            for (int carta = 0; carta < 3; carta++) {
                System.out.printf("[] ", niveles[1][carta].mitadSuperior);
            }
            System.out.println();
            
            // Subnivel 4: Nivel 2 - Mitad Inferior (3 cartas)
            System.out.print("SUBNIVEL 4:  ");
            for (int carta = 0; carta < 3; carta++) {
                System.out.printf("[] ", niveles[1][carta].mitadInferior);
            }
            System.out.println();
            System.out.println();
            
            // Subnivel 5: Nivel 3 - Mitad Superior (4 cartas)
            System.out.print("SUBNIVEL 5: ");
            for (int carta = 0; carta < 4; carta++) {
                System.out.printf("[] ", niveles[2][carta].mitadSuperior);
            }
            System.out.println();
            
            // Subnivel 6: Nivel 3 - Mitad Inferior (4 cartas)
            System.out.print("SUBNIVEL 6: ");
            for (int carta = 0; carta < 4; carta++) {
                System.out.printf("[] ", niveles[2][carta].mitadInferior);
            }
            System.out.println();
            System.out.println();
        }
        
        public void mostrarSubniveles() {
            System.out.println("=== INFORMACIÓN DE SUBNIVELES ===");
            System.out.println("1. Subnivel 1 - Nivel 1, Mitad Superior (2 cartas)");
            System.out.println("2. Subnivel 2 - Nivel 1, Mitad Inferior (2 cartas)");
            System.out.println("3. Subnivel 3 - Nivel 2, Mitad Superior (3 cartas)");
            System.out.println("4. Subnivel 4 - Nivel 2, Mitad Inferior (3 cartas)");
            System.out.println("5. Subnivel 5 - Nivel 3, Mitad Superior (4 cartas)");
            System.out.println("6. Subnivel 6 - Nivel 3, Mitad Inferior (4 cartas)");
            System.out.println();
        }
        
        public void mostrarTiposCalaveras() {
            System.out.println("=== TIPOS DE CALAVERAS DISPONIBLES ===");
            for (int i = 0; i < tiposCalaveras.length; i++) {
                System.out.println((i + 1) + ". " + tiposCalaveras[i]);
            }
            System.out.println();
        }
        
        public void agregarCalaveraEnSubnivel(int subnivel, int carta, int tipoCalavera) {
            // Validar subnivel
            if (subnivel < 1 || subnivel > 6) {
                System.out.println("Subnivel inválido. Debe ser entre 1 y 6.");
                return;
            }
            
            // Determinar nivel, mitad y validar carta
            int nivel;
            boolean esMitadSuperior;
            int maxCartas;
            
            if (subnivel == 1) { // Nivel 1, Superior
                nivel = 0; esMitadSuperior = true; maxCartas = 2;
            } else if (subnivel == 2) { // Nivel 1, Inferior
                nivel = 0; esMitadSuperior = false; maxCartas = 2;
            } else if (subnivel == 3) { // Nivel 2, Superior
                nivel = 1; esMitadSuperior = true; maxCartas = 3;
            } else if (subnivel == 4) { // Nivel 2, Inferior
                nivel = 1; esMitadSuperior = false; maxCartas = 3;
            } else if (subnivel == 5) { // Nivel 3, Superior
                nivel = 2; esMitadSuperior = true; maxCartas = 4;
            } else { // subnivel == 6, Nivel 3, Inferior
                nivel = 2; esMitadSuperior = false; maxCartas = 4;
            }
            
            if (carta < 1 || carta > maxCartas) {
                System.out.println("Carta inválida. El subnivel " + subnivel + " tiene " + maxCartas + " cartas.");
                return;
            }
            
            if (tipoCalavera < 1 || tipoCalavera > 5) {
                System.out.println("Tipo de calavera inválido. Debe ser entre 1 y 5.");
                return;
            }
            
            // Verificar si la posición está vacía
            Carta cartaSeleccionada = niveles[nivel][carta - 1];
            if (!cartaSeleccionada.estaVacia(esMitadSuperior)) {
                System.out.println("Esa posición ya tiene una calavera.");
                return;
            }
            
            // Agregar la calavera
            cartaSeleccionada.agregarCalavera(tiposCalaveras[tipoCalavera - 1], esMitadSuperior);
            
            System.out.println("Calavera '" + tiposCalaveras[tipoCalavera - 1] + "' agregada al subnivel " + 
                             subnivel + ", carta " + carta + ".");
        }
        
        public void limpiarPiramide() {
            for (int nivel = 0; nivel < 3; nivel++) {
                for (int carta = 0; carta < niveles[nivel].length; carta++) {
                    niveles[nivel][carta] = new Carta();
                }
            }
            System.out.println("Pirámide limpiada. Todas las cartas están vacías.");
        }
        
        public void mostrarEstadisticas() {
            System.out.println("=== ESTADÍSTICAS DE LA PIRÁMIDE ===");
            int[] conteoCalaveras = new int[5]; // Para cada tipo
            int totalCalaveras = 0;
            int posicionesVacias = 0;
            
            for (int nivel = 0; nivel < 3; nivel++) {
                for (int carta = 0; carta < niveles[nivel].length; carta++) {
                    Carta c = niveles[nivel][carta];
                    
                    // Contar mitad superior
                    if (c.mitadSuperior.equals(".")) {
                        posicionesVacias++;
                    } else {
                        totalCalaveras++;
                        for (int i = 0; i < tiposCalaveras.length; i++) {
                            if (c.mitadSuperior.equals(tiposCalaveras[i])) {
                                conteoCalaveras[i]++;
                                break;
                            }
                        }
                    }
                    
                    // Contar mitad inferior
                    if (c.mitadInferior.equals(".")) {
                        posicionesVacias++;
                    } else {
                        totalCalaveras++;
                        for (int i = 0; i < tiposCalaveras.length; i++) {
                            if (c.mitadInferior.equals(tiposCalaveras[i])) {
                                conteoCalaveras[i]++;
                                break;
                            }
                        }
                    }
                }
            }
            
            System.out.println("Total de calaveras: " + totalCalaveras);
            System.out.println("Posiciones vacías: " + posicionesVacias);
            System.out.println("\nConteo por tipo:");
            for (int i = 0; i < tiposCalaveras.length; i++) {
                System.out.println("- " + tiposCalaveras[i] + ": " + conteoCalaveras[i]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== JUEGO DE PIRÁMIDE DE CALAVERAS ===");
        System.out.println("¡Bienvenido al juego de la pirámide de calaveras!");
        System.out.println("Estructura: 3 niveles (2, 3, 4 cartas) - Total: 18 posiciones");
        System.out.println();
        
        Piramide piramide = new Piramide();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("MENÚ:");
            System.out.println("1. Mostrar pirámide");
            System.out.println("2. Ver información de subniveles");
            System.out.println("3. Ver tipos de calaveras");
            System.out.println("4. Agregar calavera");
            System.out.println("5. Ver estadísticas");
            System.out.println("6. Limpiar pirámide");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    piramide.mostrarPiramide();
                    break;
                case 2:
                    piramide.mostrarSubniveles();
                    break;
                case 3:
                    piramide.mostrarTiposCalaveras();
                    break;
                case 4:
                    System.out.print("Subnivel (1-6): ");
                    int subnivel = scanner.nextInt();
                    System.out.print("Carta: ");
                    int carta = scanner.nextInt();
                    System.out.print("Tipo de calavera (1-5): ");
                    int tipo = scanner.nextInt();
                    piramide.agregarCalaveraEnSubnivel(subnivel, carta, tipo);
                    break;
                case 5:
                    piramide.mostrarEstadisticas();
                    break;
                case 6:
                    piramide.limpiarPiramide();
                    break;
                case 7:
                    System.out.println("¡Gracias por jugar!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
            System.out.println();
        }
    }
}