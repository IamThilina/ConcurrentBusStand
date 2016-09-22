/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentlab3;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;

/**
 *
 * @author thilina
 */
public class BusStand implements Observer{
 
    public static boolean busArrived = false; //toggle this when a bus arrives and departs. this is a lock
    
    private Semaphore busSemaphore;
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Bus-" + arg.toString() + " Arrived @ Bus Stand");
        busArrived = true;
        busSemaphore = new Semaphore(50); // initialize a new semaphore at each bus arrival
    }
}
