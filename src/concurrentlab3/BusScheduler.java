/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentlab3;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author thilina
 */
public class BusScheduler extends Observable implements Runnable{
    
    private int busID = 0; //increment this for each bus initialization

    @Override
    public void run() {
        System.out.println("Bus Scheduler is Running");
        // code to schedule buses
        while(true){
            Bus b = new Bus(++busID);
            setChanged();
            notifyObservers(busID); //notifying passengers and bus stand
            try {
                Thread.sleep(20*60*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PassengerScheduler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
