package leetcode;

import java.util.HashMap;
import java.util.Map;

public class J169 {

  public static void main(String[] args) {
    int[] arr1 = { 3, 2, 3 };
    int[] arr2 = { 2, 2, 1, 1, 1, 2, 2 };
    System.out.println(majorityElement(arr1));
  }

  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    //각 숫자마다 몇번 나왔는지 저장
    for (int n : nums) {
      if (!map.containsKey(n)) map.put(n, 1); else map.put(n, map.get(n) + 1);
    }

    //결과를 반환할 변수와 최대값을 비교할 변수 선언
    int result = 0, max = 0;
    //위에서 저장한 숫자들을 비교해서 최대값을 구한다.
    for (int key : map.keySet()) {
      if (max < map.get(key)) {
        max = map.get(key);
        result = key;
      }
    }

    return result;
  }
}
