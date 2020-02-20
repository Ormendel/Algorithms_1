package Secretary_Problem;

import java.util.Arrays;

public class OptimalSolution 
{
	/**
	 * a secretary need to serve n clients,
	 * and she need to reduce the average waiting time
	 * how will she do it?
	 * 
	 * solution:
	 * Ti is the time of client - i
	 * so the average time is = (T1+T2...+Tn)/n
	 * to do so we need to sort from shortest time to longest time.
	 * proof:
	 * waiting time is = T1+...+Ti-1+Ti+Ti+1...+Tn = t1+...+(t1+...+ti-1)+(t1+...+ti-1+ti)+(t1+...ti)+...+(t1...tn)
	 * if we assume that ti > ti+1 (not sorting from short to long)
	 * we get = T1+...+Ti-1+Ti'+Ti+1...+Tn = t1+...+(t1+...+ti-1)+(t1+...+ti-1+*ti+1*)+(t1+...+ti-1+*ti+1*+*ti*)+...+(t1...tn)
	 * subtruct between two sums we get: ti-ti+1 > 0
	 * which means the first sum is bigger therefore its the optimal solution
	 *
	 */
	
	public static double getAverageTime(int[] times) 
	{
		Arrays.parallelSort(times);
		double avg = 0;
		for(int x:times)
			avg = avg+avg+x;
		return avg/times.length;
	}
	public static void main(String[] args)
	{
		int [] arr = {1,10,8};
		System.out.println(getAverageTime(arr));
	}

}
