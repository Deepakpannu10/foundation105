import java.util.Scanner;
class lec02{

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        // all primes till n;
        
        // for(int cn = 2 ; cn <= n ; cn++ ){
        //     boolean isprime=true;
        //     for(int div = 2 ; div*div <= cn ; div++ ){
        //         if( cn % div == 0 ){
        //             isprime = false;
        //             break;
        //         }
        //     }
        //     if(isprime==true){
        //         System.out.print(cn+" ");
        //     }
        // }


        // find length

        // int length=0;

        // while(n != 0){
            
        //     n = n/10;
        //     length++; 
        // }

        // reverse a number

        int ans=0;
        while(n != 0){
            int rem = n % 10;
            n = n / 10;
            ans = (ans * 10) + rem;
        }
        System.out.println(ans);
    }
}