class lec12{



    public static String toggle(String str){
        String ans = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            // int ch1=str.charAt(i);
            // System.out.println(ch1);
            if(ch>='a'&&ch<='z'){
                ch= (char)(ch-'a'+'A');
            }else{
                ch = (char)(ch-'A'+'a');
            }
            ans=ans+ch;
        }
        return ans;
    }




    public static void substrings(String str) {
        for(int i=0;i<str.length();i++){
            for(int j=i;j<=str.length();j++){
                System.out.println(str.substring(i, j));
            }
        }

    }

    public static void main(String[] args){
        // substrings("abcd");
        String ans=toggle("abCD");
        System.out.println(ans);

    }



}