package com.test.parkingLot;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.parkingLot.ParkingLot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
public class ParkingLotTest {
    ParkingLot parkingLot = new ParkingLot();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    @Test
    public void createParkingLot() throws Exception {
        parkingLot.createParkingLot("6");
        assertEquals(6, parkingLot.SLOT_SIZE);
        assertEquals(6, parkingLot.availableSlotList.size());
        assertTrue("createdparkinglotwith6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
    }

    @Test
    public void park() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-9999", "White");
        assertEquals(4, parkingLot.availableSlotList.size());
    }

    @Test
    public void leave() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.park("KA-01-HH-1234", "White");
        parkingLot.park("KA-01-HH-9999", "White");
        parkingLot.leave("KA-01-HH-9999","4");
        assertEquals(5, parkingLot.availableSlotList.size());
    }
}
