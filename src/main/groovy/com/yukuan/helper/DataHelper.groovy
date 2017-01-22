package com.yukuan.helper

import com.yukuan.model.Weibo

class DataHelper {
    def static adaptData(data) {
        def weiboList = []
        for (item in data) {
            def userImage = item?.user?.profile_image_url
            def userName = item?.user?.name
            def content = item?.text
            def weibo = new Weibo(userImage, userName, content)
            weiboList.add(weibo)
        }
        return weiboList
    }
}
