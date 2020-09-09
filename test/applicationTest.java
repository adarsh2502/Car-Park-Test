/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author adarsh
 */
public class applicationTest {

    static ArrayList<ParkingSpot> parkSpot = new ArrayList<ParkingSpot>();
    InputStream sysInBackup = System.in;

    public applicationTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        String simulatedUserInput = "02" + System.getProperty("line.separator")
                + "Abc001" + System.getProperty("line.separator")
                + "-" + System.getProperty("line.separator")
                + "Abc002" + System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        parkSpot.clear();

    }

    @After
    public void tearDown() {

        System.setIn(System.in);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testDeleteSpot() {

        System.out.println("***********************NEW TEST CASE DELETE SPOT*******************************");

        String spotId = "01";
        String spotId1 = "02";
        String spotType = "N";
        boolean availabe = false;
        String reg = "";
        String reg1 = "Abc002";

        parkSpot.add(new ParkingSpot(spotId, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId)) {
                parkSpot.get(i).available = true;
                parkSpot.get(i).setReg(reg);
            }
        }
        parkSpot.add(new ParkingSpot(spotId1, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId1)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg1);
            }
        }

        for (int i = 0; i < parkSpot.size(); i++) {
            System.out.println((i + 1) + " " + parkSpot.get(i).getspotIdentifier());
            System.out.println(" " + parkSpot.get(i).gettypeofSpot());
            System.out.println(" " + parkSpot.get(i).getavailable());
            if (parkSpot.get(i).getReg() == null) {
                System.out.println("Free spot");

            } else {
                System.out.println("Registration: " + parkSpot.get(i).getReg());
            }
            System.out.println();
        }
        boolean result = Application.deletespot(parkSpot);
        
        System.out.println("\nList of all Spots\n");
        
        for (int i = 0; i < parkSpot.size(); i++) {
            System.out.println((i + 1) + " " + parkSpot.get(i).getspotIdentifier());
            System.out.println(" " + parkSpot.get(i).gettypeofSpot());
            System.out.println(" " + parkSpot.get(i).getavailable());
            if (parkSpot.get(i).getReg() == null) {
                System.out.println("Free spot");
            } else {
                System.out.println("Registration: " + parkSpot.get(i).getReg());
            }
            System.out.println();
        }
        assertEquals(true, result);
    }

    @Test
    public void testDeleteSpot1() {

        System.out.println("***********************NEW TEST CASE DELETE SPOT *******************************");

        String spotId = "01";
        String spotId1 = "02";
        String spotType = "N";
        boolean availabe = false;
        String reg = "Abc001";
        String reg1 = "Abc002";

        parkSpot.add(new ParkingSpot(spotId, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg);
            }
        }
        parkSpot.add(new ParkingSpot(spotId1, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId1)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg1);
            }
        }

        for (int i = 0; i < parkSpot.size(); i++) {
            System.out.println((i + 1) + " " + parkSpot.get(i).getspotIdentifier());
            System.out.println(" " + parkSpot.get(i).gettypeofSpot());
            System.out.println(" " + parkSpot.get(i).getavailable());
            if (parkSpot.get(i).getReg() == null) {
                System.out.println("Free spot");

            } else {
                System.out.println("Registration: " + parkSpot.get(i).getReg());
            }
            System.out.println();
        }
        boolean result = Application.deletespot(parkSpot);
        
        System.out.println("\nList of all Spots\n");

        for (int i = 0; i < parkSpot.size(); i++) {
            System.out.println((i + 1) + " " + parkSpot.get(i).getspotIdentifier());
            System.out.println(" " + parkSpot.get(i).gettypeofSpot());
            System.out.println(" " + parkSpot.get(i).getavailable());
            if (parkSpot.get(i).getReg() == null) {
                System.out.println("Free spot");
            } else {
                System.out.println("Registration: " + parkSpot.get(i).getReg());
            }
            System.out.println();
        }
        assertEquals(false, result);
    }
    @Test
    public void deletespot2() {
        
        System.out.println("***********************NEW TEST CASE DELETE SPOT *******************************");
        
        
        boolean result = Application.deletespot(parkSpot);
        
        if(result == false){
            System.out.println("Non-existing Parking Spot ");
        }
        assertEquals(false, result);
    }

    @Test
    public void testIntegration() {
        
        System.out.println("***********************NEW TEST CASE INTEGRATION*******************************");

        String spotId = "01";
        String spotId1 = "02";
        String spotType = "Y";
        boolean availabe = false;
        String reg = "Abc001";
        String reg1 = "Abc002";
        
        parkSpot.add(new ParkingSpot(spotId, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg);
            }
        }
        parkSpot.add(new ParkingSpot(spotId1, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId1)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg1);
            }
        }
        for (int i = 0; i < parkSpot.size(); i++) {
            System.out.println((i + 1) + " " + parkSpot.get(i).getspotIdentifier());
            System.out.println(" " + parkSpot.get(i).gettypeofSpot());
            System.out.println(" " + parkSpot.get(i).getavailable());
            if (parkSpot.get(i).getReg() == null) {
                System.out.println("Free spot");

            } else {
                System.out.println("Registration: " + parkSpot.get(i).getReg());
            }
            System.out.println();
        }
        boolean result = Application.removecar(parkSpot, reg);
        
        assertEquals(true, result);    
        if (result) {
            boolean result2 = Application.listofspot(parkSpot);
            assertEquals(true, result2);
            System.setIn(sysInBackup);
        }
    }
        @Test
    public void testIntegration1() {
        
        System.out.println("***********************NEW TEST CASE INTEGRATION*******************************");

        String spotId = "01";
        String spotId1 = "02";
        String spotType = "Y";
        boolean availabe = false;
        String reg = "Abc001";
        String reg1 = "Abc002";
        String reg2 ="Abc003";
        parkSpot.add(new ParkingSpot(spotId, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg);
            }
        }
        parkSpot.add(new ParkingSpot(spotId1, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId1)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg1);
            }
        }
        for (int i = 0; i < parkSpot.size(); i++) {
            System.out.println((i + 1) + " " + parkSpot.get(i).getspotIdentifier());
            System.out.println(" " + parkSpot.get(i).gettypeofSpot());
            System.out.println(" " + parkSpot.get(i).getavailable());
            if (parkSpot.get(i).getReg() == null) {
                System.out.println("Free spot");

            } else {
                System.out.println("Registration: " + parkSpot.get(i).getReg());
            }
            System.out.println();
        }
        boolean result = Application.removecar(parkSpot, reg2);
        
        assertEquals(false, result);    
        if (result == false) {
            boolean result2 = Application.listofspot(parkSpot);
            assertEquals(true, result2);
            System.setIn(sysInBackup);
        }
    }
}
