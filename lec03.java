import java.util.Scanner;
class lec03{

    public static void main(String[] args) {
        // int n=123456;
        // int r=5;
        // int dn=n;
        // int length=0;
    
        // while(dn!=0){
        //     dn=dn/10;
        //     length++;
        // }
        // r=r%length;
        // if(r<0){
        //     r=length+r;}
        // int ans=0;
        // int pow=1;
        // int dr=r;
    
        // while(r>0){
        //     int rem=n%10;
        //     n=n/10;
        //     ans=ans+rem*pow;
        //     pow=pow*10;
        //     r--;
        // }
        // length=length-dr;
        // while(length>0){
        //     ans=ans*10;
        //     length--;
        // }
        // ans=ans+n;
        // System.out.println(ans);
    
        Scanner scn=new Scanner(System.in);
        int n = scn.nextInt();

        // patter 1
        // for(int cr=1;cr<=n;cr++){
        //     for(int cc=1;cc<=cr;cc++){
        //         System.out.print("*\t");
        //     }
        //     System.out.println();
        // }

        // patternn 2
        // int st=n;
        // int sp=0;
        // for(int cr=1;cr<=n;cr++){
        //     for(int csp=1;csp<=sp;csp++){
        //         System.out.print("\t");
        //     }
        //     for(int cst=1;cst<=st;cst++){
        //         System.out.print("*\t");
        //     }
        //     st--;
        //     sp++;
        //     System.out.println();
        // }

        int st=1;
        int sp=n/2;
        for(int cr=1; cr<=n;cr++){
            for(int csp=1;csp<=sp;csp++){
                System.out.print("\t");
            }
            for(int cst=1;cst<=st;cst++){
                System.out.print("*\t");
            }
            if(cr<=n/2){
                sp--;   st=st+2;
            }else{
                sp++;  st -= 2 ;   }
                System.out.println();
                System.out.println();
        }
    }
} 