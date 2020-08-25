package com.customer.cusRecords;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

import java.util.List;



@SpringBootTest
public class FileUtilsTests { 	

	private String  fileName = "./src/test/resources/customers.txt";
	
	@Test
	public void testGetAllCustomerRecordsFromFile() {
		
		FileUtils customerUtils = new FileUtils();
		List<CustomerRecords> customerList = customerUtils.getAllCustomerRecordsFromFile(fileName);
		Assertions.assertEquals(32, customerList.size());
	}
	@Test
	public void testGetCustomerRecordsWithTheSpecifiedDistance()
	{
		double distance = 100;//16
		FileUtils customerUtils = new FileUtils();
		List<DisplayCustomerRecord> list = customerUtils.getCustomerRecordsWithTheSpecifiedDistance(distance);
		Assertions.assertEquals(16, list.size());
	}
	
	@Test
	public void testFileNotCorrectException()
	{
		String file = "./src/test/resources/customer.txt";
		FileUtils customerUtils = new FileUtils();
		CustomerRecordsException ce = Assertions.assertThrows(CustomerRecordsException.class, () -> {
			customerUtils.getAllCustomerRecordsFromFile(file);
        });
		
		Assertions.assertEquals("Unable to open file 'customer.txt'. Check the file name or location of the file.", ce.getMessage());
		
	}
	
	@Test
	public void testFileParseException()
	{
		String file = "./src/test/resources/customers_withParseError.txt";
		FileUtils customerUtils = new FileUtils();
		CustomerRecordsException ce = Assertions.assertThrows(CustomerRecordsException.class, () -> {
			customerUtils.getAllCustomerRecordsFromFile(file);
        });
		
		Assertions.assertEquals("Error reading file 'customers_withParseError.txt'", ce.getMessage());

	}
	
}
