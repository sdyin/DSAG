package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description: 452. 用最少数量的箭引爆气球
 * <p>
 *     在二维空间中有许多球形的气球。对于每个气球，
 *     提供的输入是水平方向上，气球直径的开始和结束坐标。
 *     由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。
 *     开始坐标总是小于结束坐标。
 *     一支弓箭可以沿着x轴从不同点完全垂直地射出。
 *     在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 *     且满足 xstart ≤ x ≤ xend，则该气球会被引爆。
 *     可以射出的弓箭的数量没有限制。
 *     弓箭一旦被射出之后，可以无限地前进。
 *     我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *     给你一个数组 points ，
 *     其中 points [i] = [xstart,xend] ，
 *     返回引爆所有气球所必须射出的最小弓箭数。
 *     示例 1：
 *     输入：points = [[10,16],[2,8],[1,6],[7,12]]
 *     输出：2
 *     解释：对于该样例，
 *     x = 6 可以射爆 [2,8],[1,6] 两个气球，
 *     以及 x = 11 射爆另外两个气球
 *     示例 2：
 *     输入：points = [[1,2],[3,4],[5,6],[7,8]]
 *     输出：4
 *     示例 3：
 *     输入：points = [[1,2],[2,3],[3,4],[4,5]]
 *     输出：2
 *     示例 4：
 *     输入：points = [[1,2]]
 *     输出：1
 *     示例 5：
 *     输入：points = [[2,3],[2,3]]
 *     输出：1
 *     提示：
 *     0 <= points.length <= 104
 *     points[i].length == 2
 *     -231 <= xstart < xend <= 231 - 1
 *
 * @Author: liuye
 * @time: 2023/11/22$ 1:54 下午$
 */
public class FindMinArrowShots_452 {

    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        //按照起始区间排序，即按照尾节点大小排序
        // Integer.compare 避免正负相减，整形溢出
        Arrays.sort(points, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        int start = points[0][0];
        int end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            //如果当前区间的起始值大于end，不重叠
            if (points[i][0] > end) {
                start = points[i][0];
                end = points[i][1];
                count++;
            } else {
                //如果当前区间的起始值小于end，重叠
                start = Math.min(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
}