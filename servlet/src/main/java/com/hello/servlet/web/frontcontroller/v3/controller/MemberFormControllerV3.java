package com.hello.servlet.web.frontcontroller.v3.controller;

import com.hello.servlet.web.frontcontroller.ModelView;
import com.hello.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(final Map<String, String> paramMap) {
        return new ModelView("new-form");
    }

}
