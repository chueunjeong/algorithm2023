package leetcode;

import java.util.Arrays;

public class J80 {

  public static void main(String[] args) {
    int[] arr1 = { 1, 1, 1, 2, 2, 3 };
    int[] arr2 = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
    System.out.println(removeDuplicates(arr1));
  }

  public static int removeDuplicates(int[] nums) {
    int[] numsCopy = nums.clone();

    //nums의 길이가 1일 경우 바로 1로 리턴
    if (nums.length == 1) return 1;

    //최대2번 중복된 데이터를 계산하기 위한 변수
    int atMostTwice = 1;
    //데이터를 차곡차곡 넣기 위한 변수
    int numsIndex = 1;
    //nums의 길이가 2이상인 경우 첫번째 값을 건들일 필요가 없기 때문에
    //2번째 값부터 시작
    for (int i = 1; i < numsCopy.length; i++) {
      //이전 값이랑 비교했을 때, 같은 값이면
      if (numsCopy[i - 1] == numsCopy[i]) {
        //2번 반복되기 전이면 값넣고 몇번 반복된 지 기록하기
        if (atMostTwice < 2) {
          nums[numsIndex++] = numsCopy[i];
          atMostTwice++;
        } else continue; //2번 초과로 반복됐으면 넘어가기
      } else {
        //이전 값이랑 비교했을 때, 다른 값이면
        //nums에 해당 값을 넣고, 그리고 중복검사 변수를 초기화
        nums[numsIndex++] = numsCopy[i];
        atMostTwice = 1;
      }
    }

    //데이터를 다 넣고 남는 공간이 있으면 다른 값 넣기
    if (numsIndex < nums.length) {
      for (int i = numsIndex; i < nums.length; i++) {
        nums[i] = -1;
      }
    }
    return numsIndex;
  }
}
