package com.jjh.mtvs.application.facade;

import com.jjh.mtvs.presentation.dto.request.JoinUserDto;


public interface JoinFacadeService {
    public Boolean join(JoinUserDto joinUserDto);
}
