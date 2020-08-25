package com.customer.cusRecords;

public class HelperUtils {

	
	private static final double RADIUS_EARTH_KM = 6371.01;
	
	/**
	 * This method finds the distance between two points with given co-ordinates
	 * @param lat2 : Latitude of the customer
	 * @param lon2 : Longitude of the customer
	 * @return Distance between two co-ordinates
	 */
	
		public double distanceBetweenTwoPoints(double lat1, double lon1, double lat2, double lon2)
		{
		    lat1 = Math.toRadians(lat1);
	        lon1 = Math.toRadians(lon1);
	        lat2 = Math.toRadians(lat2);
	        lon2 = Math.toRadians(lon2);

	        return RADIUS_EARTH_KM * Math.acos(Math.sin(lat1)*Math.sin(lat2) + Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon1 - lon2));
			
		}
}
