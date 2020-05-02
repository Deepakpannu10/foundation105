import java.util.*;
class btree{

    static class node{
        int data;
        node left;
        node right;
        node(int d){
            data =d;
            left = null; right = null;
        }
    }

    static node root = null;

    public static void construct() {
        // int[] data = { 10,20,30,80,120,130,-1,-1,-1,-1,40,90,100,110,-1,-1,-1,-1,-1,50,60,-1,70 };
        // diameter k liye copy.
        // int[] data = { 10,20,30,80,-1,-1,40,-1,-1,50,60,-1,70 };
        // int[] data = { 50,30,10,-1,40,45,-1,-1,-1,70,60,-1,80 };
        int[] data={50,30,20,-1,40,37,-1,52,45,-1,-1,-1,-1,70,60,55,-1,-1,80,75,72,-1,-1,90};
        ArrayList<node> stack = new ArrayList<>();
        for( int i = 0 ; i < data.length ; i++ ){
            if( data[i] == -1 ){
                stack.remove( stack.size() - 1 );
            }else{
                node nn = new node( data[i] );
                if( root == null ){
                    root = nn;
                }else{
                    node cp = stack.get( stack.size() -1 );
                    if( cp.left == null ){
                        cp.left = nn;
                    }else{
                        cp.right = nn;
                    }
                }
                stack.add( nn );
            }
        }
    }


    public static void display( node root ){
        if( root == null ){
            return;
        }
        if( root.left != null ){
            System.out.print( root.left.data );
        }
        System.out.print(" <- "+ root.data + " -> " );
        if( root.right != null ){
            System.out.print( root.right.data );
        }
        System.out.println();
        if( root.left != null ){
            display( root.left );
        }
        if( root.right != null ){
            display( root.right );
        }
    }


    public static int size(node root) {
        if( root == null ){
            return 0;
        }
        int mySize = 1;
        if( root.left != null ){
            mySize += size( root.left );
        }
        if( root.right != null ){
            mySize += size( root.right );
        }
        return mySize;
    }

    public static int max( node root ) {
        if( root == null ){
            return Integer.MIN_VALUE;
        }
        int myMax = root.data;
        if( root.left != null ){
            int lm = max( root.left );
            if( myMax < lm ){
                myMax = lm;
            }
        }
        if( root.right != null ){
            int rm = max( root.right );
            if( rm > myMax ){
                myMax = rm;
            } 
        }
        return myMax;
    }


    
    public static int min( node root ) {
        if( root == null ){
            return Integer.MAX_VALUE;
        }
        int myMin = root.data;
        if( root.left != null ){
            int lm = min( root.left );
            if( myMin > lm ){
                myMin = lm;
            }
        }
        if( root.right != null ){
            int rm = min( root.right );
            if( rm < myMin ){
                myMin = rm;
            } 
        }
        return myMin;
    }


    public static boolean find( node root, int val ){
        if( root == null ){
            return false;
        }
        if( root.data == val ){
            return true;
        }
        if( root.left != null ){
            boolean lans = find( root.left, val );
            if( lans == true ){
                return true;
            }
        }
        if( root.right != null ){
            boolean rans = find( root.right, val );
            if( rans == true ){
                return true;
            }
        }
        return false;
    }


    public static int height( node root){
        if( root == null ){
            return 0;
        }
        int myHeight = 0;
        if( root.left != null ){
            myHeight = height( root.left );
        }
        if( root.right != null ){
            int rh = height( root.right );
            if( myHeight < rh ){
                myHeight = rh;
            }
        }
        return myHeight+1;
    }


    public static void preOrder( node root ){
        if( root == null ){
            return;
        }
        System.out.print( root.data+" " );
        if( root.left != null ){
            preOrder( root.left );
        }
        if( root.right != null ){
            preOrder( root.right );
        }
    }
    public static void inOrder( node root ) {
        if( root == null ){
            return;
        }
        if( root.left != null  ){
            inOrder( root.left ); 
        }
        System.out.print( root.data+" " );
        if( root.right != null ){
            inOrder( root.right );
        }
    }
    public static void postOrder( node root ) {
        if( root == null ){
            return;
        }
        if( root.left != null  ){
            postOrder( root.left ); 
        }
        if( root.right != null ){
            postOrder( root.right );
        }
        System.out.print( root.data+" " );
    }


    public static node preInConstruct( int[] pre, int[] in, int ps, int pe, int is, int ie ) {
        if( ps == pe ){
            node baseNode = new node( pre[ps] );
            return baseNode;
        }
        if( ps > pe ){
            return null;
        }
        node croot = new node( pre[ps] );
        int i = is;
        int count = 0;
        while( pre[ps] != in[i] ){
            count++;
            i++;
        }
        // pre-> Node Left Right
        // in -> Left Node Right
        croot.left  = preInConstruct(pre,in, ps + 1 , ps + count , is , i - 1  ); // left sub tree 
        croot.right = preInConstruct(pre,in, ps+count+1 , pe , i + 1  , ie  ); // right sub tree
        return croot;
    }


    //---------------------------------------------
    // diameter n^2 
    public static int diameter( node root ){
        if( root == null ){
            return 0;
        }
        int ld = diameter( root.left );
        int rd = diameter( root.right);

        int lh = height( root.left );
        int rh = height( root.right );

        int myDia = Math.max( lh + rh + 1, Math.max( ld, rd ) );
        return myDia;
    }


    static class diaHelper{
        int ht = 0;
        int dia = 0;
    }

    // diameter dp n^1

