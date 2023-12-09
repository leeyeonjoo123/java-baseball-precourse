package baseball;

import camp.nextstep.edu.missionutils.Console;

/*
코드 출처 : https://github.com/hosung-222/woowacourse-precourse-java-baseball-6
 */

//게임의 로직을 제어하고 상태를 관리
public class GameController {
    private static final int NUM_LENGTH = 3; //입력받을 숫자 길이 확인용
    private final RandomNumbers computer;
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public GameController() {
        computer = new RandomNumbers();
    }

    public void resetCnt() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public void addStrike() {
        strikeCnt++;
    }

    public void addBall() {
        ballCnt++;
    }


    public void startGame() {

        while(strikeCnt != 3) {
            resetCnt();
            String player = getPlayerInput();
            calculateResult(player);
            printResult(strikeCnt, ballCnt);
        }
    }
//    public String getPlayerInput() {
//        System.out.print("숫자를 입력해주세요 : ");
//        String input = Console.readLine();
//        if (input.length() != NUM_LENGTH) {
//            throw new IllegalArgumentException("입력 값 오류");
//        }
//        return input;
//    }


    public String getPlayerInput() {
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine(); //.readLine(); 은 콘솔에서 사용자로부터 한 줄을 읽어 오는 메소드이고, 사용자가 입력한 전체 문자열을 반환한다.

            if(input.length() != NUM_LENGTH) {
                System.out.println("입력값은 3자리여야 합니다. 다시 입력해주세요");
                continue;
            }
            return input;
        }
    }

    public void calculateResult(String input) {
        String[] player = input.split(""); //input.split("") ? 문자열을 문자 단위로 분리하는 java 코드
        for (int i = 0; i < NUM_LENGTH; i++) {
            if (computer.getNumber(i) == Integer.parseInt(player[i])) { // 그래서 Integer.parseInt로 문자열을 정수로 변환해서 비교 가능
                addStrike();        // 같은 위치에 같은 숫자인 경우 strike++
            } else if (computer.contains(Integer.parseInt(player[i]))) { //.contain은 특정 문자열을 포함하고 있는지 여부를 확인하는 메소드.. boolean을 반환
                addBall();          //다른 위치에 같은 숫자인 경우 ball++
            }


        }
    }

    //enum class 로 빼서 처리해보기 , if else 구문 최대한 줄이기
    public void printResult(int strikeCnt, int ballCnt) {
        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0) {
            System.out.println(ballCnt + "볼 ");
        } else if (ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else if (ballCnt > 0 && strikeCnt > 0) {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }
}




