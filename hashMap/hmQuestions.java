import java.util.*;

class hmQuestions{


    public static void maxFreqChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for( int i = 0 ; i < str.length() ; i++ ){
            char ch = str.charAt(i);

            if( map.containsKey( ch ) ){
                int oldfreq = map.get( ch );
                map.put( ch, oldfreq + 1 );
            }else{
                map.put( ch, 1 );
            }
        }

        int maxfreq = 1;
        char maxch = str.charAt(0);

        for( char key : map.keySet() ){
            int freq = map.get( key );
            System.out.println( key+ " -> "+ freq );
            if( freq > maxfreq ){
                maxfreq = freq;
                maxch = key;
            }
        }
        System.out.println( maxch );
    }

    public static void printCommonElements1(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for( int i = 0 ; i < a.length ; i++  ){
            map.put( a[i] , 1 );
        }

        for( int i = 0 ; i < b.length ; i++ ){
            if( map.containsKey( b[i] ) ){
                System.out.println( b[i] );
            }
        }
    }

    public static void printCommonElements2( int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for( int i = 0 ; i < a.length ; i++ ){
            if( map.containsKey( a[i] ) ){
                // int oldfreq = map.get( a[i] );
                map.put( a[i] , map.get(a[i]) + 1 );
            }else{
                map.put( a[i] , 1 );
            }
        }
        for( int i = 0 ; i < b.length ; i++ ){
            if( map.containsKey( b[i] ) ){
                System.out.println( b[i] );
                int oldfreq = map.get( b[i] );
                oldfreq--;   
                if( oldfreq > 0 ){
                    map.put(b[i], oldfreq );
                }else{
                    map.remove( b[i] );
                }
            }
        }
    }

    public static void main(String[] args) {
        // String str = "abababaaccbcbcabcbbcbcb";
        // maxFreqChar(str);
        int[] a = {1,5,10,6,27,9,8,7,5,6,20,27,3,7};
        int[] b = {3,3,30,27,37,27,5,30,27};
        printCommonElements2( a, b  );

        // HashMap<String , Integer> map = new HashMap<>();
        // map.put("india", 34567834 );
        // map.put("china", 92037449);
        // map.put("us", 67834 );
        // map.put("japan", 37449);
        // map.put("aust", 7834 );
        // map.put("brazil", 449);
        // map.put( "India", 100);
    
        // System.out.println( map.get( "india" ) );
        // map.remove( "india" );
        
        // if( map.containsKey( "india" ) == true ){
        //     System.out.println( map.get( "india" ) );
        // }else{
        //     System.out.println( "data do not exist" );
        // }

        // System.out.println( "size = " + map.size() );

        // for( String key : map.keySet() ){
        //     System.out.println( key + " -> " + map.get(key) );
        // }
    }



}