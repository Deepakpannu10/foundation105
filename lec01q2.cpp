#include<iostream>
using namespace std;
int main(){
    cout<<"enter amount:"<<endl;
    int amount=0;
    cin>>amount;
    cout<<"enter rate:"<<endl;
    int rate=0;
    cin>>rate;
    cout<<"enter time:"<<endl;
    int time=0;
    cin>>time;
    int si=(amount*rate*time)/100;
    cout<<"simple intrest is:"<<si<<endl;
    return 0;
}