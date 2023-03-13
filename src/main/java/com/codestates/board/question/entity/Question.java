package com.codestates.board.question.entity;

import com.codestates.board.answer.entity.Answer;
import com.codestates.board.audit.Auditable;
import com.codestates.board.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(nullable = false)
    private String questionTitle;
    @Column(nullable = false)
    private String questionContent;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private QuestionStatus questionStatus = QuestionStatus.QUESTION_REGISTRATION;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    Member member;

    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    Answer answer;

    public enum QuestionStatus{
        QUESTION_REGISTRATION("질문 등록 상태"),
        QUESTION_ANSWERED("답변 완료 상태"),
        QUESTION_DELETE("질문 삭제 상태");

        @Getter
        private String status;

        QuestionStatus(String status){this.status = status;}
    }
}
