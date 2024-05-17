package com.kr.formdang.model.response.form;

import com.kr.formdang.model.response.AbstractResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FindPaperResponse extends AbstractResponse {

    private Long fid;
    private Integer type; // 폼 타입 ( 0: 설문, 1: 퀴즈, 2: 쪽지시험 )
    private String title; // 폼 제목
    private String detail; // 폼 설명
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
//    private Timestamp beginDt; // 시작일 (yyyyMMdd)
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "Asia/Seoul")
//    private Timestamp endDt; // 종료일 (yyyyMMdd)
//    private Integer questionCount; // 질문 개수
//    private Integer answerCount; // 질문 응답자 수
    private Integer maxRespondent; // 인원 제한수 ( 0: 제한 없음, 1~ 제한인원)
    private String logoUrl; // 로그 url
    private String themeUrl; // 테마 url
    private List<FindPaperResponse.FormDetailQuestionResponse> question;
    private List<FindPaperResponse.FormAnswerResponse> answers;
    private boolean worker;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class FormDetailQuestionResponse {

        private Long qid;
        private Integer type; // 질문 타입 ( 0: 주관식, 1: 객관식 )
        private Integer order; // 순번
        private String title; // 질문 제목
        private String placeholder; // 질문 placeholder
        private String imageUrl; // 이미지 url
        private String[] detail; // 질문 상세 내용
        private String[] exampleDetail; // 질문 보기 상세 내용
        private Integer count; // 질문 개수
        private String[] answer; // 질문 정답

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class FormAnswerResponse {

        private long awid;
        private long fid;
        private long aid;
        private String sAnswer;
        private String mAnswer;
        private int okFlag;

    }
}
