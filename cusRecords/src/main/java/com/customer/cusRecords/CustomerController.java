package com.customer.cusRecords;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.apache.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CustomerController {

	   private static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	   
	   /**
	    * This is the endpoint to retrieve all the customers within the provided distance from Dublin 
	    * @param distance
	    * @return
	    */
	   @GetMapping(value = "/customersWithinGivenDistance", produces =APPLICATION_JSON_VALUE)
	    public List<DisplayCustomerRecord> getCustomerRecordsByDistance(@RequestParam(value="distance", defaultValue= "100") double distance){
	    	
	    	if(distance < 0)
	    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Distance should be >= 0");
	    	
	    	List<DisplayCustomerRecord> list = null;
	    	
	    	try {
	    	      list = new FileUtils().getCustomerRecordsWithTheSpecifiedDistance(distance);
	    	}
	    	  catch(CustomerRecordsException ce)
	    	{
	    		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ce.getMessage());
	    	}
	    	LOGGER.debug("List found for customers within " + distance + " kilometers of range" );
	    	return list;
	   
	    }
	   
	}
