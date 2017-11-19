package service;

import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by guoyanlei
 * date：2017/11/19
 * time：22:16
 * description：
 */
public class UtilTest {

    @Test
    public void testDate() {

        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2017-11-19 00:00:00", dtf);
        dateTime = dateTime.plusDays(1L);
        long time = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(time);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss"));
        System.out.println(format);
    }
}
