package onboarding;

public class Problem3 {

    //하나의 문자열로 합친다.
    public static String mergedNum(int number) {
        String merge = "";

        for (int i =1 ; i <= number; i++) {
            merge += String.valueOf(i);
        }

        return merge;
    }

    //합쳐진 문자열에서 3, 6, 9의 포함 개수 대로 박수 친다.
    public static int clapNum(String numbers) {
        int cnt = 0;
        for(int i = 0; i < numbers.length(); i++) {
            String index = Character.toString(numbers.charAt(i));
            if( index.equals("3") || index.equals("6") || index.equals("9")) {
                cnt ++;
            }
        }

        return cnt;
    }
    public static int solution(int number) {

        int answer = clapNum(mergedNum(number));
        return answer;
    }
}
