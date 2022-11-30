package onboarding;

public class Problem4 {


    public static String toFrogAlphabet(String text) {
        char frogtext;
        char alphabet = text.charAt(0);

        //z과 떨어져 있는 거리로 바꾼다.
        if (alphabet >= 'A' && alphabet <= 'Z') {
            frogtext = (char) ('A' + Math.abs(alphabet - 'Z')) ;
            return String.valueOf(frogtext);
        }
        if( alphabet >= 'a' && alphabet <= 'z') {
            frogtext = (char) ('a' + Math.abs(alphabet - 'z')) ;
            return String.valueOf(frogtext);
        }

        return text;

    }
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++) {
            answer = answer + toFrogAlphabet(word.split("")[i]);
        }

        return answer;
    }

}
