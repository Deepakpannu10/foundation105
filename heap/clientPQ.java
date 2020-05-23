import java.util.*;

class clientPQ{

    static class student implements Comparable<student>{
        int rollNumber;
        String name;
        int marks;
        student( int r, String n, int m ){
            this.rollNumber = r;
            this.name = n;
            this.marks = m;
        }
        public int compareTo( student other ){
            return  other.marks - this.marks ;
        }
    }


    public static void main(String[] args) {
        myPQ<student> pq = new myPQ<>();
        pq.add( new student( 1,"a",120) );
        pq.add(new student(2,"b",30) );
        pq.add(new student(3,"c",220) );
        pq.add(new student(4,"d",20) );
        pq.add(new student(5,"e",1120) );
        pq.add(new student(6,"f",320 ));
        pq.add(new student(7,"g",50 ));
        pq.add(new student(8,"h",10 ));

        while( pq.size() > 0 ){
            student stud = pq.remove();
            System.out.println( stud.rollNumber+"->  name "+ stud.name+", marks= " + stud.marks );
        }

        // PriorityQueue<Integer> pq = new PriorityQueue<>();   
    }
}