/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.matrix.MatrixDemo
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/16
 *
 */
package com.xiaolon.leetcode.matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 类描述： MatrixDemo
 **/
public class MatrixDemo {

    @ParameterizedTest
    @MethodSource(value = "productExceptSelfSource")
    public void testProductExceptSelf(int[] nums){
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }


    public static Stream<int[]> productExceptSelfSource(){
        return Stream.of(
                new int[]{1,2,3,4},
                new int[]{-1,1,0,-3,3}
                        );
    }

    public int[] productExceptSelf(int[] nums) {
        int multi = 1;
        int n = nums.length;
        for (int num : nums) {
            multi *= num;
        }
        int[] ans = new int[n];

        return null;
    }


    public static Stream<int[][]> gameOfLifeSource(){
        return Stream.of(
                new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}},
                new int[][]{{1,1},{1,0}}
                        );
    }

    @ParameterizedTest
    @MethodSource(value = "gameOfLifeSource")
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] newBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] nums = stat(board, i, j);
                int liveCnt=nums[0];
                int deadCnt=nums[1];

                System.out.println("("+i+","+j+") liveCnt:"+liveCnt+" deadCnt:"+deadCnt);

                System.out.println();
                if(board[i][j] == 1){
                    // 获取周围的细胞
                    if(liveCnt<2 || liveCnt>3) newBoard[i][j] = 0;
                    else newBoard[i][j] = 1;
                }else {
                    // 获取周围细胞
                    if(liveCnt==3)newBoard[i][j] = 1;
                    else newBoard[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = newBoard[i][j];
            }
        }

        board=newBoard;
        System.out.println(Arrays.deepToString(board));
    }

    public int[] stat(int[][] board, int i, int j) {
        // 获取周围细胞的统计数据
        int m = board.length;
        int n = board[0].length;
        int[] res = new int[2];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1,-1}, {-1, 1}, {1, -1}, {1, 1}};
        int[] cnts = new int[2];
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (0 <= x && x < m && 0 <= y && y < n) {
                if (board[x][y] == 1) {
                    cnts[0]++;
                }else{
                    cnts[1]++;
                }
            }
        }
        return cnts;
    }
}