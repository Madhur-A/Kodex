
/*
 *
 * Copyright (c) 2024
 * A. Madhur
 *
 * Permission to use, copy, modify, distribute and sell this software
 * and its documentation for any purpose is hereby granted without fee,
 * provided that the above copyright notice appear in all copies and
 * that both that copyright notice and this permission notice appear
 * in supporting documentation. A. Madhur makes no representations
 * about the suitability of this software for any purpose. It is provided
 * "as is" without express or implied warranty.
 */

// date: 23rd of January, 2024
// url: https://leetcode.com/problems/median-of-two-sorted-arrays

// note: `std::sort` is as efficient as this custom merge sort, notwithstandin
//       the number of elements.


class Solution {
public:
    inline void merge(std::vector<int> &v, int left, int mid, int right) {
        int const n = mid - left + 1, m = right - mid;
        int N[n], M[m];
        for(int i=0; i<n; N[i] = v[left+i], ++i);
        for(int i=0; i<m; M[i] = v[mid+1+i], ++i);
        int i = 0, j = 0, k = left;
        while(i < n and j < m) {
            if(N[i] < M[j]) { 
                v[k++] = N[i++]; 
            } else {
                v[k++] = M[j++]; 
            }
        }
        while(i < n) { v[k++] = N[i++]; }        
        while(j < m) { v[k++] = M[j++]; }
    }
    inline void merge_sort(std::vector<int> &v, int left, int right) {
        if(left < right) {
            int const mid = (left + right) / 2;
            merge_sort(v, left, mid);
            merge_sort(v, mid+1, right);
            merge(v, left, mid, right);
        }
    }
public:
    double findMedianSortedArrays(vector<int>& nums, vector<int>& nums2) {
        nums.insert(nums.end(), nums2.begin(), nums2.end());
        std::size_t const n = nums.size();
        // // std::ranges::sort(nums);
        // std::sort(nums.begin(), nums.end()); // faster
        /* the generic merge-sort */
        merge_sort(nums, 0, n-1);
        
        std::size_t const m = n/2;
        if(n & 1) { // total number is odd
            return nums[m];
        }
        // when total number is even
        return (nums[m] + nums[m-1])/2.0;
        
        
    }
};
