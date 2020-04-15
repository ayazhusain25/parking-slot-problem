package com.parkingLot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class InputParser {
    public InputParser(ParkingLot parkingLot) {
		super();
		this.parkingLot = parkingLot;
	}
	ParkingLot parkingLot;
    public void parseTextInput(String inputString) {
        // Split the input string to get command and input value
        String[] inputs = inputString.split(" ");
        switch (inputs[0].trim().toLowerCase()) {
            case "create_parking_lot":
                parkingLot.createParkingLot(inputs[1]);
                break;
            case "park":
            	parkingLot.park(inputs[1], inputs[2]);
                break;
           case "status":
        	    parkingLot.status();
                break;
           case "leave": 
        	    parkingLot.leave(inputs[1], inputs[2]);
        	    break;
            default:
                System.out.println("Invalid input.");
        }
    }
    public void parseFileInput(String filePath) {
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    parseTextInput(line.trim());
                }
            } catch (IOException ex) {
                System.out.println("Error in reading the input file.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the path specified.");
            e.printStackTrace();
        }
    }
    
    
}



