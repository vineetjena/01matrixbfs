package project;

import java.util.LinkedList;
import java.util.Queue;

class Node 
{
    int row;
    int col;
    int distance;

    public Node(int row, int col, int distance) 
    {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class ShortestPathBFS 
{

    public static int shortestPath(int[][] matrix, int startRow, int startCol, int targetRow, int targetCol) 
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];
        visited[startRow][startCol] = true;

        int[] rowDirections = { 0, 1 };
        int[] colDirections = { 1, 0 };
    

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startRow, startCol, 0));

        while (!queue.isEmpty()) 
        {
            Node current = queue.poll();

            if (current.row == targetRow && current.col == targetCol) 
            {
                return current.distance;
            }

            for (int i = 0; i < rowDirections.length; i++) 
            {
                int nextRow = current.row + rowDirections[i];
                int nextCol = current.col + colDirections[i];

                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !visited[nextRow][nextCol]
                        && matrix[nextRow][nextCol] == 1) 
                {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new Node(nextRow, nextCol, current.distance + 1));
                }
            }
        }

        return -1; // Return -1 if the target node is unreachable
    }

    public static void main(String[] args) 
    {
        int[][] matrix = 
        	{
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 1}
        	};

        int startRow = 0;
        int startCol = 0;
        int targetRow = 2;
        int targetCol = 2;

        int shortestPathDistance = shortestPath(matrix, startRow, startCol, targetRow, targetCol);
        if (shortestPathDistance == -1) 
        {
            System.out.println("No valid path exists.");
        } 
        else 
        {
            System.out.println("Shortest path distance: " + shortestPathDistance);
        }
    }
}
