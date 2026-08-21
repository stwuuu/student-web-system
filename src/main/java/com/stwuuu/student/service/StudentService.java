package com.stwuuu.student.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.stwuuu.student.dao.StudentDao;
import com.stwuuu.student.entity.Student;

@Service
public class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public ArrayList<Student> getStudents() {
        return studentDao.queryAllStudents();
    }

    public Student getStudentById(String id) {
        return studentDao.getStudentById(id);
    }

    public Student addStudent(Student student) {
        Student oldStudent = studentDao.getStudentById(student.getId());

        if (oldStudent != null) {
            return null;
        }

        int count = studentDao.addStudent(student);
        return count > 0 ? student : null;
    }

    public Student updateStudent(String id, Student newStudent) {
        Student oldStudent = studentDao.getStudentById(id);

        if (oldStudent == null) {
            return null;
        }

        Student updatedStudent = new Student(id, newStudent.getName(), newStudent.getAge(), newStudent.getAddress());

        int count = studentDao.updateStudent(updatedStudent);
        return count > 0 ? updatedStudent : null;
    }

    public boolean deleteStudentById(String id) {
        Student oldStudent = studentDao.getStudentById(id);

        if (oldStudent == null) {
            return false;
        }

        int count = studentDao.deleteStudentById(id);
        return count > 0;
    }
}