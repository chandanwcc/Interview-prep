package com.chandan.interview.practice.test;

import java.util.List;
import java.util.Objects;

public class Student {

    private String name;
    private List<SubjectDetails> subjectDetails;



    public Student(String name, List<SubjectDetails> subjectDetails) {
        this.name = name;
        this.subjectDetails = subjectDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDetails> getSubject() {
        return subjectDetails;
    }

    public void setSubject(List<SubjectDetails> subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(subjectDetails, student.subjectDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subjectDetails);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject=" + subjectDetails +
                '}';
    }
}
