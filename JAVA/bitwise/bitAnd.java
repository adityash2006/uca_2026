// package bitwise;

public class bitAnd {

    public static int bitwiseAnd(int x,int y){
        int ans = ~ ( (~x) | (~y) );
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(bitwiseAnd(3, 3));
    }
}
