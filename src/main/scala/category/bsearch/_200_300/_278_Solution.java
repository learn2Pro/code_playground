package category.bsearch._200_300;

/**
 * 278. First Bad Version
 */
public class _278_Solution implements VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (isBadVersion(mid) && (mid == 1 || !isBadVersion(mid - 1))) {
                return mid;
            } else if (isBadVersion(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return 0;
    }

    @Override
    public boolean isBadVersion(int version) {
        return false;
    }
}