/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_1;

/**
 *
 * @author ramon
 */
public class Demo_3 {
    
    public static void main(String[] args) {
       
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Number " + i);
                }
            }
        }); 
        thread.start();
        
    }
   
}
