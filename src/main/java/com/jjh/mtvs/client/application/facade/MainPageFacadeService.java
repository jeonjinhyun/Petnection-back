package com.jjh.mtvs.client.application.facade;

import com.jjh.mtvs.client.presentation.dto.response.MainPageDto;

public interface MainPageFacadeService {
    MainPageDto getMainPage(Long userId);
}
