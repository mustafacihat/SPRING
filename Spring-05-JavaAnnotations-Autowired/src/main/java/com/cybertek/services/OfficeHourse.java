package com.cybertek.services;

import com.cybertek.interfaces.ExtraSessions;
import org.springframework.stereotype.Component;

@Component
public class OfficeHourse implements ExtraSessions {
    public int getHours() {
        return 4;
    }
}
