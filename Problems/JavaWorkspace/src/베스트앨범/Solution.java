package 베스트앨범;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{
                500, 600, 800, 800, 2500
        })));
    }

    private static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        boolean[] visited = new boolean[10001];
        PriorityQueue<Music> priorityQueue = new PriorityQueue<>();
        HashSet<String> hashSet = new HashSet<>();

        for(int i=0; i<genres.length; i++){
            if(!hashSet.contains(genres[i])) {
                Music music = new Music(genres[i], plays[i]);
                for (int j = i + 1; j < genres.length; j++) {
                    if(genres[i].equals(genres[j])){
                        music.play += plays[j];
                        music.updateRanking(plays[j]);
                    }
                }
                hashSet.add(genres[i]);
                priorityQueue.add(music);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while(!priorityQueue.isEmpty()){
            Music music = priorityQueue.poll();
            String gerne = music.genre;
            PriorityQueue<Integer> playQueue = music.ranking;
            int size = playQueue.size() < 2 ? playQueue.size() : 2;
            for(int k=0; k<size; k++){
                int play = playQueue.poll();

                for(int i=0; i<genres.length; i++){
                    if(!visited[i] && gerne.equals(genres[i]) && plays[i] == play){
                        arrayList.add(i);
                        visited[i] = true;
                        break;
                    }
                }
            }
        }

        answer = new int[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++){
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    static class Music implements Comparable{
        String genre;
        int play;
        PriorityQueue<Integer> ranking;

        Music(String genre, int play){
            this.genre = genre;
            this.play = play;
            this.ranking = new PriorityQueue<>(Collections.reverseOrder());
            ranking.add(play);
        }

        void updateRanking(int play){
            ranking.add(play);
        }


        @Override
        public int compareTo(Object o) {
            return -Integer.compare(this.play, ((Music) o).play);
        }
    }
}
