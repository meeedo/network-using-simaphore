package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Semaphore
{

    protected int value = 0 ;

    protected Semaphore() { value = 0 ; }

    protected Semaphore(int initial) { value = initial ; }

    public synchronized void P(Device temp) //throws IOException
     {

        value-- ;
        if (value < 0)
        {
            System.out.println("(" + temp.getdevicename()+") "+" waiting");

            try {
                Router.writeinFile("(" + temp.getdevicename()+") "+" waiting");
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\Users\RS3\Desktop\\ostest.txt"));
            writer.write("(" + temp.getdevicename()+"waiting");
            writer.close();

             */

            try { wait() ; } catch(  InterruptedException e ) { }
        }


            System.out.println("(" + temp.getdevicename() + ") "+ " connected");


         try {
             Router.writeinFile("(" + temp.getdevicename() + ") "+ " connected");
         } catch (IOException e) {
             e.printStackTrace();
         }

             /*
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\Users\RS3\Desktop\\ostest.txt"));
            writer.write("(" + temp.getdevicename() + ")(" +temp.getdevicetype() +")"+ "connected");
            writer.close();

            */
     }

    public synchronized void V()
    {
        value++ ; if (value <= 0) notify() ;

    }


}
