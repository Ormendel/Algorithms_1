package SquaresOf1;

public class Source 
{
	/**
	 * By given matrix m x n, combined from zero's and one's, we need to
	 * find the largest sub square matrix combined by only one's
	 * 
	 * Solution:
	 * We use another matrix - let's call her Help.
	 * The first column and row in Help will be initialized to ZERO
	 * Afterwards, we move on all the cells in Help;
	 * If in the original matrix - the respected cell is 1 - the we fill help the minimum 
	 * between 3 cells in the top left corner of the same place + 1.
	 * Help[i,j] = min(Help[i-1,j-1], Help[i-1,j], Help[i,j-1]) + 1.
	 * If we see in the original matrix 0 - we put 0 in Help.
	 * 
	 * If in the bottom right corner in the original matrix there is 1, so our answer will be respectively
	 * in the bottom right corner in Help.
	 * 
	 *  Otherwise, we need to check everytime the maximum value in Help.
	 *  Complexity: O(n^2)
	 *  
	 *
	 * @param args
	 */
	
	private static int min3(int a,int b,int c)
	{
		int min=a;
		if(min>b)
			min=b;
		if(min>c)
			min=c;
		
		return min;
	}
	public static int subMatrixOf1(int[][]mat)
	{
		int m=mat[0].length,n=mat.length,maxDim=0;
		int[][]Help=new int[n][m];
		for(int j=0;j<m;j++)//Copy first row from the original matrix
			Help[0][j]=mat[0][j];
		for(int i=0;i<n;i++)//Copy first column from the original matrix
			Help[i][0]=mat[i][0];
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<m;j++)
			{
				if(mat[i][j]==0)
					Help[i][j]=0;
				else//The value in the cell mat[i][j] equals to 1
				{
					Help[i][j]=min3(Help[i-1][j-1],Help[i-1][j],Help[i][j-1])+1;
					if(Help[i][j]>maxDim)
						maxDim=Help[i][j];
				}
			}
		}
		return maxDim;
	}
	
	
	
	
	
	
	public static void main(String[] args)
	{
		int[][]mat=new int[][] {{0,1,1,0,1,0,0},{1,0,1,1,0,1,1},{0,1,1,1,0,0,1},{1,0,1,1,0,0,0}};
		int ans=subMatrixOf1(mat);
		System.out.println("Largest subMatrixOf1 is: "+ans);
		System.out.println("Area = "+(ans*ans));
	}

}
