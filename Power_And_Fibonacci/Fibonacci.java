package Power_And_Fibonacci;

import java.util.Arrays;

public class Fibonacci
{
	
	//This method can only be used for matrixes from size n x n
	public static int[][] multiplyMatrixes(int[][] firstMatrix, int[][] secondMatrix)
	{
		//The size of product doesn't matter, hence firstMatrix equals by size to secondMatrix
		int[][] product = new int[firstMatrix.length][firstMatrix[0].length];
		for (int i = 0; i < product.length; i++) 
		{
			int[]row=firstMatrix[i];
			int sum=0;
			int index_row=0;
			//Building one size array that represents a column in secondMatrix
			for(int j=0;j<product[0].length;j++)
			{
				for(int val:row)
				{
					sum+=val*secondMatrix[index_row++][j];
				}
				product[i][j]=sum;
				index_row=0;//Reset
				sum=0;//Reset
			}
		}
		return product;
	}
	
	public static int MatrixFibi(int n) 
	{
		int ans[][] = { { 1, 1 }, { 1, 0 } };
		int A[][] = { { 1, 1 }, { 1, 0 } };
		n -= 2;
		while (n != 0) {
			if(n%2 == 1)
				ans = multiplyMatrixes(ans, A);
			A = multiplyMatrixes(A,A);
			n = n/2;
		}
		return ans[0][0];
	}
	public static void main(String[] args)
	{
		int[][]m1= new int[][]{{1,4,3},{8,3,1},{3,3,17}};
		int[][]m2= new int[][]{{2,1,3},{5,1,5},{2,2,9}};
		int[][]m3=multiplyMatrixes(m1,m2);
		for(int i=0;i<m3.length;i++)
			System.out.println(Arrays.toString(m3[i]));
		
		System.out.println();
		System.out.println(MatrixFibi(6));
		
		
	}

}
