package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Router
{

    public int available;
    Form2 form2 = new Form2();
    Semaphore freespaces;

    //ArrayList<Integer> array = new ArrayList<Integer>();


      public static File file = new File("C:\\Users\\RS3\\Desktop\\ostest.txt");

    public static void writeinFile(String content ) throws IOException {
       // FileOutputStream fos = new FileOutputStream(file);

        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        FileWriter fr = new FileWriter(file,true);
            fr.write(content);
            fr.write("\n");
            fr.close();

    }




    Router (int maxnumber)
    {
        this.available=maxnumber;
        freespaces = new Semaphore(available);
    }

    public void connect(Device temp) // throws IOException
    {
        System.out.println("(" + temp.getdevicename() + ") (" +temp.getdevicetype() +") "+ " arrived");

        try {
            writeinFile("(" + temp.getdevicename() + ") (" +temp.getdevicetype() +") "+ " arrived");

        } catch (IOException e) {
            e.printStackTrace();
        }
        form2.setLabelStatus("(" + temp.getdevicename() + ") (" +temp.getdevicetype() +") "+ " arrived");
        /*
           // BufferedWriter writer = new BufferedWriter(new FileWriter("C:\Users\RS3\Desktop\\ostest.txt"));
            writer.write(temp.getdevicename() + " arrived");
            writer.close();


         */
        freespaces.P(temp);

    }
    public void activity(Device temp)// throws IOException
    {
        Random rand = new Random();
        int time = rand.nextInt(10000);
        System.out.println("(" + temp.getdevicename() + ") " + " Perform Online Activity");

        try {
            writeinFile("(" + temp.getdevicename() + ") " + " Perform Online Activity");
        } catch (IOException e) {
            e.printStackTrace();
        }
        form2.setLabelStatus("(" + temp.getdevicename() + ") " + " Perform Online Activity");
        /*
           // BufferedWriter writer = new BufferedWriter(new FileWriter("C:\Users\RS3\Desktop\\ostest.txt"));
            writer.write(temp.getdevicename() + " Perform Online Activity");
            writer.close();


 */

        try {
            Thread.sleep((long) time);
        } catch (InterruptedException m) {
            m.printStackTrace();
        }

    }
    public void disconnect(Device temp) //throws IOException
    {
        System.out.println("(" + temp.getdevicename() + ") " + " Disconnected");

        try {
            writeinFile("(" + temp.getdevicename() + ") " + " Disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
        form2.setLabelStatus("(" + temp.getdevicename() + ") " + " Disconnected");

        /*
           // BufferedWriter writer = new BufferedWriter(new FileWriter("C:\Users\RS3\Desktop\\ostest.txt"));
            writer.write(temp.getdevicename() + " Disconnected");
            writer.close();


 */
        freespaces.V();
    }
}

