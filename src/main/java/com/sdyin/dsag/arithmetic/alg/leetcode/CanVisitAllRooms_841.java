package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.sun.org.apache.bcel.internal.classfile.ConstantNameAndType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 841. 钥匙和房间
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 *
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 *
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 *
 * @Author: liuye
 * @time: 2023/9/13$ 4:33 下午$
 */
public class CanVisitAllRooms_841 {

    Map<Integer, Integer> map = new HashMap<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        for (int i = 0; i < size; i++) {
            map.put(i, 0);
        }
        // 第一个房间默认可以进入
        map.put(0, 1);

        getRoomListByIndex(rooms, 0);

        boolean b = map.values().stream().allMatch(v -> v.equals(1));
        return b;
    }

    private void getRoomListByIndex(List<List<Integer>> rooms, int index) {
        List<Integer> list = rooms.get(index);
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) == 1){
                continue;
            }
            map.put(list.get(i), 1);
            getRoomListByIndex(rooms, list.get(i));
        }
    }
}
