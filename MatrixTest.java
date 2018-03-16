/**
 *  File: MatrixTest.java 
 *  Author: Li Jingwei
 *  Date: October 4, 2015
 *  
 *  Description: This program creates a Matrix class for storing and manipulating matrices.
 *  Second, we will create a test harness for testing the matrix class, and third we can (for bonus
 *  marks) use the Matrix class to solve a problem.
 */
import java.util.Scanner;

/**
 *  This is the main class of the program and contains some program codes.
 *  The program starts running in the main() of this class.
 */
public class MatrixTest 
{
	/**
	 * This method is called when the program starts running.
	 * It reads in user commands to load and manipulate the matrices and then output the results.
	 * The program will be required to load and manipulate up to three matrices, named A, B, and C. 
	 * The command set will parallel the methods and constructors of the Matrix class.
	 */
	public static void main(String[] args) 
	{	
		// Instantiate new scanner to read from the console.
		Scanner keyboard = new Scanner(System.in);
		
		/** 
		 * Create a Matrix array of size 3.
		 */
		Matrix[] matrixArray= new Matrix[3];
		
		// Define the string command.
		String command;
		
		/** 
		 * One big loop that continues to iterate until the quit command is entered.
		 * The loop should first read in the next command, using the Scanner 
		 * and determine which command it is. Then, based on the command, it
		 * should read the additional parameters, using the Scanner, and perform the operation.
		 */
		while( true )
		{
			// Store the input into the command string.
			command = keyboard.next();
			
			// Determine which command the input string is.
			if ( command.equals("load") )
			{
				/**
				 * Load the matrix and assign it to the specific matrix.
				 */
				// Get the name of the matrix from the user input.
				String M = keyboard.next();
				
				// Create a new matrix for storing the matrix data input by the user.
				Matrix matrix = new Matrix( keyboard );

				// Judge if the matrix is valid.
				if ( M.equals(null) )
				{
					System.out.println("ERR");
				}
				// Check the name of the matrix and store matrix data into corresponding matrix array.
				else 
				{
					matrixArray[check(M)] = matrix;		
					System.out.println("OK");
				}	
			}
			else if ( command.equals("new") )
			// Create a matrix of size height × width and assign it to the specific matrix.
			{	
				// Get the name of the matrix from the user input.
				String M = keyboard.next();

				// Get height and width of the matrix.
				int h = keyboard.nextInt();
				int w = keyboard.nextInt();
				
				// Judge if the input is valid.
				if ( h == 0 || w == 0 )
				{
					System.out.println("ERR");
				}
				// Check the name of the matrix and set the size of the matrix into it.
				else
				{
					// Set all the numbers to zero and store the matrix into the array.
					matrixArray[check(M)] = new Matrix( h, w);
					
					System.out.println( "OK" );
				}
			}
			else if ( command.equals("clone") )
			// Create a copy of matrix N and assigns it to M.
			{
				// Get the name of the assigned matrix from the user input.
				String M = keyboard.next();
				
				// Get the name of the assigning matrix from the user input.
				String N = keyboard.next();
			
				// Judge if the strings are valid.
				if ( M.equals(null) || N.equals(null) )
				{
					System.out.println("ERR");
				}
				/**
				 *  Check the name of the matrices and store assigning matrix data 
				 *  into assigned matrix array.
				 */
				else
				{
					matrixArray[check(M)] = matrixArray[check(N)];
					System.out.println("OK");
				}	
			}
			else if ( command.equals("add") )
			// Add matrix N to P and store the result in M.
			{
				// Get the names of the matrices from the user input.
				String M = keyboard.next();
				String N = keyboard.next();
				String P = keyboard.next();

				// Judge if the strings are valid.
				if ( M.equals(null) || N.equals(null) || P.equals(null) )
				{
					System.out.println("ERR");
				}
				// Check the name of the matrix and store matrix data into corresponding matrix array.
				else
				{
					matrixArray[check(M)].add( matrixArray[check(N)], matrixArray[check(P)] );
					System.out.println("OK");
				}
			}
			else if ( command.equals("scale") )
			// Multiply matrix N by scalar, which is a decimal value, and store the result in M.
			{
				// Get the names of the matrices and the scalar number from the user input.
				String M = keyboard.next();
				double s = keyboard.nextInt();
				String N = keyboard.next();
				
				if ( M.equals(null) || N.equals(null) )
				{
					System.out.println("ERR");
				}
				// Check the name of the matrices and store matrix data into corresponding matrix array.
				else
				{
					matrixArray[check(M)].multiplyWithScalar( s, matrixArray[check(N)] );
					System.out.println("OK");
				}
			}
			else if ( command.equals("mult") )
			{
				// Get the names of the matrices from the user input.
				String M = keyboard.next();
				String N = keyboard.next();
				String P = keyboard.next();
				
				// Initialize one matrix for storing the result.
				Matrix result;

				// Judge if the strings are valid.
				if ( matrixArray[check(M)] == null || matrixArray[check(N)] == null || matrixArray[check(P)] == null )
				{
					System.out.println("ERR");
				}
				else 
				{
					// Assign the calculation result into the matrix.
					result = matrixArray[check(N)].multiplyWithMatrix( matrixArray[check(P)], matrixArray[check(M)]);
				
					// Judge if the matrix is valid.
					if ( result == null )
					{
						System.out.println("ERR");
					}	
					// Check the name of the matrices and store matrix data into corresponding matrix array.
					else
					{
						matrixArray[check(M)] = result;
						System.out.println("OK");
					}
				}
			} 
			else if ( command.equals("get") )
			{
				// Get the name of the matrix from the user input.
				String M = keyboard.next();
				
				// Get the numbers from the user input.
				int i = keyboard.nextInt();
				int j = keyboard.nextInt();
				
				// Judge if the string is valid.
				if ( matrixArray[check(M)] == null )
				{
					System.out.println("ERR");
				}
				else
				{
					// Print the valid instruction.
					System.out.println("OK");
					
					// Print out matrix element.
					System.out.println( matrixArray[check(M)].getElem( i, j ) );
				}
			}
			else if ( command.equals("set") )
			// Set matrix element M[i, j] to the value.
			{
				// Get the name of the matrix from the user input.
				String M = keyboard.next();
				
				// Get the numbers from the user input.
				int i = keyboard.nextInt();
				int j = keyboard.nextInt();
				double value = keyboard.nextDouble();
				
				// Judge if the string is valid.
				if ( matrixArray[check(M)] == null )
				{
					System.out.println("ERR");
				}
				else
				{
					// Print the valid instruction.
					System.out.println("OK");
					
					// Set the element to the value.
					matrixArray[check(M)].setElem( i, j, value);
				}
			}
			else if ( command.equals("write"))
			{
				// Get the name of the matrix from the user input.
				String M = keyboard.next();
				
				// Judge if the string is valid.
				if ( matrixArray[check(M)] == null )
				{
					System.out.println("ERR");
				}
				else
				{	
					// Print the matrix out.
					matrixArray[check(M)].write( System.out );
					
					// Print the valid instruction.
					System.out.println("OK");
				}
			}
			else if( command.equals("size") )
			{
				// Get the name of the matrix from the user input.
				String M = keyboard.next();
				
				// Judge if the string is valid.
				if ( matrixArray[check(M)] == null )
				{
					System.out.println("ERR");
				}
				else
				{	
					// Print the valid instruction.
					System.out.println("OK");
				
					// Print out the size of M.
					System.out.println( matrixArray[check(M)].getHeight() + " " + matrixArray[check(M)].getWidth() );
				}
			}
			else if ( command.equals("quit") )
			{
				break;
			}
		}
	}
	
	// The method for checking the name of the matrix and return the array number.
	public static int check( String aString )
	{
		if ( aString.equals("A") )
		{
			return 0;
		}
		else if ( aString.equals("B") )
		{
			return 1;
		}
		else if ( aString.equals("C") )
		{
			return 2;
		}
		else 
		{
			return -1;
		}
	}
}
