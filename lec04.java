class lec04{
    public static void fibo(int n) {
      int a = 0;
        int b = 1;
        for(int cr = 0 ; cr < n ; cr++){
            for(int cc = 0 ; cc <= cr ; cc++){
                System.out.print(a+"\t");
                int c = a + b;
                a=b;
                b=c; 
            }System.out.println();
        }
    }
    public static void pascal(int n) {
        for(int cr = 0; cr < n ;cr++ ){
            int ncr=1;
            for(int cc=0;cc<=cr;cc++){
                System.out.print(ncr+"\t");
                int ncrp1 = (ncr*(cr-cc))/(cc+1);
                ncr = ncrp1 ;
            }
            System.out.println();
        }
    }
    public static void displayNCR(int n, int r){
        int nfact = fact(n);
        int rfact = fact(r);
        int nmrfact = fact(n-r);
        System.out.println(nfact/(rfact*nmrfact));
    }
    public static int fact(int x){
        int ans = 1;
        for(int i=1;i<=x;i++){
            ans = ans*i;
        }
        return ans;
    } 

    public static int deciToBin(int n){
        int ans = 0;
        int pow = 1;
        while(n!=0){
            int rem = n % 2;
            n = n / 2;
            ans = ans + rem * pow;
            pow = pow * 10;
        }
        return ans;
    }
    public static int anyBaseToDecimal(int n , int sb){
        int ans = 0;
        int pow = 1;
        while(n!=0){
            int rem = n % 10;
            n = n / 10;
            ans = ans + rem * pow;
            pow = pow * sb;
        }
        return ans;
    }
    public static int decimalToAnyBase(int n , int db){
        int ans = 0;
        int pow = 1;
        while(n != 0){
            int rem = n % db;
            n = n/db;
            ans  = ans + rem*pow;
            pow = pow * 10;
        }
        return ans;
    }
    public static int anyBaseToAnyBase(int n,int sb,int db) {
        int abd = anyBaseToDecimal(n,sb);
        int ans = decimalToAnyBase(abd,db);
        return ans;
    }


    // decimal to octal
    

    public static void main(String[] args){
        // int n = 5;
        // int nfact = fact(n);
        // int r = 2;
        // int rfact = fact(r);
        // int nmrfact = fact(n-r);
        // System.out.println(nfact/(nmrfact*rfact));
        //    displayNCR(5,2);
        // int ans = deciToBin(49);
        int ans = anyBaseToAnyBase(1234,5,7); 
        System.out.println(ans);
    }
}