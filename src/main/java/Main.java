import java.util.Scanner;

public class Main {
    // Pirámide de calaveras con 3 niveles
    // Cada carta puede contener calaveras: reyes, criminales, sacerdotes, campesinos, enamorados
    static class Carta {
        String mitadSuperior;
        String mitadInferior;
        boolean volteadaSuperior;
        boolean volteadaInferior;
        
        public Carta() {
            this.mitadSuperior = "."; // Vacía inicialmente
            this.mitadInferior = "."; // Vacía inicialmente
            this.volteadaSuperior = false; // No volteada por defecto
            this.volteadaInferior = false; // No volteada por defecto
        }
        
        public void agregarCalavera(String tipo, boolean esMitadSuperior) {
            if (esMitadSuperior) {
                this.mitadSuperior = tipo;
            } else {
                this.mitadInferior = tipo;
            }
        }
        
        public void voltearMitad(boolean esMitadSuperior) {
            if (esMitadSuperior) {
                this.volteadaSuperior = !this.volteadaSuperior;
            } else {
                this.volteadaInferior = !this.volteadaInferior;
            }
        }
        
        public boolean estaVolteada(boolean esMitadSuperior) {
            if (esMitadSuperior) {
                return this.volteadaSuperior;
            } else {
                return this.volteadaInferior;
            }
        }
        
        public boolean estaVacia(boolean esMitadSuperior) {
            if (esMitadSuperior) {
                return this.mitadSuperior.equals(".");
            } else {
                return this.mitadInferior.equals(".");
            }
        }
        
        public String obtenerContenidoVisible(boolean esMitadSuperior) {
            if (estaVolteada(esMitadSuperior)) {
                return "-"; // Mostrar "-" si está volteada
            }
            
            if (esMitadSuperior) {
                return this.mitadSuperior;
            } else {
                return this.mitadInferior;
            }
        }
    }
    
    static class Piramide {
        Carta[][] niveles;
        String[] tiposCalaveras = {"Rey", "Criminal", "Sacerdote", "Campesino", "Enamorado"};
        int puntos = 0;
        int puntosTotal = 0;
        
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
            System.out.println("Las cartas se numeran de izquierda a derecha");
            System.out.println();
            
            // Subnivel 1: Nivel 1 - Mitad Superior (2 cartas)
            System.out.print("SUBNIVEL 1:   ");
            for (int carta = 0; carta < 2; carta++) {
                System.out.printf("[" + niveles[0][carta].obtenerContenidoVisible(true) + "] ");
            }
            System.out.println();
            
            // Subnivel 2: Nivel 1 - Mitad Inferior (2 cartas)  
            System.out.print("SUBNIVEL 2:   ");
            for (int carta = 0; carta < 2; carta++) {
                System.out.printf("[" + niveles[0][carta].obtenerContenidoVisible(false) + "] ");
            }
            System.out.println();
            System.out.println();
            
            // Subnivel 3: Nivel 2 - Mitad Superior (3 cartas)
            System.out.print("SUBNIVEL 3:  ");
            for (int carta = 0; carta < 3; carta++) {
                System.out.printf("[" + niveles[1][carta].obtenerContenidoVisible(true) + "] ");
            }
            System.out.println();
            
            // Subnivel 4: Nivel 2 - Mitad Inferior (3 cartas)
            System.out.print("SUBNIVEL 4:  ");
            for (int carta = 0; carta < 3; carta++) {
                System.out.printf("[" + niveles[1][carta].obtenerContenidoVisible(false) + "] ");
            }
            System.out.println();
            System.out.println();
            
            // Subnivel 5: Nivel 3 - Mitad Superior (4 cartas)
            System.out.print("SUBNIVEL 5: ");
            for (int carta = 0; carta < 4; carta++) {
                System.out.printf("[" + niveles[2][carta].obtenerContenidoVisible(true) + "] ");
            }
            System.out.println();
            
            // Subnivel 6: Nivel 3 - Mitad Inferior (4 cartas)
            System.out.print("SUBNIVEL 6: ");
            for (int carta = 0; carta < 4; carta++) {
                System.out.printf("[" + niveles[2][carta].obtenerContenidoVisible(false) + "] ");
            }
            System.out.println();
            System.out.println();
        }
        
