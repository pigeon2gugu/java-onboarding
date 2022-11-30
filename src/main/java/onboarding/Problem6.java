package onboarding;

import java.util.*;

public class Problem6 {


    //닉네임 두글자로 자르기
    public static List<String> slicedNickname(List<List<String>> forms) {
        List<String> nickname = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                nickname.add(forms.get(i).get(1).substring(j,j+2));
            }
        }

        return nickname;
    }

    //중복 문자 포함 검사
    public static List<String> duplicatedNicknameUser(List<List<String>> forms) {
        List<String> checkNickname = new ArrayList<>(slicedNickname(forms));
        List<String> warningUser = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            int cnt = 0;
            for (int j = 0; j < checkNickname.size(); j++) {
                String temp = checkNickname.get(j);
                cnt += (int) forms.get(i).stream()
                        .filter(c -> c.contains(temp))
                        .count();
            }

            //자기 자신의 문자열슬라이스 외의 것을 포함 할 때 (즉 중복)
            if(cnt > forms.get(i).get(1).length() -1) {
                warningUser.add(forms.get(i).get(0));
            }
        }

        //오름차순 정렬
        warningUser.sort(Comparator.naturalOrder());

        return warningUser;
    }
    public static List<String> solution(List<List<String>> forms) {
        return duplicatedNicknameUser(forms);
    }
}
