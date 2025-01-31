# Simulación de Restaurante Multihilo

Este repositorio contiene una simulación simple de un restaurante en el que se gestionan múltiples pedidos usando hilos en Java. Utiliza el framework de ejecución de hilos `ExecutorService`, un `CountDownLatch` para sincronizar los pedidos, y un `Lock` para controlar el acceso a la sección crítica.

## Descripción

El programa simula un restaurante con varios chefs que reciben pedidos y los preparan en paralelo. Los pedidos se procesan de forma concurrente, pero solo un chef puede preparar un pedido a la vez, lo cual se maneja con un `Lock` para evitar problemas de concurrencia.

## Arquitectura Concurrente

La arquitectura concurrente del programa está diseñada para manejar múltiples pedidos de forma simultánea utilizando hilos. Aquí se describen los componentes clave de la concurrencia:

1. **ExecutorService (cocina)**:
   - Se utiliza un `ExecutorService` con un `ThreadPool` de tamaño fijo (tres chefs en este caso) para manejar los hilos que procesan los pedidos.
   - Cada pedido es asignado a un hilo del pool de ejecutores, lo que permite la ejecución de múltiples pedidos de forma concurrente.

2. **CountDownLatch**:
   - Un `CountDownLatch` es utilizado para sincronizar la finalización de todos los pedidos. El valor del latch es el número total de pedidos que se deben preparar.
   - El hilo principal espera que todos los pedidos hayan terminado usando `latch.await()`, y se asegura de que todos los pedidos se completen antes de cerrar el restaurante.

3. **Lock (ReentrantLock)**:
   - Para evitar condiciones de carrera al acceder a recursos compartidos (en este caso, la preparación de los pedidos), se usa un `ReentrantLock`.
   - Aunque los hilos están ejecutando los pedidos en paralelo, el `Lock` garantiza que solo un chef (hilo) pueda preparar un pedido a la vez.

4. **Tiempo de Ejecución**:
   - Se mide el tiempo total que tarda en procesarse todos los pedidos, lo que se utiliza para evaluar la eficiencia de la simulación.

## Estructura del Proyecto

- **Restaurante.java**: Contiene la lógica para manejar los chefs, los pedidos y la sincronización.
- **SimulacionRestaurante.java**: Clase principal que ejecuta la simulación del restaurante.

## Requisitos

- **JDK 8 o superior**.

## Compilación y Ejecución

### 1. Clonar el repositorio

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/tuusuario/simulacion-restaurante.git
```

### 2. Compilar el código
Navega al directorio del proyecto y compílalo usando el siguiente comando (suponiendo que tienes el JDK instalado):

```bash
javac simulacionrestaurante/*.java
```

### 3. Ejecutar el programa
Una vez compilado, ejecuta el programa utilizando el siguiente comando:

```bash
java simulacionrestaurante.SimulacionRestaurante
```

### 4. Salida esperada
El programa imprimirá información sobre los pedidos que se están preparando, el tiempo que tarda en completarse, y finalmente el tiempo total de ejecución de todos los pedidos.

Ejemplo de salida:
```bash
Preparando: Pedido 1 - pool-1-thread-1
Pedido listo: Pedido 1 - pool-1-thread-1
Preparando: Pedido 2 - pool-1-thread-2
Pedido listo: Pedido 2 - pool-1-thread-2
...
Tiempo total de ejecución de todos los pedidos: 20000 ms
```
