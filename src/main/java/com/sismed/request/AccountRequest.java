package com.sismed.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AccountRequest {
    @NotNull
    private Long money;
}
