package week42;

/**
 * 191. Number of 1 Bits
 */
public class NumberOfOneBit {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /**
         * n                        = 3 2   1   0
         * ((n >>> 1) & 0x55555555) = x 3   x   1
         * result                   = x 2+3 x   0+1
         */
        n = n - ((n >>> 1) & 0x55555555);
        /**
         * (n & 0x33333333)             = x x   x   0+1
         * ((n >>> 2) & 0x33333333)     = x x   x   2+3
         * res                          = x x   x   0+1+2+3
         */
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        /**
         * n                                = x x   x   4+5+6+7 x   x   x   0+1+2+3
         * n>>>4                            = x x   x   x       x   x   x   4+5+6+7
         * (n + (n >>> 4)) & 0x0f0f0f0f     = x x   x   x       x   x   x   0->7
         */
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        /**
         * n                                = x x   5+7 4+6-5-7 x   x   1+3+5+7 0+2+4+6-1-3-5-7
         * n>>>8                            = x x   x   x       x   x   5+7     4+6-5-7
         * result                           = x x   5+7 4+6-5-7 x   x   1+3+5+7 0+2+4+6-1-3-5-7
         */
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }
}