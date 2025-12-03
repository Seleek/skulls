# Java Console Project

Un proyecto simple de Java que imprime mensajes en la consola.

## Estructura del Proyecto
```
skulls/
├── src/
│   └── main/
│       └── java/
│           └── Main.java        # Clase principal de la aplicación
├── .vscode/
│   └── tasks.json              # Configuración de tareas de VS Code
├── .github/
│   └── copilot-instructions.md # Instrucciones del workspace
└── README.md                   # Este archivo
```

## Requisitos
- Java Development Kit (JDK) 8 o superior
- VS Code con Extension Pack for Java instalado

## Cómo Ejecutar

### Opción 1: Usando VS Code Tasks
1. Presiona `Ctrl+Shift+P` para abrir la paleta de comandos
2. Busca y ejecuta "Tasks: Run Task"
3. Selecciona "Run Java" (esto compilará y ejecutará automáticamente)

### Opción 2: Línea de Comandos
1. **Compilar:** `javac -cp src/main/java -d src/main/java -source 8 -target 8 src/main/java/Main.java`
2. **Ejecutar:** `java -cp src/main/java Main`

### Opción 3: Solo Ejecutar (si ya está compilado)
```bash
java -cp src/main/java Main
```

## Salida Esperada
```
¡Hola Mundo! Este es mi proyecto Java en consola.
Java Console Project - Successfully running!
```

## Notas Técnicas
- El proyecto está configurado para ser compatible con Java 8 (`-source 8 -target 8`)
- Se usa un classpath personalizado para mantener la estructura de directorios estándar de Maven/Gradle
- Las tareas de VS Code están configuradas en `.vscode/tasks.json` para fácil compilación y ejecución

## Próximos Pasos
- Agregar más funcionalidad a la clase Main
- Implementar entrada de usuario con Scanner
- Crear clases adicionales según sea necesario
- Considerar migrar a un proyecto Maven o Gradle para mejor gestión de dependencias