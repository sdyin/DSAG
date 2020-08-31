package com.sdyin.dsag.arithmetic.alg.leetcode;

import com.google.common.collect.Lists;
import org.checkerframework.checker.i18nformatter.qual.I18nChecksFormat;

import javax.xml.crypto.Data;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @Description TODO 解答有误
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
 * @Author liuye
 * @Date 2020/8/31 17:06
 **/
public class RoomAndKey {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomSize = rooms.size();
        List<Integer> list = new ArrayList<>();
        IntStream.range(1, roomSize).map(item -> Integer.valueOf(item)).forEach(data -> {
            list.add(data);
        });

        list.stream().forEach(data -> System.out.println("房间 " + data));

        List<Integer> roomList = rooms.stream().reduce((list1, list2) -> {
            list1.addAll(list2);
            return list1;
        }).orElse(new ArrayList<Integer>());

        roomList = roomList.stream().distinct().collect(Collectors.toList());

        roomList.stream().forEach(data -> System.out.println("可达房间 " + data));
        if(roomList.containsAll(list)){
            return true;
        }
        return false;
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
        boolean b = canVisitAllRooms(rooms);
        System.out.println(b);
    }
}
