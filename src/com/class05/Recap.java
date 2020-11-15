package com.class05;

import org.testng.annotations.*;

public class Recap {

	@Test
	public void arrayRecap() {
		Object[][] data = new Object[2][3];
		data[0][0] = 12;
		data[0][1] = 13;

		data[1][0] = 100;
		System.out.println(data[1][1]);// we get null bec. it is already reserved 2 rows 3 cols and rows 1 and cols 1is
										// empty so compiler will create null value inside [1][1] icin so it gives us
										// null
	}

}
