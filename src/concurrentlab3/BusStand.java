/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentlab3;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thilina
 */
public class BusStand extends Observable implements Observer{
 
    public static boolean busArrived = false; //toggle this when a bus arrives and departs. this is a lock
    
    private Semaphore busSemaphore;
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Bus-" + arg.toString() + " Arrived @ Bus Stand");
        busArrived = true;
        busSemaphore = new Semaphore(5); // initialize a new semaphore at each bus arrival
        setChanged();
        notifyObservers(arg); //notifying passengers
    }
    
    synchronized public boolean boardBus(){
        if(!busArrived) // bus has departed
            return false;
        try {
            busSemaphore.acquire();  // passenger gets in the bus
            if(busSemaphore.availablePermits() == 0){ // bus is fully loaded
               // departure the bus now
               busArrived = false;
            }
            return true;
        } catch (InterruptedException ex) {
            Logger.getLogger(BusStand.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
}
