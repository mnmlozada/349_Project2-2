import java.util.*;
import java.io.*;

public class MatrixProduct
{

	public static void checkMatrix(int[][] A, int[][] B) throws IllegalArgumentException
	{
		int aRow = A.length;
		int aCol = A[0].length;
		int bRow = B.length;
		int bCol = B[0].length;

		//checks that each matrix is a square and that they equal each other
		if(aRow != aCol && bRow != bCol && aCol != bRow)
		{

			throw new IllegalArgumentException("Invalid Matrices");

		}

		if(!(IsPowerOfTwo(aRow)))
		{

			throw new IllegalArgumentException("Invalid Matrices");
		}
	}

	// determines if number is a power of 2
	private static boolean IsPowerOfTwo(int x)
	{
		return (x != 0) && ((x & (x - 1)) == 0);
	}

	public static int[][] matrixProduct_DAC(int[][] A, int[][] B)
	{

	}

	private static int[][] matrixProduct_DAC()
	{

	}

	public static int[][] matrixProduct_Strassen(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
	{
		// checks to see if matrix is square and power of two
		checkMatrix(A, B);

		int[][] C = new int[n][n];

		if n == 1
		{
			C[0][0] = A[]
		}
		else
		{
			int[][] s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;

			

		}

	}

	private static int[][] matrixProduct_Strassen(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
	{

	}

	// A + B
	private static int[][] matrixAdd(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
	{

	}

	// A - B
	private static int[][] matrixDiff(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
	{

	}

}
