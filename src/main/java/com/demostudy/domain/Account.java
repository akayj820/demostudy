package com.demostudy.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @EqualsAndHashCode(of="id")
/*
연관 관계가 복잡해 질 때, @EqualsAndHashCode 에서 서로 다른 연관 관계를 순환 참조하느라
무한 루프가 발생하고, 결국 stack overflow가 발생할 수 있기 때문에 id 값만 주로 사용
 */
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String password;

    private boolean emailVerified;

    private String emailCheckToken;

    private LocalDateTime joinedAt;

    private String bio; // 짧은 자기소개

    private String url; // 웹사이트 url

    private String occupation; // 직업

    private String location; // 사는 지역
    // 기본적으로 String 타입은 varchar(255) 타입으로 매핑된다.

    @Lob/*긴 문자열*/ @Basic(fetch = FetchType.EAGER/*즉시 로딩*/)
    private String profileImage;

    private boolean studyCreatedByEmail;

    private boolean studyCreatedByWeb;

    private boolean studyEnrollmentResultByEmail;

    private boolean studyEnrollmentResultByWeb;

    private boolean studyUpdatedByEmail;

    private boolean studyUpdatedByWeb;

}
