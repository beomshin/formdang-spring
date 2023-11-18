package com.kr.formdang.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "subject_tb", schema = "form_dang", catalog = "")
@Getter
@ToString
public class SubjectTbEntity extends DateEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sid")
    private long sid;
    @Basic
    @Column(name = "mac")
    private String mac;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "age")
    private Integer age;

}