        public void mostrarSubniveles() {
            System.out.println("=== INFORMACIÓN DE SUBNIVELES ===");
            System.out.println("Las cartas se numeran de izquierda a derecha en cada subnivel:");
            System.out.println();
            System.out.println("1. Subnivel 1 - Nivel 1, Mitad Superior (2 cartas: 1, 2)");
            System.out.println("2. Subnivel 2 - Nivel 1, Mitad Inferior (2 cartas: 1, 2)");
            System.out.println("3. Subnivel 3 - Nivel 2, Mitad Superior (3 cartas: 1, 2, 3)");
            System.out.println("4. Subnivel 4 - Nivel 2, Mitad Inferior (3 cartas: 1, 2, 3)");
            System.out.println("5. Subnivel 5 - Nivel 3, Mitad Superior (4 cartas: 1, 2, 3, 4)");
            System.out.println("6. Subnivel 6 - Nivel 3, Mitad Inferior (4 cartas: 1, 2, 3, 4)");
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
            
            // Verificar si la mitad de la carta está volteada
            if (cartaSeleccionada.estaVolteada(esMitadSuperior)) {
                String mitadStr = esMitadSuperior ? "superior" : "inferior";
                System.out.println("No se puede agregar una calavera en la mitad " + mitadStr + 
                                 " de la carta " + carta + " porque está volteada.");
                return;
            }
            
            // Agregar la calavera
            cartaSeleccionada.agregarCalavera(tiposCalaveras[tipoCalavera - 1], esMitadSuperior);
            
            System.out.println("Calavera '" + tiposCalaveras[tipoCalavera - 1] + "' agregada al subnivel " + 
                             subnivel + ", carta " + carta + ".");
            
            // Verificar automáticamente si algún rey necesita voltearse
            verificarYVoltearReyes();
        }
        
        public void limpiarPiramide() {
            for (int nivel = 0; nivel < 3; nivel++) {
                for (int carta = 0; carta < niveles[nivel].length; carta++) {
                    niveles[nivel][carta] = new Carta();
                }
            }
            System.out.println("Pirámide limpiada. Todas las cartas están vacías.");
        }
        
public int calcularPuntos() {
    puntosTotal = 0;  // Resetear puntos al calcular
    
    // Calcular puntos de reyes
    int puntosReyes = calcularPuntosReyes();
    puntosTotal += puntosReyes;
    
    // Calcular puntos de criminales
    int puntosCriminales = calcularPuntosCriminales();
    puntosTotal += puntosCriminales;
    
    // Calcular puntos de enamorados
    int puntosEnamorados = calcularPuntosEnamorados();
    puntosTotal += puntosEnamorados;
    
    return puntosTotal;
}

public int calcularPuntosReyes() {
    int puntosReyesTotal = 0;
    
    // Revisar cada subnivel para encontrar reyes
            for (int subnivel = 1; subnivel <= 5; subnivel++) { // Solo subniveles 1-5 pueden tener reyes con calaveras debajo
                int nivel, maxCartas;
                boolean esMitadSuperior;
                
                // Determinar nivel y mitad del subnivel actual
                if (subnivel == 1) {
                    nivel = 0; esMitadSuperior = true; maxCartas = 2;
                } else if (subnivel == 2) {
                    nivel = 0; esMitadSuperior = false; maxCartas = 2;
                } else if (subnivel == 3) {
                    nivel = 1; esMitadSuperior = true; maxCartas = 3;
                } else if (subnivel == 4) {
                    nivel = 1; esMitadSuperior = false; maxCartas = 3;
                } else { // subnivel == 5
                    nivel = 2; esMitadSuperior = true; maxCartas = 4;
                }
                
                // Buscar reyes en el subnivel actual
                for (int carta = 0; carta < maxCartas; carta++) {
                    String calavera = esMitadSuperior ? 
                        niveles[nivel][carta].mitadSuperior : 
                        niveles[nivel][carta].mitadInferior;
                    
                    if (calavera.equals("Rey")) {
                        // Contar campesinos y reyes en todos los subniveles inferiores
                        int puntosRey = contarCampesinosYReyesDebajo(subnivel, carta);
                        puntosReyesTotal += puntosRey;
                        
                        // Mostrar qué subniveles está contando
                        String subnivelesTotales = "";
                        for (int sub = subnivel + 1; sub <= 6; sub++) {
                            subnivelesTotales += sub;
                            if (sub < 6) subnivelesTotales += ", ";
                        }
                        
                        System.out.println("Rey en subnivel " + subnivel + ", carta " + (carta + 1) + 
                                         ": " + puntosRey + " puntos (contando subniveles " + subnivelesTotales + ")");
                    }
                }
            }
            
            return puntosReyesTotal;
        }
        
