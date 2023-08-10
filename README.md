# RetroScreen

Implementar un programa interactivo para dibujar en la pantalla figuras con caracteres ASCII.

Al iniciar el programa se pasarán las dimensiones de una supuesta pantalla. El caracter ‘-’
representa un “pixel” vacio. Por ejemplo al iniciar el programa con una pantalla de 10x5 
se imprime lo siguiente

```
./retroscreen 10 5
----------
----------
----------
----------
----------

>
```

Después de dibujar la pantalla, se muestra un prompt para ingresar comandos. Mediante comandos 
uno podría dibujar un rectángulo utilizando el comando new.
Cada comando imprime nuevamente la pantalla.

## Comando [new]

El primer parámetro es el símbolo que se usará para dibujar (en el primer ejemplo ‘x’),
luego las coordenadas y tamaño del rectángulo (más detalles sobre esto al final de este enunciado)


### Ejemplo:

```
> new x 3 1 4 2

----------
---xxxx---
---xxxx---
----------
----------
```
```
>new o 1 0 3 2

-ooo------
-oooxxx---
---xxxx---
----------
----------
```

Como se puede ver cada figura se dibuja en orden “ocultando” a las que tienen abajo.

Se pide implementar los siguientes comandos (no es necesario implementar todos los comandos 
para esta evaluación)

```
new <simbolo> <x> <y> <ancho> <alto>
```

Crea una nueva figura rectangular arriba de todas las demás. No se puede dibujar con un símbolo
que ya esté en uso.

## Comando [delete]

```
delete <simbolo>
```

Quita de la pantalla la figura asociada a ese símbolo. Al quitar la figura es posible que se 
descubran partes de otras figuras que estaban siendo ocultadas

### Ejemplo

```
-ooo------
-oooxxx---
---xxxx---
----------
----------
```
```
> delete o

----------
---xxxx---
---xxxx---
----------
----------
```

## Comando [move]

```
move <simbolo> <delta_x> <delta_y>
```
Mueve una figura horizontal y/o verticalmente. Parte de la figura puede quedar fuera de la 
zona visible de la pantalla, pero no es posible que la figura quede completamente fuera de 
la pantalla.

## Comando [combine]

```
combine
```
Combina todas las figuras existentes en una única figura irregular. Esta figura se dibujara y 
quedará asociada con el símbolo de la figura que está arriba (la última en haber sido dibujada).
Debe ser posible mover esta figura irregular como cualquier otra

### Ejemplo

```
-ooo------
-oooxxx---
---xxxx---
----------
----------
```
```
> combine

-ooo------
-oooooo---
---oooo---
----------
----------
```
## Comando [delete_rect]

```
delete_rect <x> <y> <ancho> <alto>
```

Borra los “píxeles ASCII” de la pantalla. Todas las figuras en el área de borrado
son modificadas.

### Ejemplo

```
-ooo------
-oooxxx---
---xxxx---
----------
----------
```
```
> delete_rect 3 0 3 3

-oo-------
-oo---x---
------x---
----------
----------
```

Implementar todas los comandos que el tiempo permita. No es necesario que el ejercicio 
esté completo.
