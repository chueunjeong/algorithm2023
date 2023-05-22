package leetcode;

public class J55 {

  public static void main(String[] args) {
    int[] arr1 = { 2, 3, 1, 1, 4 };
    int[] arr2 = { 3, 2, 1, 0, 4 };
    int[] arr3 = { 3, 2, 0, 1, 4 };
    int[] arr4 = { 0, 2, 3 };
    System.out.println(canJump(arr4));
  }

  public static boolean canJump(int[] nums) {
    //결과를 기록할 변수
    boolean result = true;

    //앞으로 나갈 에너지가 얼마나 남았는지 알려주는 변수
    int jumpEnergy = nums[0];

    //마지막에 도달하기 직전까지 남은 에너지 계산하기
    for (int i = 0; i < nums.length - 1; i++) {
      //마지막에 도달하기 전에 혹시 에너지가 고갈됐다면 false
      if (jumpEnergy < 0) {
        result = false;
        break;
      }
      //시작점을 제외하고,
      //그전까지 남은 에너지와 현재 새로 채울 수 있는 에너지를 비교해서
      //더 큰 수를 에너지로 채운다.
      if (i > 0) if (jumpEnergy <= nums[i]) jumpEnergy = nums[i];
      //이동할 때마다 에너지는 1개씩 소멸된다.
      jumpEnergy--;
    }
    //마지막 지점에서 에너지양을 확인했을 때,
    //0이면 딱 떨어지게 도착하는 것인데 음수이면 갈 에너지가 없는 것이기 때문에 false
    if (jumpEnergy < 0) result = false;
    return result;
  }
}
