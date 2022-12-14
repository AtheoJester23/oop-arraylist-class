package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    /*  Methods:

        readFromFileGrade              (String filename)
        writeToFileGrade               (String filename)
        Update_StudentGrade            ()
        View_StudentGrade              ()
        Add_StudentGrade               ()
        readfromFileStud               (String filename)
        writetoFileStud                (String filename)
        Add_Studentinformation         ()
        Search_StudInformation         ()
        Edit_StudInformation           ()	
        Delete_StudInformation         ()
        List_of_StudentInformation     ()

        
    */
    
    private static List <StudentInfo> studentinfo = new ArrayList <StudentInfo> ();
    private static List <Grades> studentgrade = new ArrayList <Grades>();  
    

    //To read from file grade.txt
     public static void readFromFileGrade (String filename){
         BufferedReader read = null;
 
         studentgrade.clear();// removes all elements in arraylist
         
         try {
             read = new BufferedReader(new FileReader(filename));  
             try {
                String studentNum, StudentFullestName , subcode, subdiscription,  remark;
                double finalgrades ,midtermgrade,averagerating,numericalequal;
                // initialize identifiers
		// loop continues til null
                while ((studentNum = read.readLine()) != null){
                    StudentFullestName = read.readLine();
                    subcode = read.readLine();
                    subdiscription = read.readLine();
                    midtermgrade =Double.parseDouble(read.readLine());
                    finalgrades =  Double.parseDouble(read.readLine());
                    averagerating =  Double.parseDouble(read.readLine());
                    numericalequal =  Double.parseDouble(read.readLine());
                    remark = read.readLine();
                     //Add the data to members arraylist
                     studentgrade.add(new Grades(studentNum,StudentFullestName, subcode, subdiscription,
                 finalgrades, midtermgrade,averagerating,numericalequal,remark));
                }
             }finally {
                 read.close();
             }
         }catch (IOException e){
             e.printStackTrace();
         }
     }
     
     
     public static boolean writeToFileGrade (String filename){
         boolean save = false;
         PrintWriter write = null;
      
         try{
         write = new PrintWriter (new FileWriter (filename));
      
         try {
             for (Grades grades : studentgrade){
                 write.println (grades.getStudentNum());    
                 write.println (grades.getStudentFullestName());  
                 write.println (grades.getSubjectCode());
                 write.println (grades.getSubjectDescription());
                 write.println (grades.getMidtermGrade());
                 write.println (grades.getFinalgrades());
                 write.println (grades.getAveragerating());
                 write.println (grades.getNumericalequal());
                 write.println (grades.getRemark());
             }
             save = true;
         }finally {
		write.close();
            }
	} catch (IOException e) {
            e.printStackTrace();
	}
            return save;
    }
     
    //For Viewing Student Grades
    public static void View_StudentGrade(){
         BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
         String StudentNums = " ";
         System.out.println("-----------------------------------------------------------------");
         System.out.println("\t\tView Summary Grade Per Student\n");
                   
                    try
                    {
                        System.out.print("Enter Student Number: ");
                 StudentNums = data.readLine();
                  }
                    catch (IOException e){
                System.out.println ("Student Number Only");
   
            }
                    readFromFileGrade("StudentGrades.txt");
                //Seeking the name from the array list
                boolean found = false;
		for (Grades grade : studentgrade){
               if (StudentNums.equalsIgnoreCase(grade.getStudentNum()))
               {
                   System.out.println("\nStudent's Information: ");
                   System.out.println("Student Number: "+grade.getStudentNum());
                   System.out.println("Student Name: "+grade.getStudentFullestName());
                   System.out.println("Student SubjectCode: "+grade.getSubjectCode());
                   System.out.println("Student SubjectDescription: "+grade.getSubjectDescription());
                   System.out.println("Student MidtermGrade: "+grade.getMidtermGrade());
                   System.out.println("Student FinalGrade: "+grade.getFinalgrades());
                   System.out.println("Average: "+grade.getAveragerating());
                   System.out.println("Numericalequal: "+grade.getNumericalequal());
                   System.out.println("Remark: "+grade.getRemark());
                   found = true;
                   
               }
                }
                if (!found) {
			System.out.println("\n StudentNumber not Found!");
		}
                   
               } 
    
    //For Updating Student Grades
    public static void Update_StudentGrade(){
         BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
           String studNum ="",
               StudentNums = " ", 
               StudentNames = " ",  
               SubjectCodes = " ", 
               SubjectDiscriptions = " ";
               String remarks = " ";
              double midtermGrades=0.0, 
               Finalgrades=0.0,
               averageratings=0.0,
               numericalequals=0.0;
         int position = -1;
         
         System.out.println("-----------------------------------------------------------------");
         System.out.println("\t\t\t UPDATE STUDENT GRADES");
         System.out.print("\nEnter Student Number to Update Grades: ");
         
         try{
             studNum = data.readLine();
         }catch(Exception e) { 
             System.out.println("Error!"); 
         }
        
        readFromFileGrade("StudentGrades.txt");
        
        boolean found = false;
        
          for(Grades student: studentgrade){
              position++;
              if (studNum.equalsIgnoreCase(student.getStudentNum())) {
                  for(Grades students: studentgrade){
                      found = true;
                      break;
                  }
              } else {
              } 
          }
          
          if(!found) System.out.println("Student Number Not Found!");
          else{
              
              try{
                  System.out.println("\nUpdating Student's Grade: ");
                  System.out.print("Please Re Enter Student Number: ");
                  StudentNums = data.readLine ();
                  System.out.print("Please Re Enter Full Name: ");
                  StudentNames = data.readLine ();
                  System.out.print("Please Enter New Subject Code: ");
                  SubjectCodes = data.readLine();
                  System.out.print("Please Enter New Subject Description: ");
                  SubjectDiscriptions =  data.readLine();
                  System.out.print("Please Enter New Midterm Grade:  ");
                  midtermGrades = Double.parseDouble(data.readLine());
                  System.out.print("Please Enter New Final Grade: ");
                  Finalgrades = Double.parseDouble(data.readLine());
              }
              catch(IOException e) {    
                  System.out.println("Error!"); 
              }
              
               studentgrade.set(position,new Grades(StudentNums,StudentNames, SubjectCodes, SubjectDiscriptions, 
                 Finalgrades, midtermGrades, numericalequals, averageratings,remarks ));
    

              
             if (writeToFileGrade("StudentGrades.txt")) {
                System.out.println("Successfully Updated."); 
            } else {
                System.err.println("Problem writing file.");
            }
        }  
     }
    
    //For Adding Student Grade
    public static void Add_StudentGrade(){
         BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
    
               String studNum =" ",
               studentNum = " ", 
               StudentNames = " ",  
               SubjectCodes = " ", 
               SubjectDiscriptions = " ";
               String remarks=" ";
               double MidtermGrade=0,
               FinalGrade=0;
               double averageratings=0,
               Numericalequals=0;
               
               System.out.println("-----------------------------------------------------------------");
               System.out.println("\t\t\tAdd Grade");
               System.out.print("\nEnter Student Number to Add Grades: ");
               try
               {
             studNum = data.readLine();
                }
               catch(Exception e) { 
            System.out.println("Error!"); 
        }
               readfromFileStud("StudentInformation.txt");
               readFromFileGrade("StudentGrades.txt");
                boolean found = false;
                
      for(Grades student: studentgrade){
             
            if (studNum.equalsIgnoreCase(student.getStudentNum()))
            {
                 System.out.println("Student Already Have Graded.!");
                 return;
            }
      }
        for(StudentInfo infos: studentinfo)
        {
            if (studNum.equalsIgnoreCase(infos.getStudentNum())) 
            {
                System.out.println("\n\nStudent's Information: ");
                System.out.println("\nStudent Number: " + infos.getStudentNum());
                System.out.println("Student's Course: " + infos.getCourse());
                System.out.println("Student's Section: " + infos.getSection());
                found = true;
                break;
             
            }
            
        }      
      
            if(!found) 
            {
                System.out.println("Student Number Registered.!");
            }
             
            else 
            { System.out.println ("\n\nAdding Grade: ");
                   try {
                      System.out.print ("\nRe Enter Student Number: ");
                      studentNum = data.readLine ();
                      System.out.print ("Re Enter Student Name: ");
                      StudentNames = data.readLine ();
                      System.out.print ("Enter Subject Code: ");
                      SubjectCodes = data.readLine();
                      System.out.print ("Enter Subject Description: ");
                      SubjectDiscriptions = data.readLine ();
                      System.out.print ("Enter Midterm Grade: ");
                      MidtermGrade = Double.parseDouble(data.readLine());
                      System.out.print ("Enter Final Grade: ");
                      FinalGrade = Double.parseDouble(data.readLine ());
                      
                   } catch (IOException e){
                       System.out.println ("Error");
                   } 
                    System.out.println("\nAdded Successfully");
        

	//New added data to members arraylist
	 studentgrade.add(new Grades(studentNum,StudentNames, SubjectCodes, SubjectDiscriptions, MidtermGrade, 
                 FinalGrade, averageratings, Numericalequals,remarks ));
         
        

	if (writeToFileGrade("StudentGrades.txt")) {
            //System.out.println("File successfully written.");
	} else {
            System.out.println("Problem writing file.");
	}
       }
    }
    
   

    public static void readfromFileStud(String filename) {
	//Initializes read identifer as BufferedReader.
	BufferedReader read = null;

	studentinfo.clear(); // removes all elements in arraylist members

	try {
            read = new BufferedReader(new FileReader(filename)); 
            try {
		 String studNum, studFName, Age, studBirth, studGender, studYrlvl, studCourse, studSec, studEmail, studContact;

		//The loop will continue until null is encountered
		while ((studNum = read.readLine()) != null) {
                    studFName = read.readLine();
                    Age = read.readLine();                    
                    studBirth = read.readLine();                    
                    studGender = read.readLine();
                    studYrlvl = read.readLine();
                    studCourse=read.readLine();
                    studSec = read.readLine();
                    studEmail = read.readLine();
                    studContact = read.readLine();

                     
                    //Adds data to members arraylist
                    studentinfo.add(new StudentInfo(studNum, studFName, Age, studBirth, studGender, 
                 studYrlvl, studCourse, studSec, studEmail, studContact));
                }
            } finally {
                read.close(); // closes BufferedReader
            }
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
    
    
    public static boolean writetoFileStud(String filename) {
    	boolean saved = false;
	PrintWriter write = null;

	try {
            write = new PrintWriter(new FileWriter(filename)); 
	
            try {
		for (StudentInfo students : studentinfo) {
            write.println(students.getStudentNum());
            write.println(students.getFullName ());
            write.println(students.getAge ());
            write.println(students.getBirthday ());
            write.println(students.getGender ());
            write.println(students.GetYearLvl ());
            write.println(students.getCourse ()); 
            write.println(students.getSection ());  
            write.println(students.getEmail ());
            write.println(students.getContactNum ()); 
            
            
		}
                    saved = true;
            } finally {
		write.close();
            }
	} catch (IOException e) {
            e.printStackTrace();
	}
            return saved;
    }
  
    
    //For Adding Student Information
    public static void Add_Studentinformation(){   
        BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
        
        String repeat = " ", 
               studNum = " ",
               studFName = " ",  
               Age = " ",
               studBirth = " ",
               studGender = " ", 
               studYrlvl = " ", 
               studCourse=" ",
               studSec = " ",
               studEmail = " ",
               studContact=" ";
        
           
         do{   
            
            try{
                
                System.out.println("-----------------------------------------------------------------");
                System.out.println ("\t\t      Add Student Record    \n");
                
                
                System.out.print ("Enter Student Number: ");
                studNum = data.readLine();
                
                System.out.print ("Enter Student's Full Name: ");
                studFName = data.readLine();
                
                System.out.print ("Enter Student's Age: ");
                Age = data.readLine();
                
                System.out.print ("Enter Student's Birth Date [Day/Month/Year]: " );
                studBirth = data.readLine();
                
                System.out.print ("Enter Student's Gender: ");
                studGender = data.readLine();
                
                System.out.print ("Enter Student's YearLevel: "); 
                studYrlvl = data.readLine();
                
                System.out.print ("Enter Student's Course: ");
                studCourse = data.readLine();
                
                System.out.print ("Enter Student's Section: ");
                studSec = data.readLine();
                
                System.out.print ("Enter Student's Email: ");  
                studEmail = data.readLine();
                
                System.out.print ("Enter Student's Contact: ");
                studContact = data.readLine();
              
         
            }
            catch(IOException e) { 
                System.out.println("Error!"); 
            }
            
            System.out.println("\nAdding Record...");
            readfromFileStud("studentInformation.txt"); //studInformation text file
            
          studentinfo.add(new StudentInfo(studNum, studFName, Age, studBirth, studGender, 
                 studYrlvl, studCourse, studSec,studEmail,studContact));
            if (writetoFileStud("StudentInformation.txt")) {
                System.out.println("\nSuccessfully Added.");
                
            } else {
                System.err.println("Problem writing file.");
            }
            
            //Asking if the user want's to add more student
            System.out.println("-----------------------------------------------------------------");
            System.out.print("\nInput another Student[Y/N]? ");
            try{
                repeat = data.readLine();
            } catch(IOException ee){
               System.out.println("\nError\n");
           }
         }while(repeat.equalsIgnoreCase("y"));
    }
    
    
    //For Searching Student
    public static void Search_StudInformation(){
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        String studNum = " ";
        
        System.out.println("-----------------------------------------------------------------");
        System.out.print("\t\t\t SEARCH A STUDENT \n");
        System.out.print("\nEnter Student Number to Search: ");
        try{
            studNum = dataIn.readLine();
        }catch(Exception e) { 
            System.out.println("Error!"); 
        }
        
        readfromFileStud("StudentInformation.txt");
        
        boolean found = false;
        
        for(StudentInfo students: studentinfo){
            if (studNum.equalsIgnoreCase(students.getStudentNum())) {
                System.out.println("\nStudent's Information: ");
                System.out.println("StudentNum: "+ students.getStudentNum());
                System.out.println("Full Name: " + students.getFullName ());
                System.out.println("Age: " + students.getAge ());
                System.out.println("Birthday.: " + students.getBirthday ());                                    
                System.out.println("Gender: " + students.getGender ());
                System.out.println("YearLevel: " + students.GetYearLvl ()); 
                System.out.println("Course: " + students.getCourse ()); 
                System.out.println("Secion: " + students.getSection ());  
                System.out.println("Email: " + students.getEmail ());
                System.out.println("Contact No.: " + students.getContactNum ());
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Student Number Not Found!");
    }
    
    
    //For Editing Student Information
    public static void Edit_StudInformation(){
        BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
        String studNum = " ";
        int index = 0;
        int found_index = -1;
        
        System.out.println("-----------------------------------------------------------------");
        System.out.print("\n\t\t\tEDIT STUDENT INFO\n");
        System.out.print("\nEnter Student Number to Edit: ");
        try{
            studNum = data.readLine();
        }catch(Exception e) { 
            System.out.println("Error!"); 
        }
        
        readfromFileStud("StudentInformation.txt");
        
       String repeat = " ", 
               studFName = " ",  
               Age = " ",
               studBirth = " ",
               studGender = " ", 
               studYrlvl = " ", 
               studCourse=" ",
               studSec = " ",
               studEmail = " ",
               studContact=" ";
        
        for(StudentInfo students: studentinfo){
            if (studNum.equalsIgnoreCase(students.getStudentNum())) {
                System.out.println("\nStudent's Information: ");
                System.out.println("Full Name: " + students.getFullName ());
                System.out.println("Age: " + students.getAge ());
                System.out.println("Birthday.: " + students.getBirthday ());
                System.out.println("Gender: " + students.getGender ());
                System.out.println("YearLevel: " + students.GetYearLvl ());                                   
                System.out.println("Course: " + students.getCourse ()); 
                System.out.println("Section: " + students.getSection ());    
                System.out.println("Email: " + students.getEmail ());
                System.out.println("Contact No.: " + students.getContactNum ());
                found_index = index;
                break;
            }
            index++;
        }
        if (found_index == -1) {
            System.out.println("Student Number Not Found!");
        } else{
            try{
                System.out.println("\nEditing Student's Information: ");
                
                System.out.print ("Please Enter New Student's FullName: ");
                studFName = data.readLine();
                
                System.out.print ("Please Enter New Student's Age ");
                Age = data.readLine();                
                
                System.out.print ("Please Enter New Student's Birth Date [Day/Month/Year]: " );
                studBirth = data.readLine();
                
                System.out.print ("Please Enter New Student's Gender: ");
                studGender = data.readLine();
                
                System.out.print ("Please Enter New Student's YearLevel: "); 
                studYrlvl = data.readLine();
                
                System.out.print ("Please Enter New Student's Course: ");
                studCourse = data.readLine();
                
                System.out.print ("Please Enter New Student's Section: ");
                studSec = data.readLine();
                
                System.out.print ("Please Enter New Student's Email: ");  
                studEmail = data.readLine();
                
                System.out.print ("Please Enter New Student Contact ");
                studContact = data.readLine();
                
            }
            catch(IOException e) { 
                System.out.println("Error!"); 
            }
            
            studentinfo.get(found_index).setFullName(studFName);
            studentinfo.get(found_index).setAge(Age);
            studentinfo.get(found_index).setBirthday(studBirth);
            studentinfo.get(found_index).setGender(studGender);
            studentinfo.get(found_index).setYearLvl(studYrlvl);
            studentinfo.get(found_index).setCourse(studCourse);
            studentinfo.get(found_index).setSection(studSec);
            studentinfo.get(found_index).setEmail(studEmail);
            studentinfo.get(found_index).setContactNum(studContact);        
            
            
             if (writetoFileStud("StudentInformation.txt")) {
                System.out.println("File successfully overwritten.");
                
            } else {
                System.err.println("Problem writing file.");
            }
        }
    }
    
    //For Deleting Student
     public static void Delete_StudInformation(){
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        String studNum = " ";
        int position = -1;
        
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\n\t\t\tDELETE STUDENT INFO ");
        System.out.print("\nEnter Student Number to Delete: ");
        try{
            studNum = dataIn.readLine();
        }catch(Exception e) { 
            System.out.println("Error!"); 
        }
        
        readfromFileStud("StudentInformation.txt");
        
        boolean found = false;
       String repeat = " ", 
               studFName = " ",
               Age = " ",
               studBirth = " ",
               studGender = " ", 
               studYrlvl = " ", 
               studCourse=" ",
               studSec = " ",
               studEmail = " ",
               studContact=" ";
        
        for(StudentInfo students: studentinfo){
            position++;
            if (studNum.equalsIgnoreCase(students.getStudentNum())) {
                System.out.println("\nStudent's Information: ");
                System.out.println("Full Name: " + students.getFullName ());
                System.out.println("Age: " + students.getAge ());
                System.out.println("Birthday.: " + students.getBirthday ());                
                System.out.println("Gender: " + students.getGender ());
                System.out.println("YearLevel: " + students.GetYearLvl ());    
                System.out.println("Course: " + students.getCourse ());                    
                System.out.println("Secion: " + students.getSection ());                   
                System.out.println("Email: " + students.getEmail ());
                System.out.println("Contact No.: " + students.getContactNum ());
                found = true;
                break;
            }
        }
        if(!found) System.out.println("\nStudent Number Not Found!");
        else{
            String delete = " ";
            System.out.print("\nAre you sure you want to delete this record [Y/N]? ");
            try {
                delete = dataIn.readLine();
            } catch (IOException e) {
                System.out.println("Error!");
            }
            
            if (delete.equalsIgnoreCase("Y"))  studentinfo.remove(position); 
            
            if (writetoFileStud("StudentInformation.txt")) {
                System.out.println("\nSuccessfully deleted.");
            } else {
                System.err.println("Problem writing file.");
            }
        }
}
     
     //For List of Student Information
       public static void List_of_StudentInformation(){
      readfromFileStud("StudentInformation.txt");
        System.out.println("\n-----------------------------------------------------------------");   
        System.out.print("Student Information Summary: \n");
       System.out.println("\nStudent Number   Student FullName  \t Student Age \t  Student Birthday  \t Student Gender  \t  Student YearLvl \t Student Course \t  Student Section \t  Student Email \t Student ContactNumber");
       for(StudentInfo students: studentinfo){
           System.out.print(students.getStudentNum() + "\t\t");
           System.out.print(students.getFullName() + "\t      ");
           System.out.print(students.getAge() + "\t\t    ");
           System.out.print(students.getBirthday() + "\t\t\t");
           System.out.print(students.getGender() + "\t\t\t");
           System.out.print(students.GetYearLvl() + "\t\t\t");
           System.out.print(students.getSection() + "\t\t");
           System.out.print(students.getCourse() + "\t\t");
           System.out.print(students.getEmail() + "\t\t");
           System.out.print(students.getContactNum() + "\n");
       }
   }
       
       
    //The Main
    public static void main(String[] args) {
       BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        
        String ans = " ";
        do{
            //Menu for basic operations
            System.out.println("-----------------------------------------------------------------");
            System.out.println("\n\t\t\t[ Main Menu ]\n");
            System.out.println("[1] - Add Student");
            System.out.println("[2] - Search Student");
            System.out.println("[3] - Edit Student's Information");
            System.out.println("[4] - Delete Student");
            System.out.println("[5] - Summary of Student Information");
            System.out.println("[6] - Add Student Grades");
            System.out.println("[7] - Update Student Grades");
            System.out.println("[8] - View Student Grades\n");
         
            System.out.print("Choose an option[1-8]: ");
            
            int menu;
            try{
                menu = Integer.parseInt(dataIn.readLine());
                
                //conditional for menu options
                if(menu == 1) Add_Studentinformation();
                if(menu == 2) Search_StudInformation(); 
                if(menu == 3) Edit_StudInformation();
                if(menu == 4) Delete_StudInformation();
                if(menu == 5) List_of_StudentInformation(); 
                if(menu == 6) Add_StudentGrade(); 
                if(menu == 7) Update_StudentGrade();
                if(menu == 8) View_StudentGrade();
                else if(menu >= 9) System.err.println("1-8 only!"); 
            }
            catch(IOException | NumberFormatException e) { 
                System.out.println("Error! Not an wee."); 
            }
            
            //syntax for looping if you want to go to menu again
            System.out.println("-----------------------------------------------------------------");
            System.out.print("\nYou want to go back to Menu Again[Y/N]? ");
            try {  
                ans = dataIn.readLine(); 
            } 
            catch(Exception e) { 
                System.out.println("Error! Not a choice."); 
            }
        }while(ans.equalsIgnoreCase("y"));
    }
}
