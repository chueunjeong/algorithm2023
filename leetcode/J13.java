package leetcode;

public class J13 {

  public static void main(String[] args) {
    String s1 = "III";
    String s2 = "LVIII";
    String s3 = "MCMXCIV";
    System.out.println(romanToInt(s2));
  }

  public static int romanToInt(String s) {
    int sum = 0;
    char[] numerals = s.toCharArray();

    for (int i = 0; i < numerals.length; i++) {
      //한 문자씩 읽기
      char numeral = numerals[i];
      //큰 수에서 작은 수 순서가 아닐경우 음수로 취급해야하므로
      int product = 1;
      switch (numeral) {
        //I-X-C일 경우 뒤의 값에 따라 음수로 취급한다.
        case 'I':
          if (
            i < numerals.length - 1 &&
            (numerals[i + 1] == 'V' || numerals[i + 1] == 'X')
          ) product = -1;
          product *= 1;
          break;
        case 'V':
          product *= 5;
          break;
        case 'X':
          if (
            i < numerals.length - 1 &&
            (numerals[i + 1] == 'L' || numerals[i + 1] == 'C')
          ) product = -1;
          product *= 10;
          break;
        case 'L':
          product *= 50;
          break;
        case 'C':
          if (
            i < numerals.length - 1 &&
            (numerals[i + 1] == 'D' || numerals[i + 1] == 'M')
          ) product = -1;
          product *= 100;
          break;
        case 'D':
          product *= 500;
          break;
        case 'M':
          product *= 1000;
          break;
      }
      sum += product;
    }
    return sum;
  }
}
