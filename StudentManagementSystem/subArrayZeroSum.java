package StudentManagementSystem;

public class subArrayZeroSum {
		public static void main(String[]args)
		{
			int arr[] = {4,2,4,1,6,-6};
			
			if(isSubarrayExists(arr))
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");
			}
		}

		private static boolean isSubarrayExists(int[] arr) {
			int sum = 0;
			int start = 0;
			int end = 0;
			for(int i = 0;i<arr.length;i++)
			{
				sum = arr[i];
				start = i;
				if(sum == 0)// if the subarray with size 1 has sum 0 means return true
				{
					
					System.out.println(start);
					return true;
				}
				
				for(int j = i+1;j<arr.length;j++)
				{
					sum = sum+arr[j];
					
					if(sum==0)
					{	
						end = j;
						System.out.println(start+" "+end);
						return true;
					}
				}
			}
			
			
			return false;
		}
}
