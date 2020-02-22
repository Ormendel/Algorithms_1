package TurtleRabbit_Problem;

public class WithArm 
{
	final static int nLetters = 23, size = 26;// size of list and numbers of letters(24)
	
	public static int ArmLength(LinkedListCycle cars) 
	{
		int ans = -1;// length of arm
		boolean ToRun = true;
		boolean flag = true;
		
		Node turtle = cars.getHead();
		Node rabbit = cars.getHead();
		
		while(flag) {
			
			if(turtle.getNext() == null || rabbit.getNext() == null || rabbit.getNext().getNext() == null) {
				System.out.println("there is no cycle");
				flag = false;
				ToRun = false;
			}
			
			else {
				turtle = turtle.getNext();
				rabbit = rabbit.getNext().getNext();
				
				if(turtle.getData() == rabbit.getData())
				{
					flag = false;
					ToRun = true;//Beginning of cycle
				}
			}
		}
		
		rabbit = cars.getHead();// move the rabbit to the starting point(arm head)
		while(ToRun) {
			ans++;
			if(turtle.getData() == rabbit.getData())
				ToRun = false;
			
			else {
				turtle = turtle.getNext();
				rabbit = rabbit.getNext();
			}
		}
		return ans;
	}
	
	public static void main(String[] args) 
	{
		//*******need more examples!*******
		LinkedListCycle cars = new LinkedListCycle();
		cars.add('#');
		for (int i = 0; i < size; i++) {
			char c = (char) ('a' + i);
			cars.add(c);
		}
		System.out.println(cars.toString());
		System.out.println("arm length = " + ArmLength(cars)); // the answer will always be 0 here because thats how we built it
	}
}
