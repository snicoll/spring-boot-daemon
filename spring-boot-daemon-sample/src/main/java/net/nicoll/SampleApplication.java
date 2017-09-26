/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.nicoll;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@SpringBootApplication
public class SampleApplication {

    @Value("${profile.name}")
    private String profile;

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    @Scheduled(fixedDelayString = "3000")
    public void printScheduling() throws InterruptedException {
        System.out.println("---------Hello World by Scheduling ---------- profile:" + profile);
    }

    @RestController
    static class HomeController {

        @RequestMapping("/")
        public String home() {
            return "Hello World";
        }
    }

}
