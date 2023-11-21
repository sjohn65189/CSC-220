public class Test
{
	public static void main(String [] args)
	{
		Integer [] x = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		printArray(x);
		Character [] y = {'a', 'b', 'c', 'd', 'e'};
		printArray(y);
	}
	
	public static <gen> void printArray(gen [] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + ", ");
		}
		System.out.println();
	}
	
}