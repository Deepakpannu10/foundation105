import java.util.*;

class clientPQ{




    public static void main(String[] args) {
        myPQ pq = new myPQ();

        pq.add( 10 );
        pq.add( 20 );
        pq.add( 5 );
        pq.add( 23 );
        pq.add( 24 );
        pq.add( -1 );
        pq.add( -5 );
        pq.add( 78 );
        pq.add( 8 );


        while( pq.size() > 0 ){

            System.out.println( pq.remove() );

        }


        // PriorityQueue<Integer> pq = new PriorityQueue<>();   
    }
}