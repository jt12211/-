<template>
<div :style='{"width":"100%","padding":"30px 7% 40px","margin":"0px auto","position":"relative","background":"none"}'>
    <el-form
	  :style='{"border":"0px solid #28890b30","width":"100%","padding":"30px","position":"relative","background":"none"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="菜品名称" prop="caipinmingcheng">
            <el-input  v-model="ruleForm.caipinmingcheng" 
                placeholder="菜品名称" clearable :disabled=" false  ||ro.caipinmingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="菜品分类" prop="caipinfenlei">
            <el-input  v-model="ruleForm.caipinfenlei" 
                placeholder="菜品分类" clearable :disabled=" false  ||ro.caipinfenlei"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="菜品图片" v-if="type!='cross' || (type=='cross' && !ro.caipintupian)" prop="caipintupian">
            <file-upload
            tip="点击上传菜品图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.caipintupian?ruleForm.caipintupian:''"
            @change="caipintupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="菜品图片" prop="caipintupian">
                <img v-if="ruleForm.caipintupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.caipintupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.caipintupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="菜品规格" prop="caipinguige">
            <el-input  v-model="ruleForm.caipinguige" 
                placeholder="菜品规格" clearable :disabled=" false  ||ro.caipinguige"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="菜品价格" prop="caipinjiage">
            <el-input type="number" v-model.number="ruleForm.caipinjiage" 
                placeholder="菜品价格" clearable :disabled=" false  ||ro.caipinjiage"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="购买数量" prop="caipinshuliang">
            <el-input  v-model.number="ruleForm.caipinshuliang" 
                placeholder="购买数量" clearable :disabled=" false  ||ro.caipinshuliang"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="总费用" prop="zongfeiyong">
              <el-input v-model="zongfeiyong" placeholder="总费用" disabled></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="购买时间" prop="goumaishijian">
              <el-date-picker
				  :disabled=" false  ||ro.goumaishijian"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.goumaishijian" 
                  type="date"
                  placeholder="购买时间">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="购买备注" prop="goumaibeizhu">
            <el-input  v-model="ruleForm.goumaibeizhu" 
                placeholder="购买备注" clearable :disabled=" false  ||ro.goumaibeizhu"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="用户账号" prop="yonghuzhanghao">
            <el-input  v-model="ruleForm.yonghuzhanghao" 
                placeholder="用户账号" clearable :disabled=" false  ||ro.yonghuzhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="用户姓名" prop="yonghuxingming">
            <el-input  v-model="ruleForm.yonghuxingming" 
                placeholder="用户姓名" clearable :disabled=" false  ||ro.yonghuxingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="手机号" prop="shoujihao">
            <el-input  v-model="ruleForm.shoujihao" 
                placeholder="手机号" clearable :disabled=" false  ||ro.shoujihao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="送餐地址" prop="songcandizhi">
            <el-input  v-model="ruleForm.songcandizhi" 
                placeholder="送餐地址" clearable :disabled=" false  ||ro.songcandizhi"></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","background":"#1e3c4f","width":"128px","lineHeight":"36px","fontSize":"14px","height":"36px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #1e3c4f","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#1e3c4f","borderRadius":"6px","background":"none","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
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
            caipinmingcheng : false,
            caipinfenlei : false,
            caipintupian : false,
            caipinguige : false,
            caipinjiage : false,
            caipinshuliang : false,
            zongfeiyong : false,
            goumaishijian : false,
            goumaibeizhu : false,
            yonghuzhanghao : false,
            yonghuxingming : false,
            shoujihao : false,
            songcandizhi : false,
            ispay : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          caipinmingcheng: '',
          caipinfenlei: '',
          caipintupian: '',
          caipinguige: '',
          caipinjiage: '',
          caipinshuliang: '',
          zongfeiyong: '',
          goumaishijian: '',
          goumaibeizhu: '',
          yonghuzhanghao: '',
          yonghuxingming: '',
          shoujihao: '',
          songcandizhi: '',
          ispay: '',
        },


        rules: {
          caipinmingcheng: [
          ],
          caipinfenlei: [
          ],
          caipintupian: [
          ],
          caipinguige: [
          ],
          caipinjiage: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          caipinshuliang: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          zongfeiyong: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          goumaishijian: [
          ],
          goumaibeizhu: [
          ],
          yonghuzhanghao: [
          ],
          yonghuxingming: [
          ],
          shoujihao: [
          ],
          songcandizhi: [
          ],
          ispay: [
          ],
        },
		centerType: false,
      };
    },
    computed: {


        zongfeiyong:{
            get: function () {
                return 1*this.ruleForm.caipinjiage*this.ruleForm.caipinshuliang
            }
        },

    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.goumaishijian = this.getCurDate()
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
            if(o=='caipinmingcheng'){
              this.ruleForm.caipinmingcheng = obj[o];
              this.ro.caipinmingcheng = true;
              continue;
            }
            if(o=='caipinfenlei'){
              this.ruleForm.caipinfenlei = obj[o];
              this.ro.caipinfenlei = true;
              continue;
            }
            if(o=='caipintupian'){
              this.ruleForm.caipintupian = obj[o].split(",")[0];
              this.ro.caipintupian = true;
              continue;
            }
            if(o=='caipinguige'){
              this.ruleForm.caipinguige = obj[o];
              this.ro.caipinguige = true;
              continue;
            }
            if(o=='caipinjiage'){
              this.ruleForm.caipinjiage = obj[o];
              this.ro.caipinjiage = true;
              continue;
            }
            if(o=='caipinshuliang'){
              this.ruleForm.caipinshuliang = obj[o];
              this.ro.caipinshuliang = true;
              continue;
            }
            if(o=='zongfeiyong'){
              this.ruleForm.zongfeiyong = obj[o];
              this.ro.zongfeiyong = true;
              continue;
            }
            if(o=='goumaishijian'){
              this.ruleForm.goumaishijian = obj[o];
              this.ro.goumaishijian = true;
              continue;
            }
            if(o=='goumaibeizhu'){
              this.ruleForm.goumaibeizhu = obj[o];
              this.ro.goumaibeizhu = true;
              continue;
            }
            if(o=='yonghuzhanghao'){
              this.ruleForm.yonghuzhanghao = obj[o];
              this.ro.yonghuzhanghao = true;
              continue;
            }
            if(o=='yonghuxingming'){
              this.ruleForm.yonghuxingming = obj[o];
              this.ro.yonghuxingming = true;
              continue;
            }
            if(o=='shoujihao'){
              this.ruleForm.shoujihao = obj[o];
              this.ro.shoujihao = true;
              continue;
            }
            if(o=='songcandizhi'){
              this.ruleForm.songcandizhi = obj[o];
              this.ro.songcandizhi = true;
              continue;
            }
          }
          this.ruleForm.caipinshuliang = 0
		  this.ro.caipinshuliang = false;
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0){
                this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
            }
            if((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0){
                this.ruleForm.yonghuxingming = json.yonghuxingming
            }
            if((json.shoujihao!=''&&json.shoujihao) || json.shoujihao==0){
                this.ruleForm.shoujihao = json.shoujihao
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`dingdanxinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

			this.ruleForm.zongfeiyong = this.zongfeiyong
			if(!this.ruleForm.caipinshuliang){
				this.$message.error("购买数量不能为空");
				return
			}
			var obj = JSON.parse(localStorage.getItem('crossObj'));
			var table = localStorage.getItem('crossTable');
			obj.caipinshuliang = obj.caipinshuliang - this.ruleForm.caipinshuliang
			if(obj.caipinshuliang<0){
				this.$message.error("购买数量不足");
				return
			}
      
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
								crossuserid=Number(localStorage.getItem('frontUserid'));
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
						this.$http.get('dingdanxinxi/list', {
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

								obj.caipinshuliang = parseFloat(obj.caipinshuliang) - parseFloat(this.ruleForm.caipinshuliang)

								this.$http.post(table+`/update`,obj).then(res => {});
								this.$http.post(`dingdanxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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

						obj.caipinshuliang = parseFloat(obj.caipinshuliang) - parseFloat(this.ruleForm.caipinshuliang)

						this.$http.post(table+`/update`,obj).then(res => {});
						this.$http.post(`dingdanxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
      caipintupianUploadChange(fileUrls) {
          this.ruleForm.caipintupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
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
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #ddd;
	  border-radius: 30px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 10px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 10px 0 30px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
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
	  cursor: pointer;
	  color: #333;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 54px;
	  border-radius: 30px;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  text-align: center;
	  min-width: 200px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  cursor: pointer;
	  color: #333;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 54px;
	  border-radius: 30px;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  text-align: center;
	  min-width: 200px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  cursor: pointer;
	  color: #333;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 54px;
	  border-radius: 30px;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  text-align: center;
	  min-width: 200px;
	  height: 54px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 0px solid #eee;
	  border-radius: 0px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  min-width: 800px;
	  height: 120px;
	}
</style>
