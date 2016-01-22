public class Solution {
    private double absPow(double x, int n) {

        double ret = x;

        if (0 == n)
            return 1;

        if (1 == n)
            return x;

        if (2 == n)
            return x * x;

        int i = 2;

        while (i < n/2) {

            ret = ret * ret;
            i = 2 * i;
            //System.out.println(i);
        }

        return ret * absPow(x, n - i);

/* First version of my code uses code like this, note that i = 2 * i overflows at some examples. It makes i = 0, then the program runs in dead loop.  

        while (i < n) {

            ret = ret * ret;
            i = 2 * i;
        }

        return ret * absPow(x, n - i/2);
*/

    }

    public double myPow(double x, int n) {

        if (n > 0)
            return absPow(x, n);
        else {
            return 1 / absPow(x, -1 * n);
        }

    }

    double power(double x, int n) {
        if (n == 0)
            return 1;
        double v = power(x, n / 2);
        if (n % 2 == 0)
            return v * v;
        else
            return v * v * x;
    }

    double pow(double x, int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n < 0)
            return 1.0 / power(x, -n);
        else
            return power(x, n);
    }

    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution();
        double base = 2.1;
        int p = 11;
        long startTime = System.currentTimeMillis();
        double a = s.myPow(base, p);
        //double a = 0;
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(a);
        System.out.println(estimatedTime);
        startTime = System.currentTimeMillis();
        double b = s.myPow(base, p);
        estimatedTime = System.currentTimeMillis() - startTime;
        // System.out.println(a);
        System.out.println(b);
        System.out.println(estimatedTime);
    }

}
