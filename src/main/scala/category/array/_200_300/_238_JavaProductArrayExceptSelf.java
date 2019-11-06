package category.array._200_300;

/**
 * 238. Product of Array Except Self
 * use java solution
 */
class _238_JavaProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            ans[i] = nums[i + 1] * ans[i];
            nums[i] = nums[i] * nums[i + 1];
        }
        return ans;
    }
}