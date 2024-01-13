package com.robert.app.CrudApp.service;

import com.robert.app.CrudApp.repository.WeldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeldServiceImpl {
    @Autowired
    private WeldRepository weldRepository;
}
