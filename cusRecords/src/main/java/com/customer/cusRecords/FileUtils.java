package com.customer.cusRecords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtils {

	private static final Logger LOGGER = Logger.getLogger(FileUtils.class);
	
	private static final String FILE_NAME = "src/main/resources/customers.txt";
	
	private static final double LATITUDE_DUBLIN = 53.339428;
	private static final double LONGITUDE_DUBLIN = -6.257664;
	
	/**
	 * Returns the list of the customers from the file provided
	 * @return list of all the customers in the file
	 */
	public List<CustomerRecords> getAllCustomerRecordsFromFile(String fileName)
	{
		List<CustomerRecords> customerList = new ArrayList<>();
	    ArrayList<JSONObject> json=new ArrayList<JSONObject>();
	    JSONObject obj;
	    String line = null;
	    File file = null;

	    try {
	    	
	    	file = new File(fileName);
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = new FileReader(file);

	        // Wrapping FileReader into BufferedReader
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	       
	        CustomerRecords cusRecord = null;
	        
	        while((line = bufferedReader.readLine()) != null) {
	            obj = (JSONObject) new JSONParser().parse(line);
	            
	            json.add(obj);
	            // Adding the fields in to Java Objects
	            cusRecord = new CustomerRecords();
	            cusRecord.setLatitude(Double.parseDouble((String)obj.get("latitude")));
	            cusRecord.setLongitutde(Double.parseDouble((String)obj.get("longitude")));
	            cusRecord.setCustomer_name((String)obj.get("name"));
	            cusRecord.setUser_id((long)obj.get("user_id"));
	            
	            LOGGER.debug("Customer name : " + cusRecord.getCustomer_name());
	            LOGGER.debug("Customer user ID : " + cusRecord.getUser_id());
	            //Adding the customer record to the list
	            
	            customerList.add(cusRecord);
	            
	        }
	        // Closing the files
	        bufferedReader.close();         
	    }
	    catch(FileNotFoundException ex) {
	       
	    	LOGGER.error("Unable to open file '" + file.getName() + "'");
	    	throw new CustomerRecordsException("Unable to open file '" + file.getName() + "'. Check the file name or location of the file.");
	     }
	    catch(IOException ex) {
	    	LOGGER.error("Error reading file '" + file.getName() + "'");
	    	throw new CustomerRecordsException("Error reading file '" + file.getName() + "'");
	    } catch (ParseException e) {
	    	LOGGER.error("Error reading file '" + file.getName() + "'");
	    	throw new CustomerRecordsException("Error reading file '" + file.getName() + "'");
	    }
	    LOGGER.debug("The complete list of the customers :" +  customerList);
	    return customerList;
	}
	/**
	 * Returns the list of the customers within the range of the provided kilometers
	 * @param kilometers
	 * @return list of customers
	 */
	public List<DisplayCustomerRecord> getCustomerRecordsWithTheSpecifiedDistance(double distance)
	{
		List<CustomerRecords> customerList = getAllCustomerRecordsFromFile(FILE_NAME);
		List<DisplayCustomerRecord> customerListWithinDistance = new ArrayList<>();
		DisplayCustomerRecord displayRecord = null;
		for(CustomerRecords cusR : customerList)
		{
			HelperUtils helper = new HelperUtils();
			if(helper.distanceBetweenTwoPoints(LATITUDE_DUBLIN, LONGITUDE_DUBLIN, cusR.getLatitude(), cusR.getLongitutde()) <= distance)
			{
				displayRecord = new DisplayCustomerRecord();
				displayRecord.setCustomer_name(cusR.getCustomer_name());
				displayRecord.setUser_id(cusR.getUser_id());
				customerListWithinDistance.add(displayRecord);
			}
		}
		
		Collections.sort(customerListWithinDistance, new Comparator<DisplayCustomerRecord>() {
		    @Override
		    public int compare(DisplayCustomerRecord id1, DisplayCustomerRecord id2) {
		        return (int)id1.getUser_id() - (int)id2.getUser_id();
		    }
		});
		LOGGER.debug("The number of the customers within "+ distance+ " Kms range of kilometers" +  customerListWithinDistance.size());
		return customerListWithinDistance;
	}
	
	
	
}
