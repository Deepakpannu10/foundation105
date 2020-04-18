#include<iostream>
#include<vector>

using namespace std;

void display(vector<int>& arr){

    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}


void display1(vector<vector<int> >& arr){

    for(int i=0;i<arr.size();i++){
       for(int j=0;j<arr[0].size();j++){
           cout<<arr[i][j]<<" ";
       }cout<<endl;
    }
    cout<<endl;
}


void incremnt(vector<int> &arr){
    for(int i=0;i<arr.size();i++){
        arr[i] =arr[i]+5;    
    }
    display(arr);
}

void input(vector<int> &arr){
    for(int i=0;i<arr.size();i++){
        cin>>arr[i];
    }
}

void subSets(vector<int>& arr){
            int pow = 1;
            for(int i=0;i<arr.size();i++){ pow = pow * 2; }
                int count = 0 ;
                while(count<pow){
                    int cc = count;
                    int length = 0;
                    while(cc!=0){
                        int rem = cc%2; cc=cc/2;
                        if(rem == 1){
                     cout<<arr[length] <<" ";}
                        length++;
                    }
                    count++; cout<<endl;
                }
        }

void subArrays(vector<int> &arr){
            for(int i=0;i<arr.size();i++){
                for(int j=i;j<arr.size();j++){
                    for(int x=i;x<=j;x++){
                        cout<<arr[x]<<" ";
                    }cout<<endl;
                }
            }
        }

int main(){
    // vector<int> arr{2,335,34,345};
    // input(arr);
    // incremnt(arr);
    // display(arr);

        vector<vector<int> > arr(4,vector<int>(5,0));
    display1(arr);

    return 0;
}