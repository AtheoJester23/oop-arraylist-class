package main;

public class Grades {
    
    public String StudentNum;
    public String StudentFullestName;
    public String SubjectCode;
    public String SubjectDescription;
    public double MidtermGrade;
    public double FinalGrade;
    public double Averagerating;
    public double Numericalequal;
    public String Remark;
   
    
    public Grades (String StudentNum, String StudentFullestName, String SubjectCode, String SubjectDescription,  double MidtermGrades, double Finalgrades,double Averagerating,double Numericalequals,String Remarks){
        this.StudentNum = StudentNum;
        this.StudentFullestName = StudentFullestName;
        this.SubjectCode = SubjectCode;
        this.SubjectDescription = SubjectDescription;
        this.MidtermGrade = MidtermGrades;
        this.FinalGrade = Finalgrades;
        this.Averagerating = Averagerating;
        this.Numericalequal = Numericalequals;
        this.Remark = Remarks; 
        
     
    }

 
    public String getStudentNum (){
        return StudentNum;
    }
    public String getStudentFullestName (){
        return StudentFullestName;
    }
    public String getSubjectCode (){
        return SubjectCode;
    }
    public String getSubjectDescription(){
        return SubjectDescription;
    }
    public double getMidtermGrade (){
        return MidtermGrade;
    }
    public double getFinalgrades (){
        return FinalGrade;
    }
    public double getAveragerating (){
              double x = (MidtermGrade + FinalGrade)/2;
        return x;
      
       
    
     
    }
    
    public double getNumericalequal (){
         
               double x = 0;
                double z = (MidtermGrade + FinalGrade)/2;
        if(z >= 97)  x = 1.00; 
        else if(z >= 96) x = 1.25; 
        else if(z >= 93) x = 1.50;
        else if(z >= 90) x = 1.75;
        else if(z >= 87) x = 2.00;
        else if(z >= 84) x = 2.25;
        else if(z >= 81) x = 2.50;
        else if(z >= 78) x = 2.75;
        else if(z == 75) x = 3.00;
        else if(z <= 74) x = 5.00;
        return x;
       
    }
    public String getRemark (){
      double x;
      x=(FinalGrade+MidtermGrade)/2;
      String rem=" ";
      
      if(x>=96|| x>=100) rem="Passed";
      if(x>=93) rem="Passed";
      if(x>=90) rem="Passed";
      if(x>=87) rem="Passed";
      if(x>=84) rem="Passed";
      if(x>=81) rem="Passed";
      if(x>=78) rem="Passed";
      if(x>=75) rem="Passed";
       if(x<=74) rem="Failed";
       return rem;
    }
    
    public void setStudentNum (String StudentNum){
        this.StudentNum = StudentNum;
    }
    public void setStudentName (String getStudentFullestName){
        this.StudentFullestName = getStudentFullestName;
    }
    public void setSubjectCode (String SubjectCode){
        this.SubjectCode = SubjectCode;
    }
    public void setSubjectDescription (String SubjectDescription){
        this.SubjectDescription = SubjectDescription;
    }
    public void setMidtermGrade (double MidtermGrade){
        this.MidtermGrade = MidtermGrade;
    }
    public void setFinalgrades (double Finalgrades){
        this.FinalGrade = Finalgrades;
    }
    public void setAveragerating (double Averagerating){
         this.Averagerating = Averagerating;
    }
    public void setNumericalequal (double Numericalequal){
        this.Numericalequal = Numericalequal;
    }
    public void setremarks (String Remark){
        this.Remark = Remark;
    }
}
