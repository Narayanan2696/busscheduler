package com.apsrtc.busscheduler;

import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BusschedulerApplicationTests {

  @Karate.Test
  Karate testBusPost() {
    return Karate.run("classpath:features/buspost").relativeTo(getClass());
  }
}
