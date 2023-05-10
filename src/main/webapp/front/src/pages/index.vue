<template>
	<div class="main-containers">
		<div class="top-container" :style='{"boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","padding":"0 7%","alignItems":"center","display":"flex","justifyContent":"space-between","overflow":"hidden","top":"0","left":"0","background":"url(http://codegen.caihongy.cn/20230129/0a243ca4167747aca640474cc2d2311f.jpg) no-repeat center bottom,#fff","width":"100%","position":"fixed","height":"64px","zIndex":"1002"}'>
			<img v-if='false' :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"block","height":"44px"}' src='http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg'>
			<div v-if="true" :style='{"color":"#333","textAlign":"center","fontSize":"24px"}'>基于J2EE的校内社团学习交流系统</div>
			<div>
				<div v-if="false" :style='{"color":"#333","fontSize":"18px","display":"inline-block"}'>0753-1234567</div>
				<div v-if="Token" :style='{"color":"#333","fontSize":"18px","display":"inline-block"}'>{{username}}</div>
				<el-button v-if="!Token" @click="toLogin()" :style='{"border":"none","padding":"0 20px","margin":"0 0 0 10px","color":"#fff","borderRadius":"2px","background":"#ffa800","display":"inline-block","fontSize":"14px","lineHeight":"32px","minWidth":"80px","height":"32px"}'>登录/注册</el-button>
                <el-button v-if="Token" @click="logout" :style='{"padding":"0 20px","margin":"0 0 0 10px","color":"#666","borderRadius":"2px","background":"#eee","display":"inline-block","fontSize":"14px","lineHeight":"32px","minWidth":"80px","height":"32px"}'>退出</el-button>
			</div>
		</div>
		
		
		<div class="body-containers" :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"rgba(64, 158, 255, .3)","display":"block"} : {"minHeight":"100vh","padding":"64px 0 0","margin":"0","position":"relative","background":"#fff"}'>
			<div class="menu-preview" :style='{"padding":"0","borderColor":"#efefef","margin":"0 auto 20px","background":"none","borderWidth":"0","width":"100%","borderStyle":"solid","height":"60px"}'>
				<el-menu class="el-menu-horizontal-demo" :style='{"border":0,"padding":"0","listStyle":"none","margin":"0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230129/5344a0c11a4b4f6f82d86e117117b4d5.png) no-repeat left top / auto 100%,url(http://codegen.caihongy.cn/20230129/008def74860e46aa86d0135826d25973.png) no-repeat right top / auto 100%,url(http://codegen.caihongy.cn/20230129/067e20cadadc47589e5d37085f1cd98f.png) repeat-x center center / auto 100%","display":"flex","position":"relative","justifyContent":"center"}' :default-active="activeIndex" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<el-image v-if="false" :style='{"width":"44px","margin":"8px 10px 8px 0","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					<el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"60px","fontSize":"14px","height":"60px"}' :class="iconArr[index]"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"16px","color":"inherit","height":"60px"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item @click="goBackend">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-box"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"16px","color":"inherit","height":"60px"}'>后台管理</span>
					</el-menu-item>
					<el-menu-item :index="menuList.length + 2 + ''" v-if="Token && notAdmin" @click="goMenu('/index/center')">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-user"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"16px","color":"inherit","height":"60px"}'>个人中心</span>
					</el-menu-item>
				</el-menu>
			</div>
			
			<div class="banner-preview" :style='{"width":"90%","margin":"0 5%","height":"auto"}'>
				<el-carousel :style='{"width":"100%","margin":"0 auto"}' trigger="click" indicator-position="inside" arrow="always" type="card" direction="horizontal" height="500px" :autoplay="true" :interval="3000" :loop="true">
					<el-carousel-item :style='{"width":"50%","margin":"o auto","borderRadius":"8px","height":"100%"}' v-for="item in carouselList" :key="item.id">
						<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			
			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"minHeight":"150px","padding":"20px 0","alignItems":"center","background":"#333","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center"}'>
			    <img :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" >
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Vue from 'vue'
export default {
    data() {
		return {
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["新增","查看","修改","删除"],"menu":"社团类型","menuJump":"列表","tableName":"shetuanleixing"}],"menu":"社团类型管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","修改","删除","审核"],"menu":"建立社团","menuJump":"列表","tableName":"jianlishetuan"}],"menu":"建立社团管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","修改","删除"],"menu":"社团信息","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","修改","删除"],"menu":"加入社团","menuJump":"列表","tableName":"jiarushetuan"}],"menu":"加入社团管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除"],"menu":"社团活动","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改","删除","审核"],"menu":"解散社团","menuJump":"列表","tableName":"jiesanshetuan"}],"menu":"解散社团管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["新增","查看","修改","删除"],"menu":"话题交流","tableName":"forum"}],"menu":"话题交流"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-discover","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-vip","buttons":["查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","申请加入"],"menu":"社团信息列表","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","申请参加"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除","解散"],"menu":"建立社团","menuJump":"列表","tableName":"jianlishetuan"}],"menu":"建立社团管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["新增","查看","修改","删除","解散社团"],"menu":"社团信息","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","审核"],"menu":"加入社团","menuJump":"列表","tableName":"jiarushetuan"}],"menu":"加入社团管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"社团活动","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","审核"],"menu":"申请参加","menuJump":"列表","tableName":"shenqingcanjia"}],"menu":"申请参加管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看"],"menu":"解散社团","menuJump":"列表","tableName":"jiesanshetuan"}],"menu":"解散社团管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","申请加入"],"menu":"社团信息列表","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","申请参加"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			Token: localStorage.getItem('Token'),
            username: localStorage.getItem('username'),
            notAdmin: localStorage.getItem('sessionTable')!='"users"',
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],	
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
        },
    },
    methods: {
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: '登出成功',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		goMenu(path) {
            if (!localStorage.getItem('Token')) {
                this.toLogin();
            } else {
                this.$router.push(path);
            }
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		color: #fff;
		white-space: nowrap;
		display: flex;
		font-size: 16px;
		line-height: 60px;
		background: none;
		justify-content: center;
		align-items: center;
		position: relative;
		list-style: none;
		height: 60px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		color: #9c5bf5;
		white-space: nowrap;
		background: url(http://codegen.caihongy.cn/20230129/6c7258b7743f421f905576aadbcc782a.png) no-repeat center bottom / auto 100%;
		font-size: 16px;
		line-height: 60px;
		position: relative;
		list-style: none;
		height: 60px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		color: #9c5bf5;
		white-space: nowrap;
		background: url(http://codegen.caihongy.cn/20230129/6c7258b7743f421f905576aadbcc782a.png) no-repeat center bottom / auto 100%;
		font-size: 14px;
		line-height: 60px;
		position: relative;
		list-style: none;
		height: 60px;
	}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 14px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: #abb340;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 14px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: #abb340;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
      .left-content {
          width: 100%;
          text-align: left;
      }
      .right-content {
          width: 100%;
          text-align: right;
      }
    }
</style>
