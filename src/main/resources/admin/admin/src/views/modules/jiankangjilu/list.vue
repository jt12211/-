<template>
	<div class="main-content" :style='{"width":"calc(100% - 60px)","padding":"30px","margin":"0 30px","background":"#fff"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"margin":"0 0 20px","background":"#fff"}' :inline="true" :model="searchForm">
				<el-row :style='{"display":"block"}' >
				</el-row>

				<el-row class="actions" :style='{"flexWrap":"wrap","margin":"20px 0","display":"flex"}'>
					<el-button class="add" v-if="isAuth('jiankangjilu','新增')" type="success" @click="addOrUpdateHandler()">
						<span class="icon iconfont icon-tianjia7" :style='{"margin":"0 2px","fontSize":"14px","color":"#0E9BD3","height":"40px"}'></span>
						添加
					</el-button>
					<el-button class="del" v-if="isAuth('jiankangjilu','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						<span class="icon iconfont icon-shanchu7" :style='{"margin":"0 2px","fontSize":"14px","color":"#0E9BD3","height":"40px"}'></span>
						删除
					</el-button>




					<el-button class="btn18" v-if="isAuth('jiankangjilu','健康数据分析')" type="success" @click="chartDialog1()">
						<span class="icon iconfont icon-qita1" :style='{"margin":"0 2px","fontSize":"14px","color":"#0E9BD3","height":"40px"}'></span>
						健康数据分析
					</el-button>
				</el-row>
			</el-form>
			<div :style='{"width":"100%","padding":"10px"}'>
				<el-table class="tables"
					:stripe='false'
					:style='{"width":"100%","padding":"0","borderColor":"#eee","borderStyle":"solid","borderWidth":"1px 0 0 1px","background":"#fff"}' 
					:border='true'
					v-if="isAuth('jiankangjilu','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='false' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='false'  
						prop="yonghuzhanghao"
						label="用户账号">
						<template slot-scope="scope">
							{{scope.row.yonghuzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="yonghuxingming"
						label="用户姓名">
						<template slot-scope="scope">
							{{scope.row.yonghuxingming}}
						</template>
					</el-table-column>
					<!-- 无 -->
					<el-table-column :resizable='true' :sortable='false' prop="fengmian" width="200" label="封面">
						<template slot-scope="scope">
							<div v-if="scope.row.fengmian">
								<img v-if="scope.row.fengmian.substring(0,4)=='http'" :src="scope.row.fengmian.split(',')[0]" width="100" height="100">
								<img v-else :src="$base.url+scope.row.fengmian.split(',')[0]" width="100" height="100">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="tizhong"
						label="体重">
						<template slot-scope="scope">
							{{scope.row.tizhong}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="tiwen"
						label="体温">
						<template slot-scope="scope">
							{{scope.row.tiwen}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="xueyangbaohedu"
						label="血氧饱和度">
						<template slot-scope="scope">
							{{scope.row.xueyangbaohedu}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="xinlv"
						label="心率">
						<template slot-scope="scope">
							{{scope.row.xinlv}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="xueya"
						label="血压">
						<template slot-scope="scope">
							{{scope.row.xueya}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="xuetang"
						label="血糖">
						<template slot-scope="scope">
							{{scope.row.xuetang}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="xuezhi"
						label="血脂">
						<template slot-scope="scope">
							{{scope.row.xuezhi}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shili"
						label="视力">
						<template slot-scope="scope">
							{{scope.row.shili}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="shuimianzhiliang"
						label="睡眠质量">
						<template slot-scope="scope">
							{{scope.row.shuimianzhiliang}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='false'  
						prop="celiangriqi"
						label="测量日期">
						<template slot-scope="scope">
							{{scope.row.celiangriqi}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if=" isAuth('jiankangjilu','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								<span class="icon iconfont icon-chakan18" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
								详情
							</el-button>
							<el-button class="edit" v-if=" isAuth('jiankangjilu','修改') " type="success" @click="addOrUpdateHandler(scope.row.id)">
								<span class="icon iconfont icon-xiugai1" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
								编辑
							</el-button>




							<el-button class="del" v-if="isAuth('jiankangjilu','删除') " type="primary" @click="deleteHandler(scope.row.id )">
								<span class="icon iconfont icon-shanchu8" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
								DEL
							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 20, 30, 50]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="< "
				next-text="> "
				:hide-on-single-page="true"
				:style='{"padding":"0","margin":"20px 0 0","whiteSpace":"nowrap","color":"#333","textAlign":"center","width":"100%","fontWeight":"500"}'
			></el-pagination>
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>





		<el-dialog
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="celiangriqiChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>
	</div>
</template>

<script>
import * as echarts from 'echarts'
import chinaJson from "@/components/echarts/china.json";
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
	export default {
		data() {
			return {
				searchForm: {
					key: ""
				},
				form:{},
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				sfshVisiable: false,
				shForm: {},
				chartVisiable: false,
				chartVisiable1: false,
				chartVisiable2: false,
				chartVisiable3: false,
				chartVisiable4: false,
				chartVisiable5: false,
				addOrUpdateFlag:false,
				layouts: ["prev","pager","next","sizes"],
			};
		},
		created() {
			this.init();
			this.getDataList();
			this.contentStyleChange()
		},
		mounted() {
		},
		filters: {
			htmlfilter: function (val) {
				return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
			}
		},
		computed: {
			tablename(){
				return this.$storage.get('sessionTable')
			},
		},
		components: {
			AddOrUpdate,
		},
		methods: {

			contentStyleChange() {
				this.contentPageStyleChange()
			},
			// 分页
			contentPageStyleChange(){
				let arr = []

				// if(this.contents.pageTotal) arr.push('total')
				// if(this.contents.pageSizes) arr.push('sizes')
				// if(this.contents.pagePrevNext){
				//   arr.push('prev')
				//   if(this.contents.pagePager) arr.push('pager')
				//   arr.push('next')
				// }
				// if(this.contents.pageJumper) arr.push('jumper')
				// this.layouts = arr.join()
				// this.contents.pageEachNum = 10
			},


//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{
        var celiangriqiChart1 = echarts.init(document.getElementById("celiangriqiChart1"),'macarons');
        this.$http({
            url: `jiankangjilu/valueMul/celiangriqi?yColumnNameMul=tiwen,xinlv,xueya,xuetang,xuezhi`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis1 = [];
                let yAxis1 = [];
                let pArray1 = []
                for(let i=0;i<res[0].length;i++){
                    xAxis1.push(res[0][i].celiangriqi);
                    yAxis1.push(parseFloat((res[0][i].total)));
                    pArray1.push({
                        value: parseFloat((res[0][i].total)),
                        name: res[0][i].celiangriqi
                    })
                }
                let xAxis2 = [];
                let yAxis2 = [];
                let pArray2 = []
                for(let i=0;i<res[1].length;i++){
                    xAxis2.push(res[1][i].celiangriqi);
                    yAxis2.push(parseFloat((res[1][i].total)));
                    pArray2.push({
                        value: parseFloat((res[1][i].total)),
                        name: res[1][i].celiangriqi
                    })
                }
                let xAxis3 = [];
                let yAxis3 = [];
                let pArray3 = []
                for(let i=0;i<res[2].length;i++){
                    xAxis3.push(res[2][i].celiangriqi);
                    yAxis3.push(parseFloat((res[2][i].total)));
                    pArray3.push({
                        value: parseFloat((res[2][i].total)),
                        name: res[2][i].celiangriqi
                    })
                }
                let xAxis4 = [];
                let yAxis4 = [];
                let pArray4 = []
                for(let i=0;i<res[3].length;i++){
                    xAxis4.push(res[3][i].celiangriqi);
                    yAxis4.push(parseFloat((res[3][i].total)));
                    pArray4.push({
                        value: parseFloat((res[3][i].total)),
                        name: res[3][i].celiangriqi
                    })
                }
                let xAxis5 = [];
                let yAxis5 = [];
                let pArray5 = []
                for(let i=0;i<res[4].length;i++){
                    xAxis5.push(res[4][i].celiangriqi);
                    yAxis5.push(parseFloat((res[4][i].total)));
                    pArray5.push({
                        value: parseFloat((res[4][i].total)),
                        name: res[4][i].celiangriqi
                    })
                }
                var option = {};
                option = {
                    title: {
                        left: 'left'
                    },
                    legend: {
                        data: [
							'体温',
							'心率',
							'血压',
							'血糖',
							'血脂',
						]
                    },
                    tooltip: {
                      trigger: 'axis',
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis1
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [
                    {
                        data: yAxis1,
                        type: 'line',
                        name: '体温',
                    },
                    {
                        data: yAxis2,
                        type: 'line',
                        name: '心率',
                    },
                    {
                        data: yAxis3,
                        type: 'line',
                        name: '血压',
                    },
                    {
                        data: yAxis4,
                        type: 'line',
                        name: '血糖',
                    },
                    {
                        data: yAxis5,
                        type: 'line',
                        name: '血脂',
                    },
                    ]
                };
                // 使用刚指定的配置项和数据显示图表。
                celiangriqiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    celiangriqiChart1.resize();
                };
            }
        });
      })
    },




    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
    params['sort'] = 'celiangriqi';
    params['order'] = 'desc';
      this.$http({
        url: "jiankangjilu/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
			this.dataList = data.data.list;
			this.totalPage = data.data.total;
        } else {
			this.dataList = [];
			this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 下载
    download(file){
      let arr = file.replace(new RegExp('upload/', "g"), "")
      axios.get(this.$base.url + 'file/download?fileName=' + arr, {
      	headers: {
      		token: this.$storage.get('Token')
      	},
      	responseType: "blob"
      }).then(({
      	data
      }) => {
      	const binaryData = [];
      	binaryData.push(data);
      	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
      		type: 'application/pdf;chartset=UTF-8'
      	}))
      	const a = document.createElement('a')
      	a.href = objectUrl
      	a.download = arr
      	// a.click()
      	// 下面这个写法兼容火狐
      	a.dispatchEvent(new MouseEvent('click', {
      		bubbles: true,
      		cancelable: true,
      		view: window
      	}))
      	window.URL.revokeObjectURL(data)
      },err=>{
		  axios.get((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] :'') + this.$base.name + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: this.$storage.get('Token')
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  })
	  })
    },
	// 预览
	preClick(file){
		if(!file){
			return false
		}
		window.open((location.href.split(this.$base.name).length>1 ? location.href.split(this.$base.name)[0] :'') + this.$base.name + '/' + file)
	},
	jiankangjilustatusChange(e,row){
		if(row.status==0){
			row.passwordwrongnum = 0
		}
		this.$http({
			url:'jiankangjilu/update',
			method:'post',
			data:row
		}).then(res=>{
			if(row.status==1){
				this.$message.error('该用户已锁定')
			}else{
				this.$message.success('该用户已解除锁定')
			}
		})
	},
    // 删除
    deleteHandler(id ) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "jiankangjilu/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
			this.$message({
			  message: "操作成功",
			  type: "success",
			  duration: 1500,
			  onClose: () => {
			    this.search();
			  }
			});
            
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 2px dashed #C8C8C8;
				border-radius: 0;
				padding: 0 12px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #000;
				width: 170px;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 2px dashed #C8C8C8;
				border-radius: 0;
				padding: 0 10px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #000;
				width: 170px;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 2px dashed #C8C8C8;
				border-radius: 0;
				padding: 0 10px 0 30px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #000;
				width: 170px;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .search {
				border: 1px solid #0E9BD3;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 14px;
				outline: none;
				color: #0E9BD3;
				background: transparent;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .search:hover {
				opacity: 0.5;
			}
	
	.center-form-pv .actions .add {
				border: 1px solid #0E9BD3;
				cursor: pointer;
				border-radius: 0;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #0E9BD3;
				background: transparent;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .actions .add:hover {
				opacity: 0.5;
			}
	
	.center-form-pv .actions .del {
				border: 1px solid #0E9BD3;
				cursor: pointer;
				border-radius: 0;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #0E9BD3;
				background: transparent;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .actions .del:hover {
				opacity: 0.5;
			}
	
	.center-form-pv .actions .statis {
				border: 1px solid #0E9BD3;
				cursor: pointer;
				border-radius: 0;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #0E9BD3;
				background: transparent;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .actions .statis:hover {
				opacity: 0.5;
			}
	
	.center-form-pv .actions .btn18 {
				border: 1px solid #0E9BD3;
				cursor: pointer;
				border-radius: 0;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #0E9BD3;
				background: transparent;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.center-form-pv .actions .btn18:hover {
				opacity: 0.5;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #fff;
				background: rgba(14, 155, 211, .5);
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #999;
				background: #fff;
				border-color: #eee;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 0 10px 10px 0;
				outline: none;
				color: #fff;
				background: #0E9BD3;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view:hover {
				opacity: 0.5;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add:hover {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 0 10px 10px 0;
				outline: none;
				color: #fff;
				background: #0E9BD3;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit:hover {
				opacity: 0.5;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 0 10px 10px 0;
				outline: none;
				color: #fff;
				background: #0A0808;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del:hover {
				opacity: 0.5;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 0 10px 10px 0;
				outline: none;
				color: #fff;
				background: #0A0808;
				width: auto;
				font-size: 14px;
				height: 32px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8:hover {
				opacity: 0.5;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #409EFF;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #0E9BD3;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #FFF;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 2px;
				background: #0E9BD3;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	// list one
	.one .list1-view {
				border: 1px solid #0E9BD3;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 0;
				outline: none;
				color: #0E9BD3;
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.one .list1-view:hover {
				opacity: 0.5;
			}
	
	.one .list1-edit {
				border: 1px solid #0E9BD3;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 0;
				outline: none;
				color: #0E9BD3;
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.one .list1-edit:hover {
				opacity: 0.5;
			}
	
	.one .list1-del {
				border: 1px solid #0E9BD3;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 0;
				outline: none;
				color: #0E9BD3;
				background: #fff;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.one .list1-del:hover {
				opacity: 0.5;
			}
	
	.one .list1-btn8 {
				border: 0px solid #0E9BD3;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #0E9BD3;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.one .list1-btn8:hover {
				opacity: 0.5;
			}
	
	.main-content .el-table .el-switch {
				display: inline-flex;
				vertical-align: middle;
				line-height: 30px;
				position: relative;
				align-items: center;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--left {
				cursor: pointer;
				margin: 0 10px 0 0;
				color: #333;
				font-weight: 500;
				display: none;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--right {
				cursor: pointer;
				margin: 0 0 0 10px;
				color: #333;
				font-weight: 500;
				display: none;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core {
				border: 1px solid #0000ff;
				cursor: pointer;
				border-radius: 15px;
				margin: 0;
				outline: 0;
				background: #0000ff;
				display: inline-block;
				width: 60px;
				box-sizing: border-box;
				transition: border-color .3s,background-color .3s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core::after {
				border-radius: 100%;
				top: 1px;
				left: 1px;
				background: #FFF;
				width: 26px;
				position: absolute;
				transition: all .3s;
				height: 26px;
			}
	.main-content .el-table .el-switch.is-checked /deep/ .el-switch__core::after {
				margin: 0 0 0 -27px;
				left: 100%;
			}
	
	.main-content .el-table .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	.main-content .el-table .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				display: inline-block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
</style>
