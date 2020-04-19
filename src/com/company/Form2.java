package com.company;

import com.company.Form;

import javax.swing.*;

public class Form2 {
    JPanel panel2;
    private JLabel labelStatus;
   private Form form1 = new Form();
   //int numOfDevices = form1.getNumOfDevices();
    public Form2()
    {
      //  for(int i =0; i< numOfDevices;i++)
        {
            setLabelStatus("Router Status"); //get it from router status class
        }
    }


    public String getLabelStatus() {
        return labelStatus.getText();
    }

    public void setLabelStatus(String  status) {
        this.labelStatus.setText(status);
    }
}
