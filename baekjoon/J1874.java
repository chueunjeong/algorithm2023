import java.util.Scanner;
import java.util.Stack;

public class J1874 {

  public static void main(String[] args) {
    //입력받기
    Scanner snr = new Scanner(System.in);
    int count = snr.nextInt();
    int[] nums = new int[count];

    for (int i = 0; i < count; i++) {
      nums[i] = snr.nextInt();
    }

    Stack<Integer> stack = new Stack<>();
    StringBuffer stringBuffer = new StringBuffer();

    Integer N = 1;

    for (int num : nums) {
      if ((num >= N)) {
        while (num >= N) {
          stack.push(N++);
          stringBuffer.append("+\n");
        }
        stack.pop();
        stringBuffer.append("-\n");
      } else {
        int out = stack.pop();
        if (num < out) return "NO";
      }
    }
    return stringBuffer.toString();
  }
}
