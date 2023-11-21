public class Fibonacci
{
	public static void main(String [] args)
	{
		int n = 18;
		System.out.println("Fib(" + n + ") = " + fib(n));
		System.out.println("iFib(" + n + ") = " + ifib(n));
	}
	
	public static int fib(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		else if (n == 1)
		{
			return 1;
		}
		else
		{
			return fib(n - 1) + fib(n - 2);
		}
	}
	
	public static int ifib(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		else if (n == 1)
		{
			return 1;
		}
		else
		{
			int a = 0, b = 1, c = 0;
			for (int i = 2; i < n; i++)
			{
				c = a + b;
				a = b;
				b = c;
			}
		
			return c;
		}
	}
}
		
		