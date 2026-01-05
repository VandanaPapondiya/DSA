//Our problem is find out the k size subarray in the given array whose sum is maximum
//Sliding Window with Two Pointer 
//The window size is Constant already given in the question that is k
//the window we taken is already given a constant window size k=3

/*
Problem: Find the maximum sum of a subarray of size k using the sliding window technique.

Intuition (Corrected):
1.Take two pointers left and right.
  Initialize left = 0
  Initialize right = k - 1

2.Calculate the sum of the first window (from index 0 to k-1).
  Store this sum in windowSum
  Initialize maxSum = windowSum

3.Now slide the window:
  Move the right pointer one step forward (right++)
  Add arr[right] to windowSum
  Subtract arr[left] from windowSum
  Move the left pointer forward (left++)

4.After each slide:
  Update maxSum if windowSum > maxSum
  Continue this process until right < n.

**Key Concept:
Sliding Window works efficiently because we avoid recalculating the sum from scratch.
We only add one new element and remove one old element.

*/
class GDemo1{
public static void main(String ar[]){
int arr[]={2,6,7,3,4,1,8};
int k=3;
int maxSum;
int windowSum=0;
int left=0;
int right=k-1;

//first window sum
for(int i=0;i<k;i++){
windowSum+=arr[i];
}
maxSum=windowSum;
right++;

//slide the window
while(right<arr.length){
windowSum+=arr[right++];
windowSum-=arr[left++];
if(windowSum>maxSum) maxSum=windowSum;
}

System.out.println(maxSum);
}
}