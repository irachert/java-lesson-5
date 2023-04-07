package com.example.lesson_5;

import jakarta.validation.constraints.*;

import java.util.Objects;

public class CreateUserDTO {
    @NotBlank(message=" 'name field must be filled")
    @Size(min=3,max=20, message= "min=3,max=20")
    private String name;
    private int age;
    @NotBlank(message="age field must be filled")
    private String gender;
    @NotBlank(message="company field must be filled")
    private String company;
    @Email()
    private String email;
    @NotBlank(message="phone field must be filled")
    private String phone;

    public CreateUserDTO(String name, int age, String gender, String company, String email, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }

    public CreateUserDTO() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserDTO that = (CreateUserDTO) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(gender, that.gender) && Objects.equals(company, that.company) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, company, email, phone);
    }

    @Override
    public String toString() {
        return "CreateUserDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}