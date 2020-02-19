package Prisoners_Problem;

public class Prison 
{
	//Implementation of the algorithm when the lamp is on
	public static boolean prisonersLampOn(int n)
	{
		boolean enter[]=new boolean[n];//All values initialized to be false
		boolean lamp=true;//At first the lamp is on
		int count=0;
		while(count<n)
		{
			int p=(int)(Math.random()*n);//Random choice for prisoner
			if(p==0)//The representative entered the room
			{
				if(!enter[0])//The first time the representative entered
				{
					enter[0]=true;
					count++;
				}
				if(!lamp)
				{
					lamp=true;
					count++;
				}
			}
			else //Other prisoner besides the representative entered the room
			{
				if(!enter[p]&&lamp)//If he hadn't entered before and the lamp is on
				{
					lamp=false;
					enter[p]=true;
				}
			}
		}

		boolean ans=true;
		for(int i=0;ans&&i<enter.length;i++)//Checking if all of the prisoners entered one time exactly
		{
			if(!enter[i])
			{
				ans=false;
				break;
			}
		}
		return ans;
	}

	
	//Implementation of the algorithm when the lamp is ON or OFF
	public static boolean prisonersLampUnknown(int n)
	{
		int enter[]=new int[n];//All values initialized to be 0
		int count=0;
		boolean lamp=((int)(Math.random()*2))==0? false:true;//Random choice for the situation of the lamp ON/OFF
		while(count<(2*n))//We need to count 2n prisoners
		{
			int p=(int)(Math.random()*n);//Random choice for prisoner
			if(p==0&&!lamp)
			{
				/**
				 * If the representative entered and the lamp is OFF,
				 * he turns it ON and update the count.
				 * i.e. counts himself and another prisoner
				 */
				lamp=true;
				count++;
				if(enter[0]==0)
				{
					enter[0]++;
					count++;
				}
			}
			else//Other prisoner besides the representative entered the room
			{
				if(enter[p]<2&&lamp)
				{
					enter[p]++;
					lamp=false;//turns it OFF
				}
			}		
		}
		
		boolean ans=true;
		for(int i=0;ans&&i<enter.length;i++)//Checking if all of the prisoners entered at least one time
		{
			if(enter[i]==0)
			{
				ans=false;
				break;
			}
		}
		return ans;

	}
	public static void main(String[] args) 
	{
		System.out.println(prisonersLampOn(9));
		System.out.println(prisonersLampUnknown(9));
	}

}
