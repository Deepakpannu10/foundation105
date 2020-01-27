class lec07{


    public static boolean binarySearch(int[] arr,int data){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==data){
                return true;
            }else if(arr[mid]>data){
                right = mid -1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }

    public static int iIntoArrOfI(int[] arr){
        int sum = 0;
        int rot = 0;
        for(int i=0;i<arr.length;i++){
            sum = sum +arr[i];
            rot = rot + ( i * arr[i] );
        }
        int mymax = rot;
        for(int i=1 ;i<arr.length;i++){
            rot = rot - (sum - arr.length*arr[i-1]);
            if(mymax<rot){
                mymax = rot;
            }
        }
        return mymax;
        }

        public static void subArrays(int[] arr){
            for(int i=0;i<arr.length;i++){
                for(int j=i;j<arr.length;j++){
                    for(int x=i;x<=j;x++){
                        System.out.print(arr[x]+" ");
                    }System.out.println();
                }
            }
        }

        public static  void subSets(int[] arr){
            int pow = 1;
            for(int i=0;i<arr.length;i++){ pow = pow * 2; }
                int count = 0 ;
                while(count<pow){
                    int cc = count;
                    int length = 0;
                    while(cc!=0){
                        int rem = cc%2; cc=cc/2;
                        if(rem == 1){
                            System.out.print(arr[length] +" ");}
                        length++;
                    }
                    count++; System.out.println();
                }
        }
    public static void main(String[] args){
        int[] arr = {1,2,3};
        subSets(arr);
    }
}