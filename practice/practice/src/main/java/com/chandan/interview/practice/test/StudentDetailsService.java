package com.chandan.interview.practice.test;

import java.util.*;

public class StudentDetailsService {

    public Set<Student> getStudentList() {
        return studentList;
    }

    Set<Student> studentList = new HashSet<>();

    public void addStudent(String studentName, String subjectName, double mark){

        SubjectDetails subjectDetails = new SubjectDetails(subjectName, mark);

        Optional<Student> student = studentList.stream().filter(x->x.getName().equals(studentName)).findFirst();

        if(student.isPresent()){
            Student currentStudent = student.get();
            currentStudent.getSubject().add(subjectDetails);
        }
        else {
            List<SubjectDetails> subjectDetailsList = new ArrayList<>();
            subjectDetailsList.add(subjectDetails);

            Student student1 = new Student(studentName, subjectDetailsList);

            studentList.add(student1);
        }

    }

    public void updateMarks(String studentName, String subjectName, double mark){

        Optional<Student> student = studentList.stream().filter(x->x.getName().equals(studentName)).findFirst();

        if(student.isPresent()){
            List<SubjectDetails> subjectDetails = student.get().getSubject();
            Optional<SubjectDetails> subject = subjectDetails.stream().filter(x->x.getName().equals(subjectName)).findFirst();
            if(subject.isPresent()){
                SubjectDetails updatedSubjectDetails = subject.get();
                updatedSubjectDetails.setMarks(mark);
            }
        }

    }

    public static void main(String[] args) {
        StudentDetailsService studentDetailsService = new StudentDetailsService();

        studentDetailsService.addStudent("std1", "math", 97);
        studentDetailsService.addStudent("std1", "english", 68);
        studentDetailsService.addStudent("std3", "history", 80);
        studentDetailsService.addStudent("std4", "science", 92);

        System.out.println(studentDetailsService.getStudentList());

        studentDetailsService.updateMarks("std1", "english", 100);

        System.out.println(studentDetailsService.getStudentList());

    }
}
