package prereqchecker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


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
 * ValidPreReqInputFile name is passed through the command line as args[1]
 * Read from ValidPreReqInputFile with the format:
 * 1. 1 line containing the proposed advanced course
 * 2. 1 line containing the proposed prereq to the advanced course
 * 
 * Step 3:
 * ValidPreReqOutputFile name is passed through the command line as args[2]
 * Output to ValidPreReqOutputFile with the format:
 * 1. 1 line, containing either the word "YES" or "NO"
 */
public class ValidPrereq {

     

    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
            return;
        }
        StdIn.setFile(args[0]); //set inputfile
        HashMap<String, ArrayList<String>> courses = new HashMap<>(); //make a graph
        HashMap<String, Boolean> mark = new HashMap<>(); //map that tells us if we visited a vertex or not
        makeAdjList(courses, mark);
        

        StdIn.setFile(args[1]);
        String advCourse = StdIn.readString();
        String proposedPrereq = StdIn.readString();
        StdOut.setFile(args[2]);
        StdOut.print(isValid(proposedPrereq, advCourse, courses, mark));



        
    
    }

    public static void makeAdjList(HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark)
    {
        int numOfCourses = StdIn.readInt(); //get the number of courses
        

    
        for (int i =0; i<numOfCourses; i++)
        {
            String course = StdIn.readString();            
            courses.put(course, new ArrayList<String>()); //put all the keys in the hashmap
            mark.put(course, false);
         
        }

        int numOfEdges = StdIn.readInt(); //get number of edges
       
        
            for(int j=0; j<numOfEdges; j++)
            {
                
                    String courseToTake = StdIn.readString();
                    String prereq = StdIn.readString();
                    courses.get(courseToTake).add(prereq);
            }

        
    }

    public static String isValid(String course, String proposedPrereq, HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark)
    {

        HashSet<String> prereqs = new HashSet<>();
        DFS(course, prereqs, courses, mark); //returns all the prereqs of advanced course or course 1
        if (prereqs.contains(proposedPrereq)) // if list of prereqs for advCourse contains course 2
        {
            return "NO";
        }
        else{
            return "YES";
        }

     


    }

    public static void DFS(String course, HashSet<String> prereqs, HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark)
    {
        for(String prereq: courses.get(course)) //getting the arraylist and putting each item in prereq
        {
             //if we have not visited that prereq
            
                if(!mark.get(prereq))
                {
                prereqs.add(prereq); //add that to the hashset of prereqs
                DFS(prereq, prereqs, courses, mark); //do dfs on the prereq of that prereq
                } //getting the prereqs of the prereqs till we have all direct and indirect prereqs
            
        }

        mark.put(course, true); //change to true because we done w it
    }

}


