package com.yukuan.mvc

import com.yukuan.helper.APIHelper
import com.yukuan.helper.DataHelper
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletResponse

@Controller
class MvcController {
    @Autowired
    AppSetting appSetting

    //step1: authorization
    @RequestMapping(value = "/requestLogin", method = RequestMethod.GET)
    def requestLogin() {
        return new ModelAndView("redirect:" + APIHelper.buildAuthorizeUrl(appSetting))
    }

    //step2: use code to get access token
    @RequestMapping(value = "/getToken/{code}", method = RequestMethod.GET)
    def @ResponseBody
    index(@PathVariable("code") String code, HttpServletResponse resp) {
        def result = APIHelper.getToken(code, appSetting)
        def jsonSlurper = new JsonSlurper()
        def data = jsonSlurper.parseText(result.str);
        return data
    }

    //step3: use token to access api
    @RequestMapping(value = "/weibo", method = RequestMethod.GET)
    def @ResponseBody
    requestWeibo(@RequestParam(value = "token") token,
                 @RequestParam(value = "count") count,
                 @RequestParam(value = "page") page) {
        def result = APIHelper.timeline(token, count, page)
        return DataHelper.adaptData(result.statuses)
    }
}
