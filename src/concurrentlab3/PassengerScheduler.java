/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentlab3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thilina
 */
public class PassengerScheduler implements Runnable{
    
    private int passengerID = 0; //increment this for each passenger
    private BusScheduler bScheduler;
    
    public PassengerScheduler(BusScheduler bScheduler) {
        this.bScheduler = bScheduler;
    }

    @Override
    public void run() {
        System.out.println("Passenger Scheduler is Running");
        // code to schedule passengers
        while(true){
            Passenger p = new Passenger(++passengerID);
            bScheduler.addObserver(p);
            Thread pThread = new Thread(p);
            pThread.start();
            try {
                Thread.sleep(30*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PassengerScheduler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
}
