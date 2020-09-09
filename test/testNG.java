/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author adarsh
 */
public class testNG {

    static ArrayList<ParkingSpot> parkSpot = new ArrayList<ParkingSpot>();
    InputStream sysInBackup = System.in;

    public testNG() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {

        String simulatedUserInput = "02" + System.getProperty("line.separator")
                + "Abc001" + System.getProperty("line.separator")
                + "-" + System.getProperty("line.separator")
                + "Abc002" + System.getProperty("line.separator");
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        parkSpot.clear();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void deleteSpot() {
        System.out.println("***********************NEW TEST CASE DELETE SPOT*******************************");

        String spotId = "01";
        String spotId1 = "02";
        String spotId2 = "03";
        String spotId3 = "04";

        String spotType = "N";
        boolean availabe = false;
        String reg = "";
        String reg1 = "Abc002";
        String reg2 = "Abc003";
        String reg3 = "Abc004";

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
        parkSpot.add(new ParkingSpot(spotId2, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId2)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg2);
            }
        }
        parkSpot.add(new ParkingSpot(spotId3, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId3)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg3);
            }
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
}
