/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramon
 */
public class Demo_5 {
    
    private int counter = 0;
    
    public static void main(String[] args) {
        Demo_5 app = new Demo_5();
        app.doWork();
    }
    
    public void doWork(){
        
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        
        threadOne.start();
        threadTwo.start();
        
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_5.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        System.out.println("The counter value is " + counter);
    }
    
    private synchronized void increment() {
        counter++;
    }
    
}
