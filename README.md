# Student Web System

这是一个基于 Spring Boot 开发的学生管理系统后端项目，主要实现了学生信息的增删改查功能。

## 技术栈

- Java 21
- Spring Boot
- Maven
- RESTful API

## 项目结构

- Student：学生实体类
- StudentController：控制层，负责接收 HTTP 请求并返回响应
- StudentService：业务层，负责学生信息的增删改查逻辑

## 接口说明

| 功能 | 请求方式 | 请求路径 | 成功状态码 | 失败状态码 |
|---|---|---|---|---|
| 查询所有学生 | GET | /students | 200 | - |
| 按学号查询学生 | GET | /students/{id} | 200 | 404 |
| 添加学生 | POST | /students | 201 | 409 |
| 修改学生 | PUT | /students/{id} | 200 | 404 |
| 删除学生 | DELETE | /students/{id} | 204 | 404 |

## 当前说明

当前项目使用内存集合保存学生数据，程序重启后新增、修改、删除的数据会恢复到初始状态。后续可以继续接入数据库，实现数据持久化保存。