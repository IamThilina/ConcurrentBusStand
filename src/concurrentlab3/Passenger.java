/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentlab3;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;

/**
 *
 * @author thilina
 */
public class Passenger implements Observer, Runnable{
    
    private int ID;

    public Passenger(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Passenger-" + this.ID + " Notifies The Arrival of Bus-" + arg.toString());
    }

    @Override
    public void run() {
        System.out.println("Passenger-" + this.ID + " Arrived @ Bus Stand");
//        while(isAlive()){
//            
//        }
        
    }
    
    
}
