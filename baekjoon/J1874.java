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

    //답변이 있는지 확인하는 변수
    boolean result = true;
    Integer N = 1;

    for (int num : nums) {
      //자연수가 현재 데이터보다 작을 경우
      if (num >= N) {
        //자연수가 현재 데이터만큼 커질때까지 스택에 값을 집어넣는다.
        while (num >= N) {
          stack.push(N++);
          stringBuffer.append("+\n");
        }
        //다 집어넣었으면 현재 데이터를 출력해야하므로 하나꺼낸다.
        stack.pop();
        stringBuffer.append("-\n");
        //자연수가 현재 데이터보다 클 경우
        //스택 상단에 있는 값을 꺼낸다.
        //꺼냈는데 꺼낸 값이 현재 데이터보다 클 경우 원하는대로 숫자값을 뽑을 수 없는 경우이기 때문에
        //반복문을 끝낸다.
      } else {
        int out = stack.pop();
        if (num < out) {
          result = false;
          System.out.println("NO");
          break;
        } else {
          stringBuffer.append("-\n");
        }
      }
    }
    if (result) System.out.println(stringBuffer.toString());
  }
}
