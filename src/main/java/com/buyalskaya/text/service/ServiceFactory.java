package com.buyalskaya.text.service;

import com.buyalskaya.text.service.impl.ComponentServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ComponentService componentService = new ComponentServiceImpl();

    private ServiceFactory() {
    }

    public ComponentService getComponentService() {
        return componentService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}