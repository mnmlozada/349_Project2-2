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

	public static int[][] matrixProduct_DAC(int[][] A, int[][] B) throws IllegalArgumentException
	{
		checkMatrix(A, B);
        matrixProduct_DAC(0, 0, A, 0, 0, B, A.length);
		int[][] C = new int[1][1];
		return C;
	}

<<<<<<< HEAD
	private static int[][] matrixProduct_DAC(int aRow, int aCol, int A[][], int bRow, int bCol, int B[][], int size)
  {
=======
	// C11 - C22 need 2 recursive calls, then the 2 matrices resulting from the recursive calls need to be added
	private static int[][] matrixProduct_DAC(int A[][], int startrowA, int startcolA, int B[][], int startrowB, int startcolB, int size)
	{
>>>>>>> 554721c280d527be754490eec42e7f3f0a1f6df8
        int[][] C = new int[size][size];
		
<<<<<<< HEAD
//		if(size == 1)
//		{
//			C = A[aRow, aCol] * B[bRow][bCol];
//		}
//		else
//		{
//
//		}
		
		return C;
    }

=======
		if(size == 1)
		{
			C[0][0] = A[startrowA][startcolA] * B[startrowB][startcolB];
		}
		else{

			int offset = size/2;
			
			//C11
			temp1 = matrixProduct_DAC(A, startrowA, startcolA, B, startrowB, startcolB, offset);
			temp2 = matrixProduct_DAC(A, startrowA, startcolA + offset, B, startrowB + offset, startcolB, offset);
			sumMatrix(C, temp1, temp2, 0, 0);

			//C12
			temp1 = matrixProduct_DAC(A, startrowA, startcolA, B, startrowB, startcolB + offset, offset);
			temp2 = matrixProduct_DAC(A, startrowA, startcolA+offset, B, startrowB + offset, startcolB+offset, offset);
			sumMatrix(C, temp1, temp2, 0, offset);

			 
			//C21
			temp1 = matrixProduct_DAC(A, startrowA + offset, startcolA, B, startrowB, startcolB, offset);
			temp2 = matrixProduct_DAC(A, startrowA + offset, startcolA + offset, B, startrowB+ offset, startcolB, offset);
			sumMatrix(C, temp1, temp2, offset, 0);

			//C22
			temp1 = matrixProduct_DAC(A, startrowA + offset, startcolA, B, startrowB, startcolB +offset, offset);
			temp2 = matrixProduct_DAC(A, startrowA + offset, startcolA + offset, B, startrowB + offset, startcolB + offset, offset);
			sumMatrix(C, temp1, temp2, offset, offset);
		}
		
		return C;
	}
	
	private static void sumMatrix(int[][] C, int[][] A, int[][] B,int row, int col)
	{
		for(int i = 0; i < A.length; i++)
		{
			for(int j = 0; j < A.length; j++)
			{
				C[i + row][j + col] = A[i][j] + B[i][j];
			}
		}

	}

