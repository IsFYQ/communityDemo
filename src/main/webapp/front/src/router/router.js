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
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import shetuanleixingList from '../pages/shetuanleixing/list'
import shetuanleixingDetail from '../pages/shetuanleixing/detail'
import shetuanleixingAdd from '../pages/shetuanleixing/add'
import jianlishetuanList from '../pages/jianlishetuan/list'
import jianlishetuanDetail from '../pages/jianlishetuan/detail'
import jianlishetuanAdd from '../pages/jianlishetuan/add'
import shetuanxinxiList from '../pages/shetuanxinxi/list'
import shetuanxinxiDetail from '../pages/shetuanxinxi/detail'
import shetuanxinxiAdd from '../pages/shetuanxinxi/add'
import jiarushetuanList from '../pages/jiarushetuan/list'
import jiarushetuanDetail from '../pages/jiarushetuan/detail'
import jiarushetuanAdd from '../pages/jiarushetuan/add'
import shetuanhuodongList from '../pages/shetuanhuodong/list'
import shetuanhuodongDetail from '../pages/shetuanhuodong/detail'
import shetuanhuodongAdd from '../pages/shetuanhuodong/add'
import jiesanshetuanList from '../pages/jiesanshetuan/list'
import jiesanshetuanDetail from '../pages/jiesanshetuan/detail'
import jiesanshetuanAdd from '../pages/jiesanshetuan/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'

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
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'shetuanleixing',
					component: shetuanleixingList
				},
				{
					path: 'shetuanleixingDetail',
					component: shetuanleixingDetail
				},
				{
					path: 'shetuanleixingAdd',
					component: shetuanleixingAdd
				},
				{
					path: 'jianlishetuan',
					component: jianlishetuanList
				},
				{
					path: 'jianlishetuanDetail',
					component: jianlishetuanDetail
				},
				{
					path: 'jianlishetuanAdd',
					component: jianlishetuanAdd
				},
				{
					path: 'shetuanxinxi',
					component: shetuanxinxiList
				},
				{
					path: 'shetuanxinxiDetail',
					component: shetuanxinxiDetail
				},
				{
					path: 'shetuanxinxiAdd',
					component: shetuanxinxiAdd
				},
				{
					path: 'jiarushetuan',
					component: jiarushetuanList
				},
				{
					path: 'jiarushetuanDetail',
					component: jiarushetuanDetail
				},
				{
					path: 'jiarushetuanAdd',
					component: jiarushetuanAdd
				},
				{
					path: 'shetuanhuodong',
					component: shetuanhuodongList
				},
				{
					path: 'shetuanhuodongDetail',
					component: shetuanhuodongDetail
				},
				{
					path: 'shetuanhuodongAdd',
					component: shetuanhuodongAdd
				},
				{
					path: 'jiesanshetuan',
					component: jiesanshetuanList
				},
				{
					path: 'jiesanshetuanDetail',
					component: jiesanshetuanDetail
				},
				{
					path: 'jiesanshetuanAdd',
					component: jiesanshetuanAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
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
