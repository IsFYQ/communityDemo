export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["新增","查看","修改","删除"],"menu":"社团类型","menuJump":"列表","tableName":"shetuanleixing"}],"menu":"社团类型管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","修改","删除","审核"],"menu":"建立社团","menuJump":"列表","tableName":"jianlishetuan"}],"menu":"建立社团管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","修改","删除"],"menu":"社团信息","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","修改","删除"],"menu":"加入社团","menuJump":"列表","tableName":"jiarushetuan"}],"menu":"加入社团管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除"],"menu":"社团活动","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改","删除","审核"],"menu":"解散社团","menuJump":"列表","tableName":"jiesanshetuan"}],"menu":"解散社团管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["新增","查看","修改","删除"],"menu":"话题交流","tableName":"forum"}],"menu":"话题交流"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-discover","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-vip","buttons":["查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","申请加入"],"menu":"社团信息列表","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","申请参加"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除","解散"],"menu":"建立社团","menuJump":"列表","tableName":"jianlishetuan"}],"menu":"建立社团管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["新增","查看","修改","删除","解散社团"],"menu":"社团信息","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","审核"],"menu":"加入社团","menuJump":"列表","tableName":"jiarushetuan"}],"menu":"加入社团管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"社团活动","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","审核"],"menu":"申请参加","menuJump":"列表","tableName":"shenqingcanjia"}],"menu":"申请参加管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看"],"menu":"解散社团","menuJump":"列表","tableName":"jiesanshetuan"}],"menu":"解散社团管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","申请加入"],"menu":"社团信息列表","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","申请参加"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"学生","tableName":"xuesheng"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
