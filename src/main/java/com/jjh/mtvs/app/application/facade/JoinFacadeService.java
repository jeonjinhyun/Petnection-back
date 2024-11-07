package com.jjh.mtvs.app.application.facade;

import com.jjh.mtvs.app.presentation.dto.request.auth.SignupRequestDTO;


public interface JoinFacadeService {
    public Boolean join(SignupRequestDTO signupRequestDTO);
}
