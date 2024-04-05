import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import shequfuwu from '@/views/modules/shequfuwu/list'
    import jiankangjilu from '@/views/modules/jiankangjilu/list'
    import news from '@/views/modules/news/list'
    import discusszizhuxuancan from '@/views/modules/discusszizhuxuancan/list'
    import yuyueshangmen from '@/views/modules/yuyueshangmen/list'
    import discussyiliaoxinxi from '@/views/modules/discussyiliaoxinxi/list'
    import zizhuxuancan from '@/views/modules/zizhuxuancan/list'
    import dingdanxinxi from '@/views/modules/dingdanxinxi/list'
    import suqiufankui from '@/views/modules/suqiufankui/list'
    import fuwupingjia from '@/views/modules/fuwupingjia/list'
    import caipinfenlei from '@/views/modules/caipinfenlei/list'
    import forum from '@/views/modules/forum/list'
    import fuwufenlei from '@/views/modules/fuwufenlei/list'
    import yuyueguahao from '@/views/modules/yuyueguahao/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yiliaoxinxi from '@/views/modules/yiliaoxinxi/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/shequfuwu',
        name: '社区服务',
        component: shequfuwu
      }
      ,{
	path: '/jiankangjilu',
        name: '健康记录',
        component: jiankangjilu
      }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/discusszizhuxuancan',
        name: '自助选餐评论',
        component: discusszizhuxuancan
      }
      ,{
	path: '/yuyueshangmen',
        name: '预约上门',
        component: yuyueshangmen
      }
      ,{
	path: '/discussyiliaoxinxi',
        name: '医疗信息评论',
        component: discussyiliaoxinxi
      }
      ,{
	path: '/zizhuxuancan',
        name: '自助选餐',
        component: zizhuxuancan
      }
      ,{
	path: '/dingdanxinxi',
        name: '订单信息',
        component: dingdanxinxi
      }
      ,{
	path: '/suqiufankui',
        name: '诉求反馈',
        component: suqiufankui
      }
      ,{
	path: '/fuwupingjia',
        name: '服务评价',
        component: fuwupingjia
      }
      ,{
	path: '/caipinfenlei',
        name: '菜品分类',
        component: caipinfenlei
      }
      ,{
	path: '/forum',
        name: '交流论坛',
        component: forum
      }
      ,{
	path: '/fuwufenlei',
        name: '服务分类',
        component: fuwufenlei
      }
      ,{
	path: '/yuyueguahao',
        name: '预约挂号',
        component: yuyueguahao
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/yiliaoxinxi',
        name: '医疗信息',
        component: yiliaoxinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '公告信息分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
