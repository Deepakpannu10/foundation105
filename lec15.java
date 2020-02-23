import java.util.ArrayList;

class lec15{


    public static int[] allocc(int[] arr,int idx,int data,int count){
        if(idx == arr.length){
            int[] baseans = new int[count];
            return baseans;
        }
        if(arr[idx] == data){
            count++;
        }
        int[] recAns = allocc(arr, idx+1, data, count);
        if(arr[idx] == data){
            recAns[count-1] = idx;
        }
        return recAns;
    }


    public static void subseq(String ques,String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        subseq(roq, ans+ch);
        subseq(roq, ans);
    }



    public static ArrayList<String> subseq(String ques){
        if(ques.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        String roq = ques.substring(1);
        ArrayList<String> recAns= subseq(roq);
        ArrayList<String> myans = new ArrayList<>();
        char ch = ques.charAt(0);
        for(int i=0;i<recAns.size();i++){
            myans.add(ch + recAns.get(i));
        }
        for(int i=0;i<recAns.size();i++){
            myans.add( recAns.get(i));
           }   return myans;
    }

    public static void stairsPath(int n,String path){
        if(n==0){
            System.out.println(path);
            return;
        }
        if(n-1>=0)
        stairsPath(n-1, path+"1");
        if(n-2>=0)
        stairsPath(n-2, path+"2");
        if(n-3>=0)
        stairsPath(n-3, path+"3");
    }
    public static void main(String[] args) {
    stairsPath(4, "");
        // int[] arr = {3,5,2,3,5,6,3,2};
        // int[] ans = allocc(arr, 0, 3, 0);
        // for(int i=0;i<ans.length;i++)
        // {System.out.print(ans[i]+" ");}
        // subseq("abc", "");
        // ArrayList<String> ans = subseq("abc");
        // System.out.println(ans);
        
    }


}