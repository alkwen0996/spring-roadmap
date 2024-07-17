package com.hello.servlet.web.frontcontroller.v4.controller;

import com.hello.servlet.web.frontcontroller.v4.ControllerV4;
import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {


    @Override
    public String process(final Map<String, String> paramMap, final Map<String, Object> model) {
        return "new-form";
    }
}
