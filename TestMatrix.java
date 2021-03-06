import java.util.*;
import java.io.*;

public class TestMatrix
{
	public static void main (String[] args)
    {
        MatrixProduct test = new MatrixProduct();

		// result matrices
		int[][] J = new int[2][2];
		int[][] K = new int[4][4];
		int[][] Q = new int[1][1];

		// invalid matrix, not square
		int A[][] = { {1, 2, 3},
                      {4, 5, 6}};

        int B[][] = { {1, 2, 3},
                      {4, 5, 6}};


		// 2 x 2 matrix
		int C[][] = { {1, 2},
                      {3, 4}};

        int D[][] = { {1, 2},
                      {3, 4}};


        // 4 x 4 matrix
		int E[][] = { {1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12},
					  {13, 14, 15, 16}};

        int F[][] = { {1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12},
					  {13, 14, 15, 16}};

		int P[][] = { {5}};

		// correct result

		// 2x2
		int M[][] = {{7, 10},
					 {15, 22}};

		// 4x4
		int N[][] = { {90, 100, 110, 120},
                      {202, 228, 254, 280},
                      {314, 356, 398, 440},
					  {426, 484, 542, 600}};


		/*/case 1

		try
		{
			J = test.matrixProduct_DAC(A, B);
			System.out.println("Should throw exception");
			J = test.matrixProduct_Strassen(A, B);
			System.out.println("Should throw exception");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Caught");
		}
		*/


		//case 2
		J = test.matrixProduct_DAC(C, D);
		System.out.println("DAC Results:");
		printMatrix(J);
		System.out.println("DAC Answer:");
		printMatrix(M);
		J = test.matrixProduct_Strassen(C, D);
		System.out.println("Strassen Results:");
		printMatrix(J);
		System.out.println("Strassen Answer:");
		printMatrix(M);


		//case 3
		K = test.matrixProduct_DAC(E, F);
		System.out.println("DAC Results:");
		printMatrix(K);
		System.out.println("DAC Answer:");
		printMatrix(N);
		K = test.matrixProduct_Strassen(E, F);
		System.out.println("Strassen Results:");
		printMatrix(K);
		System.out.println("Strassen Answer:");
		printMatrix(N);

		// case 4
		Q = test.matrixProduct_DAC(P, P);
		System.out.println("DAC Results:");
		printMatrix(Q);
		Q = test.matrixProduct_Strassen(P, P);
		System.out.println("Strassen Results:");
		printMatrix(Q);

		// case 5

		int[][] Z = new int[64][64];
		for(int i = 0; i < 64; i++)
		{
			for(int j = 0; j < 64; j++)
			{
				Z[i][j] = i;
			}
		}
		// case 4
		int[][] jk;
		jk = test.matrixProduct_DAC(Z, Z);
		System.out.println("DAC Results:");
		printMatrix(jk);
		jk = test.matrixProduct_Strassen(Z, Z);
		System.out.println("Strassen Results:");
		printMatrix(jk);

    }

	public static void printMatrix(int[][] A)
	{
		// can use A.length for both parameters since known square matrix
		for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A.length; j++)
                System.out.print(A[i][j]+" ");

            System.out.println();
        }
	}
}
