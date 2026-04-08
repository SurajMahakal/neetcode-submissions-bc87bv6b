class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int prevPrice = prices[0];
        for(int price: prices){
            prevPrice = Math.min(prevPrice, price);
            maxProfit = Math.max(maxProfit, price - prevPrice);
        }

        return maxProfit;
    }
}
