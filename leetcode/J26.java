package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J26 {

  public static void main(String[] args) {
    int[] arr1 = { 1, 1, 2 };
    int[] arr2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    int[] arr3 = { 1 };
    System.out.println(removeDuplicates(arr3));
  }

  public static int removeDuplicates(int[] nums) {
    //nums 복제
    int[] numsCopy = nums.clone();

    //유니크한 값들을 저장할 list
    List<Integer> list = new ArrayList<Integer>();

    //nums를 순회하면서 유니크하면 list에 저장하고 아니면 continue
    for (int num : numsCopy) {
      if (!list.contains(num)) {
        list.add(num);
      } else continue;
    }

    //저장한 list를 nums에 차곡차곡 넣어주기
    for (int i = 0; i < list.size(); i++) {
      nums[i] = list.get(i);
    }

    //다 넣었는데도 나머지 공간이 남았으면 101 넣어주기
    if (nums.length - list.size() > 0) {
      Arrays.fill(nums, list.size(), nums.length, 101);
    }

    return list.size();
  }
}
