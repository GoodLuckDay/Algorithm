package 빈도정렬;

import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Pair<Integer,Integer>> map = new HashMap();
        int N = scanner.nextInt();
        int C = scanner.nextInt();

        for(int i=0; i<N; i++) {
            int number = scanner.nextInt();
            if (number <= C) {
                if (map.containsKey(number)) {
                    Pair pair = map.get(number);
                    map.replace(number, new Pair<Integer, Integer>((Integer) pair.getKey(), (Integer) pair.getValue() + 1));
                } else {
                    map.put(number, new Pair<>(i, 1));
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Pair<Integer,Integer> pair1 = map.get(o1);
                Pair<Integer,Integer> pair2 = map.get(o2);
                if(pair1.getValue() == pair2.getValue()){
                    return pair2.getKey().compareTo(pair1.getKey());
                }
                return pair1.getValue().compareTo(pair2.getValue());
            }
        });

        Collections.reverse(list);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            int temp = (int)iterator.next();
            for(int i=0; i< map.get(temp).getValue(); i++){
                System.out.print(temp+" ");
            }
        }
    }

}
