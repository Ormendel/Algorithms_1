package Power_And_Fibonacci;

import java.util.Arrays;

public class Fibonacci
{

	/**This function calculates multiply of one matrix in another
	 * 
	 * @param firstMatrix - can be n x n or m x k
	 * @param secondMatrix can be n x n or k x q
	 * @return thirdMatrix from n x n or m x q
	 */
	public static int[][] multiplyMatrixes(int[][] firstMatrix, int[][] secondMatrix)
	{
		if(firstMatrix[0].length!=secondMatrix.length)
			return null;
		int[][]product = new int[firstMatrix.length][secondMatrix[0].length];
		for (int i = 0; i < product.length; i++) 
		{
			int[]row=firstMatrix[i];
			int sum=0;
			int index_row=0;
			for(int j=0;j<secondMatrix[0].length;j++)
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
		while (n != 0)
		{
			if(n%2 == 1)
				ans = multiplyMatrixes(ans, A);
			A = multiplyMatrixes(A,A);
			n = n/2;
		}
		return ans[0][0];//Our answer is located here
	}
	public static void main(String[] args)
	{
		int[][]m1= new int[][]{{8,5,8,4}};
		int[][]m2= new int[][]{{8},{8},{8},{8}};
		int[][]m3=multiplyMatrixes(m1,m2);
		for(int i=0;i<m3.length;i++)
			System.out.println(Arrays.toString(m3[i]));

		System.out.println();
		System.out.println(MatrixFibi(6));


	}

}
