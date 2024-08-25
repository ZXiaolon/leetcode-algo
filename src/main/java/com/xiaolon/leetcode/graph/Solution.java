/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.graph.Solution
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/25
 *
 *   版权描述：
 *   公司地址：
 *
 */
package com.xiaolon.leetcode.graph;

/**
 * 类描述： Solution
 **/
public class Solution {
    /**
     * leetcode: 200 岛屿的数量 深度优先或者广度优先
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x>=0 && x<m && y>=0 && y<n && grid[x][y] == '1' && !visited[x][y]){
                dfs(x, y,grid,visited);
            }

        }

    }
}