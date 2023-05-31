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

    //미리 그 지점에서 획득량-소요량을 계산해둔다.
    for (int i = 0; i < gas.length; i++) {
      movePrices[i] = gas[i] - cost[i];
    }

    //총 획득량-총 소요량을 저장
    int total = 0;
    //시작점 기록
    int answer = 0;
    //각 시작점에 남은 가스량 기록
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
    //맞는 시작지점이면 다시 시작하지 않고 가스를 가지고 있기때문에, total에 더해줘
    //total이 음수인지 확인한다.
    //음수이면 반복문을 다 돌아도 가스가 부족한 상황이다.
    total += sum;
    return total < 0 ? -1 : answer;
  }
}
