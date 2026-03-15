public class leetcode122
{
    public static void main(String[] args) {
        
    }

    public static int buyNSellStocks2(int []prices)
    {
        int profit = 0;
        for(int i=0; i<prices.length; i++)
        {
            if(Buy(i, prices, 0))
            {
                Sell(i, prices, profit);
            }
        }
        return -1;
    }
    private static boolean Buy(int day, int[] prices, int boughtDay)
    {
        while(prices[day+1] < prices[day])
        {
            day++;
        }
        if(day < prices.length+1){
        boughtDay = day;
        return true;
        }
       
        return false;
    }

    private static int Sell(int day, int[]prices, int boughtDay, int profit)
    {
        while (prices[boughtDay] > prices[boughtDay+1]){ 
            boughtDay++;
        }
        if(boughtDay < prices.length)
        {
            buy
            return boughtDay;

        }
        return -1;
    }
}