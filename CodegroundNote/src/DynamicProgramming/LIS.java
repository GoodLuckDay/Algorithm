package DynamicProgramming;
import java.util.*;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int[] d = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(a[j] < a[i]){
                    if(d[i] < d[j]){
                        d[i] = d[j];
                    }
                }
            }
            d[i]++;
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            if(ans < d[i]){
                ans = d[i];
            }
        }
        System.out.println(ans);
    }
}
