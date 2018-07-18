/*
 *  Copyright 2017 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 *  or implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */

package example.app.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;

/**
 * The {@link SpringBootApacheGeodeServerApplication} class is a {@link SpringBootApplication} used to bootstrap
 * an Apache Geode server.
 *
 * @author John Blum
 * @see org.springframework.boot.SpringApplication
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 * @see org.springframework.data.gemfire.config.annotation.CacheServerApplication
 * @see org.springframework.data.gemfire.config.annotation.EnableLocator
 * @see org.springframework.data.gemfire.config.annotation.EnableManager
 * @see org.springframework.data.gemfire.config.annotation.EnablePdx
 * @since 1.0.0
 */
@SpringBootApplication
@CacheServerApplication(locators = "localhost[10334]")
public class SpringBootApacheGeodeServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootApacheGeodeServerApplication.class).web(false).build().run(args);
	}

	@Configuration
	@EnableLocator
	@EnableManager(start = true)
	@Profile("locator-manager")
	@SuppressWarnings("unused")
	static class LocatorManagerConfiguration {
	}
}
