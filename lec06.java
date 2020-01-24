class lec06{

    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
         }
    }
    public static void reverse(int[] arr,int si,int ei){
        
        // for(si;si<ei;si++,ei--){
            while(si<ei){
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
                si++; ei--;
        }
    }

    public static void rotate(int[] arr,int r){
        r=r%arr.length;
        if(r<0){
            r=r+arr.length;
        }
        
        reverse(arr,arr.length-r,arr.length-1);
        reverse(arr,0,arr.length-r-1);
        reverse(arr,0,arr.length-1);
    }

    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7};
        int r=3;
        rotate(arr,r);
        display(arr);
    }
}