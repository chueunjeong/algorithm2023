package leetcode;

import java.util.Arrays;

public class J238 {

  public static void main(String[] args) {
    int[] arr1 = { 1, 2, 3, 4 };
    int[] arr2 = { -1, 1, 0, -3, 3 };

    System.out.println(Arrays.toString(productExceptSelf(arr1)));
  }

  public static int[] productExceptSelf(int[] nums) {
    int[] answer = new int[nums.length];

    //각 부분곱 만들기
    int[] forward = new int[nums.length];
    int[] backward = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      //앞-> 뒤
      int prev = i == 0 ? 1 : forward[i - 1];
      forward[i] = prev * nums[i];
      //뒤->앞
      int prevB = i == 0 ? 1 : backward[nums.length - i];
      backward[nums.length - 1 - i] = prevB * nums[nums.length - 1 - i];
    }

    //값 채워넣기
    for (int k = 0; k < nums.length; k++) {
      int fValue = k == 0 ? 1 : forward[k - 1];
      int bValue = k == nums.length - 1 ? 1 : backward[k + 1];
      answer[k] = fValue * bValue;
    }
    return answer;
  }
}
