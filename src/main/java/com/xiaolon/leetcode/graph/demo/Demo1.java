/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.graph.demo.Demo1
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/1
 *
 */
package com.xiaolon.leetcode.graph.demo;

import com.xiaolon.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 类描述： Demo1
 * 求海岛最大面积
 **/
public class Demo1 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 0}
        };
        int area = maxAreaOfIsland(grid);
        System.out.println("max area: " + area);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = getAreaDfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    /**
     * 广度遍历(队列实现)，获取从当前节点出发所求面积
     *
     * @param grid
     * @param visited
     * @param i
     * @param j
     * @return
     */
    public static int getAreaBfs(int[][] grid, boolean[][] visited, int i, int j) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int area = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            area++;

            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < grid.length
                    && c >= 0 && c < grid[0].length
                    && grid[r][c] == 1 && !visited[r][c]) {
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return area;
    }

    /**
     * 广度优先搜索（递归实现）
     *
     * @param grid
     * @param visited
     * @param i
     * @param j
     * @return
     */
    public static int getAreaBfsR(int[][] grid, boolean[][] visited, int i, int j) {

        int area = 0;

        return area;
    }

    /**
     * 深度优先搜索（栈实现）
     *
     * @return
     */
    public static int getAreaDfs(int[][] grid, boolean[][] visited, int i, int j) {
        Deque<int[]> stack = new LinkedList<>();
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        stack.push(new int[]{i, j});
        visited[i][j] = true;

        int area = 0;
        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            area++;

            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < grid.length
                    && c >= 0 && c < grid[0].length
                    && grid[r][c] == 1 && !visited[r][c]) {
                    stack.push(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return area;
    }

    /**
     * 深度优先搜索（递归实现）
     * @param grid
     * @param visited
     * @param i
     * @param j
     * @return
     */
    public static int getAreaDfsR(int[][] grid, boolean[][] visited, int i, int j) {
        int area=1;
        visited[i][j]=true;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] dir:dirs){
            int r=i+dir[0];
            int c=j+dir[1];

            if(r>=0 && r<grid.length
               && c>=0 && c<grid[0].length
               && grid[r][c]==1 && !visited[r][c]){
                area += getAreaDfsR(grid,visited,r,c);
            }
        }
        return area;
    }
}