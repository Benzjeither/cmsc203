

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	Property p1,p2,p3, p4,p5,p6;
	ManagementCompany otherCompany;
	@Before
	public void setUp() throws Exception {
		//student create a management company
	
		//student add three properties, with plots, to mgmt co
		otherCompany= new ManagementCompany("Benz", "3435",9);
		 
	
		
		p1 = new Property ("Montgomery County", "Rockville", 3550.00, "Benz Tamayo",4,1,3,3);
		p2 = new Property ("Kensington Heights", "Silver Spring", 3900.00, "Joshua Uy",7,5,1,1);
		p3 = new Property ("Deep Creek Mountain", "Wheaton", 6700, "Jasper Jules",1,1,2,2);
		otherCompany.addProperty(p1);
		otherCompany.addProperty(p2);
		otherCompany.addProperty(p3);
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		p1 = null;
		p2 = null;
		p3 = null;
		otherCompany = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
	//	fail("STUDENT test not implemented yet");
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
	
		p4 = new Property ("Friendship Heights", "Caloocan", 5000, "Louwella Jica",0,0,1,1);
		p5 = new Property ("Montgomery Village", "Gaithersburg", 7500, "Jem Tamayo",3,3,3,3);
		p6 = new Property ("Full Array", "Wheaton", 1500, "Byron Joery",6,5,2,2);
		
		
		 
		System.out.println(otherCompany.toString());
		assertEquals(otherCompany.addProperty(p4),3,0);
		System.out.println(otherCompany.toString());
		assertEquals(otherCompany.addProperty(p5),4,0);
		System.out.println(otherCompany.toString());
		assertEquals(otherCompany.addProperty(p6),-1,0); //exceeds the size of the array and can not be added, add property should return -1	
		System.out.println(otherCompany.toString());
	}
 
	@Test
	public void testMaxRentProp() {
	//	fail("STUDENT test not implemented yet");
		//student should test if maxRentProp contains the maximum rent of properties
		String maxRentString = otherCompany.maxRentProp().split("\n")[3];
		assertTrue(maxRentString.contains("6700.0"));
		
	}

	@Test
	public void testTotalRent() {
	//	fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		assertEquals(otherCompany.totalRent(),14150.0,0);
	}

 }