>>>>>>> 554721c280d527be754490eec42e7f3f0a1f6df8
	public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) throws IllegalArgumentException
	{
		// checks to see if matrix is square and power of two
		try
		{
			checkMatrix(A, B);
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("Invalid Matrices");
		}


		int [][] C = matrixProduct_Strassen(A, 0, 0, B, 0, 0, A.length);
		return C;
	}

	private static int[][] matrixProduct_Strassen(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
	{
		int[][] C = new int[n][n];
		
		if(n == 1)
		{
			C[0][0] = A[startrowA][startcolA] * B[startrowB][startcolB];
		}
		else
		{
			int[][] s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
			s1  = matrixDiff(B, startrowB, startcolB + n / 2, B, startrowB + n / 2, startcolB + n / 2, n / 2); // s1 = b12 - b22
			s2  = matrixAdd(A, startrowA, startcolA, A, startrowA, startcolA + n / 2, n / 2);                  // s2 = a11 + a12
			s3  = matrixAdd(A, startrowA + n / 2, startcolA, A, startrowA + n / 2, startcolA + n / 2, n / 2);  // s3 = a21 + a22
			s4  = matrixDiff(B, startrowB + n / 2, startcolB, B, startrowB, startcolB, n / 2);                 // s4 = b21 - b11
			s5  = matrixAdd(A, startrowA, startcolA, A, startrowA + n / 2, startcolA + n / 2, n / 2);          // s5 = a11 + a22
			s6  = matrixAdd(B, startrowB, startcolB, B, startrowB + n / 2, startcolB + n / 2, n / 2);          // s6 = b11 + b22
			s7  = matrixDiff(A, startrowA, startcolA + n / 2, A, startrowA + n / 2, startcolA + n / 2, n / 2); // s7 = a12 - a22
			s8  = matrixAdd(B, startrowB + n / 2, startcolB, B, startrowB + n / 2, startcolB + n / 2, n / 2);  // s8 = b21 + b22
			s9  = matrixDiff(A, startrowA, startcolA, A, startrowA + n / 2, startcolA, n / 2);                 // s9 = a11 - a21
			s10 = matrixAdd(B, startrowB, startcolB, B, startrowB, startcolB + n / 2, n / 2);                  // s10 = b11 + b12

			int[][] p1, p2, p3, p4, p5, p6, p7;
			p1 = matrixProduct_Strassen(A, startrowA, startcolA, s1, 0, 0, n / 2);                  // p1 = a11 * s1
			p2 = matrixProduct_Strassen(s2, 0, 0, B, startrowB + n / 2, startcolB + n / 2, n / 2);  // p2 = s2 * b22
			p3 = matrixProduct_Strassen(s3, 0, 0, B, startrowB, startcolB, n / 2);                  // p3 = s3 * b11
			p4 = matrixProduct_Strassen(A, startrowA + n / 2, startcolA + n / 2, s4, 0, 0, n / 2);  // p4 = a22 * s4
			p5 = matrixProduct_Strassen(s5, 0, 0, s6, 0, 0, n / 2);                                 // p5 = s5 * s6
			p6 = matrixProduct_Strassen(s7, 0, 0, s8, 0, 0, n / 2);                                 // p6 = s7 * s8
			p7 = matrixProduct_Strassen(s9, 0, 0, s10, 0, 0, n / 2);                                // p7 = s9 * s10

			// Computing C quadrants
			int[][] c11, c12, c21, c22;
			c11 = matrixAdd(matrixDiff(matrixAdd(p5, 0, 0, p4, 0, 0, n / 2), 0, 0, p2, 0, 0, n / 2), 0, 0, p6, 0, 0, n / 2);
			c12 = matrixAdd(p1, 0, 0, p2, 0, 0, n / 2);
			c21 = matrixAdd(p3, 0, 0, p4, 0, 0, n / 2);
			c22 = matrixDiff(matrixDiff(matrixAdd(p5, 0, 0, p1, 0, 0, n / 2), 0, 0, p3, 0, 0, n / 2), 0, 0, p7, 0, 0, n / 2);

			fillMatrix(C, c11, c12, c21, c22, n);
		}

		return C;
	}

	private static void fillMatrix(int[][] C, int[][] c11, int[][] c12, int[][] c21, int[][] c22, int n)
	{
		// filling in c11
		for(int i = 0; i < n / 2; i++)
		{
			for(int j = 0; j < n / 2; j++)
			{
				C[i][j] = c11[i][j];
			}
		}

		// filling in c12
		for(int i = 0; i < n / 2; i++)
		{
			for(int j = 0; j < n / 2; j++)
			{
				C[i][j + n / 2] = c12[i][j];
			}
		}

		// filling in c21
		for(int i = 0; i < n / 2; i++)
		{
			for(int j = 0; j < n / 2; j++)
			{
				C[i + n / 2][j] = c21[i][j];
			}
		}

		// filling in c22
		for(int i = 0; i < n / 2; i++)
		{
			for(int j = 0; j < n / 2; j++)
			{
				C[i + n / 2][j + n / 2] = c22[i][j];
			}
		}

	}

	// A + B
	private static int[][] matrixAdd(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
	{
		int[][] C = new int[n][n];

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
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
			for(int j = 0; j < n; j++)
			{
				C[i][j] = A[startrowA + i][startcolA + j] - B[startrowB + i][startcolB + j];
			}
		}
		return C;
	}

}
