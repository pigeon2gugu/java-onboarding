package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {


    public static List<Integer> toBill(int money) {
        int[] bill = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] billCnt = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < bill.length; i++) {
            billCnt[i] = (int)(money/bill[i]);
            money = (int)(money%bill[i]);
        }


        //int[] -> Integer -> list
        return Arrays.stream(billCnt)
                .boxed()
                .collect(Collectors.toList());
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = toBill(money);
        return answer;
    }
}
