package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class J380 {

  public static void main(String[] args) {
    RandomizedSet randomizedSet = new RandomizedSet();
    System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
    System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
    System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
    System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
    System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
    System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
    System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
  }
}

class RandomizedSet {

  private HashMap<Integer, Boolean> hashMap;

  //주어진 숫자를 넣기위해 HashMap 초기화
  public RandomizedSet() {
    this.hashMap = new HashMap<Integer, Boolean>();
  }

  //putIfAbsent()은 해당 값이 없으면 null, 있으면 해당 값을 반환
  public boolean insert(int val) {
    return hashMap.putIfAbsent(val, true) == null ? true : false;
  }

  //remove()는 해당 값이 있으면 true, 없으면 null 반환
  public boolean remove(int val) {
    return hashMap.remove(val) != null ? true : false;
  }

  //0~(숫자 개수-1) 사이의 숫자를 랜덤으로 생성하여 그 인덱스에 해당하는 값 반환
  public int getRandom() {
    ArrayList<Integer> keySet = new ArrayList<>(hashMap.keySet());
    int randomNum = ThreadLocalRandom.current().nextInt(0, keySet.size());
    return keySet.get(randomNum);
  }
}