    public static diaHelper diameterDP( node root ){
        if( root == null ){
            diaHelper baseAns = new diaHelper();
            return baseAns;
        }else if( root.left == null && root.right == null ){
            diaHelper baseAns = new diaHelper();
            baseAns.ht = 1;
            baseAns.dia = 1;
            return baseAns;
        }
        diaHelper lAns = diameterDP( root.left );
        diaHelper rAns = diameterDP( root.right );
        diaHelper myAns = new diaHelper();
        myAns.dia = Math.max( lAns.ht + rAns.ht + 1, Math.max( lAns.dia, rAns.dia ));
        myAns.ht = Math.max( lAns.ht, rAns.ht ) + 1;
        return myAns;
    }

    //----------------
    static class balHelper{
        boolean isBal = true;
        int ht = 0;
    }


    public static boolean isTreeBalanced( node root ){
        if( root == null ){
            return true;
        }else if( root.left == null && root.right == null ){
            return true;
        }
        boolean lb = isTreeBalanced( root.left );
        boolean rb = isTreeBalanced( root.right );

        int lh = height( root.left );
        int rh = height( root.right );

        boolean mybal = lb && rb && lh-rh >= -1 && lh - rh <= 1;
        return mybal;
    }




    public static balHelper isTreeBalancedDP( node root ){
        if( root == null ){
            balHelper baseAns = new balHelper();
            return baseAns;
        }else if( root.left == null && root.right == null ){
            balHelper baseAns = new balHelper();
            baseAns.isBal =  true;
            baseAns.ht = 1;
            return baseAns;
        }
        balHelper lAns = isTreeBalancedDP( root.left );
        balHelper rAns = isTreeBalancedDP( root.right );

        balHelper myAns = new balHelper();
        myAns.isBal = lAns.isBal && rAns.isBal && lAns.ht  - rAns.ht >= -1 && lAns.ht  - rAns.ht <= 1;
        myAns.ht = Math.max( lAns.ht, rAns.ht ) + 1;
        return myAns;
    }


    public static boolean isTreeBST( node root ){
        if( root == null ){
            return true;
        }else if( root.left == null && root.right == null ){
            return true;
        }
        boolean lbst =  isTreeBST( root.left );
        if(  lbst == false ){
            return false;
        }
        boolean rbst = isTreeBST( root.right );
        if( rbst == false ){
            return false;
        }
        int lmax = max( root.left );
        int rmin = min( root.right );
        return lmax < root.data && root.data < rmin;
    }

    static class bstHelper{
        int min =  Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isBst = true;
        int size = 0;
        node lBSTRoot = null;
    }


    public static bstHelper isTreeBSTDP(node root){
        if( root == null ){
            return new bstHelper();
        }else if( root.left == null && root.right == null ){
            bstHelper baseAns = new bstHelper();
            baseAns.min = root.data;    baseAns.max = root.data;
            return baseAns;
        }
        bstHelper lAns = isTreeBSTDP( root.left );
        bstHelper rAns = isTreeBSTDP( root.right );
        bstHelper myAns = new bstHelper();
        myAns.isBst = lAns.isBst && rAns.isBst && lAns.max < root.data && root.data < rAns.min ;
        if( myAns.isBst ){
            if( root.left != null ){
                myAns.min = lAns.min;
            }else{
                myAns.min = root.data;
            }

            if( root.right != null ){
                myAns.max = rAns.max;
            }else{
                myAns.max = root.data;
            }
        }
        return myAns;
    }


    public static bstHelper largestTreeBSTDP(node root){
        if( root == null ){
            return new bstHelper();
        }else if( root.left == null && root.right == null ){
            bstHelper baseAns = new bstHelper();
            baseAns.min = root.data;    baseAns.max = root.data;    baseAns.size = 1; baseAns.lBSTRoot = root;
            return baseAns;
        }
        bstHelper lAns = largestTreeBSTDP( root.left );
        bstHelper rAns = largestTreeBSTDP( root.right );
        bstHelper myAns = new bstHelper();
        myAns.isBst = lAns.isBst && rAns.isBst && lAns.max < root.data && root.data < rAns.min ;
        if( myAns.isBst ){
            if( root.left != null ){
                myAns.min = lAns.min;
            }else{
                myAns.min = root.data;
            }

            if( root.right != null ){
                myAns.max = rAns.max;
            }else{
                myAns.max = root.data;
            }
            myAns.size = lAns.size + rAns.size + 1;
            myAns.lBSTRoot = root;
        }else{
            if( lAns.size > rAns.size ){
                myAns.size = lAns.size;
                myAns.lBSTRoot = lAns.lBSTRoot;
            }else{
                myAns.size = rAns.size;
                myAns.lBSTRoot = rAns.lBSTRoot;
            }
        }
        return myAns;
    }



    public static void main(String[] args) {
        construct();
        // display( root );
        // System.out.println( "size = "+size(root) );
        // System.out.println( "max = "+max(root) );
        // System.out.println( "height = "+height(root) );
        // System.out.println( "find = "+find(root , 100) );
        // preOrder( root );
        // System.out.println( " <- pre. ");
        // inOrder( root );
        // System.out.println( " <- in. ");
        // int[] pre = { 10,20,30,40,50,60,70,80 };
        // int[] in = { 20,40,30,50,10,60,80,70 };

        // node root1 = preInConstruct(pre, in, 0 , pre.length - 1 , 0 , in.length - 1);       
        // display( root1 );
    //    System.out.println( diameter( root ) );
        // diaHelper ans = diameterDP( root );
        // balHelper ans = isTreeBalancedDP( root );
        // System.out.println( ans.isBal );
        // System.out.println( isTreeBST( root ) );
        // bstHelper ans = isTreeBSTDP( root );
        // System.out.println( ans.isBst );
        bstHelper ans = largestTreeBSTDP( root );
        System.out.println( ans.lBSTRoot.data+" - >  " + ans.size);
    }
}