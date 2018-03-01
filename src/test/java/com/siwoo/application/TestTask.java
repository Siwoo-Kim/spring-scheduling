package com.siwoo.application;

import com.siwoo.application.config.AppConfig;
import com.siwoo.application.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestTask {

    @Autowired CarService carService;

    @Test
    public void testTask() throws InterruptedException {

        while(!carService.isDone()){
            Thread.sleep(2000);
        }
    }
}
