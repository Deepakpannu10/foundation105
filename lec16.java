import java.util.ArrayList;

class lec16{


    public static void nokiaKeyPad(String[] codes,
    String ques,String msg){
        if(ques.length()==0){
            System.out.print(msg+" ");
            return;
        }
        int num = ques.charAt(0) - '0';
        String word = codes[num];
        String roq = ques.substring(1);
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            nokiaKeyPad(codes, roq, msg + ch);
        }
    }

    public static ArrayList<String> nokiaKeyPad(String[] codes,String ques){
        if(ques.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        String roq = ques.substring(1);
        ArrayList<String> recAns = nokiaKeyPad(codes,roq);
        ArrayList<String> myAns = new ArrayList<>();
        int num = ques.charAt(0)-'0';
        String word = codes[num];
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            for(int j=0;j<recAns.size();j++){
                myAns.add(ch+recAns.get(j));
            }
        }
        return myAns;
    }


    public static int mazePath(int sr,int sc,int er,int ec,String path){
        if(sr==er && sc == ec){
            System.out.println(path);
            return 1;
        }
        int ans = 0;
        if(sc+1<=ec)
            ans += mazePath(sr, sc+1, er, ec, path+'h');
        if(sr+1<=er)
            ans += mazePath(sr+1, sc, er, ec, path+'v');
        return ans;
    }

    public static void main(String[] args) {
        // String[] codes = {",.;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        // nokiaKeyPad(codes,"456","");
        // System.out.println();
        // System.out.println(nokiaKeyPad(codes, "456"));
        System.out.println(mazePath(0,0,2,2,""));
    }
}