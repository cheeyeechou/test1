/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sem2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author CheeYee
 */
public class patient {
    
    Date date = new Date();
    String name, ic;
    int serious;
    long time;
    
    public patient(){
        
    }
    
    public patient(String name, String ic, int serious){
        this.name = name;
        this.ic = ic;
        this.serious = serious;
        time = date.getTime();
    }
    
    public patient(String name, String ic, int serious, Date t){
        this.name = name;
        this.ic = ic;
        this.serious = serious;
        this.time = t.getTime();
    }
    
    public void setSerious(int serious){
        this.serious = serious;
    }
    
    public int getSerious(){
        return serious;
    }
    
    public long getTime(){
        return time;
    }
    
    public boolean compareTo(patient other){
        return time<other.getTime();
    }
    
    public String toString(){
        
        return name + "  " + ic + "  " + serious + "  " + time;
    }
    
}
