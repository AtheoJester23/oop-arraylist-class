package main;

public class StudentInfo {
    
        private String STDN;
        private String FullName;
        private String Age;
        private String BDate;
	private String Sex;
	private String YL;
        private String Course;
        private String Sec;
        private String Email;
        private String Contact;

	public StudentInfo(String StudentNum, String FirstName, String studAge, String Birthday, String Gender, String YearLvl, String Course, String Section, String Email, String ContactNum) {
		this.STDN =StudentNum;
                this.FullName =FirstName;
                this.Age = studAge;
                this.BDate = Birthday;
		this.Sex = Gender;
		this.YL = YearLvl;
                this.Course = Course;                
                this.Sec= Section;
                this.Email= Email;
                this.Contact = ContactNum;
              
	}
    // to display the information
        public String getStudentNum() {
		return STDN;
	}
	public String getFullName() {
		return FullName;
	}
        
        public String getAge() {
		return Age;
	}        

        public String getBirthday() {
		return BDate;
	}        
        
	public String getGender() {
		return Sex;
	}
        
        public String GetYearLvl() {
		return  YL;
	}
        
        public String getCourse() {
		return Course;        
        }
        
	public String getSection() {
		return Sec;
	}
        
 
        public String getEmail() {
		return Email;
	}

        public String getContactNum() {
		return Contact;
	}

      
      
      
      //Set
        public void setStudentNum(String StudentNum) {
		this.STDN = StudentNum;
	}

	public void setFullName(String FullName) {
		this.FullName = FullName;
        }
                
        public void setAge(String Age) {
		this.Age = Age;
	}
        
        public void setBirthday(String Birthday) {
		this.BDate = Birthday;
	}        
                
        
        public void setGender(String Gender) {
		this.Sex = Gender;

	}
        
        public void setYearLvl(String YearLvl) {
		this.YL = YearLvl;
	}        
        
	public void setCourse(String Course) {
		this.Course = Course;
	}
        
        public void setSection(String Section) {
		this.Sec = Section;
	}  
        
        public void setEmail(String Email) {
		this.Email = Email;
	}

         public void setContactNum(String ContactNum) {
		this.Contact = ContactNum;
	}
	
}
