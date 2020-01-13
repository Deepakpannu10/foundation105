#include<iostream>

using namespace std;

int main(){

    int n=123456;
    int r=5;
    int dn=n;
    int length=0;

    while(dn!=0){
        dn=dn/10;
        length++;
    }
    r=r%length;
    if(r<0){
        r=length+r;}
    int ans=0;
    int pow=1;
    int dr=r;

    while(r>0){
        int rem=n%10;
        n=n/10;
        ans=ans+rem*pow;
        pow=pow*10;
        r--;
    }
    length=length-dr;
    while(length>0){
        ans=ans*10;
        length--;
    }
    ans=ans+n;
    cout<<ans;





    return 0;
}
