 ## Pruebas extras
 -Añade una prueba para generar una excepción  `IndexOutOfBoundsException`, por ejemplo intentando acceder a una posición inexistente de una lista, y capturarla mostrando el mensaje de error. Ésta es una excepción habitual en Java cuando se manipulan colecciones sin hacer las comprobaciones adecuadas.

-Cambia la clase `EmptySaleException` para que extienda de una excepción en tiempo de ejecución, como `RuntimeException`.

-¿Sabes lo que esto significa? 
-¿Qué diferencia existe entre una excepción verificada (checked) y una no verificada (unchecked) como RuntimeException?
- R: 
--Excepciones verificadas (checked)
- 1. El compilador obliga a manejarlas
- Debes capturarlas con `try-catch` o declararlas con `throws`, si no, el código no compila.

- 2. Herencia
- Hereden de Exception pero no de RuntimeException.

- 3. Qué representan
- Situaciones previsibles y recuperables, generalmente externas al programa.

--Excepciones no verificadas (unchecked)
- 1. El compilador NO obliga a manejarlas
- Puedes capturarlas si quieres, pero no es obligatorio.

- 2. Herencia
- Hereden de RuntimeException.

- 3. Qué representan
- Errores de programación, bugs o estados inválidos del código.