        private int contarCampesinosYReyesDebajo(int subnivelRey, int cartaRey) {
            puntos = 0;  // Resetear puntos para este rey
            
            // Recorrer todos los subniveles por debajo del rey
            for (int subnivelInferior = subnivelRey + 1; subnivelInferior <= 6; subnivelInferior++) {
                int nivel, maxCartas;
                boolean esMitadSuperior;
                
                // Determinar nivel y mitad del subnivel inferior
                if (subnivelInferior == 1) {
                    nivel = 0; esMitadSuperior = true; maxCartas = 2;
                } else if (subnivelInferior == 2) {
                    nivel = 0; esMitadSuperior = false; maxCartas = 2;
                } else if (subnivelInferior == 3) {
                    nivel = 1; esMitadSuperior = true; maxCartas = 3;
                } else if (subnivelInferior == 4) {
                    nivel = 1; esMitadSuperior = false; maxCartas = 3;
                } else if (subnivelInferior == 5) {
                    nivel = 2; esMitadSuperior = true; maxCartas = 4;
                } else { // subnivelInferior == 6
                    nivel = 2; esMitadSuperior = false; maxCartas = 4;
                }
                
                // Contar campesinos y reyes en todas las cartas del subnivel
                for (int carta = 0; carta < maxCartas; carta++) {
                    String calavera = esMitadSuperior ? 
                        niveles[nivel][carta].mitadSuperior : 
                        niveles[nivel][carta].mitadInferior;
                    
                    if (calavera.equals("Campesino") || calavera.equals("Rey")) {
                        puntos++;
                    }
                }
            }
            
            return puntos;
        }
        
        public int calcularPuntosCriminales() {
            int puntosCriminalesTotal = 0;
            
            // Revisar cada subnivel para encontrar criminales
            for (int subnivel = 1; subnivel <= 6; subnivel++) {
                int nivel, maxCartas;
                boolean esMitadSuperior;
                
                // Determinar nivel y mitad del subnivel actual
                if (subnivel == 1) {
                    nivel = 0; esMitadSuperior = true; maxCartas = 2;
                } else if (subnivel == 2) {
                    nivel = 0; esMitadSuperior = false; maxCartas = 2;
                } else if (subnivel == 3) {
                    nivel = 1; esMitadSuperior = true; maxCartas = 3;
                } else if (subnivel == 4) {
                    nivel = 1; esMitadSuperior = false; maxCartas = 3;
                } else if (subnivel == 5) {
                    nivel = 2; esMitadSuperior = true; maxCartas = 4;
                } else { // subnivel == 6
                    nivel = 2; esMitadSuperior = false; maxCartas = 4;
                }
                
                // Buscar criminales en el subnivel actual
                for (int carta = 0; carta < maxCartas; carta++) {
                    String calavera = esMitadSuperior ? 
                        niveles[nivel][carta].mitadSuperior : 
                        niveles[nivel][carta].mitadInferior;
                    
                    if (calavera.equals("Criminal")) {
                        // Verificar si tiene sacerdotes adyacentes
                        boolean tieneSacerdoteAdyacente = verificarSacerdotesAdyacentes(subnivel, carta, nivel, esMitadSuperior, maxCartas);
                        
                        if (tieneSacerdoteAdyacente) {
                            puntosCriminalesTotal += 1;
                            System.out.println("Criminal en subnivel " + subnivel + ", carta " + (carta + 1) + 
                                             ": 1 punto (tiene sacerdote adyacente)");
                        }
                    }
                }
            }
            
            return puntosCriminalesTotal;
        }
        
