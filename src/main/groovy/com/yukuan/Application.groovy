package com.yukuan

import com.yukuan.mvc.AppSetting
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@EnableConfigurationProperties(AppSetting.class)
@ComponentScan(basePackages = "com.yukuan.mvc")
class Application {
    static main(args) {
        new SpringApplicationBuilder()
                .sources(Application.class)
                .bannerMode(Banner.Mode.OFF)
                .run()
    }
}
