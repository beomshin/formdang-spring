package com.kr.formdang.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "question_tb", schema = "form_dang", catalog = "")
@Getter
@ToString
public class QuestionTbEntity extends DateEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "qid")
    private long qid;
    @Basic
    @Column(name = "fid")
    private Long fid;
    @Basic
    @Column(name = "order")
    private int order;
    @Basic
    @Column(name = "question_type")
    private byte questionType;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "question_sub_title")
    private String questionSubTitle;
    @Basic
    @Column(name = "question_detail")
    private String questionDetail;
    @Basic
    @Column(name = "quiz_answer")
    private String quizAnswer;
    @Basic
    @Column(name = "image")
    private String image;

}
