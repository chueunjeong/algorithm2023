package leetcode;

public class J27 {

  public static void main(String[] args) {
    int[] nums1 = { 0, 1, 2, 2, 3, 0, 4, 2 };
    int m = 2;
    System.out.println(removeElement(nums1, m));
  }

  public static int removeElement(int[] nums, int val) {
    int[] numsCopy = nums.clone();
    int length = nums.length;
    int count = 0;
    int numsIndex = 0;
    for (int num : numsCopy) {
      if (num == val) {
        count++;
        continue;
      }
      nums[numsIndex++] = num;
    }

    if (numsIndex < length) {
      for (int i = numsIndex; i < nums.length; i++) {
        nums[i] = -1;
      }
    }

    return length - count;
  }
}
