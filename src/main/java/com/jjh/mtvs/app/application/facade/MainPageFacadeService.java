package com.jjh.mtvs.app.application.facade;

import com.jjh.mtvs.app.presentation.dto.response.MainPageDto;

public interface MainPageFacadeService {
    MainPageDto getMainPage(Long userId);
}
