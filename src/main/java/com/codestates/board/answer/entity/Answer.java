package com.codestates.board.answer.entity;

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
public class Answer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AnswerId;
    @Column(nullable = false)
    private String answerTitle;
    @Column(nullable = false)
    private String answerContent;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


}
