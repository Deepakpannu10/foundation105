#include<iostream>
using namespace std;
// implement grading system.
int main(){
    cout<<"apne marks btao:"<<endl;
    int marks=0;
    cin>> marks;
    if(marks<95 && marks>85 ){
        cout<<"u will get 20% off";
    }else if(marks>=95){
        cout<<" u will get 50% off ";
    }else if(marks>80){
        cout<<" u will get 10% off ";
    }else{
        cout<<" u have pay whole fee";
    }
    return 0;
}