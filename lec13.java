class lec13{

    public static void p1(int x){
        if(x==0){ return; }
        p1(x-1);
        System.out.println(x);
    }



    public static void pDI(int x){
        if(x==1){ 
            System.out.println(x);
            return; }
        System.out.println(x);
        pDI(x-1);
        System.out.println(x);
    }

    public static int facto(int x){
        if(x==0){
            return 1;
        }
        int recAns = facto(x-1);
        int myans = x * recAns;
        return myans;
    }



    public static void oddEven(int x){
       if(x==0){
            System.out.println(x);
            return;
        }

        if(x%2==0){
            System.out.println(x);
        }
        oddEven(x-1);
        
        if(x%2==1){
            System.out.println(x);
        }

    }


    public static int printzz(int x){
        if(x==0){ return 1;}
        int myans=0;
        System.out.println(x);
        myans += printzz(x-1);
        System.out.println(x);
        myans += printzz(x-1);
        System.out.println(x);
        return myans;
    }

    public static void main(String[] args){
        // pDI(5);
        System.out.println(facto(5));
    }
}