/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.InputStream;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author adarsh
 */
public class performanceTest {
    
    static ArrayList<ParkingSpot> parkSpot = new ArrayList<ParkingSpot>();
    static String reg5 = "Abc002";
    InputStream sysInBackup = System.in;
    
    public performanceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        parkSpot.clear();
        String spotId = "01";
        String spotId1 = "02";
        String spotId3 = "03";
        String spotId4 = "04";
        
        String spotType = "N";
        boolean availabe = false;
        String reg = "";
        String reg1 = "Abc002";
        String reg3 = "Abc003";
        String reg4 = "Abc004";

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
        parkSpot.add(new ParkingSpot(spotId1, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId1)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg1);
            }
        }
        parkSpot.add(new ParkingSpot(spotId1, spotType));
        for (int i = 0; i < parkSpot.size(); i++) {
            if (parkSpot.get(i).getspotIdentifier().equals(spotId1)) {
                parkSpot.get(i).available = false;
                parkSpot.get(i).setReg(reg1);
            }
        }
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test(timeout = 15)
    public void performanceTest() {
        System.out.println("***********************NEW TEST CASE PERFORMANCE*******************************\n");
        long start = System.currentTimeMillis();
        Application.listofspot(parkSpot);
        long end = System.currentTimeMillis();
        System.out.println("Time taken By System To DIsplay The List " + (end-start) + " Milli Second");
    }
    @Test
    public void volumeTest() {
       // parkSpot.clear();
        System.out.println("***********************NEW TEST CASE VOLUME*******************************\n");
        long start = System.currentTimeMillis();
        Application.listofspot(parkSpot);
        long end = System.currentTimeMillis();
        System.out.println("Time taken By System To Show List " + (end-start) + " Milli Second");
    }
    
}
