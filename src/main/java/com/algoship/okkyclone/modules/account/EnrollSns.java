package com.algoship.okkyclone.modules.account;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class EnrollSns {

    private Boolean facebook;
    private Boolean google;
}
