<template>
  <div>
    
    <el-row class="acp-dashboard-panel" :gutter="20">

      <el-col class="panel-col" :span="19">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 日志集成套件</div>
          </div>
          <div class="panel-body acp-height-auto" style="padding: 5px">
            <div class="acp-app-list">
              <ul>
                <li class="app-items" v-for="item in apps" :key="item" 
                  style="width:calc(25% - 10px);
                         height:80px;
                         border:1px solid #ebebeb;
                         margin:5px;
                         padding: 10px;
                         border-radius: 3px;">
                  <div class="app-icon">
                    <i :class="item.icon" style="font-size: 20px;color: #3b5998;" :alt="item.name" />
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.name }}</div>
                    <div class="app-item desc">{{ item.desc }}</div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>

      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-user-nurse"></i> 日志资产统计</div>
          </div>
          <div class="panel-body acp-height-auto">
            <ul class="panel-item-text">
              <li style="width:50%;padding:4px;border-bottom: 0px;" v-for="item in opertionAssets" :key="item.id">
                <div class="item-health-box">
                  <div class="item-health-title">{{ item.title }}</div>
                  <div class="item-health-count">{{ item.count }}</div>
                </div>
              </li>
            </ul>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>

    </el-row>
  </div>
</template>

<script setup>

const opertionAssets = ref([
  {id:'1' , title:'接入应用' , count:15} ,
  {id:'2' , title:'日志总量' , count:7649145} ,
  {id:'3' , title:'异常分析' , count:65} ,
  {id:'5' , title:'日志存储' , count:'445G'} ,
  {id:'6' , title:'巡检任务' , count:145} ,
])

const apps = ref([
  {icon:'fa-brands fa-slack'  , name:'分布式链路跟踪' , desc:'基于OpenTelemetry标准构建的Trace服务'},
  {icon:'fa-solid fa-list-check' , name:'智能异常分析' , desc:'智能时序异常发现、文本异常模式挖掘、自定义根因分析诊断平台'},
  {icon:'fa-solid fa-at' , name:'容器云管理服务' , desc:'网络请求日志分析，提供详细的请求情况和流量监控等'},
  {icon:'fa-solid fa-eye-slash' , name:'智能异常分析' , desc:'提供IT系统监控、K8s监控、中间件监控、融合分析、智能告警'},
  {icon:'fa-solid fa-user-shield' , name:'审计日志服务' , desc:'覆盖Web应用、监控页面访问速度、JS错误、资源监控、端到端链路'},
  {icon:'fa-solid fa-comment-slash' , name:'自动化操作日志' , desc:'提供IT系统监控、K8s监控、中间件监控、融合分析'},
  {icon:'fa-brands fa-slack' , name:'容器云管理服务' , desc:'网络请求日志分析，提供详细的请求情况和流量监控等'},
]);

</script>

<style lang="scss" scoped>
.item-health-title{
  margin-bottom: 5px !important;
}
.item-health-count{
  margin-bottom: 5px;
}
</style>