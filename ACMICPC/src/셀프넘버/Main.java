package 셀프넘버;

public class Main {
    public static void main(String[] args) {
        boolean[] selfNum = new boolean[10001];
        for(int i=1; i<selfNum.length; i++){
            int temp = i;
            int result = 0;
            while(temp > 0){
                result += temp%10;
                temp = temp / 10;
            }
            int index = result + i;
            if(index < selfNum.length){
                selfNum[index] = true;
            }
        }
        for(int i=1; i<selfNum.length; i++){
            if(!selfNum[i])
                System.out.println(i);
        }
    }
}
