import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/* ***************************************************************************
 * Stephan Johnson
 * 11/9/2022
 * Infix2Postfix.java
 *
 * <a simple, short program/class description>
 * **************************************************************************/
public class Infix2Postfix
{
	public static void main(String [] args) throws Exception
	{
		// // this was for testing out my evaluatePostfix function
		// // for its beginning stages
		// String p = "138*+";
		// System.out.println(evaluatePostfix(p));
		
		
		// // this is using the "input" file directly
		// // I was trying to use this method at the start of making this program
		// // didn't work
		// File input = new File("C:/Users/sjohn/Desktop/CSC 220/Notepad++/Infix2Postfix/input");
		
		
		
		// // readFile to read the File using a Buffered Reader
		// // I was trying to use this readFile() for public static void main
		// // but i ditched the idea
		// List<String> list = readFile();
		// list.First();
		// for (int i = 0; i < list.GetSize(); i++)
		// {
			// System.out.println(list.GetValue());
			
			// Queue cp_result = convertPostfix(list.GetValue());
			// String cp = cp_result.toString();
			// System.out.print(cp);
			
			// // Queue ep_result = evaluatePostfix(cp);
			// // String ep = ep_result.toString();
			// // System.out.print(ep);
			
			// double ep_result = evaluatePostfix(cp);
			// System.out.print(ep_result);
			
			// System.out.print("\n");
			// list.Next();
		// }
		
		
		
		// Out of all the methods that I tried to use, 
		// this is my best way to print out the input file
		// i decided to use convertPostfix as a Queue
		// i decided to use evaluatePostfix as a Double
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			System.out.println(line);
			
			Queue cp_result = convertPostfix(line);
			System.out.println(cp_result);
			
			String str = cp_result.toString();
			double ep_result = evaluatePostfix(str);
			System.out.println(ep_result);
			System.out.println();
			
		}
		
		
		
		
		
		// // this is for testing out my convertPostfix
		// // when my evaluatePostfix was a Queue instead of a Double
		// Scanner scanner = new Scanner(System.in);
		
		// while (scanner.hasNextLine())
		// {
			// String line = scanner.nextLine();
			// System.out.println(line);
			
			// Queue cp_result = convertPostfix(line);
			// System.out.println(cp_result);
			
			
			// String str = cp_result.toString();
			// Queue ep_result = evaluatePostfix(str);
			// System.out.println(ep_result);
			
		// }
		
		
		
		
		
		
		// // this is for testing out my convertPostfix function
		// // in its beginning stages
		
		// Scanner scanner = new Scanner(System.in);
		
		// while (scanner.hasNextLine())
		// {
			// String line = scanner.nextLine();
			// System.out.println(line);
			// System.out.println(convertPostfix(line));
			
		// }
		
		
	}

	public static double evaluatePostfix(String str)
	
	// // a test when the return value is a Queue
	// public static Queue evaluatePostfix(String str)
	
	// // a test when the return value is a Integer
	// public static int evaluatePostfix(String str)
	{
		int s = str.length();
		
		// empty stack
		
		Stack<Double> Postfix = new Stack<Double>(); 
		
		// // a test for integers 
		// Stack<Integer> Postfix = new Stack<Integer>();
		
		// traversing through the expression
		for (int i = 0; i < s; i++)
		{
			char c = str.charAt(i);
			
			// if the character is an operand, push it
			if (Character.isDigit(c))
			{
				double c1 = (double) (c - '0');
				Postfix.Push(c1);
				
				// // a test for integers 
				// Postfix.Push(c - '0');
			}
			
			// if the character is an operator
			else
			{
				// remove the two element at the top from the stack
				
				double operator1 = Postfix.Pop();
				double operator2 = Postfix.Pop();
				
				// // a test for integers 
				// int operator1 = Postfix.Pop();
				// int operator2 = Postfix.Pop();
				
				// evaulate the expressoin and push back the result to the stack
				if (c == '+')
				{
					Postfix.Push(operator1 + operator2);
				}
				else if (c == '-')
				{
					Postfix.Push(operator2 - operator1);
				}
				else if (c == '*')
				{
					Postfix.Push(operator2 * operator1);
				}
				else if (c == '/')
				{
					Postfix.Push(operator2 / operator1);
				}
				else if (c == '^')
				{
					// // a test for integers 
					// Postfix.Push((int) Math.pow(operator1, operator2));
					
					Postfix.Push(Math.pow(operator2, operator1));
				}
			}
		}
		
		// returns the result of the expression
		
		// // a test for the return value a Queue
		// Queue<Double> d = new Queue<Double>();
		// double p = Postfix.Pop();
		// d.Enqueue(p);
		// return d;
		
		return Postfix.Pop();
	}
	
	public static int priority(char operator)
	{
		// ranking operators to determine how long each one stays
		// in the stack through a numeric system
		if (operator == '^')
		{
			return 3;
		}
		else if (operator == '*' || operator == '/')
		{
			return 2;
		}
		else if (operator == '+' || operator == '-')
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	
	public static Queue convertPostfix(String str)
	{
		// empty infix expression
		String infixQ = str;
		
		// empty queue
		Queue<String> postfixQ = new Queue<String>();
		
		// empty stack
		Stack<String> operS = new Stack<String>();
		
		int s = str.length();
		
		// traversing through the expression until the expression is not empty
		for (int i = 0; i < s; i++)
		{
			char token = str.charAt(i);
			
			// if token is an operand
			if (Character.isDigit(token))
			{
				String t = Character.toString(token);
				postfixQ.Enqueue(t);
			}
			else if (!operS.IsEmpty() && token == '^')
			{
				operS.Push("^");
			}
			
			// if token is a left parenthesis
			else if (token == '(')
			{
				operS.Push("(");
			}
			
			// if token is a right parenthesis
			else if (token == ')')
			{
				while (!operS.IsEmpty() && operS.Peek() != "(")
				{
					postfixQ.Enqueue(operS.Peek());
					operS.Pop();
				}
				operS.Pop();
			}
			
			// if token is a operator that is not a parenthesis
			else
			{
				String t = Character.toString(token);
				
				while (!operS.IsEmpty() && priority(token) <= priority(operS.Peek().charAt(0)))
				{
					postfixQ.Enqueue(operS.Peek());
					operS.Pop();
				}
				operS.Push(t);
			}
		}
		
		// traversing the operator stack until it is empty
		while (!operS.IsEmpty())
		{
			if (operS.Peek() == "(" || operS.Peek() == ")")
			{
				operS.Pop();
			}
			postfixQ.Enqueue(operS.Peek());
			operS.Pop();
		}	
		
		// return the postfix queue
		return postfixQ;
		
	}
	
	// readFile to read the File using a Buffered Reader
	// I was trying to use this readFile() for public static void main
	// but i ditched the idea
	public static List<String> readFile()
	{
		List<String> list = new List<String>();
		try {
			InputStreamReader r = new InputStreamReader(System.in);  
			BufferedReader br = new BufferedReader(r);  
			
			String line;
			
			while((line = br.readLine()) != null)
			{
				list.InsertAfter(line);
			}
			br.close();
			
			
		} catch (Exception e) {
			System.out.println("exception");
		}
		
		return list;
	}
			

}