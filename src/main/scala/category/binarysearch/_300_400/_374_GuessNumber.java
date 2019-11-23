package category.binarysearch._300_400;

/**
 * 374. Guess Number Higher or Lower
 */
public class _374_GuessNumber extends GuessGame {
    public int guessNumber(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int lo, int hi) {
        int mid = (lo + hi) >>> 1;
        if (guess(mid) == 0) {
            return mid;
        } else if (guess(mid) > 0) {
            return binarySearch(lo, mid);
        } else {
            return binarySearch(mid + 1, hi);
        }
    }
}