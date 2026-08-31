// package bitwise;

public class bitwiseOperations {

    public static int bitwiseAnd(int x,int y){
        int ans = ~ ( (~x) | (~y) );
        return ans;
    }

    public static int bitwiseXor(int x,int y){
        int ans = ~ ( ~(~x & y) & ~(x & ~y) );
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(bitwiseXor(0, 1));
    }
}