        public int calcularPuntosEnamorados() {
            // Primero recopilar todas las posiciones de enamorados
            java.util.List<PosicionEnamorado> enamorados = new java.util.ArrayList<>();
            
            for (int subnivel = 1; subnivel <= 6; subnivel++) {
                int nivel, maxCartas;
                boolean esMitadSuperior;
                
                if (subnivel == 1) {
                    nivel = 0; esMitadSuperior = true; maxCartas = 2;
                } else if (subnivel == 2) {
                    nivel = 0; esMitadSuperior = false; maxCartas = 2;
                } else if (subnivel == 3) {
                    nivel = 1; esMitadSuperior = true; maxCartas = 3;
                } else if (subnivel == 4) {
                    nivel = 1; esMitadSuperior = false; maxCartas = 3;
                } else if (subnivel == 5) {
                    nivel = 2; esMitadSuperior = true; maxCartas = 4;
                } else {
                    nivel = 2; esMitadSuperior = false; maxCartas = 4;
                }
                
                for (int carta = 0; carta < maxCartas; carta++) {
                    String calavera = esMitadSuperior ? 
                        niveles[nivel][carta].mitadSuperior : 
                        niveles[nivel][carta].mitadInferior;
                    
                    if (calavera.equals("Enamorado")) {
                        enamorados.add(new PosicionEnamorado(subnivel, carta, nivel, esMitadSuperior));
                    }
                }
            }
            
            // Encontrar emparejamiento óptimo
            return encontrarEmparejamientoOptimo(enamorados);
        }
        
        private int encontrarEmparejamientoOptimo(java.util.List<PosicionEnamorado> enamorados) {
            int numEnamorados = enamorados.size();
            boolean[] usado = new boolean[numEnamorados];
            int pares = 0;
            
            // Construir matriz de adyacencia
            boolean[][] adyacente = new boolean[numEnamorados][numEnamorados];
            for (int i = 0; i < numEnamorados; i++) {
                for (int j = i + 1; j < numEnamorados; j++) {
                    if (sonAdyacentes(enamorados.get(i), enamorados.get(j))) {
                        adyacente[i][j] = true;
                        adyacente[j][i] = true;
                    }
                }
            }
            
            // Algoritmo greedy mejorado: priorizar enamorados con menos conexiones
            while (true) {
                int mejorI = -1, mejorJ = -1;
                int menorConexiones = Integer.MAX_VALUE;
                
                // Buscar el enamorado no usado con menor número de conexiones disponibles
                for (int i = 0; i < numEnamorados; i++) {
                    if (usado[i]) continue;
                    
                    int conexiones = 0;
                    for (int j = 0; j < numEnamorados; j++) {
                        if (!usado[j] && adyacente[i][j]) {
                            conexiones++;
                        }
                    }
                    
                    if (conexiones > 0 && conexiones < menorConexiones) {
                        menorConexiones = conexiones;
                        mejorI = i;
                    }
                }
                
                if (mejorI == -1) break; // No hay más pares posibles
                
                // Buscar la mejor pareja para el enamorado seleccionado
                for (int j = 0; j < numEnamorados; j++) {
                    if (!usado[j] && adyacente[mejorI][j]) {
                        mejorJ = j;
                        break; // Tomar la primera pareja disponible
                    }
                }
                
                if (mejorJ != -1) {
                    usado[mejorI] = true;
                    usado[mejorJ] = true;
                    pares++;
                    
                    PosicionEnamorado pos1 = enamorados.get(mejorI);
                    PosicionEnamorado pos2 = enamorados.get(mejorJ);
                    System.out.println("Par de enamorados: Subnivel " + pos1.subnivel + " carta " + (pos1.carta + 1) + 
                                     " con Subnivel " + pos2.subnivel + " carta " + (pos2.carta + 1) + " - 1 punto");
                }
            }
            
            return pares;
        }
        
