package LCS;

public class LCS
{
	public static String Greedy(String X,String Y)
	{
		String ans="";
		int start=0,i_m=0,i_n=0;
		int m=X.length(),n=Y.length();
		while(i_m<m&&i_n<n)
		{
			i_n=Y.indexOf(X.charAt(i_m),start);
			if(i_n!=-1)
			{
				ans=ans.concat(""+X.charAt(i_m));
				start=i_n+1;
			}
			++i_m;
		}
		return ans;
	}
	public static String ImprovedGreedy(String X,String Y)
	{
		/**
		 * We choose the shortest string, assuming its X
		 * We build associative memory - array that contains
		 * number of appearances for each character in X
		 * Idea: We don't want to search the characters in Y 
		 * that are not in X
		 */
		
		int[]help=new int[26];
		int m=X.length(),n=Y.length();
		int place;
		for(int i=0;i<m;i++)//O(min(m,n))
		{
			place=X.charAt(i)-'a';
			help[place]++;
		}
		
		String ans="";
		int start=0,index=0,i=0;
		while(i<n&&index<m)
		{
			place = Y.charAt(i) - 'a';
			if(help[place]>0)
			{
				index=X.indexOf(Y.charAt(i),start);
				if(index!=-1)
				{
					ans=ans.concat(""+Y.charAt(i));
					start=index+1;
					help[place]--;
				}
				else
					help[place]=0;
			}
			++i;
		}
		return ans;
	}
	
	
	/**
	 * Side function for fullSearch
	 * @param arr
	 */
	public static void plus1(int[]arr)
	{
		int i=arr.length-1;
		while(i>=0&&arr[i]==1)
			arr[i--]=0;
		if(i>=0)
			arr[i]=1;
	}
	
	/**
	 * side function for fullSearch
	 * @param X
	 * @return
	 */
	public static String[] allCombinations(String X)
	{
		int n=X.length(),count=(int) (Math.pow(2, n)-1);
		String[]list=new String[count];
		int[]bin=new int[n];
		for(int i=0;i<count;i++)
		{
			plus1(bin);
			String t="";
			for(int j=0;j<n;j++)
			{
				if(bin[j]==1)
					t=t+X.charAt(j);
			}
			list[i]=t;
		}
		return list;
	}
	
	public static String fullSearch(String X,String Y)
	{
		int m=X.length(),n=Y.length();
		String ans="",sShort=X,sLong=Y;
		int maxLen=Integer.MIN_VALUE;
		if(m>n)
		{
			sShort=Y;
			sLong=X;
		}
		String[]tShort=allCombinations(sShort);
		String[]tLong=allCombinations(sLong);
		
		for(int i=0;i<tShort.length;i++)//O(2^m)
		{
			int len=tShort[i].length();
			for(int j=0;j<tLong.length;j++)//O(2^n)
			{
				if(tShort[i].equals(tLong[j])&&len>maxLen)//O(m)
				{
					maxLen=len;
					ans=tShort[i];
				}
			}
		}
		return ans;
		
	}
	
	
	/**
	 * build the matrix which contains all possible subsequences
	 * @param X
	 * @param Y
	 * @return
	 */
	public static int[][] BuildMatrix(String X, String Y)
	{
		int row = X.length()+1;
		int col = Y.length()+1;
		int mat[][] = new int[row][col];
		int i = 0;
		int j = 0;
		for(i = 0; i < row; i++)
		{
			mat[i][0] = 0;
		}
		for(j=0; j < col; j++) 
		{
			mat[0][j] = 0;
		}
		for(i=1; i < row; i++) 
		{
			for(j=1; j < col; j++) 
			{
				if(X.charAt(i-1) == Y.charAt(j-1))
					mat[i][j] = mat[i-1][j-1] +1;
				else
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
			}
		}
//		int length = mat[row-1][col-1]; - the wanted length of LCS
		return mat;
	}
	
	
	/**
	 * turn back from the bottom left to the way we came from
	 * @param X
	 * @param Y
	 * @return
	 */
	public static String MaxSequence(String X, String Y) 
	{
		int mat[][] = BuildMatrix(X,Y);
		int row = mat.length;
		int col = mat[0].length;
		int seqLength = mat[row-1][col-1];
		String result = "";
		int i =row-1;
		int j = col-1;
		int count = seqLength-1;
		
		while(count >= 0) 
		{
			if(X.charAt(i-1) == Y.charAt(j-1)) 
			{
				result = X.charAt(i-1) + result;
				i--;
				j--;
				count--;
			}
			else if(mat[i][j] == mat[i][j-1])
				j--;
			else
				i--;
		}
		return result;
	}
	public static void main(String[] args)
	{
		String X="abbdcedddd",Y="bace";
		System.out.println(Greedy(X,Y));
		System.out.println(ImprovedGreedy(Y,X));
		System.out.println(fullSearch(X,Y));
		System.out.println(MaxSequence(Y, X));
	}

}
