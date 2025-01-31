# Simulación de Restaurante Multihilo

Este repositorio contiene una simulación simple de un restaurante en el que se gestionan múltiples pedidos usando hilos en Java. Utiliza el framework de ejecución de hilos `ExecutorService`, un `CountDownLatch` para sincronizar los pedidos, y un `Lock` para controlar el acceso a la sección crítica.

## Descripción

El programa simula un restaurante con varios chefs que reciben pedidos y los preparan en paralelo. Los pedidos se procesan de forma concurrente, pero solo un chef puede preparar un pedido a la vez, lo cual se maneja con un `Lock` para evitar problemas de concurrencia.

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