        private boolean sonAdyacentes(PosicionEnamorado pos1, PosicionEnamorado pos2) {
            // Misma carta, diferente mitad
            if (pos1.subnivel == pos2.subnivel && pos1.carta == pos2.carta) {
                return pos1.esMitadSuperior != pos2.esMitadSuperior;
            }
            
            // Mismo subnivel, cartas adyacentes
            if (pos1.subnivel == pos2.subnivel) {
                return Math.abs(pos1.carta - pos2.carta) == 1;
            }
            
            // Adyacencias verticales entre diferentes subniveles
            // Ordenar posiciones para simplificar lógica
            PosicionEnamorado menor = pos1.subnivel < pos2.subnivel ? pos1 : pos2;
            PosicionEnamorado mayor = pos1.subnivel < pos2.subnivel ? pos2 : pos1;
            
            // Verificar adyacencias según el patrón de la pirámide
            if (menor.subnivel == 1 && mayor.subnivel == 2) {
                // Subnivel 1 (mitad superior) a subnivel 2 (mitad inferior) - mismo nivel físico
                return menor.carta == mayor.carta;
            }
            if (menor.subnivel == 2 && mayor.subnivel == 3) {
                // Subnivel 2 (mitad inferior nivel 0) a subnivel 3 (mitad superior nivel 1)
                return mayor.carta == menor.carta || mayor.carta == menor.carta + 1;
            }
            if (menor.subnivel == 3 && mayor.subnivel == 4) {
                // Subnivel 3 (mitad superior) a subnivel 4 (mitad inferior) - mismo nivel físico
                return menor.carta == mayor.carta;
            }
            if (menor.subnivel == 4 && mayor.subnivel == 5) {
                // Subnivel 4 (mitad inferior nivel 1) a subnivel 5 (mitad superior nivel 2)
                return mayor.carta == menor.carta || mayor.carta == menor.carta + 1;
            }
            if (menor.subnivel == 5 && mayor.subnivel == 6) {
                // Subnivel 5 (mitad superior) a subnivel 6 (mitad inferior) - mismo nivel físico
                return menor.carta == mayor.carta;
            }
            
            return false;
        }
        
        private int contarCriminalesAdyacentes(int subnivelRey, int cartaRey, boolean esMitadSuperior) {
            int criminalesCount = 0;
            int nivelRey = subnivelANivel(subnivelRey);
            
            // Verificar criminal en la misma carta (mitad opuesta)
            String calavеraEnMismaCarta = esMitadSuperior ? 
                niveles[nivelRey][cartaRey].mitadInferior : 
                niveles[nivelRey][cartaRey].mitadSuperior;
            
            if (calavеraEnMismaCarta.equals("Criminal")) {
                criminalesCount++;
            }
            
            // Verificar criminales adyacentes horizontales (mismo subnivel)
            int maxCartas = getMaxCartasParaSubnivel(subnivelRey);
            
            // Carta a la izquierda
            if (cartaRey > 0) {
                String calavеraIzquierda = esMitadSuperior ? 
                    niveles[nivelRey][cartaRey - 1].mitadSuperior : 
                    niveles[nivelRey][cartaRey - 1].mitadInferior;
                
                if (calavеraIzquierda.equals("Criminal")) {
                    criminalesCount++;
                }
            }
            
            // Carta a la derecha
            if (cartaRey < maxCartas - 1) {
                String calavеraDerecha = esMitadSuperior ? 
                    niveles[nivelRey][cartaRey + 1].mitadSuperior : 
                    niveles[nivelRey][cartaRey + 1].mitadInferior;
                
                if (calavеraDerecha.equals("Criminal")) {
                    criminalesCount++;
                }
            }
            
            // Verificar criminales adyacentes verticales (diferentes subniveles)
            criminalesCount += verificarCriminalesAdyacentesVerticales(subnivelRey, cartaRey);
            
            return criminalesCount;
        }
        
        private int subnivelANivel(int subnivel) {
            switch (subnivel) {
                case 1:
                case 2:
                    return 0; // Nivel 1
                case 3:
                case 4:
                    return 1; // Nivel 2
                case 5:
                case 6:
                    return 2; // Nivel 3
                default:
                    return 0;
            }
        }
        
        private int getMaxCartasParaSubnivel(int subnivel) {
            switch (subnivel) {
                case 1:
                case 2:
                    return 2; // Nivel 1 tiene 2 cartas
                case 3:
                case 4:
                    return 3; // Nivel 2 tiene 3 cartas
                case 5:
                case 6:
                    return 4; // Nivel 3 tiene 4 cartas
                default:
                    return 2;
            }
        }
        
