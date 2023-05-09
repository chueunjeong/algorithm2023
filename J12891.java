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
    //결과 값
    int result = 0;

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
    if (checkPWOption == 4) result++;
    //이제 슬라이드를 한칸씩 이동하면서 조사
    for (int k = SUBSTR_LENGTH; k < LENGTH; k++) {
      //이동 전 이전 시작부분
      int prior = k - SUBSTR_LENGTH;
      //이동하면서 새롭게 추가된 부분
      int newpart = k;
      Add(DNA_ARR[newpart]);
      Remove(DNA_ARR[prior]);
      if (checkPWOption == 4) result++;
    }

    System.out.println(result);
    bufferedReader.close();
  }

  //현재 슬라이딩에 대해 값을 더할 부분
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

  //옮기면서 이전부분을 삭제
  private static void Remove(char c) {
    switch (c) {
      case 'A':
        //이전 슬라이드가 조건에 딱 맞았다면 지금 문자를 빼면서 그 조건에 안맞게 되기 때문에
        if (minArr[0] == nowArr[0]) checkPWOption--;
        nowArr[0]--;
        break;
      case 'C':
        if (minArr[1] == nowArr[1]) checkPWOption--;
        nowArr[1]--;
        break;
      case 'G':
        if (minArr[2] == nowArr[2]) checkPWOption--;
        nowArr[2]--;
        break;
      case 'T':
        if (minArr[3] == nowArr[3]) checkPWOption--;
        nowArr[3]--;
        break;
    }
  }
}
