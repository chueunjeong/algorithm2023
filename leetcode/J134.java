package leetcode;

import java.util.Arrays;

public class J134 {

  public static void main(String[] args) {
    int[] gas1 = { 1, 2, 3, 4, 5 };
    int[] cost1 = { 3, 4, 5, 1, 2 };
    int[] gas2 = { 2, 3, 4 };
    int[] cost2 = { 3, 4, 3 };
    int[] gas3 = { 4, 5, 2, 6, 5, 3 };
    int[] cost3 = { 3, 2, 7, 3, 2, 9 };

    System.out.println(canCompleteCircuit(gas3, cost3));
  }

  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int[] movePrices = new int[gas.length];

    for (int i = 0; i < gas.length; i++) {
      movePrices[i] = gas[i] - cost[i];
    }

    int total = 0;
    int answer = 0;
    int sum = 0;
    for (int k = 0; k < movePrices.length; k++) {
      sum += movePrices[k % movePrices.length];

      //남은 연료가 음수면 시작점을 다음 점으로 둔다.
      if (sum < 0) {
        //총합이 음수이면 결국 이동하지 못하는 경우이므로 계산해둔다.
        total += sum;
        //다시 시작하기
        sum = 0;
        //시작점을 다음 가스 주유소로 둔다.
        answer = k + 1;
      }
    }
    total += sum;
    System.out.println(total);
    return total < 0 ? -1 : answer;
  }
}
