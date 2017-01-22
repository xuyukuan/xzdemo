package com.yukuan.mvc

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "xzdemo")
class AppSetting {
    String clientId
    String clientSecret
    String grantType
    String redirectUri
}
