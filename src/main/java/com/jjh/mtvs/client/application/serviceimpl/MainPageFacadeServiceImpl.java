package com.jjh.mtvs.client.application.serviceimpl;

import com.jjh.mtvs.client.application.facade.MainPageFacadeService;
import com.jjh.mtvs.client.presentation.dto.response.MainPageDto;
import org.springframework.stereotype.Service;

@Service
public class MainPageFacadeServiceImpl implements MainPageFacadeService {
    @Override
    public MainPageDto getMainPage(Long userId) {
        return null;
    }
}
