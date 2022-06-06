package amazon;

import java.util.HashMap;
import java.util.Map;

public class MaxStockSum {
  private static int maxStockSum(int[] nums, int k) {
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
      map.put(nums[i],map.getOrDefault(nums[i],0)+1);  //统计数字 出现次数
    }
    int res = -1;
    if(map.size()==k){
      //说明没有重复的数字
      res = sum;
    }
    for (int i = k; i < n; i++) {
      map.put(nums[i - k],map.get(nums[i - k])-1);   //去掉一个
      if(map.get(nums[i-k])==0){
        map.remove(nums[i-k]);
      }
      map.put(nums[i],map.getOrDefault(nums[i],0)+1);//添加一个
      sum = sum - nums[i - k] + nums[i];
      if(map.size()==k){
        //说明没有重复的数字
        res = Math.max(res,sum);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 7, 7, 4, 3};
    int k = 2;
    System.out.println(maxStockSum(nums, k));
  }

}
