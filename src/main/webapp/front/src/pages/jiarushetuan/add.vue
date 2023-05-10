<template>
<div :style='{"width":"100%","padding":"40px 7%","margin":"0 auto","position":"relative","background":"none"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="150px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="加入编号" prop="jiarubianhao">
              <el-input v-model="ruleForm.jiarubianhao" placeholder="加入编号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="社团名称" prop="shetuanmingcheng">
            <el-input v-model="ruleForm.shetuanmingcheng" 
                placeholder="社团名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="社团标签" prop="shetuanbiaoqian">
            <el-input v-model="ruleForm.shetuanbiaoqian" 
                placeholder="社团标签" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}'  label="人数" prop="renshu">
            <el-select v-model="ruleForm.renshu" placeholder="请选择人数"  >
              <el-option
                  v-for="(item,index) in renshuOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="申请时间" prop="shenqingshijian" >
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.shenqingshijian" 
                  type="date"
                  placeholder="申请时间">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="加入学生账号" prop="jiaruxueshengzhanghao">
            <el-input v-model="ruleForm.jiaruxueshengzhanghao" 
                placeholder="加入学生账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="加入学生姓名" prop="jiaruxueshengxingming">
            <el-input v-model="ruleForm.jiaruxueshengxingming" 
                placeholder="加入学生姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="学生账号" prop="xueshengzhanghao">
            <el-input v-model="ruleForm.xueshengzhanghao" 
                placeholder="学生账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0","background":"none"}' label="学生姓名" prop="xueshengxingming">
            <el-input v-model="ruleForm.xueshengxingming" 
                placeholder="学生姓名" clearable ></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0 45px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20230129/bc3d34ffcafa4e53b8fa1013dfdfb08e.png) repeat-x right top / auto 100%,#43bcaa","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0 45px","margin":"0","outline":"none","color":"#fff","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20230129/5374952d49f04eba875b50eb26db67fd.png) repeat-x right top / auto 100%,#43bcaa","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            jiarubianhao : false,
            shetuanmingcheng : false,
            shetuanbiaoqian : false,
            renshu : false,
            shenqingshijian : false,
            jiaruxueshengzhanghao : false,
            jiaruxueshengxingming : false,
            xueshengzhanghao : false,
            xueshengxingming : false,
            sfsh : false,
            shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          jiarubianhao: this.getUUID(),
          shetuanmingcheng: '',
          shetuanbiaoqian: '',
          renshu: '',
          shenqingshijian: '',
          jiaruxueshengzhanghao: '',
          jiaruxueshengxingming: '',
          xueshengzhanghao: '',
          xueshengxingming: '',
        },
        renshuOptions: [],
        rules: {
          jiarubianhao: [
          ],
          shetuanmingcheng: [
          ],
          shetuanbiaoqian: [
          ],
          renshu: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          shenqingshijian: [
          ],
          jiaruxueshengzhanghao: [
          ],
          jiaruxueshengxingming: [
          ],
          xueshengzhanghao: [
          ],
          xueshengxingming: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.shenqingshijian = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='jiarubianhao'){
              this.ruleForm.jiarubianhao = obj[o];
              this.ro.jiarubianhao = true;
              continue;
            }
            if(o=='shetuanmingcheng'){
              this.ruleForm.shetuanmingcheng = obj[o];
              this.ro.shetuanmingcheng = true;
              continue;
            }
            if(o=='shetuanbiaoqian'){
              this.ruleForm.shetuanbiaoqian = obj[o];
              this.ro.shetuanbiaoqian = true;
              continue;
            }
            if(o=='renshu'){
              this.ruleForm.renshu = obj[o];
              this.ro.renshu = true;
              continue;
            }
            if(o=='shenqingshijian'){
              this.ruleForm.shenqingshijian = obj[o];
              this.ro.shenqingshijian = true;
              continue;
            }
            if(o=='jiaruxueshengzhanghao'){
              this.ruleForm.jiaruxueshengzhanghao = obj[o];
              this.ro.jiaruxueshengzhanghao = true;
              continue;
            }
            if(o=='jiaruxueshengxingming'){
              this.ruleForm.jiaruxueshengxingming = obj[o];
              this.ro.jiaruxueshengxingming = true;
              continue;
            }
            if(o=='xueshengzhanghao'){
              this.ruleForm.xueshengzhanghao = obj[o];
              this.ro.xueshengzhanghao = true;
              continue;
            }
            if(o=='xueshengxingming'){
              this.ruleForm.xueshengxingming = obj[o];
              this.ro.xueshengxingming = true;
              continue;
            }
          }
          this.ruleForm.renshu = 0
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.xueshengzhanghao!=''&&json.xueshengzhanghao) || json.xueshengzhanghao==0){
                this.ruleForm.jiaruxueshengzhanghao = json.xueshengzhanghao
            }
            if((json.xueshengxingming!=''&&json.xueshengxingming) || json.xueshengxingming==0){
                this.ruleForm.jiaruxueshengxingming = json.xueshengxingming
            }
          }
        });
        this.renshuOptions = "1".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('jiarushetuan/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        var obj = JSON.parse(localStorage.getItem('crossObj'));
        var table = localStorage.getItem('crossTable');
        obj.renshu = parseFloat(obj.renshu) + parseFloat(this.ruleForm.renshu)

        //this.$http.post(table+`/update`, obj).then(res => {});
        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('jiarushetuan/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算
                          var obj = JSON.parse(localStorage.getItem('crossObj'));
                          var table = localStorage.getItem('crossTable');

                          obj.renshu = parseFloat(obj.renshu) + parseFloat(this.ruleForm.renshu)

                          this.$http.post(table+`/update`,obj).then(res => {});
                          this.$http.post('jiarushetuan/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {
                  var obj = JSON.parse(localStorage.getItem('crossObj'));
                  var table = localStorage.getItem('crossTable');

                  obj.renshu = parseFloat(obj.renshu) + parseFloat(this.ruleForm.renshu)

                  this.$http.post(table+`/update`,obj).then(res => {});
                  this.$http.post('jiarushetuan/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #9f9fd7;
	  font-weight: 500;
	  width: 150px;
	  font-size: 15px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #ccc;
	  border-radius: 8px;
	  padding: 0 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #ccc;
	  border-radius: 8px;
	  padding: 0 10px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #ccc;
	  border-radius: 8px;
	  padding: 0 10px 0 30px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px dashed #333;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed #333;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed #333;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #ccc;
	  border-radius: 8px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
