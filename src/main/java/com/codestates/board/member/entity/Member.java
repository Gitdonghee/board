package com.codestates.board.member.entity;

import com.codestates.board.answer.entity.Answer;
import com.codestates.board.audit.Auditable;
import com.codestates.board.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private MemberType memberType;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Answer> answers = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    public Member(String email, String name, int typeNumber){
        this.email = email;
        this.name = name;
        if(typeNumber == 1) this.memberType = MemberType.MEMBER_COMMON;
        else if (typeNumber == 2) this.memberType = MemberType.MEMBER_ADMIN;

    }

    public enum MemberType {
        MEMBER_COMMON(1, "일반 회원"),
        MEMBER_ADMIN(2, "관리자");

        @Getter
        private int typeNumber;
        @Getter
        private String memberDescription;

        MemberType(int typeNumber, String memberDescription) {
            this.typeNumber = typeNumber;
            this.memberDescription = memberDescription;
       }
    }
}