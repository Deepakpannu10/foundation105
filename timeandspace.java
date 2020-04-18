
class timeandspace{


    public static void bubbleSort(int[] arr){
        for( int itr = 0 ; itr < arr.length -1 ; itr++){
            for( int j = 0 ; j < arr.length - itr - 1 ; j++){
                if( arr[j] > arr[j+1] ){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    public static void selectionSort(int[] arr){
        for( int si = 0 ; si < arr.length - 1 ; si++ ){
            for( int j = si + 1 ; j < arr.length ; j++ ){
                if( arr[si] > arr[j] ){
                    int temp = arr[si];
                    arr[si] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static int[] merge2sortedArray( int[] arr1, int[] arr2 ){ 
        int[] ans = new int[ arr1.length + arr2.length ];
        int i = 0;  // for travering arr1
        int j = 0;  // for travering arr2
        int k = 0;  // for travering ans
        while( i < arr1.length && j < arr2.length ){
            if( arr1[i] < arr2[j]){
                ans[k] = arr1[i];
                k++; i++;
            }else{
                ans[k] = arr2[j];
                j++; k++;
            }
        }
        while( i < arr1.length ){
            ans[k] = arr1[i];
            k++; i++;
        }
        while(  j < arr2.length ){
            ans[k] = arr2[j];
            j++; k++;
        }
        return ans;
    }


    public static int[] mergeSort( int[] arr, int lo , int hi ){
        if( lo == hi ){
            int[] base = new int[1];
            base[0] = arr[lo];
            return base;
        }
        int mid = ( lo + hi )/2;
        int[] left =  mergeSort(arr, lo, mid);
        int[] right = mergeSort(arr, mid+1, hi);
        int[] ans = merge2sortedArray(left, right);
        return ans;
    }


    public static void sort01(int[] arr){
        int i = 0 , j = 0; // i = 1's starting pt, j = un-identified sstarting pt.
        while(j < arr.length){
            if( arr[j] == 0  ){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
    }

    public static void swap(int[]arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void sort012(int[] arr){
        int i = 0; // 1's st pt.
        int j = 0; // 2's st pt.
        int k = 0; // to iterate.
        while( k < arr.length){
            if( arr[k] == 0){
                // 2's ko shift krege.
                swap(arr,j,k);
                // 1's ko shift krege
                swap(arr,i,j);
                i++; j++; 
            }else if(arr[k] == 1){
                swap(arr,j,k);
                j++; 
            }
            k++;
        }
    }


    public static int parition(int[] arr , int lo, int hi){
        int i=lo,j=lo,pivot = arr[hi];
        while( j <= hi ){
            if(arr[j] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
        return i-1;
    }

    public static void quickSort(int[] arr,int lo,int hi) {
        if( lo >= hi ){
            return;
        }
        int pi = parition(arr,lo,hi);
        quickSort(arr,lo,pi-1);
        quickSort(arr,pi+1,hi);
    }



    public static void main(String[] args) {
        // int[] arr = { 2,5,7,9,10,23,45,67};
        // int[] brr = { 1,2,3,4,100,150,200 };
        // bubbleSort(arr);
        // selectionSort(arr);
        // int[] arr = {20,3,15,7,9,11,13,5,4,1};
        // int[] ans = mergeSort(arr, 0 , arr.length-1); 
        int[] ans = {3,8,10,5,4,2,6,7,3,5};
        // System.out.println(parition(ans));
        quickSort(ans,0,ans.length-1);
        for( int i = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] +" ");
        }
    }
}
