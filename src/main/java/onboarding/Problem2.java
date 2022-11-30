package onboarding;
import java.util.Stack;

public class Problem2 {

    public static String duplication(String text) {
        Stack<String> stack = new Stack<>();
        stack.add(text.split("")[0]);

        for(int i = 1; i < text.length(); i++) {

            //앞의 문자와 중복되지 않을 경우 넣어준다.
            if(!stack.peek().equals(text.split("")[i])) {
                stack.add(text.split("")[i]);
            } else { //중복되면 앞의 중복 문자도 지워준다.
                stack.pop();
            }

        }

        String answer = "";

        while(stack.size() > 0) {
            answer = stack.pop() + answer;
        }

        System.out.println(answer);
        return answer;
    }
    public static String solution(String cryptogram) {
        String answer = duplication(cryptogram);
        return answer;
    }

}
