/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

class Processor implements Runnable{

    private CountDownLatch latch;
    
    public Processor(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println("Started");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        latch.countDown();
    }
    
}
/**
 *
 * @author ramon
 */
public class Demo_8 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(latch));
        }
        
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_8.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Completed.");
        
    }
    
}
