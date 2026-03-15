import java.util.HashMap;

public class leetcode560 {
    public static void main(String[] args) {
        int result = subarraySum(new int[]{1,2,3}, 3);
        System.out.println(result);
    }

    public static int SubarraySum(int[] nums, int k)
    {
        int count =0;
        int left =0;
        int sum = 0;
        int right =0;
       while(right < nums.length)
       {
        sum += nums[right];
        while(sum > k)
        {
            sum -= nums[left++];
        }
        if(sum == k)
        {
           count++;
           sum = nums[right];
           left = right;
        }
        right++;
       }

       return count;
    }

    /*
    Core DSA thinking patterns (must-master)

You should consciously label problems as:

Sliding Window (positive numbers only)

Prefix Sum + HashMap

Two Pointers

Binary Search on Answer

Stack (Next Greater / Smaller)

Monotonic Stack

BFS / DFS

Greedy

DP (state + transition)

🔥 1. Arrays & Basic Logic

Why: Foundation of everything

Must-do Mediums

53. Maximum Subarray

Product of Array Except Self

Rotate Array

First Missing Positive ⭐

Gas Station ⭐

🔥 2. Prefix Sum

Why: Counting subarrays, ranges, sums

Must-do Mediums

560. Subarray Sum Equals K ⭐⭐⭐

Contiguous Array

Subarray Sums Divisible by K

Binary Subarrays With Sum

Count Number of Nice Subarrays

👉 If you master these, many “count subarray” problems become easy.

🔥 3. Sliding Window

Why: Optimized subarray problems

Fixed Window

Permutation in String

Find All Anagrams in a String

Variable Window

Longest Substring Without Repeating Characters ⭐

Longest Repeating Character Replacement ⭐

Fruit Into Baskets

Max Consecutive Ones III

⚠️ Remember: fails when negatives exist

🔥 4. Two Pointers

Why: Sorted arrays, optimal scanning

Must-do Mediums

15. 3Sum ⭐

3Sum Closest

Container With Most Water ⭐

Sort Colors

4Sum

🔥 5. Hashing

Why: Frequency, fast lookup

Must-do Mediums

49. Group Anagrams ⭐

Longest Consecutive Sequence ⭐

Top K Frequent Elements

4Sum II

Valid Sudoku

🔥 6. Binary Search

Why: Log-time optimization, very common in interviews

Classic

Search in Rotated Sorted Array

Find First and Last Position

Search in Rotated Sorted Array II

Binary Search on Answer ⭐⭐⭐

Koko Eating Bananas

Capacity To Ship Packages Within D Days

Minimum Number of Days to Make m Bouquets

Split Array Largest Sum

🔥 7. Stack

Why: Nearest greater/smaller, monotonic logic

Must-do Mediums

739. Daily Temperatures ⭐

Online Stock Span

Next Greater Element II

132 Pattern

Asteroid Collision

🔥 8. Linked List

Why: Pointer manipulation (frequent round-1 filter)

Must-do Mediums

2. Add Two Numbers ⭐

Remove Nth Node From End

Linked List Cycle II ⭐

Sort List

Copy List with Random Pointer ⭐

🔥 9. Trees (VERY IMPORTANT)

Why: Almost guaranteed in placements

Traversals / Basics

Binary Tree Level Order Traversal

Inorder Traversal

Preorder Traversal

Medium Core

Construct Binary Tree from Preorder & Inorder ⭐

Lowest Common Ancestor ⭐⭐⭐

Validate BST

Kth Smallest Element in BST

Path Sum III

🔥 10. Graphs (BFS / DFS)

Why: Connectivity, components

Must-do Mediums

200. Number of Islands ⭐

Rotting Oranges

Clone Graph

Pacific Atlantic Water Flow

Number of Provinces

🔥 11. Heap / Priority Queue

Why: Top-K, scheduling

Must-do Mediums

215. Kth Largest Element in an Array ⭐

Top K Frequent Elements

K Closest Points to Origin

Task Scheduler

Find Median from Data Stream ⭐

🔥 12. Greedy

Why: Optimization with decisions

Must-do Mediums

45. Jump Game II ⭐

Jump Game

Gas Station

Non-overlapping Intervals

Minimum Number of Arrows to Burst Balloons

🔥 13. Dynamic Programming (Medium Core)

Why: Hardest jump for most students

1D DP

House Robber

House Robber II

Coin Change ⭐

Longest Increasing Subsequence ⭐⭐⭐

2D DP

Unique Paths

Minimum Path Sum

Longest Common Subsequence ⭐⭐⭐

Partition Equal Subset Sum

🔥 14. Strings (Medium)

Why: Common in OA + interviews

Must-do Mediums

5. Longest Palindromic Substring ⭐

Decode String

Reverse Words in a String

String Compression

Minimum Remove to Make Valid Parentheses

🎯 How to use this list (IMPORTANT)

Don’t do it randomly.

Order for YOU (placement focused):

Arrays → Prefix Sum → Sliding Window

Hashing → Two Pointers

Stack → Binary Search

Trees → Graphs

Heap → Greedy

DP (last, but must do)
     */

    public static int subarraySum(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // base case

    int sum = 0;
    int count = 0;

    for (int num : nums) {
        sum += num;

        if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
}

    
}
