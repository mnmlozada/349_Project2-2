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

	public static int[][] matrixProduct_Strassen(int[][] A, int rowA, int colA, int[][] B, int rowB, int colB)
	{

	}

	private static int[][] matrixProduct_Strassen(int[][] A, int rowA, int colA, int[][] B, int rowB, int colB)
	{

	}

}
