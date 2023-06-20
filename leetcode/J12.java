package leetcode;

public class J12 {

  public static void main(String[] args) {
    System.out.println(intToRoman(1994));
    System.out.println(intToRoman(58));
    System.out.println(intToRoman(27));
  }

  public static String intToRoman(int num) {
    StringBuilder stringBuilder = new StringBuilder("");

    int square = String.valueOf(num).length() - 1;
    int share;

    for (int i = square; i >= 0; i--) {
      share = (int) (num / Math.pow(10, i));
      num = (int) (num % Math.pow(10, i));

      //4나 9인 경우
      if (share % 5 == 4) {
        //100의 자리
        if (i == 2) {
          if (share / 5 == 1) stringBuilder.append(
            "CM"
          ); else stringBuilder.append("CD");
        }
        //10의 자리
        if (i == 1) {
          if (share / 5 == 1) stringBuilder.append(
            "XC"
          ); else stringBuilder.append("XL");
        }
        //1의 자리
        if (i == 0) {
          if (share / 5 == 1) stringBuilder.append(
            "IX"
          ); else stringBuilder.append("IV");
        }
        //그 외의 경우
      } else {
        //1000의 자리
        if (i == 3) stringBuilder.append("M".repeat(share));
        //100의 자리
        if (i == 2) stringBuilder.append(
          "D".repeat(share / 5) + "C".repeat(share % 5)
        );
        //10의 자리
        if (i == 1) stringBuilder.append(
          "L".repeat(share / 5) + "X".repeat(share % 5)
        );
        //1의 자리
        if (i == 0) stringBuilder.append(
          "V".repeat(share / 5) + "I".repeat(share % 5)
        );
      }
    }
    return stringBuilder.toString();
  }
}
