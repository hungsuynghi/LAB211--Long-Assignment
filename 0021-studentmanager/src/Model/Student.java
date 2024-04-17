package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Student {
    private String name,id;
    private int semester, course;

    public Student() {
    }

    public Student(String name, String id, int semester, int course) {
        this.name = name;
        this.id = id;
        this.semester = semester;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
    
    public String getCourseString(){
        String result = null;
        switch(course){
            case 1:
                result = "Java";   
                break;
            case 2:
                result = ".Net";
                break;
            case 3:
                result = "C/C++";
                break;    
        }
        return result;
    }


    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s %-10s", id, name, semester, getCourseString());
    }
    
    
}
