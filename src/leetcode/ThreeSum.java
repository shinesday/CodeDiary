package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15
public class ThreeSum {
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
      if (i == 0 || nums[i - 1] != nums[i]) {// i == 0
        twoSum2(nums, i, res);
      }

    }
    return res;
  }

  private static void twoSum2(int[] nums, int i, List<List<Integer>> res) {
    int lo = i + 1;
    int hi = nums.length - 1;
    while (lo < hi) {
      int sum = nums[i] + nums[lo] + nums[hi];
      if (sum < 0) {
        lo++;
      } else if (sum > 0) {
        hi--;
      } else {
        res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--])); //lo++, hi--
        while (lo < hi && nums[lo] == nums[lo -1]) lo++;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(nums));
  }

}
