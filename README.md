# LABORATORIO #2: Control de Versiones Distribuido (CVDS)
## Participantes: Laura Valentina Gutiérrez Rico - Juan José Mejía Celis
## Patterns - Factory

### Prerrequisitos
- **Java**: OpenJDK Runtime Environment 17.x.x
- **Apache Maven**: 3.9.x


### 1.	¿Qué es Maven?
```
    Maven es una herramienta que se usa para crear y gestionar cualquier proyecto en todo su ciclo de vida basado en Java.![image](https://github.com/user-           attachments/assets/a03402ba-bc0d-412d-bd78-2eda44ae4e68)

```
### 2.	Cuál es su mayor utilidad
```
  Maven es una herramienta con muchas utilidades, entre estas están:

  -Proporcionar información de calidad  de los proyectos
  -Fomentar mejores prácticas de desarrollo
```

### Objetivos
- Comprender **¿Qué es Maven?**
  Maven es una herramienta que se usa para crear y gestionar cualquier proyecto en todo su ciclo de vida basado en Java.

- Usar comandos de **arquetipos**, **compilación** y **ejecución** en un proyecto Maven.
- Implementar el **Patrón Factory** para la creación de figuras geométricas.

---

## Instalación y Configuración

### 1. Creación del Proyecto con Maven
Ejecuta en la terminal:
```sh
mvn archetype:generate \
  -DgroupId=edu.eci.cvds \
  -DartifactId=Patterns \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

### 2. Configurar `pom.xml`
Edita `pom.xml` y agrega:
```xml
<properties>
  <maven.compiler.target>1.8</maven.compiler.target>
  <maven.compiler.source>1.8</maven.compiler.source>
</properties>
```

---

## Ejecución del Proyecto

### 1. Compilar el Proyecto
```sh
mvn clean package
```

### 2. Ejecutar la Aplicación
```sh
mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.archetype.App"
```

Para ejecutar con un argumento:
```sh
mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.archetype.App" -Dexec.args="Nombre"
```

---

## Implementación del Patrón Factory

### 1. Estructura de Paquetes
```
edu.eci.cvds.patterns.shapes
edu.eci.cvds.patterns.shapes.concrete
```

### 2. Interfaz `Shape`
```java
package edu.eci.cvds.patterns.shapes;

public interface Shape {
    int getNumberOfEdges();
}
```

### 3. Enumeración `RegularShapeType`
```java
package edu.eci.cvds.patterns.shapes;

public enum RegularShapeType {
    Triangle, Quadrilateral, Pentagon, Hexagon;
}
```

### 4. Implementaciones de Figuras (Ejemplo `Triangle`)
```java
package edu.eci.cvds.patterns.shapes.concrete;

import edu.eci.cvds.patterns.shapes.Shape;

public class Triangle implements Shape {
    public int getNumberOfEdges() {
        return 3;
    }
}
```

### 5. `ShapeFactory.java`
```java
package edu.eci.cvds.patterns.shapes;

import edu.eci.cvds.patterns.shapes.concrete.*;

public class ShapeFactory {
    public static Shape create(RegularShapeType type) {
        switch (type) {
            case Triangle: return new Triangle();
            case Quadrilateral: return new Quadrilateral();
            case Pentagon: return new Pentagon();
            case Hexagon: return new Hexagon();
            default: throw new IllegalArgumentException("Unknown shape type");
        }
    }
}
```

### 6. `ShapeMain.java`
```java
package edu.eci.cvds.patterns.shapes;

public class ShapeMain {
    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            System.err.println("Parameter of type RegularShapeType is required.");
            return;
        }
        try {
            RegularShapeType type = RegularShapeType.valueOf(args[0]);
            Shape shape = ShapeFactory.create(type);
            System.out.println("Successfully created a " + type + " with " + shape.getNumberOfEdges() + " sides.");
        } catch (IllegalArgumentException ex) {
            System.err.println("Invalid shape type: " + args[0]);
        }
    }
}
```

---

## Ejecución del Factory

Ejecutar `ShapeMain` con un tipo de figura:
```sh
mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.shapes.ShapeMain" -Dexec.args="Triangle"
```
Salida esperada:
```
Successfully created a Triangle with 3 sides.
```

---

## Conclusión
- Se utilizó **Maven** para gestionar dependencias y automatizar la compilación.
- Se implementó el **Patrón Factory** para la creación de figuras.
- Se verificó el uso de argumentos en la ejecución de la aplicación.

**Fuente**: [GitHub Pull Requests](https://docs.github.com/en/pull-requests)  


"❤️😊"
