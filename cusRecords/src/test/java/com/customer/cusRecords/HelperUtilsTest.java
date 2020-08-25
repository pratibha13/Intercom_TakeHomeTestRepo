package com.customer.cusRecords;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class HelperUtilsTest {

	@Test
	public void testDistanceFromDublin()
	{
		HelperUtils utils = new HelperUtils();
		double distance = utils.distanceBetweenTwoPoints(53.339428, -6.257664, 52.986375, -6.043701);
		Assertions.assertEquals(41.768791061593895, distance);
	}
}
