# S1.02-Exceptions
**Descripción**: Aprenderémos a trabajar con el sistema de gestión de errores de Java mediante el uso de excepciones . El objetivo principal es dotar a las aplicaciones de robustez , evitando que se rompan ante errores habituales como entradas incorrectas o acceso a datos inexistentes. 

## 📌 Nivel 1 • Ejercicio 1 - Excepciones personalizadas y control de errores
-Empieza definiendo una clase `Product` con dos atributos: `name` y `price`. Esta clase representará un producto individual en la venta.

-Crea una clase `Sale`, que debe contener una colección `ArrayList<Product> products` y una variable para almacenar el total `totalPrice`. Esta clase incluirá un método `calculateTotal()` que:

- Compruebe si la colección está vacía.
- Si está vacía, tire una excepción personalizada llamada `EmptySaleException`, con el mensaje: "Para hacer una venta primero debes añadir productos" .
- Si hay productos, sume los precios y guarde el total en el atributo `totalPrice`.

-La clase `EmptySaleExceptiondebe` ser hija de `Exception`, y debe incluir este mensaje en su constructor.

## 📌 Nivel 2 • Ejercicio 1 - Lectura segura desde el teclado

-Crea una clase utilitaria llamada `ConsoleReader` que permita leer distintos tipos de datos desde el teclado de forma segura

-Con tratamiento de InputMismatchException:
- `public static byte readByte(String message)`
- `public static int readInt(String message)`
- `public static float readFloat(String message)`
- `public static double readDouble(String message)`

-Con una excepción personalizada:
- `public static char readChar(String message)`
- `public static String readString(String message)`
- `public static boolean readYesNo(String message)`

- Si la entrada es incorrecta, se mostrará un mensaje de error y se volverá a pedir el dato hasta que sea válido.

## 🛠 Tecnologías  
- Java 21
- IntelliJ IDEA
- GitHub

## 🚀 Clonar repositorio
`git clone https://github.com/AlePesole/S1.02-Exceptions.git` 