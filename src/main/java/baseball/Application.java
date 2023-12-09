package baseball;

import camp.nextstep.edu.missionutils.Console;


/*
코드 출처 : https://github.com/hosung-222/woowacourse-precourse-java-baseball-6
 */
public class Application {
    private static final int RESTART_OPTION = 1;
    private static final int EXIT_OPTION = 2;

    public static void main(String[] args) {

        //게임시작, 게임종료
        while (true) { //(코드 수정 필요)Conditional break inside loop
            System.out.println("숫자 야구 게임을 시작합니다");
            GameController game = new GameController(); //GameController 클래스로 game 객체를 만든다
            game.startGame(); //game객체의 startGame 메소드 실행
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

//            int nextGame = askNextGame(); //nextGame 이라는 변수에 askNextGame 을 집어넣어라 1or 2 값을 말하는 건가?
            if(askNextGame()) {
                break; //오 맞네 2 라면 게임 종료
            }
        }
    }


    // 게임 진행 여부 확인
    private static boolean askNextGame() {
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요");
        int nextGame = Integer.parseInt(Console.readLine()); //user가 console에 입력한 값을 nextGame 변수에 저장
        if (nextGame != RESTART_OPTION && nextGame != EXIT_OPTION) { // 오 user가 입력한 값이 1도 아니고 2도 아니라면 오.. 이렇게도 코드를 쓰구나
            throw new IllegalArgumentException("입력 오류");
        }
        return nextGame == EXIT_OPTION;
    }
}



