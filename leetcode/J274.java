package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class J274 {

  public static void main(String[] args) {
    int[] arr1 = { 3, 0, 6, 1, 5 };
    int[] arr2 = { 10, 8, 5, 4, 3 };
    int[] arr3 = { 25, 8, 5, 3, 3 };
    int[] arr4 = { 2 };
    System.out.println(hIndex(arr4));
  }

  public static int hIndex(int[] citations) {
    int hIndex = 0;

    //내림차순 정렬
    Integer[] citatioIntegers = Arrays
      .stream(citations)
      .boxed()
      .toArray(Integer[]::new);
    Arrays.sort(citatioIntegers, Collections.reverseOrder());

    //최대 hIndex 값이 total paper 수이기 때문에
    //1~총 페이퍼 수 순회
    for (int i = 1; i <= citations.length; i++) {
      //중간에 빠져나오는지 확인하는 변수
      Boolean check = false;
      //h만큼 만족하는 지만 확인하면 되기 때문에
      //arr Index 0~(h-1)만큼 만족하는 지 확인
      //내림차순한 상태이기 때문에, 딱 h만큼 해당되는 지 확인 가능
      for (int k = 0; k < i; k++) {
        //순회를 돌면서 해당 인용 수가 h보다 적으면 빠져나옴
        if (i > citatioIntegers[k]) {
          check = true;
          break;
        }
      }
      //중간에 빠져나오게 되면 해당 h를 만족하지 못한 경우이기 때문에
      //그 전의 h까지만 만족한 것
      //중간에 빠져나오지 않으면 해당 h는 만족하게 된 상태.
      if (check) {
        hIndex = i - 1;
        break;
      } else hIndex = i;
    }

    return hIndex;
  }
}
