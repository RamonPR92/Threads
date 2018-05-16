/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.chapter_1;

/**
 *
 * @author ramon
 */

class Runner extends Thread{
    
    public Runner(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Number " + i + " of process " + this.getName());
        }
    }
    
}
public class Demo_1 {
    
    public static void main(String[] args) {
        Runner runnerOne = new Runner("RunnerOne");
        Runner runnerTwo = new Runner("RunnerTwo");
        runnerTwo.start();
        runnerOne.start();
    }
    
}
