// package JAVA;

public class Fibbo {
    public static int evenSumFibboOpt(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 2;

        // there is a even number relation in fibbonacci series which says F^n=4*F^n-1 +
        // F^n-2
        int sum = 2;
        int a = 2;
        int b = 8;

        while (b <= n) {
            sum += b;
            int neweven = 4 * b + a;
            a = b;
            b = neweven;
        }

        return sum;
    }

    public static int evenSumOnBrute(int n) {
        if (n < 2)
            return 0;
        int a = 0;
        int b = 1;
        int sum = 0;
        int ans = 0;
        while (b <= n) {

            sum = a + b;
            if (sum % 2 == 0 && sum < n) {
                ans += sum;
            }
            a = b;
            b = sum;
        }
        return ans;
    }

    public static void main(String[] args) {

        int ans = evenSumOnBrute(13); // brute force
        int ans2 = evenSumFibboOpt(34); // log n Approach

    }
}
