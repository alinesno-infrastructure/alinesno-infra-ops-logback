<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="19">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 日志服务使用文档</div>
          </div>
          <div class="panel-body" style="height: auto;position: relative;">
              <div class="direct-box">
                <ul>
                  <li class="box-item" v-for="item in directContent" :key="item">
                    <div class="dire-panel">
                      <div class="panel-title">
                        <i class="dire-panel-icon" :class="item.icon" :alt="item.name" />
                        {{ item.name }} 
                      </div>
                      <div class="panel-describe">{{ item.desc }}</div>
                    </div>
                  </li>
                </ul>
              </div>
          </div>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-link"></i> 构建解决方案</div>
          </div>
          <div class="panel-body" style="height: auto;position: relative;">
            <div class="acp-app-list">
              <ul>
                <li class="app-items" style="width:100%" v-for="item in apps" :key="item">
                  <div class="app-info">
                    <div class="app-item-title">
                      <i :class="item.icon" :alt="item.name" /> 
                      {{ item.name }} 
                    </div>
                    <div class="app-item desc">{{ item.desc }}</div>
                  </div>
                </li>
              </ul>
            </div>
          </div>

        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script setup>

const directContent = ref([
  { icon: 'fa-solid fa-shield-alt', name: 'SpringBoot应用集成', desc: '用于将日志和信息从SpringBoot应用程序集成到系统中，以便进行监控和分析。' },
  { icon: 'fa-solid fa-chart-line', name: '前端操作日志接入 ', desc: '允许将前端操作记录和日志接入系统中，以便追踪用户行为和系统操作。' },
  { icon: 'fa-solid fa-clipboard-list', name: 'Nginx日志请求集成', desc: '实现将Nginx服务器生成的日志和请求数据整合到日志管理系统中进行分析。' },
  { icon: 'fa-solid fa-chart-bar',name: '正则文本日志集成', desc: '支持通过正则表达式将文本日志格式集成到系统中，便于统一管理和分析。' },
  { icon: 'fa-solid fa-cogs',  name: '业务巡检日志集成', desc: '将业务巡检中收集到的日志信息整合到日志系统中，以便进行全面的审计和分析。' },
  { icon: 'fa-solid fa-users-cog', name: '数据库操作记录接入', desc: '捕获数据库操作记录并将其纳入系统日志中，便于追踪和审计数据库活动。' },
  { icon: 'fa-brands fa-docker', name: 'Kubernetes日志集成', desc: '整合来自Kubernetes平台的日志数据，以便进行系统运行和健康状态的监控。' },
]);

const apps = ref([
  { icon: 'fa-solid fa-building', name: '网站搭建', desc: '快速解决网站日志方案' },
  { icon: 'fa-solid fa-cogs', name: '环境部署', desc: '快速解决开发环境日志方案' },
  { icon: 'fa-solid fa-users-cog', name: '云博客搭建', desc: '快速解决博客日志方案' },
  { icon: 'fa-solid fa-pen-nib', name: '高可用架构', desc: '快速解决高可用架构日志方案' },
]);

</script>