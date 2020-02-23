package Donuts;

public class DonutsProblem 
{
	private static final int time = 2;//Cooking time for one donut
	
	/**
	 * returns the total time for the donuts
	 * Complexity: O(1)
	 */
	public static int getTime(int numOfDonuts,int capacity) 
	{
		if(capacity >= numOfDonuts) 
			return time;
		if((time*numOfDonuts)%capacity == 0) 
			return (time*numOfDonuts)/capacity;
		return (time*numOfDonuts)/capacity + 1;
	}
	public static void main(String[] args) 
	{
		int numOfDonuts=3,capacity=8;
		System.out.println("For "+numOfDonuts+ " donuts takes: "+getTime(numOfDonuts,capacity)+ " minutes");
	}

}
