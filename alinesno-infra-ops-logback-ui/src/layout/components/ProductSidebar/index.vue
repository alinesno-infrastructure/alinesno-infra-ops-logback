<template>
  <div class="siderbar">
    <el-menu default-active="1" class="el-menu-vertical" :collapse="isCollapse" @open="handleOpen" @close="handleClose">
      <el-menu-item index="1" @click="jumpTo">
        <i class="fa-solid fa-desktop"></i>
      </el-menu-item>

      <el-tooltip effect="dark" :content="item.desc" v-for="item in menuItems" :key="item.id" placement="right">
          <el-menu-item :index="item.id" @click="openServiceList(item.link)">
            <i :class="item.icon"></i>
          </el-menu-item>
      </el-tooltip>

    </el-menu>

  </div>
</template>

<script setup>

const dialogVisible = ref(false)
const router = useRouter();

// 菜单列表
const menuItems = ref([
  {id:'9' , icon:'fa-solid fa-feather' , link:'/ops/logback/project/index' , desc:'项目管理'},
  {id:'2' , icon:'fa-solid fa-truck-plane' , link:'/ops/logback/businessLog/index' , desc:'日志分析'},
  {id:'3' , icon:'fa-solid fa-box' , link:'/ops/logback/containerLog/index' , desc:'容器日志分析'},
  {id:'4' , icon:'fa-solid fa-server' , link:'/ops/logback/frontLog/index' , desc:'前端监控'},
  {id:'5' , icon:'fa-solid fa-plane-departure' , link:'/ops/logback/nginx/index' , desc:'Nginx日志分析'},
  {id:'7' , icon:'fa-solid fa-house-tsunami' , link:'/ops/logback/inspection/index' , desc:'巡检日志'},
  {id:'8' , icon:'fa-solid fa-swatchbook' , link:'/ops/logback/account/index' , desc:'账户日志'},
]);

// 打开服务市场
function openServiceList(_path) {
  router.push({ path: _path });
}

// 打开客户配置
function jumpToConstomTheme() {
  router.push({ path: "/dashboard/dashboardTheme" });
}

// 打开首页
function jumpTo() {
  router.push({ path: "/index" });
}

// 打开智能客服
function openSmartService() {
  router.push({ path: "/dashboard/smartService" });
}

</script>

<style lang="scss" scoped>
.el-menu-vertical:not(.el-menu--collapse) {
  width: 65px;
}

.acp-suggest {
  bottom: 20px;
  position: absolute;
}

.siderbar {
  float: left;
  height: 100%;
  width: 64px;
  border-right: 1px solid #e6e6e6;
  padding-top: 40px;
  overflow: hidden;
  background-color: #fff;
  position: fixed;
}
</style>