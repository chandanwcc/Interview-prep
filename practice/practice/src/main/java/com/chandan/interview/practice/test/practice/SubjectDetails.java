package com.chandan.interview.practice.test.practice;

import java.util.Objects;

public class SubjectDetails {

    private String name;
    private double marks;

    public SubjectDetails(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SubjectDetails)) return false;
        SubjectDetails subjectDetails = (SubjectDetails) o;
        return Double.compare(marks, subjectDetails.marks) == 0 && Objects.equals(name, subjectDetails.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, marks);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
