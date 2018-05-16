/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Use of synchronized keyword, only can be used on methods or code blocks
 * allow that only one thread can enter on the method or code block on the same time
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
            threadOne.join();//main thread wait until threadOne finishes
            threadTwo.join();//main thread wait until threadTwo finishes
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo_5.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        System.out.println("The counter value is " + counter);
    }
    // only one thread can enter at the same time
    //on this method, ensure the consistency
    private synchronized void increment() {
        counter++;
    }
    
}
