class lec10{
    public static void display(int[][]arr){
         for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
    }
    public static void swap(int[][] arr,int i,int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
    public static void transpose(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                  if(i<j)
                    swap(arr,i,j);
            }
        }
    }
    public static void rotate(int[][] arr){
        transpose(arr);
        for(int i=0;i<arr.length/2;i++){
            for(int j=0;j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[arr.length-1-i][j];
                arr[arr.length-1-i][j] = temp;
            }
        }
    }


    public static void subArrayWithGivenSum(int[] arr,int target){
        int i = 0 , j = 0;
        int sum=0;
        while(j<arr.length){
            if(sum<target){
                sum += arr[j];
                j++;
            }else if(sum>target){
                sum -= arr[i];
                i++;
            }else{
                break;
            }
        }
        if(sum==target){
            System.out.println(i+", "+(j-1));
        }



    }


    public static void main(String[] args){
        int[][] arr = {{ 1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};

        // rotate(arr);
        // display(arr);
        int[] arr1 = {16,2,5,7,9,10,20};
        subArrayWithGivenSum(arr1,26);
    }


}