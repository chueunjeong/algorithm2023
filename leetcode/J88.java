package leetcode;

import java.util.Arrays;

public class J88 {

  public static void main(String[] args) {
    // int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    // int m = 3;
    // int[] nums2 = { 2, 5, 6 };
    // int n = 3;

    int[] nums1 = { 1 };
    int m = 1;
    int[] nums2 = {};
    int n = 0;
    merge(nums1, m, nums2, n);
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    //실제 값이 있는 부분만 따로 뽑기
    int[] nums1Copy = Arrays.copyOf(nums1, m);

    //각각 num1cody, nums2, nums1의 인덱스를 기록할 변수
    int n1Index = 0, n2Index = 0, i = 0;

    //nums1copy와 num2 중 하나가 다 읽어질 때까지
    while (n2Index < nums2.length && n1Index < nums1Copy.length) {
      //각각 현재 인덱스의 위치해서 하나씩 값을 뽑았을 때
      //nums1Copy가 작으면 nums1의 값을, nums2의 값이 작으면 nums2의 값을 nums1에 처음부터 차곡차곡 넣는다.
      if (nums1Copy[n1Index] <= nums2[n2Index]) {
        nums1[i] = nums1Copy[n1Index++];
      } else {
        nums1[i] = nums2[n2Index++];
      }
      i++;
    }

    //위의 반복문이 끝났다면 둘중 한쪽만 데이터가 남는 경우이다.
    //이때 남은 데이터를 털어서 nums1에 넣으면 된다.
    if (n2Index < nums2.length) {
      for (; i < nums1.length; i++) {
        nums1[i] = nums2[n2Index++];
      }
    }
    if (n1Index < nums1Copy.length) {
      for (; i < nums1.length; i++) {
        nums1[i] = nums1Copy[n1Index++];
      }
    }
  }
}
