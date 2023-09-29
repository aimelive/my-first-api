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
    @Scheduled(cron="0 0 8 * * ?")//Everyday at 8:00
    public void fixedRateSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Fixed Rate scheduler:: " + strDate);

        emailService.sendEmail(
                "aimendayambaje24@gmail.com",
                "My First Api - Progress",
                "Hello Aime! Are you okay? what's your progress in SpringBoot level up. Please not down all of the things you and the one you are remaining with."

        );
    }
}