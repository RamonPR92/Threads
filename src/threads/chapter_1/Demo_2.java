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

class RunnerRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Number " + i );
        }
    }
   
}
public class Demo_2 {
    public static void main(String[] args) {
        RunnerRunnable runnerRunnableOne = new RunnerRunnable();
        Thread threadOne = new Thread(runnerRunnableOne);
        Thread threadTwo = new Thread(runnerRunnableOne);
        threadTwo.start();
        threadOne.start();
    }
}
