package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {

    //예외 상황
    public static int exceptionCase(List<Integer> page) {

        //시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
        for(int i = 0; i < page.size(); i++) {
            if (page.get(i) == 1 || page.get(i) == 400) {
                return -1;
            }
        }

        //페이지가 연속이 아니다.
        if (page.get(1) - page.get(0) != 1) {
            return -1;
        }

        return 0;
    }

    public static int addScore(int a){
        int add = 0;

        while(a != 0) {
            add += a%10;
            a = a/10;
        }

        return add;
    }

    public static int multipleScore(int a){
        int mul = 1;

        while(a != 0) {
            mul *= a%10;
            a = a/10;
        }

        return mul;
    }

    public static int maxScore(List<Integer> page) {

        int score = 0;
        List<Integer> allScore = new ArrayList<>();

        for(int i = 0; i < page.size(); i++) {
            allScore.add(addScore(page.get(i)));
            allScore.add(multipleScore(page.get(i)));
        }

        score =  Collections.max(allScore);
        return score;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (exceptionCase(pobi) == -1 || exceptionCase(crong) == -1){
            return -1;
        }

        if(maxScore(pobi) > maxScore(crong)) {
            return 1;
        }

        if(maxScore(pobi) < maxScore(crong)) {
            return 2;
        }

        return 0;
    }

}