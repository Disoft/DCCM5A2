/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionrestaurante;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 *
 * @author Admin
 */
class Restaurante {
    private final int numChefs;
    private final ExecutorService cocina;
    private final Lock lock = new ReentrantLock();

    public Restaurante(int numChefs) {
        this.numChefs = numChefs;
        this.cocina = Executors.newFixedThreadPool(numChefs);
    }

    public void recibirPedido(String pedido, CountDownLatch latch) {
        cocina.execute(() -> {
            prepararPedido(pedido);
            latch.countDown(); // Reducir el contador cuando termine la tarea
        });
    }

    private void prepararPedido(String pedido) {
        lock.lock();
        try {
           // long startTime = System.currentTimeMillis(); 
            System.out.println("Preparando: " + pedido + " - " + Thread.currentThread().getName());
            Thread.sleep(2000); // Simula tiempo de preparación
            System.out.println("Pedido listo: " + pedido + " - " + Thread.currentThread().getName());
            // long endTime = System.currentTimeMillis(); // Finalizar el timer
            //System.out.println("Tiempo total de ejecución: " +pedido+":::"+ (endTime - startTime) + " ms");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void cerrarRestaurante() {
        cocina.shutdown();
    }
}

public class SimulacionRestaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante(3); // 3 chefs disponibles
        int numPedidos = 10;
        CountDownLatch latch = new CountDownLatch(numPedidos); // Sincronización
        
        long startTime = System.currentTimeMillis(); // Iniciar el timer
        
        for (int i = 1; i <= numPedidos; i++) {
            String pedido = "Pedido " + i;
            restaurante.recibirPedido(pedido, latch);
        }
        
        try {
            latch.await(); // Esperar a que todos los pedidos terminen
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        restaurante.cerrarRestaurante();
        
        long endTime = System.currentTimeMillis(); // Finalizar el timer
        System.out.println("Tiempo total de ejecución de todos los pedidos: " + (endTime - startTime) + " ms");
    }
    
}
