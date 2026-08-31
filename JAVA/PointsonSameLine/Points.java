import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();

            int duplicates = 0;
            int max = 0;

            for (int j = i + 1; j < n; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Same point
                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                double slope;

                // Vertical line
                if (dx == 0) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    slope = (double) dy / dx;
                }

                int count = map.getOrDefault(slope, 0) + 1;
                map.put(slope, count);

                max = Math.max(max, count);
            }

            ans = Math.max(ans, max + duplicates + 1);
        }

        return ans;
    }
}


class Solution2 {
    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();

            int duplicates = 0;
            int maxSlope = 0;

            for (int j = i + 1; j < n; j++) {
                long dx = (long) points[j][0] - points[i][0];
                long dy = (long) points[j][1] - points[i][1];

                // Same point
                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                // Reduce the slope using GCD
                long gcd = gcd(Math.abs(dx), Math.abs(dy));

                dx /= gcd;
                dy /= gcd;

                // Keep only one representation for a slope
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                String slope = dy + "/" + dx;

                int count = map.getOrDefault(slope, 0) + 1;
                map.put(slope, count);

                maxSlope = Math.max(maxSlope, count);
            }

            // +1 for the current point
            // +duplicates for identical points
            answer = Math.max(answer, maxSlope + duplicates + 1);
        }

        return answer;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}