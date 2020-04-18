import java.util.ArrayList;





class revision{

    public static void kpc(String[] codes,String ques,String ans){
        if(ques.length()==0){
            System.out.print(ans+" ");
            return;
        }
        int num = ques.charAt(0) - '0';
        String word = codes[num];
        for(int i = 0;i<word.length();i++){
             kpc(codes, ques.substring(1), ans+word.charAt(i));
        }
    }


    public static ArrayList<String> kpc(String[] codes,String ques){
        if(ques.length()==0){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        ArrayList<String> recAns = kpc(codes, ques.substring(1));
        ArrayList<String> myAns = new ArrayList<>();
        String word = codes[ ques.charAt(0) - '0'];
        // int num = ques.charAt(0) - '0';
        // String word = codes[num];
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            for(int j = 0 ; j<recAns.size();j++){
                myAns.add(ch + recAns.get(j));
            }
        }
        return myAns;
    }


    public static void mazePath(int sr,int sc,int er,int ec,String path){
        if(sr==er && sc==ec){
            System.out.println(path);
            return;
        }
        if(sc+1<=ec)
        mazePath(sr, sc+1, er, ec, path+'h');
        if(sr+1<=er)
        mazePath(sr+1, sc, er, ec, path+'v');
    }

    public static void mazePathMultiMove(int sr,int sc,int er,
    int ec,String path){

        // base case print path and return
        if(sr==er && sc==ec){
            System.out.println(path);
        return;
        }

        // horizontal jumps
        for(int i=1;sc+i<=ec;i++){
            mazePathMultiMove(sr, sc+i, er, ec, path+'h'+i);
        }

        // diagonal jumps
            for(int i=1;sr+i<=er && sc+i<=ec;i++){
                mazePathMultiMove(sr+i, sc+i, er, ec, path+'d'+i);
            }

        // vertical jumps
            for(int i=1;sr+i<=er;i++){
                mazePathMultiMove(sr+i, sc, er, ec, path+'v'+i);
            }
    }


    public static ArrayList<String> mazePath(int sr,int sc,int er,int ec){
        if(sr==er && sc==ec){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        ArrayList<String> myAns = new ArrayList<>();
        //l1
        for(int i=1;sc+i<=ec ;i++){
            ArrayList<String> recAns =  mazePath(sr, sc+i, er, ec);
            for(int x=0;x<recAns.size();x++){
                myAns.add("h"+i +recAns.get(x));
            }
        }
        //l2
        for(int i=1;sc+i<=ec && sr+i<=er ;i++){
            ArrayList<String> recAns =  mazePath(sr+i, sc+i, er, ec);
            for(int x=0;x<recAns.size();x++){
                myAns.add("d"+i +recAns.get(x));
            }
        }
        //l3
        for(int i=1;sr+i<=er ;i++){
            ArrayList<String> recAns =  mazePath(sr+i, sc, er, ec);
            for(int x=0;x<recAns.size();x++){
                myAns.add("v"+i +recAns.get(x));
            }
        }
        return myAns;
    }


    public static ArrayList<String> stairsPR(int n){
        if(n==0){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        ArrayList<String> myans = new ArrayList<>();
        for(int jump = 1;n-jump>=0 && jump<=3;jump++){
            ArrayList<String> recAns =   stairsPR(n-jump);
                for(int x= 0 ;x<recAns.size();x++){
                    myans.add(jump+recAns.get(x));
                }
        }
        
        // if(n-1>=0){
        //     ArrayList<String> recAns =   stairsPR(n-1);
        //     for(int x= 0 ;x<recAns.size();x++){
        //         myans.add('1'+recAns.get(x));
        //     }
            // for(String str : recAns){
            //     myans.add("1"+str);
            // }
        // }
        // if(n-2>=0){
        //     ArrayList<String> recAns =   stairsPR(n-2);
        //     for(int x= 0 ;x<recAns.size();x++){
        //         myans.add('2'+recAns.get(x));
        //     }
        // }


        // if(n-3>=0){
        //     ArrayList<String> recAns =   stairsPR(n-3);
        //     for(int x= 0 ;x<recAns.size();x++){
        //         myans.add('3'+recAns.get(x));
        //     }
        // }
            return myans;
    }


    public static void main(String[] args) {
        String[] codes = {" .",",;","abc","def","ghi","jkl","mno","pqrs","tuvw","xyz"};
        // kpc(codes, "234", "");
        // mazePathMultiMove(0, 0, 2, 2, "");        System.out.println(mazePath(0, 0, 2, 2));
        System.out.println(stairsPR(7));
    }
}