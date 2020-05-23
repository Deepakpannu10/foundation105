import java.util.*;

class myPQ{



    private ArrayList<Integer> list;

    myPQ(){
        list = new ArrayList<>();
    }

    private void swap( int i, int j ) {
        int temp = list.get(i);
        list.set(i, list.get( j ) );
        list.set( j, temp );
    }

    private void upheapify( int ci ) {
        int pi = ( ci - 1 ) / 2;
        if( ci != 0 && list.get( ci ) < list.get( pi ) ){
            swap( ci, pi );
            upheapify( pi );
        }
    }

    private void downheapify( int pi ){
        int lci = ( 2 * pi ) + 1;
        int rci = ( 2 * pi ) + 2;
        int si = pi;
        if( lci < list.size() && list.get( lci ) < list.get( pi ) ){
            si = lci;
        }
        if( rci < list.size() && list.get( rci ) < list.get( pi ) ){
            if( list.get( rci ) < list.get( lci ) ){
                si = rci;
            }            
        }
        if( si != pi ){
            swap( si, pi );
            downheapify( si );
        }
    }


    //--------------------------------

    public void add( int val ) {
        list.add( val );
        upheapify( list.size() - 1 );
    }

    public int remove() {
        swap(0, list.size() - 1);
        int remVal = list.remove( list.size() - 1 );
        downheapify( 0 );
        return remVal;
    }

    public int peek() {
        return list.get(0);
    }

    public int size() {
        return list.size();
    }










}