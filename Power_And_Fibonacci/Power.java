package Power_And_Fibonacci;

public class Power 
{
	public static int powerLoop(int x, int n)
	{
		/**
		 * This method calculates x^n by loop, we add x to result only when the binary digit equals to 1!
		 */
		int result=1;
		while(n!=0)//n is positive
		{
			if(n%2==1)
			{
				result*=x;
			}
			x*=x;
			n/=2;
		}
		return result;
	}
	public static int powerRecursion(int x, int n)
	{
		/**
		 * This method calculates x^n by loop, we add x to result only when the binary digit equals to 1!
		 */
		if(n==0)
			return 1;
		if(n%2==0)//Even number
			return powerRecursion(x*x,n/2);
		return x*powerRecursion(x*x,(n-1)/2);//Odd number
	}
	public static void main(String[]args)
	{
		int x=7,n=3;
		System.out.println(powerLoop(x,n));
		System.out.println(powerRecursion(x,n));
	}
}
