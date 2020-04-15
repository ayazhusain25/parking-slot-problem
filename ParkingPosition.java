package com.parkingLot;

import java.io.FileNotFoundException;

public class ParkingPosition {
	  public static void main( String args[]) throws FileNotFoundException {
		  InputParser obj= new InputParser(new ParkingLot());
		  obj.parseFileInput("C:\\Users\\91980\\command.txt");
	  }
}
