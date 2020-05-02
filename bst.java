class bst{
    static class node{
        int data;
        node left;
        node right;
        node( int d ){
            data = d; left = right = null;
        }
    }

    public static node construct( int[] values, int lo, int hi ){
        if( lo > hi ){
            return null;
        }else if( lo == hi ){
            return new node( values[lo] );
        }
        int mid = ( lo + hi) / 2;
        node root = new node( values[mid] );
        root.left = construct( values, lo , mid - 1 );
        root.right = construct( values, mid + 1, hi );
        return root;
    }

    public static void display(node root) {
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

    public static int height(node root) {
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

    public static int min(node root) {
        while( root.left != null ){
            root = root.left;
        }
        return root.data;
    }
    public static int max(node root) {
        while( root.right != null ){
            root = root.right;
        }
        return root.data;
    }
    public static int LCA( node root,int a, int b ) {
        if( root == null ){
            return Integer.MIN_VALUE;
        }
        if( a < root.data && b < root.data ){
            return LCA( root.left, a, b );
        }else if( a > root.data && b > root.data ){
            return LCA( root.right, a  , b );
        }else{
            return root.data;
        }
    }


    public static void main(String[] args) {
        int[] values = {10,20,30,40,50,60,70,80,90};
        node root = construct( values, 0 , values.length - 1 );
        display(root);
        System.out.println(size(root));
        System.out.println(height(root));
        System.out.println( LCA( root, 60, 90 ) );       
    }
}