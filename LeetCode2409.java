

/*
2409. Count Days Spent Together
Easy
Topics
premium lock icon
Companies
Hint
Alice and Bob are traveling to Rome for separate business meetings.

You are given 4 strings arriveAlice, leaveAlice, arriveBob, and leaveBob. Alice will be in the city from the dates arriveAlice to leaveAlice (inclusive), while Bob will be in the city from the dates arriveBob to leaveBob (inclusive). Each will be a 5-character string in the format "MM-DD", corresponding to the month and day of the date.

Return the total number of days that Alice and Bob are in Rome together.

You can assume that all dates occur in the same calendar year, which is not a leap year. Note that the number of days per month can be represented as: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31].

 

Example 1:

Input: arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
Output: 3
Explanation: Alice will be in Rome from August 15 to August 18. Bob will be in Rome from August 16 to August 19. They are both in Rome together on August 16th, 17th, and 18th, so the answer is 3.
Example 2:

Input: arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
Output: 0
Explanation: There is no day when Alice and Bob are in Rome together, so we return 0.
 

Constraints:

All dates are provided in the format "MM-DD".
Alice and Bob's arrival dates are earlier than or equal to their leaving dates.
The given dates are valid dates of a non-leap year. */

public class LeetCode2409
{
    public static void main(String[] args) {



       int c =  countDaysTogether("01-01", "01-18", "01-16", "01-19");
       System.out.println("The count : "+ c);
        // String arriveAlice, String leaveAlice, String arriveBob, String leaveBob
    }
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int count=0;
        int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int alice_arrive_month = 0, alice_leave_month =0 ,bob_arrive_month  = 0, bob_leave_month = 0;
        int alice_arrive_date=0, alice_leave_date=0, bob_arrive_date=0, bob_leave_date=0;

        for(int i=1; i<months.length; i++){
            months[i] += months[i-1];
        }

        for(int i=0; i<=1; i++)
        {
            // alice and bob arrive month 
            alice_arrive_month = alice_arrive_month * 10 + (arriveAlice.charAt(i) - '0');
            bob_arrive_month = bob_arrive_month * 10 + (arriveBob.charAt(i) - '0');


            // alice and bob leave month 
            alice_leave_month = alice_leave_month * 10 + (leaveAlice.charAt(i) - '0');
            bob_leave_month = bob_leave_month * 10 + (leaveBob.charAt(i) - '0');

            // alice and bob arrive date
            alice_arrive_date = alice_arrive_date * 10 + (arriveAlice.charAt(3+i) - '0');
            bob_arrive_date = bob_arrive_date * 10 + (arriveBob.charAt(3+i) - '0');

             // alice and bob leave date
            alice_leave_date = alice_leave_date * 10 + (leaveAlice.charAt(3+i) - '0');
            bob_leave_date = bob_leave_date * 10 + (leaveBob.charAt(3+i) - '0');

        }
        int start = (alice_arrive_month == 1 ? 0 : months[alice_arrive_month-2]) + alice_arrive_date;
        int end = (alice_leave_month == 1 ? 0 : months[alice_leave_month-2]) + alice_leave_date;

        int []days = new int[366];
        for( ; start<=end; start++)
        {
            days[start]++;
        }
         start = (bob_arrive_month == 1 ? 0 : months[bob_arrive_month-2]) + bob_arrive_date;
         end = (bob_leave_month == 1 ? 0 : months[bob_leave_month-2]) + bob_leave_date;
        for( ; start<=end; start++)
        {
           if(days[start] == 1)
           {
            count++;
           }
        }
        // for(int i:months)
        // {
        //     System.out.println(i);
        // }
        return count;
    }

}