import java.util.Scanner;
class lec05{

    static Scanner scn = new Scanner(System.in);

    public static int octalAddition(int n1,int n2){
        int ans = 0;
        int pow = 1;
        int carry = 0;
        while(n1 != 0 || n2 != 0 || carry != 0 ){
            int r1 = n1 % 10; n1 = n1/10;
            int r2 = n2 % 10; n2 = n2/10;
            int octet = r1 + r2 + carry;
            carry = octet / 8;
            octet = octet % 8;
            ans = ans + octet * pow;
            pow *=10; 
        }
        return ans;
    }

    public static int octalSub(int n1,int n2){
        boolean isSwapped = false;
        if(n2>n1){
            isSwapped = true;
            int temp = n1;
            n1=n2;
            n2=temp;
        }
        int ans=0;
        int pow=1;
        int borrow=0;
        while(n1 != 0){
            int r1 = n1%10; n1 /=10;
            int r2 = n2%10; n2 /=10;
            int octet = (r1  - borrow) - r2;
            if(octet<0){
                octet += 8;
                borrow = 1;
            }else{
                borrow = 0;
            }
            ans = ans + octet * pow;
            pow *= 10;
        }
        if(isSwapped){
            ans = -ans;
        }
        return ans;
    }
    public static void input(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }
    public static void display(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void printSpan(int[] arr){
        int mymax = arr[0];
        int mymin = arr[0];
        for(int i = 1; i<arr.length ;i++ ){
            if(arr[i]>mymax){
                mymax = arr[i];
            }
            if(arr[i]<mymin){
                mymin = arr[i];
            }
        }
        System.out.println("span of array is:"+(mymax-mymin));
    }

    public static void addition(int[] arr1,int[] arr2){
        int size = arr1.length;
        if(size<arr2.length){
            size = arr2.length; }
        size++;
        int[] res = new int[size];
        int i = arr1.length-1;
        int j = arr2.length-1;
        int k  =res.length-1;
        int carry = 0;

        while(i>=0 && j>=0 && k>=0){
            int num = arr1[i] + arr2[j] + carry;
            carry = num/10;
            num = num%10;
            res[k] = num;
            i--; j--; k--;
        }
        while(i>=0){
            int num = arr1[i]+carry;
            carry = num/10;
            res[k] = num%10;
            i--; k--;
        }
        while(j>=0){
            int num = arr2[j] + carry;
            carry = num/10;
            res[k] = num%10;
            j--; k--;
        }        
        if(carry>0){
            res[k]= carry;
            k--;
        }

        for(int x=0;x<res.length;x++){
            if( x == 0 && res[x] == 0){
                continue;
            }
                System.out.print(res[x]);
        }
        // display(res);


    }

    public static void main(String[] args){
        // System.out.println(octalSub(277,365));
        // System.out.println("enter the size of array:");
        // int size = scn.nextInt();
        // int[] arr = new int[size];
        // input(arr);
        // printSpan(arr);
        // display(arr);
        int[] arr1 =  {9,9,9,9};
        int[] arr2 =  {9,9};
        addition(arr2,arr1);
    }


}