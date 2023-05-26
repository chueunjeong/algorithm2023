package leetcode;

import java.util.Arrays;

public class J45 {

  public static void main(String[] args) {
    int[] arr1 = { 2, 3, 1, 1, 4 };
    int[] arr2 = { 2, 3, 0, 1, 4 };
    int[] arr3 = { 5, 1, 1 };
    int[] arr4 = { 3, 2, 0, 1, 4 };
    int[] arr5 = { 1, 1, 4, 2, 3, 1 };
    int[] arr6 = { 2, 0, 1, 4 };
    int[] arr7 = { 3, 0, 0, 7 };
    int[] arr8 = { 4, 1, 1, 3, 1, 1, 1 };
    int[] arr9 = { 0 };
    int[] arr10 = { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
    System.out.println(jump(arr8));
  }

  public static int jump(int[] nums) {
    if (nums.length == 1) return 0;
    //각 지점마다 최소 이동 횟수를 저장하는 배열
    int[] arr = new int[nums.length];
    //계속 반복문을 돌 지 결정해주는 변수
    boolean check = false;

    for (int i = 0; i < nums.length; i++) {
      //현재 값에서 최소~최대로 접근할 수 있는 범위
      for (int k = i + 1; k <= i + nums[i]; k++) {
        //이미 값이 들어가있다면
        //이미 최소 이동으로 그 지점에 접근할 수 있다는 뜻이므로
        //넘어간다.
        if (arr[k] != 0); else {
          //현재시점에서 또 한 칸 넘어갈 것이기 때문에
          //현재 시점의 이동 수+1
          arr[k] = arr[i] + 1;
        }
        //이동 중 마지막 지점에 도착한 다면 반복문 나오기
        if (k == nums.length - 1) {
          check = true;
          break;
        }
      }
      if (check) break;
    }
    return arr[nums.length - 1];
  }
}
