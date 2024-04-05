import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import caipinfenleiList from '../pages/caipinfenlei/list'
import caipinfenleiDetail from '../pages/caipinfenlei/detail'
import caipinfenleiAdd from '../pages/caipinfenlei/add'
import fuwufenleiList from '../pages/fuwufenlei/list'
import fuwufenleiDetail from '../pages/fuwufenlei/detail'
import fuwufenleiAdd from '../pages/fuwufenlei/add'
import yiliaoxinxiList from '../pages/yiliaoxinxi/list'
import yiliaoxinxiDetail from '../pages/yiliaoxinxi/detail'
import yiliaoxinxiAdd from '../pages/yiliaoxinxi/add'
import zizhuxuancanList from '../pages/zizhuxuancan/list'
import zizhuxuancanDetail from '../pages/zizhuxuancan/detail'
import zizhuxuancanAdd from '../pages/zizhuxuancan/add'
import yuyueguahaoList from '../pages/yuyueguahao/list'
import yuyueguahaoDetail from '../pages/yuyueguahao/detail'
import yuyueguahaoAdd from '../pages/yuyueguahao/add'
import dingdanxinxiList from '../pages/dingdanxinxi/list'
import dingdanxinxiDetail from '../pages/dingdanxinxi/detail'
import dingdanxinxiAdd from '../pages/dingdanxinxi/add'
import shequfuwuList from '../pages/shequfuwu/list'
import shequfuwuDetail from '../pages/shequfuwu/detail'
import shequfuwuAdd from '../pages/shequfuwu/add'
import yuyueshangmenList from '../pages/yuyueshangmen/list'
import yuyueshangmenDetail from '../pages/yuyueshangmen/detail'
import yuyueshangmenAdd from '../pages/yuyueshangmen/add'
import suqiufankuiList from '../pages/suqiufankui/list'
import suqiufankuiDetail from '../pages/suqiufankui/detail'
import suqiufankuiAdd from '../pages/suqiufankui/add'
import fuwupingjiaList from '../pages/fuwupingjia/list'
import fuwupingjiaDetail from '../pages/fuwupingjia/detail'
import fuwupingjiaAdd from '../pages/fuwupingjia/add'
import jiankangjiluList from '../pages/jiankangjilu/list'
import jiankangjiluDetail from '../pages/jiankangjilu/detail'
import jiankangjiluAdd from '../pages/jiankangjilu/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import discussyiliaoxinxiList from '../pages/discussyiliaoxinxi/list'
import discussyiliaoxinxiDetail from '../pages/discussyiliaoxinxi/detail'
import discussyiliaoxinxiAdd from '../pages/discussyiliaoxinxi/add'
import discusszizhuxuancanList from '../pages/discusszizhuxuancan/list'
import discusszizhuxuancanDetail from '../pages/discusszizhuxuancan/detail'
import discusszizhuxuancanAdd from '../pages/discusszizhuxuancan/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'caipinfenlei',
					component: caipinfenleiList
				},
				{
					path: 'caipinfenleiDetail',
					component: caipinfenleiDetail
				},
				{
					path: 'caipinfenleiAdd',
					component: caipinfenleiAdd
				},
				{
					path: 'fuwufenlei',
					component: fuwufenleiList
				},
				{
					path: 'fuwufenleiDetail',
					component: fuwufenleiDetail
				},
				{
					path: 'fuwufenleiAdd',
					component: fuwufenleiAdd
				},
				{
					path: 'yiliaoxinxi',
					component: yiliaoxinxiList
				},
				{
					path: 'yiliaoxinxiDetail',
					component: yiliaoxinxiDetail
				},
				{
					path: 'yiliaoxinxiAdd',
					component: yiliaoxinxiAdd
				},
				{
					path: 'zizhuxuancan',
					component: zizhuxuancanList
				},
				{
					path: 'zizhuxuancanDetail',
					component: zizhuxuancanDetail
				},
				{
					path: 'zizhuxuancanAdd',
					component: zizhuxuancanAdd
				},
				{
					path: 'yuyueguahao',
					component: yuyueguahaoList
				},
				{
					path: 'yuyueguahaoDetail',
					component: yuyueguahaoDetail
				},
				{
					path: 'yuyueguahaoAdd',
					component: yuyueguahaoAdd
				},
				{
					path: 'dingdanxinxi',
					component: dingdanxinxiList
				},
				{
					path: 'dingdanxinxiDetail',
					component: dingdanxinxiDetail
				},
				{
					path: 'dingdanxinxiAdd',
					component: dingdanxinxiAdd
				},
				{
					path: 'shequfuwu',
					component: shequfuwuList
				},
				{
					path: 'shequfuwuDetail',
					component: shequfuwuDetail
				},
				{
					path: 'shequfuwuAdd',
					component: shequfuwuAdd
				},
				{
					path: 'yuyueshangmen',
					component: yuyueshangmenList
				},
				{
					path: 'yuyueshangmenDetail',
					component: yuyueshangmenDetail
				},
				{
					path: 'yuyueshangmenAdd',
					component: yuyueshangmenAdd
				},
				{
					path: 'suqiufankui',
					component: suqiufankuiList
				},
				{
					path: 'suqiufankuiDetail',
					component: suqiufankuiDetail
				},
				{
					path: 'suqiufankuiAdd',
					component: suqiufankuiAdd
				},
				{
					path: 'fuwupingjia',
					component: fuwupingjiaList
				},
				{
					path: 'fuwupingjiaDetail',
					component: fuwupingjiaDetail
				},
				{
					path: 'fuwupingjiaAdd',
					component: fuwupingjiaAdd
				},
				{
					path: 'jiankangjilu',
					component: jiankangjiluList
				},
				{
					path: 'jiankangjiluDetail',
					component: jiankangjiluDetail
				},
				{
					path: 'jiankangjiluAdd',
					component: jiankangjiluAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'discussyiliaoxinxi',
					component: discussyiliaoxinxiList
				},
				{
					path: 'discussyiliaoxinxiDetail',
					component: discussyiliaoxinxiDetail
				},
				{
					path: 'discussyiliaoxinxiAdd',
					component: discussyiliaoxinxiAdd
				},
				{
					path: 'discusszizhuxuancan',
					component: discusszizhuxuancanList
				},
				{
					path: 'discusszizhuxuancanDetail',
					component: discusszizhuxuancanDetail
				},
				{
					path: 'discusszizhuxuancanAdd',
					component: discusszizhuxuancanAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
