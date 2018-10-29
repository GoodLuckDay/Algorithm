package 완주하지못한선수;

import java.util.HashMap;

class Main {

    public static void main(String[] args) {
        String value = solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden","kiki"});
        System.out.println(value);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String aParticipant : participant){
            if(hashMap.getOrDefault(aParticipant, null) == null){
                hashMap.put(aParticipant, 1);
            }
            else{
                hashMap.replace(aParticipant, hashMap.get(aParticipant)+1);
            }
        }

        for (String aCompletion : completion) {
            if(hashMap.containsKey(aCompletion)){
                if(hashMap.get(aCompletion) > 1){
                    hashMap.replace(aCompletion, hashMap.get(aCompletion)-1);
                }
                else if(hashMap.get(aCompletion) == 1){
                    hashMap.remove(aCompletion);
                }
            }
        }
        answer = (String) hashMap.keySet().toArray()[0];

        return answer;
    }
}
