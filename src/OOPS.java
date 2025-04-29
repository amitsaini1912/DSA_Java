public class OOPS {
   public static void main(String[] args){
       Pen p1 = new Pen(); //Created a pen object p1
       p1.setColor("Red");
       System.out.println(p1.getColor());
       p1.setTip(6);
       System.out.println(p1.getTip());

       //Copy Constructor
       Student s1 = new Student();
       s1.name = "Amit";
       s1.rollNo = 205;
       s1.password = "xyz";

       Student s2 = new Student(s1);

   }
}

class Student {
    String name;
    int rollNo;
    String password;
    int marks[];

    Student(Student S1){

    }

    Student(){
        System.out.println("constructor is called");
    }
    Student(String name){
        this.name = name;
    }
    Student(int rollNo){
        this.rollNo = rollNo;
    }
}


class Pen {
    private String color;
    private int tip;

    String getColor(){
        return this.color;
    }
     void setColor(String newColor){
         color = newColor;
     }
     void setTip(int tip){
         this.tip = tip;
     }
     int getTip(){
        return this.tip;
     }

}

//class Student{
//    String name;
//    int age;
//    float percentage;
//
//    void calculateAge( int phy, int chem, int maths){
//        percentage = (phy + chem + maths) / 3;
//    }
//}