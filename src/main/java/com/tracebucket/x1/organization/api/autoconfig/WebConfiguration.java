package com.tracebucket.x1.organization.api.autoconfig;

import com.tracebucket.tron.autoconfig.NonExistingWebBeans;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by Vishwajit on 16-04-2015.
 */
@Configuration
@Conditional(value = NonExistingWebBeans.class)
@ComponentScan(basePackages = {"com.tracebucket.x1.**.api.rest"})
public class WebConfiguration {
}