package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J26 {

  public static void main(String[] args) {
    int[] arr1 = { 1, 1, 2 };
    int[] arr2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    System.out.println(removeDuplicates(arr1));
  }

  public static int removeDuplicates(int[] nums) {
    int[] numsCopy = nums.clone();

    List<Integer> list = new ArrayList<Integer>();

    for (int num : numsCopy) {
      if (!list.contains(num)) {
        list.add(num);
      } else continue;
    }

    list.forEach(num -> System.out.print(num + ","));

    for (int i = 0; i < list.size(); i++) {
      nums[i] = list.get(i);
    }

    if (nums.length - list.size() > 0) {
      Arrays.fill(nums, list.size(), nums.length, 101);
    }

    System.out.println(Arrays.toString(nums));

    return list.size();
  }
}
