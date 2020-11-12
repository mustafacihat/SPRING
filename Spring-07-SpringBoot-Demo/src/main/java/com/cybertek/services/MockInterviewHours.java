package com.cybertek.services;

import com.cybertek.interfaces.ExtraSession;


public class MockInterviewHours implements ExtraSession {
    @Override
    public int getHours() {
        return 7;
    }
}
