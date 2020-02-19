package Numbers_Game;

import java.util.Arrays;

/**
 * In this game are two players;
 * In each turn a player must take a number from
 * an left edge or right edge of a given array.
 * The player with the most score wins.
 * 
 * The optimal solution:
 * Building a matrix that will present every situation in the game. 
 * To build that matrix we need to take all the elements from the array and put them in the main diagonal.
 * After that we start from the bottom right so that 
 * mat[i][j] = max(game[i]-mat[i+1][j],game[j]-mat[i][j-1]) 
 * After that we look at the upper right corner and check how did we get there.
 * (same as before - max(game[i]-mat[i+1][j],game[j]-mat[i][j-1])
 * And add that score to the player.
 * 
 * @author Ormendel
 *
 */
public class TheNumbersGame 
{

	// build help matrix to calculate all possible choices
	public static int[][] buildMatrix(int game[]) 
	{
		int n = game.length;
		int[][] mat = new int[n][n];//Initialize values in ZERO's
		for (int i = 0; i < n; i++) 
		{
			mat[i][i] = game[i];// main diagonal from the array
		}
		
		for (int i = n - 2; i >= 0; i--) 
		{
			for (int j = i + 1; j <= n-1; j++) 
			{
				mat[i][j] = Math.max(game[i] - mat[i + 1][j], game[j] - mat[i][j - 1]);
			}
		}
		
		for(int i=0;i<n;i++)
			System.out.println(Arrays.toString(mat[i]));
		return mat;
	}

	public static void DynamicProgramming(int game[]) 
	{
		System.out.println("The given array is: "+Arrays.toString(game)+"\n");
		
		int[][] mat = buildMatrix(game);
		
		int i = 0;
		int n = game.length;
		int j = n - 1;
		int first = 0;
		int second = 0;
		int firstSum = 0;
		int secondSum = 0;

		for (int k = 0; k < (n / 2); k++) {
			if (game[i] - mat[i + 1][j] > game[j] - mat[i][j - 1]) 
			{// first choose
				firstSum += game[i];
				first = i++;
			} else 
			{
				firstSum += game[j];
				first = j--;
			}
			if (i != j) // second choose
			{
				if (game[i] - mat[i + 1][j] > game[j] - mat[i][j - 1]) 
				{
					secondSum += game[i];
					second = i++;
				} else 
				{
					secondSum += game[j];
					second = j--;
				}
			} 
			else 
			{ // second takes the last number - j=0 or i=n-1
				second = j;
				secondSum += game[j];
			}
			System.out.println("A chose: " + (game[first]) + " B chose: " + (game[second]));
		}
		System.out.println("A's score is: " + firstSum + " B's score is: " + secondSum);
		
		System.out.println();
		if(firstSum<secondSum)
		{
			System.out.println("B is the winner!");
			return;
		}
		if(firstSum>secondSum)
		{
			System.out.println("A is the winner!");
			return;
		}
		System.out.println("It's a tie :|");
	}

	public static void main(String[] args) 
	{
		int[] arr = { 1,1,1,1};
		DynamicProgramming(arr);
	}
}
