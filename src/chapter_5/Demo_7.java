/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class Processor implements Runnable{

    private int id;
    
    public Processor(int id){
        this.id = id;
    }
    @Override
    public void run() {
        
        System.out.println("Starting: " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Completed: " + id);
    }
    
}
/**
 *Executor service 
 * @author ramon
 */
public class Demo_7 {
    
    public static void main(String[] args) {
        //2 is the capacity of threads for excecute at the same time 
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Processor(i));//send all the tasks
        }
        
        executorService.shutdown();// try stop of acept more tasks
        
        System.out.println("All tasks submitted.");
        
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);//has a day for finish this works
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_7.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("All tasks completed.");
        
    }
    
}
