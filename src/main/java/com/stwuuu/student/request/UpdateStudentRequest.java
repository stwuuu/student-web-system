package com.stwuuu.student.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UpdateStudentRequest {
    @NotBlank(message = "姓名不能为空")
    private String name;

    @Min(value = 1, message = "年龄不能小于1")
    @Max(value = 120, message = "年龄不能大于120")
    private int age;

    @NotBlank(message = "地址不能为空")
    private String address;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}