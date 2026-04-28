<template>
  <div class="addEdit-block">
    <el-form class="detail-form-content" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="80px" :style="{backgroundColor:addEditForm.addEditBoxColor}">
      <el-row>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="菜品名称" prop="caipinmingcheng">
          <el-input v-model="ruleForm.caipinmingcheng" placeholder="菜品名称" clearable :readonly="ro.caipinmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="菜品名称" prop="caipinmingcheng">
            <el-input v-model="ruleForm.caipinmingcheng" placeholder="菜品名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="菜品图片" prop="caipintupian">
          <el-upload class="avatar-uploader" action="" :show-file-list="false" :before-upload="uploadBefore">
            <img v-if="ruleForm.caipintupian" :src="$base.url+ruleForm.caipintupian" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="菜品图片" prop="caipintupian">
            <img v-if="ruleForm.caipintupian" :src="$base.url+ruleForm.caipintupian" style="max-width:200px;max-height:150px;border-radius:4px;">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="餐类型" prop="canleixing">
          <el-select v-model="ruleForm.canleixing" placeholder="请选择餐类型">
            <el-option label="早餐" value="早餐"></el-option>
            <el-option label="午餐" value="午餐"></el-option>
            <el-option label="晚餐" value="晚餐"></el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="餐类型" prop="canleixing">
            <el-input v-model="ruleForm.canleixing" placeholder="餐类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="价格" prop="jiage">
          <el-input v-model="ruleForm.jiage" placeholder="价格" clearable :readonly="ro.jiage"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="价格" prop="jiage">
            <el-input v-model="ruleForm.jiage" placeholder="价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="份额" prop="fene">
          <el-select v-model="ruleForm.fene" placeholder="请选择份额">
            <el-option label="小份" value="小份"></el-option>
            <el-option label="中份" value="中份"></el-option>
            <el-option label="大份" value="大份"></el-option>
            <el-option label="标准份" value="标准份"></el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="份额" prop="fene">
            <el-input v-model="ruleForm.fene" placeholder="份额" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">
        <el-form-item class="input" v-if="type!='info'" label="菜品介绍" prop="caipinjieshao">
          <el-input type="textarea" v-model="ruleForm.caipinjieshao" placeholder="菜品介绍" :rows="4"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="菜品介绍" prop="caipinjieshao">
            <el-input type="textarea" v-model="ruleForm.caipinjieshao" placeholder="菜品介绍" readonly :rows="4"></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
      <el-form-item class="btn">
        <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
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
      addEditForm: {"btnSaveFontColor":"rgba(255, 255, 255, 1)","inputFontSize":"14px","inputBorderRadius":"4px","btnSaveFontSize":"14px","btnCancelWidth":"88px","btnSaveBorderRadius":"4px","inputLableColor":"rgba(0, 0, 0, 1)","addEditBoxColor":"rgba(202, 233, 236, 0)","btnSaveBgColor":"rgba(36, 139, 146, 1)","btnCancelBgColor":"rgba(36, 139, 146, 1)","btnSaveBorderStyle":"solid","btnCancelBorderStyle":"solid","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"rgba(255, 255, 255, 1)","inputFontColor":"rgba(0, 0, 0, 1)","btnCancelFontSize":"14px","inputBorderStyle":"solid","inputBgColor":"rgba(255, 255, 255, 0)","inputLableFontSize":"14px","btnSaveHeight":"44px","btnSaveWidth":"88px","inputBorderWidth":"3px","inputBorderColor":"rgba(36, 139, 146, 1)","btnCancelBorderWidth":"0","btnCancelBorderRadius":"4px","btnSaveBorderColor":"rgba(36, 139, 146, 1)","btnSaveBorderWidth":"0"},
      id: '',
      type: '',
      ro: {
        caipinmingcheng: false, caipintupian: false, canleixing: false,
        jiage: false, fene: false, caipinjieshao: false,
      },
      ruleForm: {
        caipinmingcheng: '', caipintupian: '', canleixing: '',
        jiage: '', fene: '', caipinjieshao: '',
      },
      rules: {
        caipinmingcheng: [{ required: true, message: '菜品名称不能为空', trigger: 'blur' }],
        canleixing: [{ required: true, message: '请选择餐类型', trigger: 'change' }],
        jiage: [{ required: true, message: '价格不能为空', trigger: 'blur' }],
        fene: [{ required: true, message: '请选择份额', trigger: 'change' }],
      }
    };
  },
  props: ["parent"],
  created() { this.addEditStyleChange(); },
  methods: {
    init(id, type) {
      if (id) { this.id = id; this.type = type; }
      if (this.type == 'info' || this.type == 'else') { this.info(id); }
      else if (this.type == 'cross') {
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj) {
          if (o == 'caipinmingcheng') { this.ruleForm.caipinmingcheng = obj[o]; this.ro.caipinmingcheng = true; }
          if (o == 'caipintupian') { this.ruleForm.caipintupian = obj[o]; this.ro.caipintupian = true; }
          if (o == 'canleixing') { this.ruleForm.canleixing = obj[o]; this.ro.canleixing = true; }
          if (o == 'jiage') { this.ruleForm.jiage = obj[o]; this.ro.jiage = true; }
          if (o == 'fene') { this.ruleForm.fene = obj[o]; this.ro.fene = true; }
          if (o == 'caipinjieshao') { this.ruleForm.caipinjieshao = obj[o]; this.ro.caipinjieshao = true; }
        }
      }
    },
    info(id) {
      this.$http({ url: `caipinxinxi/info/${id}`, method: "get" }).then(({ data }) => {
        if (data && data.code === 0) { this.ruleForm = data.data; }
        else { this.$message.error(data.msg); }
      });
    },
    uploadBefore(file) {
      let formData = new FormData();
      formData.append('file', file);
      this.$http({ url: 'file/upload', method: 'post', data: formData }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm.caipintupian = 'upload/' + data.file;
          this.$forceUpdate();
        } else { this.$message.error(data.msg); }
      });
      return false;
    },
    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({ url: `caipinxinxi/${!this.ruleForm.id ? "save" : "update"}`, method: "post", data: this.ruleForm }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({ message: "操作成功", type: "success", duration: 1500, onClose: () => {
                this.parent.showFlag = true; this.parent.addOrUpdateFlag = false; this.parent.search(); this.parent.contentStyleChange();
              }});
            } else { this.$message.error(data.msg); }
          });
        }
      });
    },
    back() { this.parent.showFlag = true; this.parent.addOrUpdateFlag = false; this.parent.contentStyleChange(); },
    addEditStyleChange() {
      this.$nextTick(()=>{
        document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
          el.style.height=this.addEditForm.inputHeight; el.style.color=this.addEditForm.inputFontColor; el.style.fontSize=this.addEditForm.inputFontSize
          el.style.borderWidth=this.addEditForm.inputBorderWidth; el.style.borderStyle=this.addEditForm.inputBorderStyle; el.style.borderColor=this.addEditForm.inputBorderColor
          el.style.borderRadius=this.addEditForm.inputBorderRadius; el.style.backgroundColor=this.addEditForm.inputBgColor
        })
        document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
          el.style.lineHeight=this.addEditForm.inputHeight; el.style.color=this.addEditForm.inputLableColor; el.style.fontSize=this.addEditForm.inputLableFontSize
        })
        document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
          el.style.width=this.addEditForm.btnSaveWidth; el.style.height=this.addEditForm.btnSaveHeight; el.style.color=this.addEditForm.btnSaveFontColor
          el.style.fontSize=this.addEditForm.btnSaveFontSize; el.style.borderRadius=this.addEditForm.btnSaveBorderRadius; el.style.backgroundColor=this.addEditForm.btnSaveBgColor
        })
        document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
          el.style.width=this.addEditForm.btnCancelWidth; el.style.height=this.addEditForm.btnCancelHeight; el.style.color=this.addEditForm.btnCancelFontColor
          el.style.fontSize=this.addEditForm.btnCancelFontSize; el.style.borderRadius=this.addEditForm.btnCancelBorderRadius; el.style.backgroundColor=this.addEditForm.btnCancelBgColor
        })
      })
    },
  }
};
</script>
<style lang="scss">
.addEdit-block { margin: -10px; }
.detail-form-content { padding: 12px; background-color: transparent; }
.btn .el-button { padding: 0; }
.avatar-uploader .el-upload { border: 1px dashed #d9d9d9; border-radius: 6px; cursor: pointer; position: relative; overflow: hidden; }
.avatar-uploader .el-upload:hover { border-color: #409EFF; }
.avatar-uploader-icon { font-size: 28px; color: #8c939d; width: 120px; height: 120px; line-height: 120px; text-align: center; }
.avatar { width: 120px; height: 120px; display: block; object-fit: cover; }
</style>
