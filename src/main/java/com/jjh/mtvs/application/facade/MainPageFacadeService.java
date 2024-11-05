package com.jjh.mtvs.application.facade;

import com.jjh.mtvs.presentation.dto.response.MainPageDto;

public interface MainPageFacadeService {
    MainPageDto getMainPage(Long userId);
}
