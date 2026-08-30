class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // if negative = true matlb negative ans aayega
        boolean negative = (dividend < 0) != (divisor < 0);

        long a = Math.abs ((long)dividend);
        long b = Math.abs ((long)divisor);

        long quotient = 0;

        while (a >= b) {

            long value = b;
            long cnt = 1;

            while (value + value <= a) {
                value += value;
                cnt += cnt;
            }

            a -= value;

            quotient += cnt;

        }

        if (negative) {
            quotient = -quotient;
        }

        return (int) quotient;
        
    }
}