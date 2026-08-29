class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;

        for (int pile: piles) {
            end = Math.max(end, pile);
        }

        int result = end;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if ( kokoCanFinish(piles, mid, h) ) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private boolean kokoCanFinish(int[] piles, int k, int h) {
        long totalHours = 0;

        for (int pile: piles) {
            totalHours += (long) (pile + k - 1) / k;
        }

        return totalHours <= h;
    }
}
