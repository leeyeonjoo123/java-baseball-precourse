package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/*
코드 출처 : https://github.com/hosung-222/woowacourse-precourse-java-baseball-6
 */

//랜덤숫자 생성
public class RandomNumbers {
    private static final int NUMBER_LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private final List<Integer> numbers = new ArrayList<>();

    public RandomNumbers() {
        generateRandomNumbers();
    }

    public void generateRandomNumbers() {
        while (numbers.size() < NUMBER_LENGTH) {
            int n = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            validationAdd(n); //숫자 검증
        }
    }

    public void validationAdd(Integer number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }
}
