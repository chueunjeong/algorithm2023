import java.util.Scanner;

public class J11720 {

  public static void main(String[] args) {
    //입력받기
    Scanner snr = new Scanner(System.in);
    String count = snr.nextLine();
    String numStr = snr.nextLine();

    //문자열 배열로 만들기
    char[] numbers = numStr.toCharArray();

    //배열 내 숫자 더하기
    int sum = 0;
    for (char num : numbers) {
      sum += Character.getNumericValue(num);
    }

    System.out.println(sum);
  }
}
