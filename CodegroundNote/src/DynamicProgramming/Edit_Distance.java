package DynamicProgramming;
import java.util.*;
import java.lang.*;

public class Edit_Distance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int la = scanner.nextInt();
        int lb = scanner.nextInt();

        String a = scanner.next();
        String b = scanner.next();

        int d[][] = new int[la+1][lb+1];
        for(int i=1; i<=la; i++){
            d[i][0] = i;
        }

        for(int j=1; j<=lb; j++){
            d[0][j] = j;
        }

        for(int i=1; i<=la; i++){
            for(int j=1; j<=lb; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    d[i][j] = d[i-1][j-1];
                }
                else{
                    d[i][j] = Math.min(Math.min(d[i-1][j],d[i][j-1]), d[i-1][j-1])+1;
                }
            }
        }
        System.out.println(d[la][lb]);
    }
}
