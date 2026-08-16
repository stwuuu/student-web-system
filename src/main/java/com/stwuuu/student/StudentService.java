package com.stwuuu.student;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private ArrayList<Student> list = new ArrayList<>();


    public StudentService() {
        list.add(new Student("001", "张三", 20, "广州"));
        list.add(new Student("002", "李四", 19, "上海"));
    }

    public ArrayList<Student> getStudents() {
        return list;
    }

    public Student getStudentById(String id) {
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);

            if (s.getId().equals(id)) {
                return s;
            }
        }

        return null;
    }

    public Student addStudent(Student student) {
        Student oldStudent = getStudentById(student.getId());

        if (oldStudent != null) {
            return null;
        }

        list.add(student);
        return student;
    }

    public Student updateStudent(String id, Student newStudent) {
        Student s = getStudentById(id);

        if (s == null) {
            return null;
        }

        s.setName(newStudent.getName());
        s.setAge(newStudent.getAge());
        s.setAddress(newStudent.getAddress());

        return s;
    }

    public boolean deleteStudentById(String id) {
        Student s = getStudentById(id);

        if (s == null) {
            return false;
        }

        list.remove(s);
        return true;
    }
}
