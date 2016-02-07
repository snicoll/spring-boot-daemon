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

package net.nicoll.boot.daemon;

import java.util.Arrays;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ClassUtils;

/**
 * Basic {@link Daemon} implementation for a Spring Boot app. Only for demonstration
 * purposes as Spring Boot 1.3 has a much better support for this.
 *
 * @author Stephane Nicoll
 */
public class SpringBootDaemon implements Daemon {

	private Class<?> springBootApp;

	private ConfigurableApplicationContext content;

	public void init(DaemonContext context) throws Exception {
		System.out.println("Daemon initialized with arguments [" +
				Arrays.toString(context.getArguments()) + "]");
		this.springBootApp = ClassUtils.resolveClassName(context.getArguments()[0],
				SpringBootDaemon.class.getClassLoader());
	}

	public void start() throws Exception {
		System.out.println("Starting Spring Boot application [" + this.springBootApp.getName() + "]");
		this.content = SpringApplication.run(springBootApp);
	}

	public void stop() throws Exception {
		System.out.println("Stopping Spring Boot application [" + this.springBootApp.getName() + "]");
		this.content.close();
	}

	public void destroy() {

	}

}