class GDemo2{
public static void main(String ar[]){
int arr[]={2,7,5,4,3,1,5,6};
int n=arr.length;
int k=8;
int left=0;
int right=0;
int maxLength=0;
int sum=0;
while(right<n){
sum+=arr[right];
while(sum>k){
sum-=arr[left++];
}
maxLength = Math.max(maxLength, right - left + 1);
right++;
}

System.out.println(maxLength);
}
}