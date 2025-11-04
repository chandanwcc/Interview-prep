package com.chandan.interview.practice.test.practice;

public class IsLandCount {

    public static void main(String[] args) {
        char[][] grid = {
                { 'L', 'L', 'W', 'W', 'W' },
                { 'W', 'L', 'W', 'W', 'L' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'W', 'W', 'W', 'W', 'W' },
                { 'L', 'W', 'L', 'L', 'W' }
        };

        System.out.println(countIslands(grid)); // Output the number of islands
    }

    private static int countIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int count =0;

        for(int i =0; i< row; i++){
            for(int j =0; j< col; j++){
                if(grid[i][j] == 'L'){
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int r, int c, boolean[][] visited) {

        int row = visited.length;
        int col = visited[0].length;

        if(r < 0 || r>= row || c<0 || c>= col || visited[row][col]){
            return;
        }

        visited[r][c]=true;

        dfs(grid, r, c+1, visited);
        dfs(grid, r+1, c, visited);
        dfs(grid, r-1, c, visited);
        dfs(grid, r, c-1, visited);
    }
}
