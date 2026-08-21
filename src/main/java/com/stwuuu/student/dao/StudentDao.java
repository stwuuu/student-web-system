package com.stwuuu.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stwuuu.student.entity.Student;

@Repository
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Student> queryAllStudents() {
        String sql = "SELECT id, name, age, address FROM student";

        List<Student> list = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address")
                )
        );

        return new ArrayList<>(list);
    }

    public Student getStudentById(String id) {
        String sql = "SELECT id, name, age, address FROM student WHERE id = ?";

        List<Student> list = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address")
                ),
                id
        );

        return list.isEmpty() ? null : list.get(0);
    }

    public int addStudent(Student student) {
        String sql = "INSERT INTO student (id, name, age, address) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getAddress());
    }

    public int updateStudent(Student student) {
        String sql = "UPDATE student SET name = ?, age = ?, address = ? WHERE id = ?";
        return jdbcTemplate.update(sql,
                student.getName(),
                student.getAge(),
                student.getAddress(),
                student.getId());
    }

    public int deleteStudentById(String id) {
        String sql = "DELETE FROM student WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}