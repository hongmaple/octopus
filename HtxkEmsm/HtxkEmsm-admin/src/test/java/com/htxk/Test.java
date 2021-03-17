package com.htxk;

import com.htxk.ruoyi.common.utils.DateUtils;
import com.htxk.ruoyi.common.utils.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {


    @org.junit.Test
    public void geiDate(){
       /* String kkfk = DateUtils.parseDateToStr("yyyyMMddmmss",DateUtils.getNowDate());*/
        String dsff = "15682374764";
        System.out.println(dsff);
        System.out.println(StringUtils.substring(dsff,5));
    }
}
