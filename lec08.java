class lec08{


    public static void subArrays(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k = i ; k<=j;k++){
                    System.out.print(arr[k]+", ");
                }System.out.println();
            }
        }
    }


    public static void kadane(int[] arr){
        int os=0,oe=0,omax=0;
        int cs=0,ce=0,cmax=0;
        while(ce<arr.length){
            if(cmax>0){
                cmax = cmax+arr[ce];
            }else{
                cmax = arr[ce];  cs = ce;
            }
            if(omax<cmax){
                omax = cmax;  os = cs; oe = ce; }
            ce++;
        }
        for(int i=os;i<=oe;i++){
            System.out.print(arr[i]+" ");
        }  System.out.println("sum = "+omax);
    }


    public static void fill(int[][] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=count;
                count++;
            }
        }
    }
    public static void display(int[][] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+", ");
            }
            System.out.println();
        }
    }

    public static void matrixMul(int[][] arr1,int[][]arr2){
         int[][] ans = new int[arr1.length][arr1.length];   
        //loop
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1.length;j++){
                for(int k=0;k<arr2.length;k++){
                    ans[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        display(ans);
    }


    public static void main(String[] args){
        // int[] arr={3,5,-9,2,4,-7,8,9,-18,5};
        // kadane(arr);
        int[][] arr = new int[4][5];
        // int[][] arr1 = {{23,1,45,34},{345,234,1235,45}};

        fill(arr);
        display(arr); 
    }
}