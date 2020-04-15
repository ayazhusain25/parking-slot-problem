package com.parkingLot;

import java.util.*;

public class ParkingLot {
   public int SLOT_SIZE = 0;
   
    // Available slots list
    public ArrayList<Integer> availableSlotList=new ArrayList<Integer>();
    // Map of Slot, Car
    Map<String, Car> map1=new HashMap<String, Car>();
    // Map of RegNo, Slot
    Map<String, String> map2=new HashMap<String, String>();

    public void createParkingLot(String slotCount) {
    	 try {
             this.SLOT_SIZE = Integer.parseInt(slotCount);
         } catch (Exception e) {
             System.out.println("Invalid lot count");
             System.out.println();
         }
        for (int i=1; i<= this.SLOT_SIZE; i++) {
            availableSlotList.add(i);
        }
        System.out.println("Created parking lot with " + slotCount + " slots");
        System.out.println();
    }
    
    public void park(String regNo, String color) {
        if (this.SLOT_SIZE == 0) {
            System.out.println("Sorry parking lot is not created");
            System.out.println();
        } else if (this.map1.size() == this.SLOT_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } else {
            Collections.sort(availableSlotList);
            String slot = availableSlotList.get(0).toString();
            Car car = new Car(regNo, color);
            this.map1.put(slot, car);
            this.map2.put(regNo, slot);
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            availableSlotList.remove(0);
        }
    }
    public void leave(String regNo, String time) {
    	 int parkedTime=0;
    	 try {
            parkedTime = Integer.parseInt(time);
         } catch (Exception e) {
             System.out.println("Invalid time");
             System.out.println();
         }
    	if(parkedTime <2) {
    		parkedTime=2;
    	}
        if (this.SLOT_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() > 0) {
        	String slotNo=map2.get(regNo);
            Car carToLeave = this.map1.get(slotNo);
            if (carToLeave != null) {
                this.map1.remove(slotNo);
                this.map2.remove(carToLeave.regNo);
                // Add the Lot No. back to available slot list.
                this.availableSlotList.add(Integer.parseInt(slotNo));
                int totalcharge=10+(parkedTime-2)*10;
                System.out.println(regNo +" is free with Slot number " + slotNo + "  with total charge  " +totalcharge);
                System.out.println();
            } else {
                System.out.println( regNo+" Registration no doesn't exists in parking slot");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    public void status() {
        if (this.SLOT_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.map1.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.\tColor");
            Car car;
            for (int i = 1; i <= this.SLOT_SIZE; i++) {
                String key = Integer.toString(i);
                if (this.map1.containsKey(key)) {
                    car = this.map1.get(key);
                    System.out.println(i + "\t" + "        "+car.regNo + "\t" +"        "+ car.color);
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
}
