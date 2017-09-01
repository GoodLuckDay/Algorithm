package 단어공부;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Character,Integer> hashMap = new HashMap<>();
        String str = scanner.nextLine();
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        for(int i=0; i<str.length(); i++){
            if(hashMap.containsKey(chars[i])){
                int temp = hashMap.get(chars[i]);
                hashMap.replace(chars[i],temp+1);
            }
            else{
                hashMap.put(chars[i],1);
            }
        }
        int maxCount = -1;
        char maxChar = ' ';
        boolean multi = false;
        for(Character key : hashMap.keySet()){
            if(maxCount < hashMap.get(key)){
                maxCount = hashMap.get(key);
                maxChar = key;
                multi = false;
            }
            else if(maxCount == hashMap.get(key)){
                multi = true;
            }
        }
        if(multi){
            System.out.println('?');
        }
        else{
            System.out.println(Character.toUpperCase(maxChar));
        }
    }
}

