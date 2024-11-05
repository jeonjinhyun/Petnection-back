package com.jjh.mtvs.client.application.facade;

import com.jjh.mtvs.client.presentation.dto.request.JoinUserDto;


public interface JoinFacadeService {
    public Boolean join(JoinUserDto joinUserDto);
}
