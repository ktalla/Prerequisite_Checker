package prereqchecker;

import java.util.*;



/**
 * 
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
 * EligibleInputFile name is passed through the command line as args[1]
 * Read from EligibleInputFile with the format:
 * 1. c (int): Number of courses
 * 2. c lines, each with 1 course ID
 * 
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2]
 * Output to EligibleOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class Eligible {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
            return;
        }

        StdIn.setFile(args[0]);
        HashMap<String, ArrayList<String>> courses = new HashMap<>(); //make a graph
        HashMap<String, Boolean> mark = new HashMap<>(); //map that tells us if we visited a vertex or not
        HashSet<String> prereqs = new HashSet<>();
        ArrayList<String> coursesYouCanTake = new ArrayList<>();
        makeAdjList(courses, mark);

        StdIn.setFile(args[1]);

        int numOfCourses = StdIn.readInt();
        Collection <String> coursesTaken = new ArrayList<>(); 
        for(int i=0; i<numOfCourses; i++) //add all the courses taken
        {
            String course = StdIn.readString();
            coursesTaken.add(course);
        }

        method(coursesTaken, courses, mark, prereqs); //prereqs should be filled with direct and indirect classes you have taken

        for(String course: courses.keySet()) //get a course
        {
            Boolean canTakeCourse=true;
            if(!prereqs.contains(course)) //if you have not taken the course
            {
               ArrayList<String> listOfPrereqs= courses.get(course); //get course you have not taken's prereq
               for(int i=0; i<listOfPrereqs.size(); i++)
               {
                   String prereq=listOfPrereqs.get(i);
                   if(!prereqs.contains(prereq)) //if you have not taken the prereq of the course
                   {
                       canTakeCourse=false; //then you cant take the course
                       
                   }
               }
               if(canTakeCourse) //if you can take the course (so it never switched to false), add it to the coursesyoucantake
               coursesYouCanTake.add(course);
               
            }
            
        }


        StdOut.setFile(args[2]);
       for(String courseYCN: coursesYouCanTake)
       {
           StdOut.println(courseYCN);
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

    public static HashSet method(Collection<String> coursesTaken, HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark, HashSet<String> prereqs)
    {
       
        for (String coursetk: coursesTaken) 
        { 
            prereqs.add(coursetk); //add all courses taken
            DFS(coursetk, prereqs, courses, mark); //add all the direct and indirect prereqs taken
        }

            return prereqs;

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
