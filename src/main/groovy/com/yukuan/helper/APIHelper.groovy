package com.yukuan.helper

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.URLENC

class APIHelper {

    def static timeline(token, count, page) {
        def url = "https://api.weibo.com/2/";
        def http = new HTTPBuilder(url)
        return http.get(path: '/statuses/home_timeline.json',
                query: [access_token: token,
                        count       : count, page: page])
    }

    def static getToken(code, appSetting) {
        def url = "https://api.weibo.com/";
        def http = new HTTPBuilder(url)
        return http.post(path: '/oauth2/access_token', body: [client_id    : appSetting.clientId,
                                                              client_secret: appSetting.clientSecret,
                                                              grant_type   : appSetting.grantType,
                                                              redirect_uri : appSetting.redirectUri,
                                                              code         : code], requestContentType: URLENC)
    }

    def static buildAuthorizeUrl(appSetting) {
        return "https://api.weibo.com/oauth2/authorize" +
                "?client_id=${appSetting.clientId}" +
                "&response_type=code" +
                "&redirect_uri=${appSetting.redirectUri}"
    }
}
