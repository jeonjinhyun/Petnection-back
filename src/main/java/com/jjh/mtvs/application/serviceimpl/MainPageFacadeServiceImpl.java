package com.jjh.mtvs.application.serviceimpl;

import com.jjh.mtvs.application.facade.MainPageFacadeService;
import com.jjh.mtvs.presentation.dto.response.MainPageDto;
import org.springframework.stereotype.Service;

@Service
public class MainPageFacadeServiceImpl implements MainPageFacadeService {
    @Override
    public MainPageDto getMainPage(Long userId) {
        return null;
    }
}
