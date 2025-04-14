package com.ncmn.school.member;

import java.time.LocalDateTime;

public class Member {
    private String name;
    private String phone;
    private String email;
    private String birthday;
    private String address;
    private String church;
    private String job;
    private LocalDateTime timestamp;

    public Member(String name, String phone, String email, String birthday, String address, String church, String job, LocalDateTime timestamp) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.church = church;
        this.job = job;
        this.timestamp = timestamp;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChurch() {
        return church;
    }

    public void setChurch(String church) {
        this.church = church;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
