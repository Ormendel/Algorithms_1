package TurtleRabbit_Problem;

public class NoArm 
{
	
	final static int nLetters = 23, size = 26;// size of list and numbers of letters(24)
	public static boolean ifCycle(LinkedListCycle cars)
	{
		boolean flag = true;// loop condition
		boolean ans = false;// keeps the answer
		int count = 0;

		Node turtle = (Node) cars.getHead();
		Node rabbit = (Node) cars.getHead();

		while (flag) 
		{
			count++;
			if (turtle.getNext() == null || rabbit.getNext() == null || rabbit.getNext().getNext() == null) {
				System.out.println("there is no cycle");// if there is no cycle so the turtle and the rabbit can't meet
				flag = false;
				ans = false;
			}

			else 
			{
				turtle = turtle.getNext();// move turtle
				rabbit = rabbit.getNext().getNext();// move rabbit (2*turtle moves)
				if (turtle.getData() == rabbit.getData()) 
				{
					System.out.println("there is a cycle!");// if they met so there is a cycle
					flag = false;
					ans = true;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) 
	{
		LinkedListCycle cars = new LinkedListCycle();
		for (int i = 0; i < size; i++) {
			char c = (char) ('a' + i);
			cars.add(c);
		}
		System.out.println(cars.toString());
		System.out.println("there is a cycle? = " + ifCycle(cars));
	}
}
