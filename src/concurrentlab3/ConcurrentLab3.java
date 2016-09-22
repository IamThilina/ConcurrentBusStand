/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentlab3;

/**
 *
 * @author thilina
 */
public class ConcurrentLab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BusScheduler bScheduler = new BusScheduler();
        PassengerScheduler pScheduler = new PassengerScheduler(bScheduler);
        BusStand bStand = new BusStand();
        Thread pSchedulerThread = new Thread(pScheduler);
        pSchedulerThread.start();
        bScheduler.addObserver(bStand);
        Thread bSchedulerThread = new Thread(bScheduler);
        bSchedulerThread.start();
        
    }
    
}
