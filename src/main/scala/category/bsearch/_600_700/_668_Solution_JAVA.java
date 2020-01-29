/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.bsearch._600_700;

/**
 * @author tang
 * @version : _668_Solution_JAVA.java, v 0.1 2020年01月26日 18:01 tang Exp $
 */
public class _668_Solution_JAVA {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int cnt = 0;
            for (int i = 1, j = n; i <= m; i++) {
                while (j >= 1 && i * j > mid) { j--; }
                cnt += j;
            }
            if (cnt < k) { lo = mid + 1; } else { hi = mid; }
        }
        return lo;
    }
}