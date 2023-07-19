package com.ds;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        // Create a min heap (priority queue)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Add elements to the min heap
        for (int num : nums) {
            pq.offer(num);
            // Keep the size of the heap <= k
            if (pq.size() > k) {
                System.out.println(pq.poll());
            }
        }

        // The root of the min heap will be the kth largest element
        return pq.peek();
    }

    
    public static void main(String[] args) {
        int[] nums = {3, 12, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("Kth Largest Element: " + kthLargest);
    }
}


