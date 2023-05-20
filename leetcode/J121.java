package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class J121 {

  private static final int C = 0;

  public static void main(String[] args) {
    int[] arr1 = { 7, 1, 5, 3, 6, 4 };
    int[] arr2 = { 7, 6, 4, 3, 1 };
    int[] arr3 = { 2, 4, 1 };

    System.out.println(maxProfit(arr2));
  }

  public static int maxProfit(int[] prices) {
    int result = 0;
    if (prices.length == 1) return 0;

    //구간별 최대값 구간 구하기
    int[] S = new int[prices.length - 1];
    for (int i = prices.length - 1; i > 0; i--) {
      if (i == prices.length - 1) S[i - 1] = prices[i]; else {
        if (S[i] >= prices[i]) S[i - 1] = S[i]; else S[i - 1] = prices[i];
      }
    }
    //오늘 날짜와 나머지 미래의 날짜의 최댓값을 비교하기
    for (int k = 0; k < prices.length - 1; k++) {
      if (S[k] - prices[k] > result) result = S[k] - prices[k];
    }

    return result;
  }
}
