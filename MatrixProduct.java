import java.util.*;
import java.io.*;

public class MatrixProduct
{
	
	private static void checkMatrix(int[][] A, int[][] B) throws IllegalArgumentException
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
		checkMatrix(A, B);
		// get row/col lengths
		int[][] C = new int[100][100];
        matrixProduct_DAC(row1, col1, A, row2, col2, B, C);
	}
	
	private static void matrixProduct_DAC(int row1, int col1, int A[][], int row2, int col2, int B[][], int C[][])
    {
        // If all rows traversed
        if (i >= row1)
            return;
  
        // If i < row1
        if (j < col2)
        {
            if (k < col1)
            {
                C[i][j] += A[i][k] * B[k][j];
                k++;
  
                matrixProduct_DAC(row1, col1, A, row2, col2, B, C);
            }
  
            k = 0;
            j++;
            matrixProduct_DAC(row1, col1, A, row2, col2, B, C);
        }
  
        j = 0;
        i++;
        matrixProduct_DAC(row1, col1, A, row2, col2, B, C);
    }

	public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) throws IllegalArgumentException
	{
		// checks to see if matrix is square and power of two
		checkMatrix(A, B);

		matrixProduct_Strassen(A, 0, 0, B, 0, 0, A.length);

	}

	private static int[][] matrixProduct_Strassen(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
	{
		int[][] C = new int[n][n];
		if n == 1
		{
			C[0][0] = A[]
		}
		else
		{
			int[][] s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
			s1 = matrixDiff(B, startrowB, startcolB + n / 2, B, startrowB + n / 2, startcolB + n / 2); // s1 = b12 - b22
			s2 = matrixAdd(A, startrowA, startcolA, A, startrowA, startcolA + n / 2); // s2 = a11 + a12
			s3 = matrixAdd(A, startrowA + n / 2, startcolA, A, startrowA + n / 2, startcolA + n / 2); // s3 = a21 + a22
			s4 = matrixDiff(B, startrowB + n / 2, startcolB, B, startrowB, startcolB); // s4 = b21 - b11
			s5 = matrixAdd(A, startrowA, startcolA, A, startrowA + n / 2, startcolA + n / 2); // s5 = a11 + a22
			s6 = 


		}
	}

	// A + B
	private static int[][] matrixAdd(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
	{
		int[][] C = new int[n][n];

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; i < n; j++)
			{
				C[i][j] = A[startrowA + i][startcolA + j] + B[startrowB + i][startcolB + j];
			}
		}
		return C;
	}

	// A - B
	private static int[][] matrixDiff(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
	{
		int[][] C = new int[n][n];

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; i < n; j++)
			{
				C[i][j] = A[startrowA + i][startcolA + j] - B[startrowB + i][startcolB + j];
			}
		}
		return C;
	}

}
