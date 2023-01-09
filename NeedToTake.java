package prereqchecker;

import java.util.*;


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
 * NeedToTakeInputFile name is passed through the command line as args[1]
 * Read from NeedToTakeInputFile with the format:
 * 1. One line, containing a course ID
 * 2. c (int): Number of courses
 * 3. c lines, each with one course ID
 * 
 * Step 3:
 * NeedToTakeOutputFile name is passed through the command line as args[2]
 * Output to NeedToTakeOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class NeedToTake {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java NeedToTake <adjacency list INput file> <need to take INput file> <need to take OUTput file>");
            return;
        }

        StdIn.setFile(args[0]);
        HashMap<String, ArrayList<String>> courses = new HashMap<>(); //make a graph
        HashMap<String, Boolean> mark = new HashMap<>(); //map that tells us if we visited a vertex or not
        HashSet<String> prereqsOfTakenCourses = new HashSet<>();
        HashSet<String> prereqsOfTargetCourses = new HashSet<>();
        ArrayList<String> coursesYouNeed = new ArrayList<>();

        makeAdjList(courses, mark);

        StdIn.setFile(args[1]);
        String targetCourse = StdIn.readString();
        int numOfTakenCourses = StdIn.readInt();

        for(int i =0; i<numOfTakenCourses; i++)
        {
            String course = StdIn.readString();
            prereqsOfTakenCourses.add(course);
            DFS(course, prereqsOfTakenCourses, courses, mark); //now all courses are in prereqs
        }

        // for(String prereq: prereqsOfTakenCourses)
        // {
        //     System.out.println(prereq);
        // }


        DFS(targetCourse, prereqsOfTargetCourses, courses, mark);
        
        for(String prereq: prereqsOfTargetCourses) //get all the prereqs of target course
        { //System.out.println(prereq);
            if(!prereqsOfTakenCourses.contains(prereq)) //if you have not taken the prereq of target course
            {
                coursesYouNeed.add(prereq);
            }
        }

        StdOut.setFile(args[2]);
        for(String courseYN: coursesYouNeed)
        {
            StdOut.println(courseYN);
        }
        

	
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

    public static void DFS(String course, HashSet<String> prereqsOfTakenCourses, HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark)
    {
        
        for(String prereq: courses.get(course)) //getting the arraylist and putting each item in prereq
        {
             //if we have not visited that prereq
            
                if(!mark.get(prereq))
                {
                prereqsOfTakenCourses.add(prereq); //add that to the hashset of prereqs
                DFS(prereq, prereqsOfTakenCourses, courses, mark); //do dfs on the prereq of that prereq
                } //getting the prereqs of the prereqs till we have all direct and indirect prereqs
            
        }

        mark.put(course, true); //change to true because we done w it
    }

}
