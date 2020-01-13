#include<iostream>

using namespace std;


int main(){

    // loop basic
        // int n=0;
        // cin>>n;
        
        // for(int i=1 ; i<=10 ; i++){
        //     cout<<(i*n)<<endl;
        // }

    // q1 - is a number prime
        int n=0;
        cout<<"enter your number"<<endl;
        cin>>n;
        bool isprime = true;
        // for(int i=2 ; i < n ; i++){
        //     if( n % i == 0){
        //         isprime = false;
        //         break;
        //     }
        // }
        // for(int i=2 ; i <= n/2 ; i++){
        //     if( n % i == 0){
        //         isprime = false;
        //         break;
        //     }
        // }
        for(int i=2 ; i * i <= n; i++){
            if( n % i == 0){
                isprime = false;
                break;
            }
        }
        if(isprime==true){
            cout<<"Prime";
        }else{
            cout<<"Not Prime";
        }

    return 0;
}