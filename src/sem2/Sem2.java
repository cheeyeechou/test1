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
public class Sem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListInterface<patient> patientList = new LList<patient>();
        Date date = new Date();
        patient p = new patient("asd", "asda", 2);
        patient p1 = new patient("zxmcz", "123", 2);
        patient p2 = new patient("asd2", "asda", 1);
        patient p3 = new patient("asd3", "asda", 3);
        patient p4 = new patient("asd4", "asda", 2);
        patient p5 = new patient("asd5", "asda", 1);
        patient p6 = new patient("asd6", "asda", 3);
        patient p7 = new patient("asd7", "asda", 2);
        patient p8 = new patient("asd8", "asda", 1);
        patient p9 = new patient("asd9", "asda", 3);
        
        Date t = new Date();
        patient p10 = new patient("acascx","asdsac", 2,t);
        
        t = new Date();
        patient p11 = new patient("acascx","asdsac", 2, t);
        
        if(patientList.add(p7)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        
        if(patientList.add(p)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        if(patientList.add(p3)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        if(patientList.add(p2)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        if(patientList.add(p9)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        if(patientList.add(p4)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        if(patientList.add(p3)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        if(patientList.add(p8)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        if(patientList.add(p6)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        if(patientList.add(p5)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        if(patientList.add(p1)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        
        System.out.println(patientList.toString());
        System.out.println(patientList.getLength());
        
        patientList.sort(p1, 3);
        
        System.out.println(patientList.toString());
        System.out.println(patientList.getLength());
        
        System.out.println(p2.compareTo(p11));
        
        
        t = new Date();
        patient p12 = new patient("acascx","asdsac", 2, t);
        
        System.out.println(p12.compareTo(p10));
        for(int q=0; q<1000; q++){
            if(q==999){
                System.out.println(t);
            }
        }
        
    }
    
}
