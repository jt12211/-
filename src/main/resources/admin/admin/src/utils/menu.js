const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "用户人数", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["新增", "查看", "修改", "删除", "首页总数", "首页统计"],
                    "menu": "用户",
                    "menuJump": "列表",
                    "tableName": "yonghu"
                }],
                "menu": "用户管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "菜品分类",
                    "menuJump": "列表",
                    "tableName": "caipinfenlei"
                }],
                "menu": "菜品分类管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "下单"],
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["查看", "修改", "删除", "查看评论", "新增"],
                    "menu": "自助选餐",
                    "menuJump": "列表",
                    "tableName": "zizhuxuancan"
                }],
                "menu": "自助选餐管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "预约挂号"],
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "menu": "医疗信息",
                    "menuJump": "列表",
                    "tableName": "yiliaoxinxi"
                }],
                "menu": "医疗信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-vip",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "服务分类",
                    "menuJump": "列表",
                    "tableName": "fuwufenlei"
                }],
                "menu": "服务分类管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-similar",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "预约挂号",
                    "menuJump": "列表",
                    "tableName": "yuyueguahao"
                }],
                "menu": "预约挂号管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付", "每日订单量", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-album",
                    "buttons": ["查看", "修改", "删除", "支付", "首页总数", "首页统计"],
                    "menu": "订单信息",
                    "menuJump": "列表",
                    "tableName": "dingdanxinxi"
                }],
                "menu": "订单信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "预约上门"],
                    "appFrontIcon": "cuIcon-taxi",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "社区服务",
                    "menuJump": "列表",
                    "tableName": "shequfuwu"
                }],
                "menu": "社区服务管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "服务评价"],
                    "appFrontIcon": "cuIcon-newshot",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "预约上门",
                    "menuJump": "列表",
                    "tableName": "yuyueshangmen"
                }],
                "menu": "预约上门管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核"],
                    "appFrontIcon": "cuIcon-qrcode",
                    "buttons": ["查看", "修改", "删除", "审核"],
                    "menu": "诉求反馈",
                    "menuJump": "列表",
                    "tableName": "suqiufankui"
                }],
                "menu": "诉求反馈管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "服务评价", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-explore",
                    "buttons": ["查看", "修改", "删除", "首页总数", "首页统计"],
                    "menu": "服务评价",
                    "menuJump": "列表",
                    "tableName": "fuwupingjia"
                }],
                "menu": "服务评价管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "健康数据分析", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "健康记录",
                    "menuJump": "列表",
                    "tableName": "jiankangjilu"
                }],
                "menu": "健康记录管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-group",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "交流论坛",
                    "tableName": "forum"
                }],
                "menu": "交流论坛"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-link",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "轮播图管理",
                    "tableName": "config"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "公告信息",
                    "tableName": "news"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "公告信息分类",
                    "tableName": "newstype"
                }],
                "menu": "系统管理"
            }],
            "frontMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "预约挂号"],
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["查看", "预约挂号"],
                    "menu": "医疗信息列表",
                    "menuJump": "列表",
                    "tableName": "yiliaoxinxi"
                }],
                "menu": "医疗信息模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "下单"],
                    "appFrontIcon": "cuIcon-keyboard",
                    "buttons": ["查看", "下单"],
                    "menu": "自助选餐列表",
                    "menuJump": "列表",
                    "tableName": "zizhuxuancan"
                }],
                "menu": "自助选餐模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "预约上门"],
                    "appFrontIcon": "cuIcon-shop",
                    "buttons": ["查看", "预约上门"],
                    "menu": "社区服务列表",
                    "menuJump": "列表",
                    "tableName": "shequfuwu"
                }],
                "menu": "社区服务模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-similar",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "预约挂号",
                    "menuJump": "列表",
                    "tableName": "yuyueguahao"
                }],
                "menu": "预约挂号管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付", "每日订单量", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-album",
                    "buttons": ["查看", "修改", "删除", "支付"],
                    "menu": "订单信息",
                    "menuJump": "列表",
                    "tableName": "dingdanxinxi"
                }],
                "menu": "订单信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "服务评价"],
                    "appFrontIcon": "cuIcon-newshot",
                    "buttons": ["查看", "修改", "服务评价", "删除"],
                    "menu": "预约上门",
                    "menuJump": "列表",
                    "tableName": "yuyueshangmen"
                }],
                "menu": "预约上门管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核"],
                    "appFrontIcon": "cuIcon-qrcode",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "诉求反馈",
                    "menuJump": "列表",
                    "tableName": "suqiufankui"
                }],
                "menu": "诉求反馈管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "服务评价", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-explore",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "服务评价",
                    "menuJump": "列表",
                    "tableName": "fuwupingjia"
                }],
                "menu": "服务评价管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "健康数据分析", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["新增", "查看", "修改", "删除", "首页总数", "首页统计"],
                    "menu": "健康记录",
                    "menuJump": "列表",
                    "tableName": "jiankangjilu"
                }],
                "menu": "健康记录管理"
            }],
            "frontMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "预约挂号"],
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["查看", "预约挂号"],
                    "menu": "医疗信息列表",
                    "menuJump": "列表",
                    "tableName": "yiliaoxinxi"
                }],
                "menu": "医疗信息模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "查看评论", "下单"],
                    "appFrontIcon": "cuIcon-keyboard",
                    "buttons": ["查看", "下单"],
                    "menu": "自助选餐列表",
                    "menuJump": "列表",
                    "tableName": "zizhuxuancan"
                }],
                "menu": "自助选餐模块"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "预约上门"],
                    "appFrontIcon": "cuIcon-shop",
                    "buttons": ["查看", "预约上门"],
                    "menu": "社区服务列表",
                    "menuJump": "列表",
                    "tableName": "shequfuwu"
                }],
                "menu": "社区服务模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "是",
            "hasFrontRegister": "是",
            "roleName": "用户",
            "tableName": "yonghu"
        }]
    }
}
export default menu;