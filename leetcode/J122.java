package leetcode;

public class J122 {

  public static void main(String[] args) {
    int[] arr1 = { 7, 1, 5, 3, 6, 4 };
    int[] arr2 = { 1, 2, 3, 4, 5 };
    int[] arr3 = { 7, 6, 4, 3, 1 };
    int[] arr4 = { 1, 9, 7, 1, 9, 7 };
    int[] arr5 = { 1, 3, 7, 1, 3, 7 };
    System.out.println(maxProfit(arr5));
  }

  public static int maxProfit(int[] prices) {
    int profits = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      int profit = prices[i + 1] - prices[i];
      if (profit > 0) profits += profit;
    }
    return profits;
  }
}
