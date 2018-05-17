/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramon
 */
public class Worker {
    private Random random = new Random();
    
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    
    Object lock1 = new Object();
    Object lock2 = new Object();
    
    public void stageOne(){
        synchronized(lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            list1.add(random.nextInt(100));  
        }
        
    }
    
    public void stageTwo(){
        synchronized(lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            list2.add(random.nextInt(100));
        }
    }
    
    public void process(){
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }
    
    public void main(){
        System.out.println("Starting ....");
        long start = System.currentTimeMillis();
        
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        
        threadOne.start();
        threadTwo.start();
        
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long end = System.currentTimeMillis();
        
        System.out.println("Time take: " + (end - start));
        System.out.println("List1: " + list1.size() + " List2: " + list2.size());
      
    }
    
}
