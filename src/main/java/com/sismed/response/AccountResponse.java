package com.sismed.response;

import com.sismed.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {
    private Long id;
    private Boolean status;
    private Long balance;
    private User user;
}
