class lec18{


    public static void floodFill(int[][] arr,int i,int j,String path){
        // base case
            if(i==arr.length-1 && j==arr[0].length-1){
                System.out.println(path);
                return;
            }
        // pre work
            arr[i][j] = 1;
        // up
        if(i-1>=0 && arr[i-1][j] != 1)
            floodFill(arr, i-1, j, path+'u');            
        // left
        if(j-1>=0 && arr[i][j-1] !=1)
            floodFill(arr, i, j-1, path+'l');
        // down
        if(i+1<arr.length && arr[i+1][j] != 1)
            floodFill(arr, i+1, j, path+'d');
        // right
        if(j+1 < arr[0].length && arr[i][j+1] != 1)
            floodFill(arr, i, j+1, path+'r');
        // post work
        arr[i][j] = 0;
    }


    public static void main(String[] args) {
        int[][] arr = { {0,0,0,0,0},
                        {0,1,0,1,0},
                        {0,1,0,1,0},
                        {0,1,0,1,0},
                        {0,0,0,0,0}};

        floodFill(arr,0,0,"");`
    }


}