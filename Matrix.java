/**
 *  File: Matrix.java 
 *  Author: Li Jingwei
 *  Date: September 30, 2015
 *  
 *  Description: This program creates a Matrix class for storing and manipulating matrices.
 *  Second, we will create a test harness for testing the matrix class, and third we can (for bonus
 *  marks) use the Matrix class to solve a problem.
 */

import java.io.PrintStream;
import java.util.Scanner;

/**
 *  This is the only class of the program and contains some program code.
 *  The program starts running in some other functions.
 */

public class Matrix
{
	// Define the variables needed in Matrices.
	private double array[][];
	
	// Create a matrix of size m × n and initialize all entries to 0.
	public Matrix( int m, int n)
	{
		this.array = new double[m][n];
	}
	
	public Matrix( Matrix mtx )
	{
		// Assign related data to variables.
		int h = mtx.getHeight();
		int w = mtx.getWidth();
		
		// Create a copy of matrix mtx.
		for ( int ln1 = 0; ln1 < h; ln1++)
			for ( int ln2 = 0; ln2 < w; ln2++)
			{
				this.array[ln1][ln2] = mtx.array[ln1][ln2];
			}
	}
	
	// Create a matrix from values read in using the Scanner object.
	public Matrix( Scanner s )
	{
		// Read data in the Scanner object and store it into variables.
		int m = s.nextInt();
		int n = s.nextInt();
		
		// Define the matrix.
		this.array = new double[m][n];
		
		// Store numbers input by user into the matrix.
		for ( int ln1 = 0; ln1 < m; ln1++)
			for ( int ln2 = 0; ln2 < n; ln2++)
			{
				this.array[ln1][ln2] = s.nextDouble(); 
			}
	}
	
	/**
	 *  Take two matrices, b and res, add matrices this and b, stores the result in res,
	 *  and return it. Returns null on error.
	 */
	public Matrix add( Matrix b, Matrix res )
	{
		// Get height and width of the matrices.
		int h1 = this.getHeight();
		int w1 = this.getWidth();
		int h2 = b.getHeight();
		int w2 = b.getWidth();
		int h3 = res.getHeight();
		int w3 = res.getWidth();
		
		// If the sizes differ, return null.
		if ( h1 != h2 || w1 != w2 || h2 != h3 || w2 != w3 )
			return null;
		else			
		{
			// Calculate and assign the result into Matrix res.
			for ( int ln1 = 0; ln1 < h1; ln1++)
				for ( int ln2 = 0; ln2 < w1; ln2++)
				{
					res.array[ln1][ln2] = this.array[ln1][ln2] + b.array[ln1][ln2];
				}
			
			return res;
		}
	}
	
	/** 
	 * Take a scalar value s and a matrix res, multiple matrix this by s, store the
	 * result in res, and return it. Return null on error.
	 */
	public Matrix multiplyWithScalar( double s, Matrix res )
	{
		// Get height and width of matrices.
		int h1 = this.getHeight();
		int w1 = this.getWidth();
		int h2 = res.getHeight();
		int w2 = res.getWidth();
		
		// If the sizes of matrices differ, return null.
		if ( h1 != h2 || w1 != w2 )
			return null;
		else	
		{
			for ( int ln1 = 0; ln1 < h1; ln1++)
				for( int ln2 = 0; ln2 < w1; ln2++)
				{
					res.array[ln1][ln2] = this.array[ln1][ln2] * s;
				}
			
			return res;
		}
	}
	
	/**
	 * Take two matrices, b and res, of appropriate size, multiplies matrices this and b,
	 * store the result in res, and return it. Return null on error.
	 */
	public Matrix multiplyWithMatrix( Matrix b, Matrix res )
	{
		// Get height and width of matrices.
		int h1 = this.getHeight();
		int w1 = this.getWidth();
		int h2 = b.getHeight();
		int w2 = b.getWidth();
		int h3 = res.getHeight();
		int w3 = res.getWidth();
		
		// If matrices are not of appropriate sizes, return null.
		if ( h3 != h1 || w3 != w2 || w1 != h2 )
			return null;
		else
		{
			// Calculate the result of matrix multiplication and store the result in matrix res.
			for ( int ln1 = 0; ln1 < h1; ln1++)
				for ( int ln2 = 0; ln2 < w2; ln2++)
					for ( int ln3 = 0; ln3 < w1; ln3++)
					{
						res.setElem(ln1, ln2, res.getElem( ln1, ln2) + this.array[ln1][ln3] * b.getElem(ln3, ln2));
					}
			
			return res;
		}
	}
	
	// Take an output PrintStream object and writes the matrix to the output stream.
	public void write( PrintStream out )
	{
		// Get height and width of the matrix.
		int m = this.getHeight();
		int n = this.getWidth();
		
		// Print the number of height and width.
		out.println( m + " " + n );
		
		// Print the specific matrix numbers.
		for ( int ln1 = 0; ln1 < m; ln1++)
			for ( int ln2 = 0; ln2 < n; ln2++)
			{
				if ( ln2 != n - 1)
					out.print( this.array[ln1][ln2] + " " );
				else
					out.println( this.array[ln1][ln2] );
			}
	}
	
	// Take two integers, i and j, and return element E[i, j] of the matrix.
	public double getElem( int i, int j )
	{
		return array[i][j];
	}
	
	// Take two integers, i and j, and value v, and set element E[i, j] to value v.
	public void setElem( int i, int j, double v )
	{
		array[i][j] = v;
	}
	
	// Return the height of this matrix.
	public int getHeight()
	{
		return array.length;
	}
	
	// Return the height of this matrix.
	public int getWidth()
	{
		return array[0].length;
	}
}
