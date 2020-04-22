import java.util.*;
class gtree{
    static class node{
        int data;
        ArrayList<node> child; 
        node(int d){
            data = d;
            child = new ArrayList<>();
        }
    }
    static node root = null;
    public static void construct() {
        int[] data = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100};
        ArrayList<node> cpList = new ArrayList<>();
        for( int i = 0 ; i < data.length ; i++ ){
            if( data[i] == -1 ){
                cpList.remove( cpList.size() - 1 );
            }else{
                node nn = new node(data[i]);
                if( root == null ){
                    root = nn;
                }else{
                    node cp = cpList.get( cpList.size() - 1 );
                    cp.child.add( nn );
                }
                cpList.add( nn );
            }
        }
    }

    public static void display(node root){
        if( root == null ){
            return;
        }
        System.out.print( root.data +" -> " );
        for( int i = 0 ; i < root.child.size() ; i++ ){
            System.out.print( root.child.get(i).data +", " );
        }
        System.out.println();
        for( int i = 0 ; i < root.child.size() ; i++ ){
            display( root.child.get(i) );
        }
    }


    public static int size( node root ) {
        if( root == null ){
            return 0;
        }
        int mySize = 1;
        for( int i= 0 ; i < root.child.size() ; i++ ){
            mySize += size( root.child.get(i) );
        }
        return mySize;
    }

    public static int max( node root ){
        if( root == null ){
            return -1;
        }
        int myMax = root.data;
        for( int i = 0 ; i < root.child.size() ; i++ ){
            int childMax = max( root.child.get(i) );
            if( myMax < childMax ){
                myMax = childMax;
            }
        }
        return myMax;
    }



    public static ArrayList<Integer> n2rp( node root , int val ){
        if( root == null ){
            return null;
        }
        if( root.data == val ){
            ArrayList<Integer> baseAns = new ArrayList<>();
            baseAns.add(val);
            return baseAns;
        }
        for( int i = 0 ; i < root.child.size() ; i++ ){
            ArrayList<Integer> recAns = n2rp( root.child.get(i), val );
            if( recAns != null ){
                recAns.add( root.data );
                return recAns;
            }
        }
        return null;
    }


    public static int LCA( node root, int v1,int v2 ) {
        if( root == null ){
            return -1;
        }
        ArrayList<Integer> listForV1 = n2rp( root, v1 );
        ArrayList<Integer> listForV2 = n2rp( root, v2 );
        // if( listForV1 == null && listForV2 == null ){
        //     return -1;
        // }
        // else if( listForV1 == null ){
        //     return v2;
        // }else if( listForV2 == null ){
        //     return v1;
        // }
        int i = listForV1.size() -1, j = listForV2.size() -1;
        while( i>=0 && j >=0 ){
            if( listForV1.get(i) != listForV2.get(j) ){
                break;
            }
            i--; j--;
        }
        return listForV1.get( i + 1 );
    }



    public static boolean find( node root, int val ) {
        if( root == null ){
            return false;
        }
        if( root.data == val ){
            return true;
        }
        for( int i = 0; i < root.child.size() ; i++ ){
            boolean recAns = find( root.child.get(i) , val );
            if( recAns ) return true;
        }
        return false;
    }


    public static void LODisplay( node root ) {
        Queue<node> qu = new LinkedList<>();
        qu.add(root);
        while( qu.size() > 0 ){
            // remove
            node cn = qu.remove();

            // work
            System.out.print(cn.data+" ");

            // add child
            for( int i = 0 ; i < cn.child.size() ; i++ ){
                qu.add( cn.child.get(i) );
            }
        }
    }

    public static void LOLWDisplay( node root ) {
        Queue<node> qu = new LinkedList<>();
        qu.add(root);
        int s = 1;
        while( qu.size() > 0 ){
            // remove
            node cn = qu.remove();
            // work
            System.out.print(cn.data+" ");
            // add child
            for( int i = 0 ; i < cn.child.size() ; i++ ){
                qu.add( cn.child.get(i) );
            }
            s--;
            if( s == 0 ){
                System.out.println(); s = qu.size();
            }
        }
    }


    public static void LOLWDisplay1( node root ) {
        Queue<node> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        while( qu.size() > 0 ){
            // remove
            node cn = qu.remove();
            // work
            if( cn == null ){
                System.out.println();
                if( qu.size() > 0 ){
                    qu.add(null);
                }
                // continue;        
            }else{
                System.out.print(cn.data+" ");
                // add child
                for( int i = 0 ; i < cn.child.size() ; i++ ){
                    qu.add( cn.child.get(i) );
                }
            }
        }
    }


    public static void LOZZ( node root ){
        Queue<node> qu = new LinkedList<>();
        ArrayList<node> st = new ArrayList<>();
        qu.add(root);
        boolean isReverse = false;
        while( qu.size() > 0 ){
            node cn = qu.remove();
            System.out.print( cn.data + " " );
            if( isReverse ){
                for( int i = cn.child.size() - 1; i >=0 ; i-- ){
                    st.add( cn.child.get(i) );
                }
            }else{
                for( int i = 0; i < cn.child.size() ; i++ ){
                    st.add( cn.child.get(i) );
                }
            }
            if( qu.size() == 0 ){
                isReverse = !isReverse;
                System.out.println();
                while( st.size() > 0 ){
                    qu.add( st.remove(st.size() - 1) );
                }
            }
        }
    }




    public static void main(String[] args) {

        construct();
        // display(root);    
        // System.out.println( size(root.child.get(1)) );
        // System.out.println( max(root) );
        // ArrayList<Integer> ans = n2rp( root, 130 );
        // System.out.println(ans);
        // int lca = LCA(root,10,80);
        // if( lca != -1 ){
            // System.out.println(lca);
        // }else{
        //     System.out.println("lca do not exist");
        // }
        // System.out.println( find( root, 120 ) );
        // LOLWDisplay1(root);
            LOZZ(root);
    }
}