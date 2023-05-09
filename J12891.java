import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J12891 {

  //최소 개수들(A/C/G/T)
  static int[] minArr = new int[4];
  //현재 슬라이딩의 문자열 개수를 저장할 변수
  static int[] nowArr = new int[4];
  //슬라이딩 부분이 해당 최소개수들 4개의 조건을 만족하는지 확인하는 변수
  //값이 4가 되면 4개의 문자의 조건이 맞는 경우로 결과에 추가된다.
  static int checkPWOption = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );

    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
    //DNA 문자열 길이, 부분 문자열 길이 입력받기
    int LENGTH = Integer.parseInt(st.nextToken());
    int SUBSTR_LENGTH = Integer.parseInt(st.nextToken());
    //DNA 문자열
    char[] DNA_ARR = bufferedReader.readLine().toCharArray();

    st = new StringTokenizer(bufferedReader.readLine());
    for (int i = 0; i < minArr.length; i++) {
      minArr[i] = Integer.parseInt(st.nextToken());
      //0이면 요구조건을 맞출 필요가 없이 일단 만족이기 때문에
      if (minArr[i] == 0) checkPWOption++;
    }

    //첫번째 슬라이딩 부분의 문자열 넣기
    for (int i = 0; i < SUBSTR_LENGTH; i++) {
      Add(DNA_ARR[i]);
    }
  }

  //현재 슬라이딩
  private static void Add(char c) {
    switch (c) {
      case 'A':
        nowArr[0]++;
        if (minArr[0] == nowArr[0]) checkPWOption++;
        break;
      case 'C':
        nowArr[1]++;
        if (minArr[1] == nowArr[1]) checkPWOption++;
        break;
      case 'G':
        nowArr[2]++;
        if (minArr[2] == nowArr[2]) checkPWOption++;
        break;
      case 'T':
        nowArr[3]++;
        if (minArr[3] == nowArr[3]) checkPWOption++;
        break;
    }
  }
}
