class lec09{

    public static void waveDisplay(int[][] arr){
        for(int c=0;c<arr[0].length;c++){
            if(c%2==0){
                for(int r=0;r<arr.length;r++){
                    System.out.print(arr[r][c]+" ");
                }
            }else{
                for(int r=arr.length-1;r>=0;r--){
                    System.out.print(arr[r][c]+" ");
                }
            }
        }
    }


    public static void spiralPrint(int[][] arr){
        int rmin=0,rmax = arr.length-1, cmin=0 , cmax = arr[0].length-1;
        int count=0;
    while(count<arr.length*arr[0].length){
        // left wall
        for(int i=rmin;i<=rmax;i++){
            System.out.print(arr[i][cmin]+" ");   count++;
        }
        cmin++;
        // bottom wall
        for(int i=cmin;i<=cmax;i++){
            System.out.print(arr[rmax][i]+" ");   count++;
        }
        rmax--;
        // right wALL
        for(int i=rmax;i>=rmin;i--){
            System.out.print(arr[i][cmax]+" ");   count++;
        }
        cmax--;
        // top wall
        for(int i=cmax;i>=cmin;i--){
            System.out.print(arr[rmin][i]+" ");   count++;
        }
        rmin++;
    }
    }


    public static void exitPoint(int[][] arr){
        int r=0 , c=0 ;
        int dir = 0;
        while(true){
            dir += arr[r][c];
            dir = dir%4;
            if(dir==0){
                c++;
            }else if(dir==1){
                r++;
            }else if(dir==2){
                c--;
            }else{
                r--;
            }
    if(r<0 || c<0 || r==arr.length || c== arr[0].length){
        break;
    }
        }
    if(r<0)r++;
    if(c<0)c++;
    if(r==arr.length)r--;
    if(c==arr[0].length)c--;
    System.out.print(r+" "+c);
    }


    public static void main(String[] args){
        int[][] arr = {{ 1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        waveDisplay(arr);
    }
    


}