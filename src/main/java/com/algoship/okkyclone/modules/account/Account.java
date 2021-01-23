package com.algoship.okkyclone.modules.account;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @NoArgsConstructor : 파라미터가 없는 기본 생성자 생성
 * @AllArgsConstructor : 모든 필드 값을 파라미터로 받는 생성자를 만들어 준다.
 */

@Entity
@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long custNo;

    @Column(unique = true)
    private String userId;

    @Column(unique = true)
    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    @Column(unique = true)
    private String name;

    /*
    private Boolean subscriptionYn;

    private Boolean agreeYn;

    private Date agreeDt;

    // embedded 타입 설정
    @Embedded
    private EnrollSns snsType;

    private String userImg;

    private Boolean deleteYn;

     */
    /* general info */
    /*
    private Date regDt;

    private Date updtDt;

    private Long regId;

    private Long updtId;

     */
}
