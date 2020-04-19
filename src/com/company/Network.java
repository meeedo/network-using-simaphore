package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Network
{
    public  ArrayList<Device> devices = new ArrayList<>();

    private Router router;
    public int totalnumber;
    Scanner name = new Scanner(System.in);
    Scanner type = new Scanner(System.in);
    Network(int maxnumber,int totalnumber, String namesAndTypes)
    {
        boolean flag = true;
        router = new Router(maxnumber);
        this.totalnumber = totalnumber;
       // this.devices = new Device[totalnumber];
        String name="", type="";
        String[] namesAndTypesArr = namesAndTypes.split(" "); //then it would be name,type
        for(int i =0; i<namesAndTypesArr.length; i++)
        {
            System.out.println(namesAndTypesArr[i]+"\n");
            //System.out.println("network loop 1 "+"\n");
            for(int j =0; j<namesAndTypesArr[i].length(); j++) {
               // System.out.println("network loop 2 "+"\n");
                if (namesAndTypesArr[i].charAt(j) == ',') {
                    j++;
                    System.out.println("flag , ");
                    flag = true;
                }
                else if (namesAndTypesArr[i].charAt(j) !=',' )
                {
                    if (namesAndTypesArr[i].charAt(j) != ','&& flag)   //before comma
                    {
                        Character c = namesAndTypesArr[i].charAt(j);
                        name = name.concat(c.toString());
                        System.out.println("name = " + name);
                         flag = false;
                    }
                    if (namesAndTypesArr[i].charAt(j) != ',' && !flag)   //after comma
                    {
                        Character c = namesAndTypesArr[i].charAt(j);
                        type = type.concat(c.toString());
                        System.out.println("type = " + type);
                        flag = false;
                    }
                }
            }
            Device device = new Device(name, type, router);
            devices.add(device);
            name = ""; type = "";
        }

    }

    public void start()
    {
        for (int j = 0 ; j < totalnumber; j++)
        {
            devices.get(j).start();
        }
    }
/*
    public static void main(String[] args)
    {
        Scanner numbers = new Scanner(System.in);
        JFrame frame1 = new JFrame("Router Network");

        frame1.setContentPane(new Form().panel1);
        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);
        frame1.setSize(1000, 800);

        int maxnumber = 0;
        int totalnumber = 0;

        System.out.println("What is number of WI-FI Connections?  ");
        maxnumber = numbers.nextInt();
        System.out.println("What is number of devices Clients want to connect? ");
        totalnumber = numbers.nextInt();



        Form form1 = new Form();
        maxnumber = form1.getNumOfConn();
        totalnumber = form1.getNumOfDevices();
        String namesAndTypes = form1.getNamesAndTypes();
        JOptionPane.showInputDialog(form1.getNamesAndTypes());
        Network network = new Network(maxnumber,totalnumber, namesAndTypes);
        network.start();


    }
        */
}
