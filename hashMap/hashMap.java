import java.util.*;

class hashMap< K, V >{

    private class HMnode{
        K key;
        V value;
        HMnode( K key, V value ){
            this.key = key;   this.value = value;
        }
    }

    private int size;
    private LinkedList<HMnode> [] buckets;


    hashMap(){
        this.size = 0;
        buckets = new LinkedList[4];
        for( int i = 0 ; i < 4 ; i++ ){
            buckets[i] = new LinkedList<>();
        }
    }

    // ----- private functions
    private int hashFunction( K key ){
        int hc = key.hashCode();
        if( hc < 0 ){
            hc = -hc;
        }
        int bi = hc % buckets.length;
        return bi;
    }

    private int findInBucket( int bi , K key){
        int ki = 0;
        LinkedList<HMnode> clist = buckets[bi];
        for( HMnode node : clist ){
            if( node.key == key ){
                return ki;
            }
            ki++;
        }
        return -1;
    }

    private void rehash(){
        LinkedList<HMnode>[] oldBuckets = this.buckets;
        this.buckets = new LinkedList[ 2 * oldBuckets.length ];
        for( int i = 0 ; i < buckets.length ; i++ ){
            buckets[i] = new LinkedList<>();
        }
        for( int b = 0; b < oldBuckets.length ; b++ ){
            LinkedList<HMnode> oldList = oldBuckets[b];
            for( HMnode oldNode : oldList ){
                put( oldNode.key, oldNode.value );
            }
        }
    }


    // public functions

    public void put( K key, V value ){
        int bi = hashFunction( key );
        int ki = findInBucket( bi, key );

        if( ki == -1 ){
            HMnode cn = new HMnode(key, value);
            buckets[bi].addLast( cn );
            size++;
        }else{
            HMnode updateNode = buckets[bi].get(ki);
            updateNode.value = value;
        }

        if( 2.0 < ((this.size * 1.0 ) / buckets.length ) ){
            rehash();
        }        
    }

    public boolean containsKey( K key ){
        int bi = hashFunction( key );
        int ki = findInBucket( bi, key );
        if( ki == -1 ){
            return false;
        }else{
            return true;
        }
    }

    public V get( K key ){
        int bi = hashFunction( key );
        int ki = findInBucket( bi, key ); 

        if( ki == -1 ){
            return null;
        }else{
            HMnode cn = buckets[bi].get( ki );
            return cn.value;
        }
    }


    public V remove( K key ){
        int bi = hashFunction( key );
        int ki = findInBucket(bi ,key );

        if( ki == -1 ){
            return null;
        }else{
            HMnode removeNode = buckets[bi].remove(ki);
            size--;
            return removeNode.value;
        }
    }

    public Set<K> keySet(){
        Set<K> ks = new HashSet<>();

        for( int b = 0 ; b < buckets.length ; b++ ){
            for( HMnode node : buckets[b] ){
                ks.add( node.key );
            }
        }
        return ks;
    }

    public int size(){
        return this.size;
    }
}
