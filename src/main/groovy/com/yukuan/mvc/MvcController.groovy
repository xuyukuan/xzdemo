package com.yukuan.mvc

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MvcController {
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    def @ResponseBody homepage() {
        return "index"
    }
}
