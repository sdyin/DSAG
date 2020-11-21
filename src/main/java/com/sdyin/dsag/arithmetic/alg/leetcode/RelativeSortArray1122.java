package com.sdyin.dsag.arithmetic.alg.leetcode;

import java.util.Arrays;

/**
 * @Description: 1122. 数组的相对排序
 * 给你两个数组，arr1 和arr2，
 *
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: liuye
 * @time: 2020/11/14$ 下午5:19$
 */
public class RelativeSortArray1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] tmp=new int [1001];
        int n=arr1.length;
        for(int num:arr1){
            tmp[num]++;
        }
        int pos=0;      //arr1中索引的位置 也是arr2中含有的数字在arr1中的最大长度
        for(int num:arr2){
            while(tmp[num]>0){
                arr1[pos++]=num;
                tmp[num]--;
            }
        }
        int check=pos;  //这里是arr2中没有的值开始的位置。
        for(int i=0;i<1001;++i){
            while(tmp[i]>0){
                arr1[pos++]=i;
                tmp[i]--;
            }
        }
        Arrays.sort(arr1,check,n);
        return arr1;
    }
}
