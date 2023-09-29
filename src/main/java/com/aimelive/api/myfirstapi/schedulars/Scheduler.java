package com.aimelive.api.myfirstapi.schedulars;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aimelive.api.myfirstapi.mailer.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    private EmailService emailService;
    @Scheduled(fixedRate = 60*60*1000)//Or cron job expression , here is an hour 60*1000=60 seconds
    public void fixedRateSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Rate scheduler:: " + strDate);

        emailService.sendEmail(
                "aimendayambaje24@gmail.com",
                "Murakoze Cyane Yari njyewe celine dio",
                "<h1>Another banger</h1>A good email message is dedicated to you, right about now." + strDate

        );
    }
}