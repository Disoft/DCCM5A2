# Integrantes del grupo 4
- **Jorge B. Mostajo Pedraza**
- **Evans Balcázar Veizaga**
- **Shirley E. Pérez Delgadillo**
- **Rubén Espinoza Orosco**

# Proyecto de Simulación de Restaurante

## Descripción

Este proyecto simula el funcionamiento de un restaurante utilizando programación concurrente y paralela en Python. El objetivo principal es mostrar cómo varios chefs (procesos) pueden trabajar de manera simultánea para preparar pedidos, utilizando el módulo `multiprocessing` de Python.

En este sistema, los chefs (procesos) preparan los pedidos de forma independiente pero sincronizada, garantizando que no haya interferencias entre los procesos al acceder a recursos compartidos (como la preparación de un pedido). La sincronización se logra mediante el uso de un `Lock`.

## Funcionalidades

- **Simulación de pedidos**: El sistema simula la llegada de múltiples pedidos que los chefs deben preparar de manera concurrente.
- **Sincronización de chefs**: Se usa un `Lock` para garantizar que un solo chef (proceso) pueda preparar un pedido a la vez, evitando conflictos.
- **Procesamiento paralelo**: Cada pedido es procesado en un proceso independiente, lo que permite la ejecución de múltiples pedidos de manera simultánea.
- **Cálculo del tiempo de ejecución**: Se mide el tiempo total que toma la ejecución de todos los pedidos, lo que permite observar el impacto de la paralelización.

## Tecnologías utilizadas

- **Java**: Usa hilos y un `Lock` para gestionar la concurrencia entre chefs (threads) que preparan los pedidos.
- **Python 3.x**: Lenguaje utilizado para desarrollar la simulación.
- **Módulo `multiprocessing`**: Permite la ejecución de múltiples procesos simultáneamente.
- **`Lock`**: Utilizado para sincronizar los procesos y evitar conflictos al acceder a recursos compartidos.

## Arquitectura Concurrente

La arquitectura de la simulación se basa en procesos independientes que trabajan de manera concurrente, cada uno encargado de preparar un pedido. A continuación, se describen los componentes clave:

1. **Multiprocessing**:
   - Se crea un proceso por cada pedido, lo que permite a los chefs trabajar de manera paralela y procesar varios pedidos simultáneamente.
   
2. **Sincronización con `Lock`**:
   - Un `Lock` asegura que solo un proceso pueda preparar un pedido a la vez, evitando condiciones de carrera al acceder a la sección crítica (preparación de pedidos).
   
3. **Join**:
   - Los procesos son ejecutados en paralelo y, al final, se usa el método `join` para esperar a que todos los procesos terminen antes de calcular el tiempo total de ejecución.
