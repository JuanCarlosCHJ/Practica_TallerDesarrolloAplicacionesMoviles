Crear un proyecto con el nombre EXU1_JuanCarlosChuquipoma (reemplazar por su nombre), con las
configuraciones revisadas en clases. El texto en el app bar debe ser “Examen U1 Juan
Carlos Chuquipoma”.

Desarrollar una primera pantalla que cuente con una caja de texto y dos botones. En la caja
de texto debe colocar el usuario su nombre para luego enviarlo por argumentos a las
siguientes pantallas para mostrarlo. El primer botón con texto “Jugar adivina número”. El
segundo botón con texto “Jugar golpeado”. Ambos botones con el mismo ancho de la
pantalla, el primer botón arriba del segundo botón. Debajo del segundo botón colocar el
texto “Desarrollado por: Juan Carlos”.

La pantalla de “Jugar adivina juego”: Al cargar la pantalla, se muestra el nombre del usuario
e internamente se generará un número aleatorio entre 1 y 100, luego el jugador deberá
adivinar el número en 10 intentos, esos intentos se ingresarán escribiéndose en una caja de
texto y pulsando un botón con texto “Enviar intento”. Después de cada intento, debería
decirle al jugador si ha acertado o no, en un TextView con fondo verde si acertó o fondo rojo
si está equivocado, en caso falle, debería decirle en un Toast prolongado si el número es
muy bajo o muy alto. También debería decir los números que ya se probaron
anteriormente. El juego terminará una vez que el jugador acierte o cuando se acaben los
intentos. Cuando el juego termina, se le debe dar al jugador la opción de volver a jugar en un
botón con texto “Reiniciar”. 

La pantalla de “Jugar golpeado”: Al cargar la pantalla mostrará el nombre del usuario y
un número aleatorio entre 1 y 4, este número determinará la cantidad de jugadores. Debajo
de ese número otro botón con texto “Generar cartas”. Si es 1, generará 8 cartas aleatorias
de la baraja tradicional (Del 1 al 13, de 4 tipos: Corazones, Espadas, Flores o Diamantes.
En total 52 cartas disponibes). Si es 2, 3 o 4, solo al primero le asignará 8 cartas aleatorias
de la baraja tradicional, a los demás solo 7. Todas las cartas asignadas son irrepetibles. Las
asignaciones las puede mostrar en el componente de su preferencia. TextView, Button o
EditText. 5 puntos.

Ambas pantallas deben tener un botón que permita regresar a la pantalla de bienvenida.
