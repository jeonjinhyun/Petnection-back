package com.jjh.mtvs.app.application.facade;

import com.jjh.mtvs.app.presentation.dto.request.JoinUserDto;


public interface JoinFacadeService {
    public Boolean join(JoinUserDto joinUserDto);
}
