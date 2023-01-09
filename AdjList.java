package prereqchecker;

import java.util.ArrayList;
import java.util.HashMap;




/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * AdjListOutputFile name is passed through the command line as args[1]
 * Output to AdjListOutputFile with the format:
 * 1. c lines, each starting with a different course ID, then 
 *    listing all of that course's prerequisites (space separated)
 */
public class AdjList {
    public static void main(String[] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }
        StdIn.setFile(args[0]); //set inputfile
        int numOfCourses = StdIn.readInt(); //get the number of courses
        HashMap<String, ArrayList<String>> courses = new HashMap<>(); //make a graph

    
        for (int i =0; i<numOfCourses; i++)
        {
            String course = StdIn.readString();            
            courses.put(course, new ArrayList<String>()); //put all the keys in the hashmap
         
        }

        int numOfEdges = StdIn.readInt(); //get number of edges
       
        
            for(int j=0; j<numOfEdges; j++)
            {
                
                    String courseToTake = StdIn.readString();
                    String prereq = StdIn.readString();
                    courses.get(courseToTake).add(prereq);
            }
    

        StdOut.setFile(args[1]);
        for(String course: courses.keySet())
        {
            ArrayList<String> newArr = courses.get(course);
            StdOut.print(course+ " ");
            for(String prereqs: newArr)
            {
                StdOut.print(prereqs+ " ");
            }
            StdOut.println();
        }


	
    }

}
