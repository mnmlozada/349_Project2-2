import java.util.*;
import java.io.*;

public class TestMatrix
{
	public static void main (String[] args) 
    {
        MatrixProduct test = new MatrixProduct();
		
		// result matrices
		int[][] J = new int[2][2];
		int[][] K = new int[3][3];
		int[][] L = new int[4][4];
		
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
		
		
		// 3 x 3 matrix
		int E[][] = { {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9}};
  
        int F[][] = { {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9} };
  
        // 4 x 4 matrix
		int G[][] = { {1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12},
					  {13, 14, 15, 16}};
  
        int H[][] = { {1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12},
					  {13, 14, 15, 16}};
					  
		// correct result
		
		// 2x2
		int M[][] = {{7, 10},
					 {15, 22}};
		
		// 3x3
		int N[][] = { {30, 36, 42},
                      {66, 81, 96},
                      {102, 126, 150}};
					  
		// 4x4
		int P[][] = { {90, 100, 110, 120},
                      {202, 228, 254, 280},
                      {314, 356, 398, 440},
					  {426, 484, 542, 600}};
		
		
		/*/case 1
		J = test.matrixProduct_DAC(A, B);
		System.out.println("Should throw exception");
		J = test.matrixProduct_Strassen(A, B);
		System.out.println("Should throw exception"); */
		
		
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
		
		//case 4
		L = test.matrixProduct_DAC(G, H);
		System.out.println("DAC Results:");
		printMatrix(L);
		System.out.println("DAC Answer:");
		printMatrix(P);
		L = test.matrixProduct_Strassen(G, H);
		System.out.println("Strassen Results:");
		printMatrix(L);
		System.out.println("Strassen Answer:");
		printMatrix(P);
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


