<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row >
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="订单编号" prop="dingdanbianhao">
            <el-input v-model="ruleForm.dingdanbianhao" 
                placeholder="订单编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.dingdanbianhao" label="订单编号" prop="dingdanbianhao">
              <el-input v-model="ruleForm.dingdanbianhao" 
                placeholder="订单编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="菜单名称" prop="caidanmingcheng">
          <el-input v-model="ruleForm.caidanmingcheng" 
              placeholder="菜单名称" clearable  :readonly="ro.caidanmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="菜单名称" prop="caidanmingcheng">
              <el-input v-model="ruleForm.caidanmingcheng" 
                placeholder="菜单名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="价格" prop="jiage">
          <el-input v-model="ruleForm.jiage" 
              placeholder="价格" clearable  :readonly="ro.jiage"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="价格" prop="jiage">
              <el-input v-model="ruleForm.jiage" 
                placeholder="价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="数量" prop="shuliang">
          <el-input v-model="ruleForm.shuliang" 
              placeholder="数量" clearable  :readonly="ro.shuliang"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="数量" prop="shuliang">
              <el-input v-model="ruleForm.shuliang" 
                placeholder="数量" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="总金额" prop="zongjine">
            <el-input v-model="zongjine"
                placeholder="总金额" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.zongjine" label="总金额" prop="zongjine">
              <el-input v-model="ruleForm.zongjine" 
                placeholder="总金额" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable  :readonly="ro.yonghuming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming" 
              placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="姓名" prop="xingming">
              <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="手机号" prop="shoujihao">
          <el-input v-model="ruleForm.shoujihao" 
              placeholder="手机号" clearable  :readonly="ro.shoujihao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="手机号" prop="shoujihao">
              <el-input v-model="ruleForm.shoujihao" 
                placeholder="手机号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="酒店名称" prop="jiudianmingcheng">
          <el-input v-model="ruleForm.jiudianmingcheng" 
              placeholder="酒店名称" clearable  :readonly="ro.jiudianmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="酒店名称" prop="jiudianmingcheng">
              <el-input v-model="ruleForm.jiudianmingcheng" 
                placeholder="酒店名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="是否支付" prop="ispay">
          <el-input v-model="ruleForm.ispay" 
              placeholder="是否支付" clearable  :readonly="ro.ispay"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="是否支付" prop="ispay">
              <el-input v-model="ruleForm.ispay" 
                placeholder="是否支付" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
      <el-form-item class="btn">
        <el-button  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
	  addEditForm: {"btnSaveFontColor":"rgba(255, 255, 255, 1)","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"rgba(255, 255, 255, 0)","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"rgba(255, 255, 255, 0)","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"rgba(255, 255, 255, 0)","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"3px","inputLableColor":"rgba(0, 0, 0, 1)","addEditBoxColor":"rgba(202, 233, 236, 0)","dateIconFontSize":"14px","btnSaveBgColor":"rgba(36, 139, 146, 1)","uploadIconFontColor":"rgba(0, 0, 0, 1)","textareaBorderColor":"rgba(36, 139, 146, 1)","btnCancelBgColor":"rgba(36, 139, 146, 1)","selectLableColor":"rgba(0, 0, 0, 1)","btnSaveBorderStyle":"solid","dateBorderWidth":"3px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"rgba(0, 0, 0, 1)","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"rgba(255, 255, 255, 1)","dateBorderColor":"rgba(36, 139, 146, 1)","dateIconFontColor":"rgba(0, 0, 0, 1)","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"rgba(0, 0, 0, 1)","dateFontSize":"14px","inputBorderWidth":"3px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"rgba(0, 0, 0, 1)","uploadHeight":"148px","textareaLableColor":"rgba(0, 0, 0, 1)","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"rgba(255, 255, 255, 0)","inputLableFontSize":"14px","uploadLableColor":"rgba(0, 0, 0, 1)","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"rgba(255, 255, 255, 0)","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"rgba(36, 139, 146, 1)","inputBorderColor":"rgba(36, 139, 146, 1)","uploadBorderColor":"rgba(36, 139, 146, 1)","textareaFontColor":"rgba(0, 0, 0, 1)","selectBorderWidth":"3px","dateFontColor":"rgba(0, 0, 0, 1)","btnCancelBorderWidth":"0","uploadBorderWidth":"3px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"rgba(0, 0, 0, 1)","btnSaveBorderColor":"rgba(36, 139, 146, 1)","btnSaveBorderWidth":"0"},
      id: '',
      type: '',
      ro:{
	dingdanbianhao : false,
	caidanmingcheng : false,
	jiage : false,
	shuliang : false,
	zongjine : false,
	yonghuming : false,
	xingming : false,
	shoujihao : false,
	jiudianmingcheng : false,
	ispay : false,
      },
      ruleForm: {
        dingdanbianhao: this.getUUID(),
        caidanmingcheng: '',
        jiage: '',
        shuliang: '',
        zongjine: '',
        yonghuming: '',
        xingming: '',
        shoujihao: '',
        jiudianmingcheng: '',
        ispay: '',
      },
      rules: {
          dingdanbianhao: [
          ],
          caidanmingcheng: [
                { required: true, message: '菜单名称不能为空', trigger: 'blur' },
          ],
          jiage: [
                { required: true, message: '价格不能为空', trigger: 'blur' },
          ],
          shuliang: [
          ],
          zongjine: [
          ],
          yonghuming: [
          ],
          xingming: [
          ],
          shoujihao: [
          ],
          jiudianmingcheng: [
          ],
          ispay: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {
    zongjine:{
      get: function () {
        return 1*this.ruleForm.jiage*this.ruleForm.shuliang
      }
    },
  },
  created() {
	this.addEditStyleChange()
  },
  methods: {
    getUUID () {
      return new Date().getTime();
    },
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='dingdanbianhao'){
            this.ruleForm.dingdanbianhao = obj[o];
	    this.ro.dingdanbianhao = true;
            continue;
          }
          if(o=='caidanmingcheng'){
            this.ruleForm.caidanmingcheng = obj[o];
	    this.ro.caidanmingcheng = true;
            continue;
          }
          if(o=='jiage'){
            this.ruleForm.jiage = obj[o];
	    this.ro.jiage = true;
            continue;
          }
          if(o=='shuliang'){
            this.ruleForm.shuliang = obj[o];
	    this.ro.shuliang = true;
            continue;
          }
          if(o=='zongjine'){
            this.ruleForm.zongjine = obj[o];
	    this.ro.zongjine = true;
            continue;
          }
          if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
	    this.ro.yonghuming = true;
            continue;
          }
          if(o=='xingming'){
            this.ruleForm.xingming = obj[o];
	    this.ro.xingming = true;
            continue;
          }
          if(o=='shoujihao'){
            this.ruleForm.shoujihao = obj[o];
	    this.ro.shoujihao = true;
            continue;
          }
          if(o=='jiudianmingcheng'){
            this.ruleForm.jiudianmingcheng = obj[o];
	    this.ro.jiudianmingcheng = true;
            continue;
          }
          if(o=='ispay'){
            this.ruleForm.ispay = obj[o];
	    this.ro.ispay = true;
            continue;
          }
        }
        this.ruleForm.shuliang = 0
	    this.ro.shuliang = false;
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
		if(json.yonghuming!=''&&json.yonghuming){
                this.ruleForm.yonghuming = json.yonghuming
	    		this.ro.yonghuming = true;
		}
		if(json.xingming!=''&&json.xingming){
                this.ruleForm.xingming = json.xingming
	    		this.ro.xingming = true;
		}
		if(json.shoujihao!=''&&json.shoujihao){
                this.ruleForm.shoujihao = json.shoujihao
	    		this.ro.shoujihao = true;
		}
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    info(id) {
      this.$http({
        url: `dingcan/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
    onSubmit() {
        this.ruleForm.zongjine = this.zongjine

      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
		 this.$http({
		   url: `dingcan/${!this.ruleForm.id ? "save" : "update"}`,
		   method: "post",
		   data: this.ruleForm
		 }).then(({ data }) => {
		   if (data && data.code === 0) {
		     this.$message({
		       message: "操作成功",
		       type: "success",
		       duration: 1500,
		       onClose: () => {
			 this.parent.showFlag = true;
			 this.parent.addOrUpdateFlag = false;
			 this.parent.search();
			 this.parent.contentStyleChange();
		       }
		     });
		   } else {
		     this.$message.error(data.msg);
		   }
		 });
        }
      });
    },
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
  }
};
</script>
<style lang="scss">
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}
</style>
