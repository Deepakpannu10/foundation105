import java.util.ArrayList;

class lec17{

    public static int mazePath(int sr,int sc,int er,int ec,String path){
        if(sr==er && sc == ec){
            System.out.println(path);
            return 1;
        }
        int ans = 0;
        for(int i=1;sc+i<=ec;i++)
            ans += mazePath(sr, sc+i, er, ec, path+'h'+i);
        
        for(int i=1;sc+i<=ec && sr+i<=er;i++)
            ans+= mazePath(sr+i, sc+i, er, ec, path+'d'+i);
        
        for(int i=1;sr+i<=er;i++)
            ans += mazePath(sr+i, sc, er, ec, path+'v'+i);
        return ans;
    }


    public static ArrayList<String> mazePath1(int sr,int sc,int er,int ec){
        if(sr==er && sc==ec){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        ArrayList<String> myans = new ArrayList<>();
        for(int i=1;sc+i<=ec;i++){
            ArrayList<String> recAns = mazePath1(sr, sc+i, er, ec);
            for(int x=0;x<recAns.size();x++){
                myans.add("h"+i+recAns.get(x));
            }
        }
        for(int i=1;sc+i<=ec && sr+i<=er;i++){
            ArrayList<String> recAns = mazePath1(sr+i, sc+i, er, ec);
            for(int x=0;x<recAns.size();x++){
                myans.add("d"+i+recAns.get(x));
            }
        }
        for(int i=1;sr+i<=er;i++){
            ArrayList<String> recAns = mazePath1(sr+i, sc, er, ec);
            for(int x=0;x<recAns.size();x++){
                myans.add("v"+i+recAns.get(x));
            }
        }
    return myans;
    }


    public static ArrayList<String> stairs(int n){
        if(n==0){
            ArrayList<String> baseans = new ArrayList<>();
            baseans.add("");
            return baseans;
        }
        ArrayList<String> myans = new ArrayList<>();
        if(n-1>=0){
           ArrayList<String> recans = stairs(n-1);
           for(int i=0;i<recans.size();i++){
               myans.add("1" + recans.get(i));
           }
        }
        if(n-2>=0){
            ArrayList<String> recans = stairs(n-2);
            for(int i=0;i<recans.size();i++){
                myans.add("2" + recans.get(i));
            }
         }
         if(n-3>=0){
            ArrayList<String> recans = stairs(n-3);
            for(int i=0;i<recans.size();i++){
                myans.add("3" + recans.get(i));
            }
        }
         return myans;
    }

    public static ArrayList<String> mpathmm(int sr, int sc, int dr, int dc){
        if(sr==dr && sc == dc){
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        if(sr>dr || sc>dc){
            ArrayList<String> bb = new ArrayList<>();
            return bb;
        }
        ArrayList<String> hm = mpathmm(sr+1, sc, dr, dc);
        ArrayList<String> vm =  mpathmm(sr, sc+1, dr, dc);
        ArrayList<String> dm =  mpathmm(sr+1, sc+1, dr, dc);
        ArrayList<String> myres= new ArrayList<>();
        for(int i=0; i<hm.size(); i++){
            myres.add("h"+hm.get(i));
        }
        for(int i=0; i<vm.size(); i++){
            myres.add("v"+vm.get(i));
        }
        for(int i=0; i<dm.size(); i++){
            myres.add("d"+dm.get(i));
        }
        return myres;
    }





    public static void main(String[] args) {
        
        ArrayList<String> ans1 = mpathmm(0, 0, 2, 2);
        System.out.println(ans1.size()+" "+ans1);
    }
    



}