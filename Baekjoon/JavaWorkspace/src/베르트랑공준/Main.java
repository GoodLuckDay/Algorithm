package 베르트랑공준;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        while((N = scanner.nextInt()) != 0){
            int count = 0;
            for(int i=N+1; i<=2*N; i++) {
                if (isdecimal(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isdecimal(int number){
        if(number == 2)
            return true;
        else if(number == 1 || number%2 == 0)
            return false;
        for(int i=3; i<=Math.sqrt(number); i=i+2){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
