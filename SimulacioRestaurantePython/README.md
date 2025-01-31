# Simulación de Restaurante Multiproceso

Este repositorio contiene una simulación de un restaurante en el que se gestionan múltiples pedidos utilizando procesamiento paralelo en Python con el módulo `multiprocessing`. El código simula el trabajo de varios chefs (procesos) que preparan pedidos de forma concurrente, utilizando un `Lock` para evitar condiciones de carrera al acceder a recursos compartidos.

## Descripción

El programa simula un restaurante con varios chefs que reciben y preparan pedidos en paralelo. Para ello, se usa el módulo `multiprocessing` para crear un proceso por cada pedido. La sincronización entre los procesos se maneja con un `Lock`, que asegura que solo un chef pueda preparar un pedido a la vez.

### Funcionamiento

1. Se define un número de chefs disponibles (procesos).
2. Se crea un proceso para cada pedido que llega.
3. Cada chef (proceso) prepara un pedido, y el acceso a la preparación del pedido está sincronizado mediante un `Lock` para evitar que dos chefs trabajen en el mismo pedido simultáneamente.
4. El tiempo total de ejecución de todos los pedidos es calculado y mostrado al final.

## Requisitos

- **Python 3.x**
- No se requieren dependencias externas.

## Ejecución

### 1. Clonar el repositorio

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/tuusuario/simulacion-restaurante-multiproceso.git
```
### 2. Ejecutar el código
Navega al directorio del proyecto y ejecuta el archivo principal:

```bash
python restaurante.py
```
### 3. Salida esperada
El programa imprimirá el estado de cada pedido, indicando qué chef (proceso) está preparando el pedido y cuándo se ha completado. Además, se mostrará el tiempo total de ejecución de todos los pedidos.

Ejemplo de salida:
```yaml
Preparando: Pedido 1 - Process-1
Pedido listo: Pedido 1 - Process-1
Preparando: Pedido 2 - Process-2
Pedido listo: Pedido 2 - Process-2
...
Tiempo total de ejecución de todos los pedidos: 20000 ms
```

## Explicación breve de la arquitectura concurrente
La arquitectura concurrente del programa utiliza multiprocessing para simular el trabajo paralelo de varios chefs (procesos) que preparan pedidos de manera independiente, pero controlada.

### Componentes principales:
Multiprocessing (Procesos Concurrentes):

El módulo multiprocessing permite ejecutar múltiples procesos de manera concurrente. En este caso, cada pedido se procesa en un proceso independiente, lo que permite a varios chefs preparar pedidos simultáneamente.
Cada vez que llega un nuevo pedido, se crea un proceso separado que ejecuta la función preparar_pedido.
Lock:

Se utiliza un Lock para garantizar que solo un proceso (chef) pueda preparar un pedido a la vez. Aunque los procesos son independientes, el Lock sincroniza el acceso a la parte del código que prepara el pedido, evitando que dos chefs preparen el mismo pedido simultáneamente.
Join:

El método join asegura que el programa espere a que todos los procesos terminen antes de calcular el tiempo total de ejecución. Este mecanismo permite coordinar la finalización de los procesos antes de que se muestre el resultado final.
