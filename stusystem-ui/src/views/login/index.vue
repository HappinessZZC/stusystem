<template>
  <div class="login_container">
    <div class="login_box">
      <div class="login_title">
        <span class="title">数据管理平台</span>
        <el-form
          ref="loginFormRef"
          :model="loginForm"
          :rules="loginFormRules"
          label-width="0px"
        >
          <!-- 用户名 -->
          <el-form-item prop="username">
            <span class="svg-container" />
            <el-input v-model="loginForm.username" placeholder="请输入账号">
              <svg-icon
                slot="prefix"
                icon-class="user"
                class="el-input__icon input-icon"
              />
            </el-input>
          </el-form-item>
          <!-- 密码 -->
          <el-form-item prop="password">
            <el-input
              v-model="loginForm.password"
              prefix-icon="fa fa-lock"
              type="password"
              placeholder="请输入密码"
            >
              <svg-icon
                slot="prefix"
                icon-class="password"
                class="el-input__icon input-icon"
              />
            </el-input>
          </el-form-item>
          <!-- 按钮区域 -->
          <el-form-item class="btns">
            <el-button type="primary" :loading="loading" @click="login"
              >登录</el-button
            >
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      loading: false,
      loginForm: {
        username: '',
        password: ''
      },
      loginFormRules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 10, message: '长度为3到10位', trigger: 'blur' }
        ],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
      },
      redirect: undefined
    }
  },
  watch: {
    $route: {
      handler: function (route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  methods: {
    login () {
      // 表单验证
      this.$refs.loginFormRef.validate(async valid => {
        if (!valid) return
        // console.log(this.loginFormRef.username)
        this.loading = true
        this.$store.dispatch('user/login', this.loginForm).then(() => {
          this.$router.push({ path: this.redirect || '/' })
          // this.$router.push({ path: '/druid' })
          this.loading = false
        }).catch(() => {
          this.loading = false
        })

        // this.$message.success('登录成功')
        // window.sessionStorage.setItem('token', res.data.token)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.login_container {
  height: 100%;
  background-image: url("~@/assets/images/login.png");
  background-size: cover;
}
.login_box {
  width: 1103px;
  height: 613px;
  background-image: url("~@/assets/images/login-background.png");
  background-size: 100%;
  // border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  // background-color: #fff;
  transform: translate(-50%, -50%);
  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 4px;
  }
}
.login_title {
  text-align: center;
  width: 325px;
  height: 300px;
  position: relative;
  left: 665px;
  top: 116px;
}
.title {
  font-size: 25px;
  font-weight: 1000;
  color: #006cde;
  letter-spacing: 8px;
  margin-bottom: 20px;
}

.el-button {
  width: 100%;
}

.el-form {
  margin-top: 20px;
}
</style>
