package com.yukuan.mvc

import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse
import static groovyx.net.http.ContentType.URLENC

@Controller
class MvcController {
    @RequestMapping(value = "/getToken/{code}", method = RequestMethod.GET)
    def @ResponseBody
    index(@PathVariable("code") String code, HttpServletResponse resp) {
        def url = "https://api.weibo.com/";
        //?client_id=582260257&client_secret=1358ccd7c01937d73de98eecb137956a&grant_type=authorization_code&redirect_uri=http://www.xuyukuan.com:8080&code="+code

        def http = new HTTPBuilder(url)
        def result = http.post(path: '/oauth2/access_token', body: [client_id: '582260257',
                                                       client_secret: '1358ccd7c01937d73de98eecb137956a',
                                                       grant_type: 'authorization_code',
                                                       redirect_uri: 'http://www.xuyukuan.com:8080',
                                                       code: code], requestContentType: URLENC)
        def jsonSlurper = new JsonSlurper()
        def data = jsonSlurper.parseText(result.str);
        return data
    }

    @RequestMapping(value = "/requestLogin", method = RequestMethod.GET)
    def requestLogin() {
        def url = "https://api.weibo.com/oauth2/authorize?client_id=582260257&response_type=code&redirect_uri=http://www.xuyukuan.com:8080"
        return new ModelAndView("redirect:" + url)
    }
}
