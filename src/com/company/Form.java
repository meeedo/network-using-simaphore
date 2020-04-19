package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Form {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
     JPanel panel1;
    private String numOfConn = "0", numOfDevices="0", namesAndTypes="--";
    private JButton button1;
    JFrame f = new JFrame("Router Network");

    public Form() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfConn = textField1.getText();
                numOfDevices = textField2.getText();
                namesAndTypes = textField3.getText();

                f.dispose();
                JFrame second = new JFrame();
                f.setContentPane(new Form2().panel2);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setSize(1000, 800);
                f.setVisible(true);


                //JOptionPane.showMessageDialog(null, numOfConn+" "+numOfDevices +" "+namesAndTypes);
                Network network = new Network(Integer.parseInt(numOfConn),Integer.parseInt(numOfDevices), namesAndTypes);
                network.start();
            }

        });
    }

    public int getNumOfConn() {
        return Integer.parseInt(numOfConn);
    }

    public int getNumOfDevices() {
        return Integer.parseInt(numOfDevices);
    }

    public String getNamesAndTypes() { return namesAndTypes; }



//    public static void main(String[] args) {
//        JFrame frame1 = new JFrame();
//        frame1.setContentPane(new Form().panel1);
//        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        frame1.pack();
//        frame1.setVisible(true);
//        frame1.setSize(1000, 800);
//
//
//
//
//    }






    public static void main(String[] args)
    {
        //Scanner numbers = new Scanner(System.in);
        JFrame frame1 = new JFrame("Router Network");

        frame1.setContentPane(new Form().panel1);
        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);
        frame1.setSize(1000, 800);

        int maxnumber = 0;
        int totalnumber = 0;
      /*
        System.out.println("What is number of WI-FI Connections?  ");
        maxnumber = numbers.nextInt();
        System.out.println("What is number of devices Clients want to connect? ");
        totalnumber = numbers.nextInt();

       */
        String namesAndTypes = "";
        Form form1 = new Form();
        maxnumber = form1.getNumOfConn();
        totalnumber = form1.getNumOfDevices();
        namesAndTypes = form1.getNamesAndTypes();
       // System.out.println(namesAndTypes);
      // JOptionPane.showInputDialog(form1.getNamesAndTypes());




    }










}
