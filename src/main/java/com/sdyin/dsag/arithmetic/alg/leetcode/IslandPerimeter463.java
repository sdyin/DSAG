package com.sdyin.dsag.arithmetic.alg.leetcode;

/**
 * @Description 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * @Author liuye
 * @Date 2020/10/30 11:49
 **/
public class IslandPerimeter463 {

    /**
     * dx,dy 组合为当前节点的上下左右
     */
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, int n, int m) {
        //第一行，最后一行，第一列，最后一列，一级当前值为0 则边长加1
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        //当前节点标记已计算 标记为2
        grid[x][y] = 2;

        int res = 0;

        //计算当前节点上下左右四条边
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }


    /**
     * 解法二
     *
     * @param grid
     * @return
     */
    public int islandPerimeter2(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //分 上下左右四种情况计算
                    //左边
                    if (i == 0 || grid[i - 1][j] == 0) {
                        res++;
                    }
                    //右边
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        res++;
                    }
                    //上边
                    if (j == 0 || grid[i][j - 1] == 0) {
                        res++;
                    }
                    //下边
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
