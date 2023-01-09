package prereqchecker;

import java.lang.reflect.Array;
import java.util.*;

import javax.swing.text.TabExpander;



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
 * SchedulePlanInputFile name is passed through the command line as args[1]
 * Read from SchedulePlanInputFile with the format:
 * 1. One line containing a course ID
 * 2. c (int): number of courses
 * 3. c lines, each with one course ID
 * 
 * Step 3:
 * SchedulePlanOutputFile name is passed through the command line as args[2]
 * Output to SchedulePlanOutputFile with the format:
 * 1. One line containing an int c, the number of semesters required to take the course
 * 2. c lines, each with space separated course ID's
 */
 public class SchedulePlan {
//     public static void main(String[] args) {

//         if ( args.length < 3 ) {
//             StdOut.println("Execute: java -cp bin prereqchecker.SchedulePlan <adjacency list INput file> <schedule plan INput file> <schedule plan OUTput file>");
//             return;
            
//         }
//         HashMap<String, ArrayList<String>> courses = new HashMap<>(); //make a graph
//         HashMap<String, Boolean> mark = new HashMap<>(); //map that tells us if we visited a vertex or not
//         StdIn.setFile(args[0]);
//         makeAdjList(courses, mark); //make adjlist

//         StdIn.setFile(args[1]);
//         String targetCourse = StdIn.readString();
//         int numOfTakenCourses = StdIn.readInt(); 
//         HashSet<String> takenCourses = new HashSet<>(); //courses taken

//         for(int i=0; i<numOfTakenCourses; i++ )
//         {
//         String coursetaken = StdIn.readString(); //get taken course from input
//         takenCourses.add(coursetaken); //add taken course to set of taken courses
//         DFS(coursetaken, takenCourses, courses, mark); //now all courses are in takencourses  

//         }
//         // for(String course: takenCourses)
//         // {
//         //     System.out.println(course);;  
//         //   }

//         //now we must determine what courses you need
//         HashSet<String> prereqsOfTargetCourses = new HashSet<>(); //all the prereqs of the target course
//          //all the courses you need to take
//         //get all the prereqs of target course
//         int semCount=0;
//         HashMap <Integer, ArrayList<String>> reverseSchedule = new HashMap<>();
//         HashSet<String> coursesYouNeed = getCoursesYouNeed(targetCourse, prereqsOfTargetCourses, takenCourses, courses, mark); //which prereqs u still need to take

//     for(String course: mark.keySet())
//     {
//         mark.replace(course, false);
//     }
//         DFT(targetCourse, coursesYouNeed, courses, mark, semCount, reverseSchedule);
//         // for(String course: coursesYouNeed)
//         // {
//         //     System.out.print(course);;  
//         //   }

//         //for all the courses you need, get the prereqs of that course
//         //if there are no prereqs, then add that course

//        // 
//        // HashSet <String> prereqsForCourseID = new HashSet();
//        /// ArrayList<String> coursesForSem = new ArrayList<>();
//        // HashMap <Integer, HashSet<String>> Schedule = getCoursesForSem(targetCourse, prereqsOfTargetCourses, takenCourses, courses, mark, coursesYouNeed);
//         // for(int sem: Schedule.keySet())
//         // {
        
//         // for(String course: Schedule.get(sem))
//         //     {
//         //     System.out.print(course+ " ");
//         //     }

//         //     System.out.println();
//         // }

//         ArrayList<ArrayList<String>> Schedule = getSchedule(reverseSchedule);

//         StdOut.setFile(args[2]);
//         StdOut.println(Schedule.size());
//         for( ArrayList<String> sem: Schedule)
//         {
//             for(String course: sem)
//             StdOut.print(course+ " ");

//             StdOut.println();
//         }
//         // for(int semCount: Schedule.keySet())
//         // {
//         // HashSet<String> coursesPerSem = Schedule.get(semCount);
//         //     //StdOut.print(course+ " ");
//         //     for(String course: coursesPerSem)
//         //     {
//         //         StdOut.print(course+ " ");
//         //     }
//         //     StdOut.println();
//         // }

         
       






        
//     }

// public static void makeAdjList(HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark)
// {
// int numOfCourses = StdIn.readInt(); //get the number of courses

// for (int i =0; i<numOfCourses; i++)
// {
//     String course = StdIn.readString();            
//     courses.put(course, new ArrayList<String>()); //put all the keys in the hashmap
//     mark.put(course, false);
 
// }

// int numOfEdges = StdIn.readInt(); //get number of edges
// for(int j=0; j<numOfEdges; j++)
// {
    
//         String courseToTake = StdIn.readString();
//         String prereq = StdIn.readString();
//         courses.get(courseToTake).add(prereq);
// }

// }

// public static void DFS(String course, HashSet<String> prereqs, HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark)
// {

// for(String prereq: courses.get(course)) //getting the arraylist and putting each item in prereq
// {
//      //if we have not visited that prereq
    
//         if(!mark.get(prereq))
//         {
//         //System.out.println(prereq);
//         prereqs.add(prereq); //add that to the hashset of prereqsOftargetcourses
//         DFS(prereq, prereqs, courses, mark); //do dfs on the prereq of that prereq
//         } //getting the prereqs of the prereqs till we have all direct and indirect prereqs
    
// }

//     mark.put(course, true); //change to true because we done w it

// }

// public static void DFT(String startingCourse, HashSet<String> coursesYouNeed, HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark, int semCount, HashMap<Integer, ArrayList<String>> reverseSchedule)
// {

//     for(String course: courses.get(startingCourse)) //getting the arraylist and putting each item in prereq
//     {
//      //if we have not visited that prereq
    
//         if(!mark.get(course))
//         {
//             if(!coursesYouNeed.contains(course))
//             {
//                 return;
//             }
//             else{
//                 if(reverseSchedule.containsKey(semCount+1))
//                     reverseSchedule.get(semCount+1).add(course);
//                 else{
//                     ArrayList<String> newSemesterList = new ArrayList<>();
//                     newSemesterList.add(course);
//                     reverseSchedule.put(semCount+1, newSemesterList);

//                 }
                    
//                 mark.put(course, true);
//               //  System.out.println(course+": " + (semCount+1));
//                 DFT(course, coursesYouNeed, courses, mark, semCount+1, reverseSchedule);
//                }

//     //    // System.out.println(prereq);
//     //     prereqs.add(prereq); //add that to the hashset of prereqsOftargetcourses
//     //     DFS(prereq, prereqs, courses, mark); //do dfs on the prereq of that prereq
//         } //getting the prereqs of the prereqs till we have all direct and indirect prereqs
   
//     }
// }

// //     mark.put(course, true); //change to true because we done w it

// // }

// public static HashSet<String> getCoursesYouNeed(String targetCourse, HashSet<String> prereqsOfTargetCourses, Collection<String> takenCourses, 
// HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark) 
// {
// HashSet<String> coursesYouNeed = new HashSet<>();
// DFS(targetCourse, prereqsOfTargetCourses, courses, mark);
// // for(String course: prereqsOfTargetCourses)
// // {
// //     System.out.println(course);
// // }

// for(String prereq: prereqsOfTargetCourses) //get all the prereqs of target course
// { //System.out.println(prereq);
//     if(!takenCourses.contains(prereq)) //if you have not taken the prereq of target course
//     {
//         coursesYouNeed.add(prereq);
//     }
// }

// // for(String course: coursesYouNeed)
// // {
// //     System.out.println(course);
// // }

// return coursesYouNeed;

// }

// public static ArrayList<ArrayList<String>> getSchedule (HashMap<Integer, ArrayList<String>> reverseSchedule)
// {
//     ArrayList<ArrayList<String>> Schedule = new ArrayList<>();
//     for(int i = reverseSchedule.size(); i>0; i--)   
//     {
//         Schedule.add(reverseSchedule.get(i));
//     }  
//     return Schedule;

// }

// // public static HashMap<Integer, HashSet<String>> getCoursesForSem(String targetCourse, HashSet<String> prereqsOfTargetCourses,
// // Collection<String> takenCourses, HashMap<String, ArrayList<String>> courses, HashMap<String, Boolean> mark, HashSet<String> coursesYouNeed) 
// // {
 
// // HashMap<Integer, HashSet<String>> Schedule = new HashMap<>();
// // int semCount=1;
// // HashSet<String> prereqsForCourseID = new HashSet<>(); // 
// // HashSet<String> coursesYouCanTakeInSem = new HashSet<>(); //
// // while(!coursesYouNeed.isEmpty()) //while courses you need is not zero
// // {
// //     for(String course: coursesYouNeed) //for every course you need
// //     {
        
// //          //prereqsForCourseID = getCoursesYouNeed(course, prereqsForCourseID, takenCourses, courses, mark); //get the courses you need for that course and store in prereqsforcourseID
// //         //  for(String course2: mark.keySet())
// //         //  {
// //         //      mark.replace(course2, false);  
// //         //  }
// //         if(prereqsForCourseID.isEmpty()) //if you took all the prereqs for this course
// //         {
// //             //System.out.println(course);
// //             coursesYouCanTakeInSem.add(course); //add the course to courses persem
// //             //coursesYouNeed.remove(course);
// //         }
// //         prereqsForCourseID.clear();
// //     } 
// //     //at the end of this. it will tell you all the courses you need to take for the next sem
// // if(!coursesYouCanTakeInSem.isEmpty())
// // {
// //     HashSet<String> deepCopy = new HashSet<>();
// //     for(String course: coursesYouCanTakeInSem)
// //     {
// //         deepCopy.add(course);
// //     }
// //     Schedule.put(semCount, deepCopy);
// //     semCount++;
// //     coursesYouNeed.removeAll(deepCopy);
// //     for(String coursetaken: deepCopy)
// //     {
// //         takenCourses.add(coursetaken);
// //     }
// //     coursesYouCanTakeInSem.clear();
// // }


// // // for(String coursetaken: coursesForSem)
// // // {
// // //     takenCourses.add(coursetaken);
// // // }
// // // coursesForSem.clear();
// //  }

// // return Schedule;

// // }




// }

    public static void main(String[] args) 
    {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.SchedulePlan <adjacency list INput file> <schedule plan INput file> <schedule plan OUTput file>");
            return;
        }

        HashMap <String, ArrayList<String>> coursesPrereq = new HashMap<>(); 
        HashMap <String, Boolean> isVisitedNeeded = new HashMap<>();
        HashMap <String, Boolean> isVisitedCompleted = new HashMap<>();
        ArrayList<String> coursesTaken = new ArrayList<String> ();
        HashSet<String> preReqCompleted = new HashSet<String>();
        HashSet<String> preReqNeeded = new HashSet<String>();
        HashMap <String, ArrayList<String>> coursesLeftToTake = new HashMap<>(); 
               
        StdIn.setFile(args[0]); 
    
        int totalCourses = StdIn.readInt(); 
    
        for (int i = 0; i < totalCourses; i++)
        {
            String course = StdIn.readString();            
            coursesPrereq.put(course, new ArrayList<String>()); 
            isVisitedNeeded.put(course, false);
            isVisitedCompleted.put(course, false);
        }
    
        int numofCoursesTaken = StdIn.readInt(); 
    
        for(int j = 0; j < numofCoursesTaken; j++)
        {
                String Courses = StdIn.readString();
                String prereq = StdIn.readString();
                coursesPrereq.get(Courses).add(prereq);
        }
        // end of AdjList Code 
        
        
        //get Target course and courses taken
        StdIn.setFile(args[1]); 
        String targetCourse = StdIn.readString();
        //Get required prereq for target course
        DFS(targetCourse, preReqNeeded, coursesPrereq, isVisitedNeeded);   
        
        int numCourses = StdIn.readInt(); 
        for (int i = 0; i < numCourses; i++) {
            String x = StdIn.readString(); 
            coursesTaken.add(x); 
        }
        
        //Get completed preReq
        for(String course:coursesTaken) {
        	preReqCompleted.add(course);
        	DFS(course, preReqNeeded,coursesPrereq, isVisitedNeeded); 
        }
        
        //Check if pre req for target is already complete
        HashMap<String,String> coursesToSchedule = new HashMap<String,String>();
        for(String preReqTarget:preReqNeeded) {
        	if(checkIfRequired(preReqTarget,preReqCompleted)) {
        		coursesToSchedule.put(preReqTarget, preReqTarget);
        	}
        }
        
        TreeMap<Integer,ArrayList<String>> schedulePlan = new TreeMap<Integer,ArrayList<String>>();
        int max = 0;
        for(String courseSchedule:coursesToSchedule.keySet()) {
        	HashMap<String,String> coursesRequired = new HashMap<String,String>();
        	getPreReq(courseSchedule,coursesRequired,coursesPrereq);
        	matchCompletedCourses(coursesRequired,preReqCompleted);
        	coursesLeftToTake.put(courseSchedule, new ArrayList(coursesRequired.keySet()));
        	if(max <coursesRequired.size()) {
        		max = coursesRequired.size();
        	}
        	int semester = coursesRequired.size()+1;
        	if(schedulePlan.get(semester) ==null) {
        		ArrayList<String> courses = new ArrayList();
        		courses.add(courseSchedule);
        		schedulePlan.put(semester, courses);
        	}
        	else {
        		schedulePlan.get(semester).add(courseSchedule);
        	}
        	
        }
        
        for(int i=1;i<=(max+1);i++) {
        	if(schedulePlan.get(i)==null && i<(max+1)) {
        		schedulePlan.put(i, schedulePlan.get(i+1));
        		schedulePlan.put(i+1, null);
        	}
        }
        
        if(schedulePlan.get(schedulePlan.size())==null) {
        	schedulePlan.remove(schedulePlan.size());
        }
        TreeMap<Integer,ArrayList<String>> scheduleFinal = new TreeMap<Integer,ArrayList<String>>();
        checkPreviousSemester(coursesLeftToTake,schedulePlan,scheduleFinal);
        
        StdOut.setFile (args[2]);
        int count = 0; 
        for(ArrayList<String> coursesSem:scheduleFinal.values()) {
        	if(coursesSem!=null && !coursesSem.isEmpty()) {
        		count++;
        	}
        }
        StdOut.println(count);
        
        for(ArrayList<String> coursesSem:scheduleFinal.values()) {
        	if(coursesSem!=null && !coursesSem.isEmpty()) {
        		for(String coursePrint:coursesSem) {
        			StdOut.print(coursePrint + " ");
        		}
        		StdOut.println();
        	}
        }
                    
     }

	private static boolean checkIfRequired(String preReqTarget, HashSet<String> preReqCompleted) {
		for(String preReq:preReqCompleted) {
			if(preReqTarget.equalsIgnoreCase(preReq)) {
				return false;
			}
		}
		return true;
	}
	
	public static void DFS (String courseID, HashSet <String> preReqRequired, HashMap <String, ArrayList<String>> coursesPrereq, HashMap <String, Boolean> isVisited) {
	
	    ArrayList<String> preReqList = coursesPrereq.get(courseID); 
	
	    for (int i = 0; i < preReqList.size(); i++) {
	        
	        if (!isVisited.get(courseID)) { 
	
	        	preReqRequired.add(preReqList.get(i));
	            DFS(preReqList.get(i), preReqRequired, coursesPrereq, isVisited);
	        }
	    }
	    isVisited.put(courseID, true); 
	
	
	}
	
	public static void getPreReq (String courseID, HashMap <String,String> preReqRequired, HashMap <String, ArrayList<String>> coursesPrereq) {
		
	    ArrayList<String> preReqList = coursesPrereq.get(courseID); 
	
	    for (int i = 0; i < preReqList.size(); i++) {
	    		preReqRequired.put(preReqList.get(i),preReqList.get(i));
	    		getPreReq(preReqList.get(i), preReqRequired, coursesPrereq);
	    }
	   
	}
	
	public static void matchCompletedCourses(HashMap <String,String> coursesRequired, HashSet <String> preReqCompleted) {
		for(String course:preReqCompleted ) {
			coursesRequired.remove(course);
		}
		
	}
	
	public static void checkPreviousSemester(HashMap <String, ArrayList<String>> coursesLeft,TreeMap<Integer,ArrayList<String>> schedulePlan,TreeMap<Integer,ArrayList<String>> scheduleFinal) {
		scheduleFinal.putAll(schedulePlan);
		
			for(int i=2;i<=schedulePlan.size();i++) {
				for(int j=1;j<i;j++) {
					ArrayList<String> courses= new ArrayList<String>(schedulePlan.get(i));
					for(String course:courses) {
						checkPreReqCompleted(coursesLeft,schedulePlan.get(j),course );
						if(coursesLeft.get(course).size()==0 && (i-j)>1) {
							ArrayList<String> temp = scheduleFinal.get(j+1);
							temp.add(course);
							scheduleFinal.put(j+1,temp);
							ArrayList<String> temp2 = scheduleFinal.get(i);
							temp2.remove(course);
							scheduleFinal.put(i,temp2);
						}
					}
				
				}
			}
	}
	
	public static void checkPreReqCompleted(HashMap <String, ArrayList<String>> coursesLeft,ArrayList<String> coursesPrevSem, String course) {
		
			ArrayList<String> preReq = coursesLeft.get(course);
			ArrayList<String> temporary = new ArrayList(preReq); 
			
			for(String course2:preReq) {
				if(coursesPrevSem.contains(course2)){
					temporary.remove(course2);
				}
				
			}
			coursesLeft.put(course, temporary);
		
	}

}
