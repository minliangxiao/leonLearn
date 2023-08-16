package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [1.两数之和]
 *
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/8/16 11:41]
 */
public class No1 {

    public int[] twoSum(int[] nums, int target) {
       // 一次循环运用map解决
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)){
                return new int[]{i,map.get(sub)};
            }
            map.put(nums[i],i);
        }

       return null;
    }
}
