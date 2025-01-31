import multiprocessing
import time

class Restaurante:
    def __init__(self, num_chefs):
        self.num_chefs = num_chefs
        self.lock = multiprocessing.Lock()

    def recibir_pedido(self, pedido, procesos):
        # Crear un proceso para cada pedido
        proceso = multiprocessing.Process(target=self.preparar_pedido, args=(pedido,))
        procesos.append(proceso)
        proceso.start()

    def preparar_pedido(self, pedido):
        with self.lock:
            print(f"Preparando: {pedido} - {multiprocessing.current_process().name}")
            time.sleep(2)  # Simula el tiempo de preparación
            print(f"Pedido listo: {pedido} - {multiprocessing.current_process().name}")

def main():
    restaurante = Restaurante(3)  # 3 chefs disponibles
    num_pedidos = 10
    procesos = []

    start_time = time.time()  # Iniciar el timer

    for i in range(1, num_pedidos + 1):
        pedido = f"Pedido {i}"
        restaurante.recibir_pedido(pedido, procesos)

    # Asegurarse de que todos los procesos terminen antes de calcular el tiempo total
    for proceso in procesos:
        proceso.join()

    end_time = time.time()  # Finalizar el timer
    print(f"Tiempo total de ejecución de todos los pedidos: {int((end_time - start_time) * 1000)} ms")

if __name__ == "__main__":
    main()