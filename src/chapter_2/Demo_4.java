/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_2;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Use de keyword volatile
 * 
 * When more than one thread access to a variable o object, each thread has 
 * a cache memory where keep  their variable value version, and is posible 
 * what the value has inconsistencies on the value when a thread read/write on the value.
 * 
 * volatile keyword keep a same variable version for all threads,
 * when storages the varible on main memory and not on cache memory
 * @author ramon
 */

class Processor extends Thread{
    
    private volatile boolean running = true;

    @Override
    public void run() {
        
        while (running) {            
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void shutdown(){
        running = false;
    }
    
}
public class Demo_4 {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();
        
        System.out.println("Press enter to stop ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();//when Enter key is pressed  
        processor.shutdown();//the infinite loop is stoped
    }
    
}
