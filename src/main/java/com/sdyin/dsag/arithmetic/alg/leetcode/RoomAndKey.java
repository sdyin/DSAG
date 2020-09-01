package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description TODO 广度优先待补充
 * leetcode 841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 深度优先dfs -> 递归, 广度优先 -> 循环
 * @Author liuye
 * @Date 2020/8/31 17:06
 **/
public class RoomAndKey {

    static boolean[] vis;
    static int num;

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomSize = rooms.size();
        vis = new boolean[roomSize];
        num = 0;
        dfs(rooms, 0);
        return num == roomSize;
    }

    /**
     * 深度优先
     * @param rooms
     * @param x
     */
    private static void dfs(List<List<Integer>> rooms, int x) {
        //有钥匙
        vis[x] = true;
        num++;
        for (int i = 0; i < rooms.get(x).size(); i++) {
            if(!vis[rooms.get(x).get(i)]){
                dfs(rooms, rooms.get(x).get(i));
            }
        }
    }

    /**
     * 广度优先
     * @param rooms
     */
    private static boolean bfs(List<List<Integer>> rooms){
        int roomSize = rooms.size();
        int num = 0;
        boolean[] visit = new boolean[roomSize];
        visit[0] = true;
        Queue queue = new LinkedList<>();
        queue.offer(0);
        while( !queue.isEmpty()){
            int x = (int)queue.poll();
            for(Integer value: rooms.get(x)){
                if(!visit[value]){
                    visit[value] = true;
                    num++;
                }
            }
        }
        return num == roomSize;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1, 3);
        List<Integer> list2 = Lists.newArrayList(3, 0,1);
        List<Integer> list3 = Lists.newArrayList(2);
        List<Integer> list4 = Lists.newArrayList(0);

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);

        //深度优先dfs测试
        //boolean b = canVisitAllRooms(rooms);

        //广度优先bfs测试
        boolean b = bfs(rooms);
        System.out.println(b);
    }
}
