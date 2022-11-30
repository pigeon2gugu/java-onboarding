package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> friendsWithMe(String user, List<List<String>> friends) {
        HashSet<String> friend = new HashSet<>();

        for(int i = 0; i <  friends.size(); i++) {
            if(friends.get(i).contains(user)) {
                friend.add(friends.get(i).get(0));
                friend.add(friends.get(i).get(1));
            }
        }

        //자기 자신 제거
        friend.remove(user);

        //list형태로 return
        return new ArrayList<>(friend);

    }

    public static List<String> allMember(String user, List<List<String>> friends, List<String> visitors) {

        HashSet<String> members = new HashSet<>();
        List<String> alreadyFriends = friendsWithMe(user, friends);

        //모든 멤버에 친구목록 추가
        for(int i = 0; i < friends.size(); i++) {
            for(int j = 0; j < friends.get(i).size(); j++) {
                members.add(friends.get(i).get(j));
            }
        }

        //모든 멤버에 방문자 추가
        for(String i : visitors) {
            members.add(i);
        }

        //본인 제거
        members.remove(user);

        //이미 친구 제거
        for(String i : alreadyFriends) {
            members.remove(i);
        }

        //오름차순 정렬
        List<String> forReturnMembers = new ArrayList<>(members);
        forReturnMembers.sort(Comparator.naturalOrder());

        return forReturnMembers;
    }

    public static int addFriendScore(List<String> memberFriends, String userFriend) {

        int cnt = (int) memberFriends.stream()
                .filter(c -> c.contains(userFriend))
                .count();

        return cnt;
    }

    public static int addVisitorScore(String member, List<String> visitors) {

        int cnt = 0;
        cnt += (int) visitors.stream()
                .filter(c -> c.contains(member))
                .count();

        return cnt;
    }

    //top5숫자 출력
    public static List<Integer> top5Score(int[] score) {
        List<Integer> sortedScore = Arrays.stream(score)
                .boxed()
                .collect(Collectors.toList());


        //내림차순 정렬
        sortedScore.sort(Comparator.reverseOrder());

        List<Integer> topScores = new ArrayList<>();

        //전체 추천 member수가 5명 미만일때
        if(sortedScore.size() < 5) {
            for(int i = 0; i < sortedScore.size(); i ++) {
                topScores.add(sortedScore.get(i));
            }

            return topScores;
        }

        for(int i = 0; i < 5; i++) {
            topScores.add(sortedScore.get(i));
        }

        return topScores;
    }

    public static String satisfyingMemberAdd(HashMap<String, Integer> membersWithScore, int memberScore) {

        String member = membersWithScore.entrySet().stream()
                .filter(e -> e.getValue() == memberScore && e.getValue() > 0)
                .map(e->e.getKey().toString())
                .findFirst()
                .map(Object::toString)
                .orElse("");


        membersWithScore.remove(member);
        return member;
    }
    public static List<String> recommendedMember(String user, List<List<String>> friends, List<String> visitors) {
        List<String> members = allMember(user, friends, visitors);
        List<String> myFriends = friendsWithMe(user, friends);
        //중복 제거 후 리스트형태로

        //점수 빈 array
        int[] score = new int[members.size()];

        //연관 친구 점수
        for(int i = 0; i < members.size(); i++) {
            List<String> friendsWithMember = friendsWithMe(members.get(i), friends);
            for(int j = 0; j < myFriends.size(); j++) {
                score[i] += addFriendScore(friendsWithMember, myFriends.get(j))*10;
            }
        }

        //방문자 점수
        for(int i = 0; i < members.size(); i++) {
            score[i] += addVisitorScore(members.get(i), visitors);
        }

        List<Integer> standardScore = top5Score(score);


        //hashMap으로 name, score 묶기
        HashMap<String, Integer> memberWithScore = new HashMap<>();

        //추천리스트
        List<String> top5Members =  new ArrayList<>();

        for(int i = 0; i < members.size(); i++) {
            memberWithScore.put(members.get(i), score[i]);
        }

        for(int j = 0; j < standardScore.size(); j++) {
                top5Members.add(satisfyingMemberAdd(memberWithScore, standardScore.get(j)));
        }

        return top5Members;

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = recommendedMember(user, friends, visitors);
        return answer;
    }
}
