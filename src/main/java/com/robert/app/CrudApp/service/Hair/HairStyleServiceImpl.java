package com.robert.app.CrudApp.service;

import com.robert.app.CrudApp.repository.HairStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HairStyleServiceImpl {

    @Autowired

    private HairStyleRepository hairRepository;
}
