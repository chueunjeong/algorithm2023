package leetcode;

import java.util.Arrays;

public class J189 {

  public static void main(String[] args) {
    int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
    int k1 = 3;
    int[] arr2 = { -1, -100, 3, 99 };
    int k2 = 2;
    rotate(arr2, k2);
  }

  public static void rotate(int[] nums, int k) {
    int[] numsCopy = nums.clone();
    for (int i = 0; i < numsCopy.length; i++) {
      nums[(i + k) % nums.length] = numsCopy[i];
    }
  }
}
