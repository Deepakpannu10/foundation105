import java.util.*;
class clientHm{


    public static void main(String[] args) {
        // hashMap<String , Integer> map = new hashMap<>();
        // map.put( "india", 100 );
        // map.put( "china", 1000 );
        // map.put( "sirlanka", 10 );
        // map.put( "brazil", 1 );
        // map.put( "pakistan", 300 );

        // System.out.println(map.size());
        // // map.remove( "pakistan" );
        // if( map.containsKey( "pakistan" ) ){
        //     System.out.println( map.get("pakistan") );
        // }
        // System.out.println(map.size());
        // for( String key: map.keySet() ){
        //     System.out.println( key+" -> " + map.get( key ) );
        // }

        hashMap<Integer , Integer> map = new hashMap<>();
        map.put( 1, 100 );
        map.put( 2, 1000 );
        map.put( 1000, 10 );
        map.put( 10, 1 );
        map.put( 2, 300 );

        System.out.println(map.size());
        map.remove( 1 );

        if( map.containsKey( 1 ) ){
            System.out.println( map.get(1) );
        }
        System.out.println(map.size());
        
        for( Integer key: map.keySet() ){
            System.out.println( key+" -> " + map.get( key ) );
        }
    }
}