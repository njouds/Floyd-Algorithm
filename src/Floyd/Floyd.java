
package Floyd;


public class Floyd {

    
    public static int Inf=99999; // declaring the infinity number as global 
    
    
    public static void Floyd_Algorithm(int [][] weight_matrix ){ // This method implements the Folyd-Warshall algorithm for the all-pairs shortest-paths problem 
        
        int i,j,k;
                
        int Vertices=weight_matrix.length; //The number of vertices is the matrix length
        int[][]distance_matrix =weight_matrix; //declaring initially that the distance matrix is the weight matrix 
                
         
        for (k = 0; k < Vertices; k++)
        {
            for (i = 0; i < Vertices; i++)
            {
                for (j = 0; j < Vertices; j++)
                {
                    distance_matrix[i][j]= Math.min(distance_matrix[i][j], distance_matrix[i][k] + distance_matrix[k][j]);// On Kth iteration the algorithm determines shortest paths between every pair of vertices i, j that use only vertices among 1,...,k as intermediate

                    
                }
            }
            System.out.println("D "+ (k+1)+" iteration");
           Print(distance_matrix); //Printing each intermediate matrix for every iteration
        }
        
        
        System.out.println("Final distance matrix is:");
        Print(distance_matrix); // printing the last D(n) matrix that contains the lengths of the shortest paths among all paths that can use all n vertices as intermediate
        
        
        
    }
    
     public static void Print(int [][] distance_matrix ){ // printing the matrix in the argument
        
        for (int i = 0; i < distance_matrix.length; i++)
        {
            for (int j = 0; j < distance_matrix.length; j++) {
              
                if(distance_matrix[i][j]>=99999)
                   System.out.printf("%5s","∞");
                else
                  System.out.printf("%5d",distance_matrix[i][j]);
            }
            System.out.println();
        }
     }
    
    public static void main(String[] args) {
       
          int  weight_matrix[][] = new int[][] //declaring weight matrix which does not allow any intermediate vertices in its paths 
          
                                    { {0, 10, Inf, Inf, Inf, 5, Inf, Inf, Inf, Inf},
                                      {Inf, 0, 3, Inf, 3, Inf, Inf, Inf, Inf, Inf},
                                      {Inf, Inf, 0, 4, Inf, Inf, Inf, 5, Inf, Inf},
                                      {Inf, Inf, Inf, 0, Inf, Inf, Inf, Inf, 4, Inf},
                                      {Inf, Inf, 4, Inf, 0, Inf, 2, Inf, Inf, Inf},
                                      {Inf, 3, Inf, Inf, Inf, 0, Inf, Inf, Inf, 2},
                                      {Inf, Inf, Inf, 7, Inf, Inf, 0, Inf, Inf, Inf},
                                      {Inf, Inf, Inf, 4, Inf, Inf, Inf, 0, 3, Inf},
                                      {Inf, Inf, Inf, Inf, Inf, Inf, Inf, Inf, 0, Inf},
                                      {Inf, 6, Inf, Inf, Inf, Inf, 8, Inf, Inf, 0}
                                    };
        
          System.out.println("D 0 Weight Matrix:");
           Print(weight_matrix);//printing the weight matrix at D0 before implementing Floyd algorithm 
           Floyd_Algorithm(weight_matrix);//calling Folyd-Warshall algorithm with the weight matrix as input
        
        
        
        
        
    }
    
}
