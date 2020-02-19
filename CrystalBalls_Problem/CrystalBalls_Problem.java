package CrystalBalls_Problem;

public class CrystalBalls_Problem 
{
	
	/**
	 * 
	 * @param n balls
	 * @param k floors
	 * @return minimum number of checking from which floor the balls will break
	 */
	
	public static int numberOfChecking(int n,int k)
	{//k>=n
		int numChecks=0;
		int[][]checks=new int[k+1][n+1];
		for(int j=0;j<=n;j++)//One ball
		{
			checks[0][j]=0;
			checks[1][j]=j;
		}
		for(int i=2;i<=k;i++)
		{
			checks[i][0]=0;
			checks[i][1]=1;
			if(n>=2)
				checks[i][2]=2;
			for(int j=2;j<=n;j++)//j represents the number of the floor
			{
				int min=n+1;
				for(int p=1;p<=j-1;p++)
					min=Math.min(Math.max(checks[i-1][p-1], checks[i][j-p]), min)+1;
				checks[i][j]=min;
			}
		}
		
		numChecks=checks[k][n];
		return numChecks;
			
	}
	public static void main(String[] args)
	{
		System.out.println(numberOfChecking(4,10));
	}

}
