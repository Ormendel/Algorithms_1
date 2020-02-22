package duel3D;

public class ShootingGame
{

	public static void duel3d(int num)
	{
		double pc=0.8,pd=0.5;//pb=1
		int countB=0,countC=0,countD=0;
		int B=1,C=2,D=3;
		double cChance=0,dChance=0;
		boolean flag=true;
		for(int i=1;i<=num;i++)
		{
			int[]q=getQueuq3();
			int first=q[1];
			switch(first)
			{
			case 1://B is the first and B kills C
				dChance=Math.random();//D fires
				if(dChance<pd)
					countD++;//D kills B
				else
					countB++;
				break;

			case 2://C is the first, C tries to kill B
				cChance=Math.random();//C fires
				if(cChance<pc)//C kills B, duel between C and D
				{
					flag=true;
					while(flag)
					{
						dChance=Math.random();//D fires
						if(dChance<pd)//C is killed
						{
							countD++;
							flag=false;
						}
						else
						{
							cChance=Math.random();
							if(cChance<pc)//D is killed 
							{
								countC++;
								flag=false;
							}
						}
					}
				}
				//C does not kill B, the triple duel B,C,D
				else if(q[2]==B)//B is the second, B kills C
				{
					dChance=Math.random();//D fires and tries to kill B
					if(dChance<pd)
						countD++;//D kills B
					else
						countB++;//B kills D
				}
				else if(q[2]==D)
				{//D is the second, D does not fire
					//B kills C
					dChance = Math.random();//D fires and tries to kill B
					if(dChance<pd)
						countD++;//D kills B
					else
						countB++;//B kills D
				}
				break;

			case 3://D is the first, D does not fire
				if(q[2]==B)//B is the second, B kills C
				{
					dChance = Math.random();//D fires
					if(dChance<pd)
						countD++;//D kills B
					else
						countB++;
				}
				else
				{
					if(q[2]==C)//C is the second,C tries to kill B
					{
						cChance=Math.random();
						if(cChance<pc)//C kills B, duel between C and D
						{
							flag=true;
							while(flag)
							{
								dChance=Math.random();//D fires
								if(dChance<pd)//C is killed
								{
									countD++;
									flag=false;
								}
								else
								{
									cChance=Math.random();//C fires
									if(cChance<pc)//D is killed
									{
										countC++;
										flag=false;
									}
								}
							}
						}
					}
					else
					{
						//B does not kill C, C kills B
						dChance=Math.random();//D fires
						if(dChance<pd)
							countD++;
						else
							countC++;//C kills D
					}
				}
				break;
			}
		}
		double probB=(double)countB/num;
		double probC=(double)countC/num;
		double probD=(double)countD/num;
		System.out.println("probB = "+probB+", probC = "+probC+", probD = "+probD);
		System.out.println("summa = "+(probB+probC+probD));
	}
	private static int[] getQueuq3() 
	{
		int[]q= {0,1,2,3};
		for(int i=1;i<q.length;i++)
		{
			int j=(int)(Math.random()*3)+1;
			int t=q[i];
			q[i]=q[j];
			q[j]=t;
		}
		return q;
	}
	public static void main(String[] args)
	{
		duel3d(15);
	}

}