        private int verificarCriminalesAdyacentesVerticales(int subnivelRey, int cartaRey) {
            int criminalesCount = 0;
            
            // Verificar según el subnivel del rey
            switch (subnivelRey) {
                case 1:
                    // Rey en subnivel 1 -> puede ver subnivel 3
                    for (int carta = cartaRey; carta <= cartaRey + 1 && carta < 3; carta++) {
                        if (niveles[1][carta].mitadSuperior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    break;
                case 2:
                    // Rey en subnivel 2 -> puede ver subnivel 3
                    for (int carta = cartaRey; carta <= cartaRey + 1 && carta < 3; carta++) {
                        if (niveles[1][carta].mitadSuperior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    break;
                case 3:
                    // Rey en subnivel 3 -> puede ver subnivel 1, 2 y 5
                    // Verificar subnivel 1 (arriba)
                    if (cartaRey < 2) {
                        if (niveles[0][cartaRey].mitadSuperior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    // Verificar subnivel 2 (arriba)
                    if (cartaRey < 2) {
                        if (niveles[0][cartaRey].mitadInferior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    // Verificar subnivel 5 (abajo)
                    for (int carta = cartaRey; carta <= cartaRey + 1 && carta < 4; carta++) {
                        if (niveles[2][carta].mitadSuperior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    break;
                case 4:
                    // Rey en subnivel 4 -> puede ver subnivel 1, 2 y 5
                    // Verificar subnivel 1 (arriba)
                    if (cartaRey < 2) {
                        if (niveles[0][cartaRey].mitadSuperior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    // Verificar subnivel 2 (arriba)
                    if (cartaRey < 2) {
                        if (niveles[0][cartaRey].mitadInferior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    // Verificar subnivel 5 (abajo)
                    for (int carta = cartaRey; carta <= cartaRey + 1 && carta < 4; carta++) {
                        if (niveles[2][carta].mitadSuperior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    break;
                case 5:
                    // Rey en subnivel 5 -> puede ver subnivel 3 y 4
                    if (cartaRey < 3) {
                        if (niveles[1][cartaRey].mitadSuperior.equals("Criminal")) {
                            criminalesCount++;
                        }
                        if (niveles[1][cartaRey].mitadInferior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    break;
                case 6:
                    // Rey en subnivel 6 -> puede ver subnivel 3 y 4
                    if (cartaRey < 3) {
                        if (niveles[1][cartaRey].mitadSuperior.equals("Criminal")) {
                            criminalesCount++;
                        }
                        if (niveles[1][cartaRey].mitadInferior.equals("Criminal")) {
                            criminalesCount++;
                        }
                    }
                    break;
            }
            
            return criminalesCount;
        }
        
        public void verificarYVoltearReyes() {
            System.out.println("\n=== VERIFICANDO AUTO-VOLTEO DE REYES ===");
            boolean alguyReyVolteado = false;
            
            for (int nivel = 0; nivel < 3; nivel++) {
                int maxCartas = (nivel == 0) ? 2 : (nivel == 1) ? 3 : 4;
                
                for (int carta = 0; carta < maxCartas; carta++) {
                    boolean cartaDebeVoltearse = false;
                    String razonVolteo = "";
                    
                    // Verificar mitad superior
                    if (niveles[nivel][carta].mitadSuperior.equals("Rey")) {
                        int subnivel = (nivel * 2) + 1; // Convertir a subnivel (1, 3, 5)
                        int criminalesAdyacentes = contarCriminalesAdyacentes(subnivel, carta, true);
                        
                        if (criminalesAdyacentes >= 2) {
                            cartaDebeVoltearse = true;
                            razonVolteo = "Rey en mitad superior con " + criminalesAdyacentes + " criminales adyacentes";
                        }
                    }
                    
                    // Verificar mitad inferior
                    if (niveles[nivel][carta].mitadInferior.equals("Rey")) {
                        int subnivel = (nivel * 2) + 2; // Convertir a subnivel (2, 4, 6)
                        int criminalesAdyacentes = contarCriminalesAdyacentes(subnivel, carta, false);
                        
                        if (criminalesAdyacentes >= 2) {
                            cartaDebeVoltearse = true;
                            razonVolteo = "Rey en mitad inferior con " + criminalesAdyacentes + " criminales adyacentes";
                        }
                    }
                    
                    // Si la carta debe voltearse y no está completamente volteada
                    if (cartaDebeVoltearse && 
                        (!niveles[nivel][carta].estaVolteada(true) || !niveles[nivel][carta].estaVolteada(false))) {
                        
                        // Voltear ambas mitades de la carta
                        if (!niveles[nivel][carta].estaVolteada(true)) {
                            niveles[nivel][carta].voltearMitad(true);
                        }
                        if (!niveles[nivel][carta].estaVolteada(false)) {
                            niveles[nivel][carta].voltearMitad(false);
                        }
                        
                        System.out.println("¡CARTA COMPLETA en Nivel " + (nivel + 1) + ", Carta " + (carta + 1) + 
                                         " se voltea automáticamente! (" + razonVolteo + ")");
                        alguyReyVolteado = true;
                    }
                }
            }
            
            if (!alguyReyVolteado) {
                System.out.println("Ningún rey necesita voltearse automáticamente.");
            }
        }
        
        public void voltearMitadCarta(int subnivel, int carta) {
            if (subnivel < 1 || subnivel > 6) {
                System.out.println("Error: El subnivel debe estar entre 1 y 6.");
                return;
            }
            
            int nivel = subnivelANivel(subnivel);
            int maxCartas = getMaxCartasParaSubnivel(subnivel);
            
            if (carta < 1 || carta > maxCartas) {
                System.out.println("Error: La carta debe estar entre 1 y " + maxCartas + " para el subnivel " + subnivel + ".");
                return;
            }
            
            boolean esMitadSuperior = (subnivel % 2 == 1); // Subniveles impares son mitad superior
            int indiceCartaReal = carta - 1; // Convertir a índice basado en 0
            
            String tipoActual = esMitadSuperior ? 
                niveles[nivel][indiceCartaReal].mitadSuperior : 
                niveles[nivel][indiceCartaReal].mitadInferior;
            
            if (tipoActual.equals(".")) {
                System.out.println("Error: No se puede voltear una mitad de carta vacía.");
                return;
            }
            
            boolean estabaVolteada = niveles[nivel][indiceCartaReal].estaVolteada(esMitadSuperior);
            niveles[nivel][indiceCartaReal].voltearMitad(esMitadSuperior);
            
            String mitadStr = esMitadSuperior ? "superior" : "inferior";
            String accion = estabaVolteada ? "se desvoltea" : "se voltea";
            
            System.out.println("La mitad " + mitadStr + " de la carta " + carta + 
                             " en subnivel " + subnivel + " " + accion + " correctamente.");
            System.out.println("Contenido: " + tipoActual + " -> " + 
                             (estabaVolteada ? "visible" : "oculto (-)"));
        }
        
        // Clase auxiliar para representar posiciones de enamorados
        private static class PosicionEnamorado {
            int subnivel;
            int carta;
            int nivel;
            boolean esMitadSuperior;
            
            PosicionEnamorado(int subnivel, int carta, int nivel, boolean esMitadSuperior) {
                this.subnivel = subnivel;
                this.carta = carta;
                this.nivel = nivel;
                this.esMitadSuperior = esMitadSuperior;
            }
        }
        
        private boolean verificarSacerdotesAdyacentes(int subnivel, int cartaCriminal, int nivel, boolean esMitadSuperior, int maxCartas) {
            // Verificar si hay sacerdote en la misma carta (mitad opuesta)
            String calavеraEnMismaCarta = esMitadSuperior ? 
                niveles[nivel][cartaCriminal].mitadInferior : 
                niveles[nivel][cartaCriminal].mitadSuperior;
            if (calavеraEnMismaCarta.equals("Sacerdote")) {
                return true;
            }
            
            // Verificar carta a la izquierda
            if (cartaCriminal > 0) {
                String calaveraIzquierda = esMitadSuperior ? 
                    niveles[nivel][cartaCriminal - 1].mitadSuperior : 
                    niveles[nivel][cartaCriminal - 1].mitadInferior;
                if (calaveraIzquierda.equals("Sacerdote")) {
                    return true;
                }
            }
            
            // Verificar carta a la derecha
            if (cartaCriminal < maxCartas - 1) {
                String calaveraDerecha = esMitadSuperior ? 
                    niveles[nivel][cartaCriminal + 1].mitadSuperior : 
                    niveles[nivel][cartaCriminal + 1].mitadInferior;
                if (calaveraDerecha.equals("Sacerdote")) {
                    return true;
                }
            }
            
            // Verificar adyacencias verticales (subniveles inferiores)
            if (verificarSacerdotesAdyacentesVerticales(subnivel, cartaCriminal)) {
                return true;
            }
            
            return false;
        }
        
        private boolean verificarSacerdotesAdyacentesVerticales(int subnivel, int cartaCriminal) {
            // Verificar adyacencias específicas según el patrón piramidal
            if (subnivel == 2) {
                // Subnivel 2 carta X es adyacente a subnivel 3 cartas X y X+1
                int nivelInferior = 1; // Nivel 2
                
                // Verificar carta en la misma posición
                if (cartaCriminal < 3) { // Máximo 3 cartas en nivel 2
                    String calavera1 = niveles[nivelInferior][cartaCriminal].mitadSuperior;
                    if (calavera1.equals("Sacerdote")) {
                        return true;
                    }
                }
                
                // Verificar carta en posición + 1
                if (cartaCriminal + 1 < 3) { // Máximo 3 cartas en nivel 2
                    String calavera2 = niveles[nivelInferior][cartaCriminal + 1].mitadSuperior;
                    if (calavera2.equals("Sacerdote")) {
                        return true;
                    }
                }
            } else if (subnivel == 4) {
                // Subnivel 4 carta X es adyacente a subnivel 5 cartas X y X+1
                int nivelInferior = 2; // Nivel 3
                
                // Verificar carta en la misma posición
                if (cartaCriminal < 4) { // Máximo 4 cartas en nivel 3
                    String calavera1 = niveles[nivelInferior][cartaCriminal].mitadSuperior;
                    if (calavera1.equals("Sacerdote")) {
                        return true;
                    }
                }
                
                // Verificar carta en posición + 1
                if (cartaCriminal + 1 < 4) { // Máximo 4 cartas en nivel 3
                    String calavera2 = niveles[nivelInferior][cartaCriminal + 1].mitadSuperior;
                    if (calavera2.equals("Sacerdote")) {
                        return true;
                    }
                }
            }
            
            return false;
        }
        
        public void mostrarPuntuacionReyes() {
            System.out.println("\n=== PUNTUACIÓN COMPLETA ===");
            System.out.println("REYES: Ganan 1 punto por cada campesino o rey en TODOS los subniveles inferiores.");
            System.out.println("CRIMINALES: Ganan 1 punto si tienen al menos un sacerdote adyacente:");
            System.out.println("  - En la misma carta (mitad superior/inferior)");
            System.out.println("  - En cartas adyacentes (izquierda o derecha en el mismo subnivel)");
            System.out.println("  - En subniveles inferiores adyacentes:");
            System.out.println("    * Subnivel 2 → Subnivel 3 (misma posición y siguiente)");
            System.out.println("    * Subnivel 4 → Subnivel 5 (misma posición y siguiente)");
            System.out.println("ENAMORADOS: Ganan 1 punto por cada par de enamorados adyacentes:");
            System.out.println("  - Emparejamiento óptimo (máximo número de pares posibles)");
            System.out.println("  - Adyacencias: misma carta, horizontal, vertical y diagonal");
            System.out.println();
            
            int puntosTotal = calcularPuntos();
            
            System.out.println("\nPUNTUACIÓN TOTAL: " + puntosTotal + " puntos");
            System.out.println();
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
            System.out.println("6. Ver puntuación");
            System.out.println("7. Limpiar pirámide");
            System.out.println("8. Voltear carta manualmente");
            System.out.println("9. Salir");
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
                    System.out.println("\n=== AGREGAR CALAVERA ===");
                    System.out.println("Recuerda: las cartas se numeran de izquierda a derecha");
                    piramide.mostrarTiposCalaveras(); // Mostrar lista de calaveras
                    System.out.print("Subnivel (1-6): ");
                    int subnivel = scanner.nextInt();
                    System.out.print("Número de carta (de izquierda a derecha): ");
                    int carta = scanner.nextInt();
                    System.out.print("Tipo de calavera (1-5): ");
                    int tipo = scanner.nextInt();
                    piramide.agregarCalaveraEnSubnivel(subnivel, carta, tipo);
                    break;
                case 5:
                    piramide.mostrarEstadisticas();
                    break;
                case 6:
                    piramide.mostrarPuntuacionReyes();
                    break;
                case 7:
                    piramide.limpiarPiramide();
                    break;
                case 8:
                    System.out.println("\n=== VOLTEAR CARTA MANUALMENTE ===");
                    System.out.print("Subnivel (1-6): ");
                    int subnivelVoltear = scanner.nextInt();
                    System.out.print("Número de carta: ");
                    int cartaVoltear = scanner.nextInt();
                    piramide.voltearMitadCarta(subnivelVoltear, cartaVoltear);
                    break;
                case 9:
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