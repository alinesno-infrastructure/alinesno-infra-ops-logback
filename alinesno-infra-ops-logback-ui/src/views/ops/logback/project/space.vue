<template>
  <div class="app-container">

     <el-page-header @back="goBack" content="告警事项"></el-page-header>
     <br/>

     <el-row :gutter="20">
        <!--类型数据-->
        <el-col :span="24" :xs="24">
           <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="100px">
              <el-form-item label="类型名称" prop="typeName">
                 <el-input v-model="queryParams.typeName" placeholder="请输入类型名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
              </el-form-item>
              <el-form-item label="类型名称" prop="channelDesc">
                 <el-input v-model="queryParams['condition[channelDesc|like]']" placeholder="请输入类型名称" clearable style="width: 240px" @keyup.enter="handleQuery" />
              </el-form-item>
              <el-form-item>
                 <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
                 <el-button icon="Refresh" @click="resetQuery">重置</el-button>
              </el-form-item>
           </el-form>

           <el-row :gutter="10" class="mb8">
              <el-col :span="1.5">
                  <el-button plain type="primary" icon="Plus" @click="handleAdd()" v-hasPermi="['system:dept:add']">新增</el-button>
                 <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate">修改</el-button>
              </el-col>
              <right-toolbar v-model:showSearch="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
           </el-row>

           <el-table v-loading="loading" :data="projectChannelList" @selection-change="handleSelectionChange">
              <el-table-column type="index" width="50" align="center" />
              <el-table-column label="图标" align="center" width="70" key="icon" v-if="columns[5].visible">
                 <template #default="scope">
                       <span style="font-size:25px;color:#3b5998">
                           <i v-if="scope.row.channelType == 'SpringBoot'" class="fa-solid fa-rocket" />
                           <i v-else-if="scope.row.channelType == 'Aliyun'" class="fa-brands fa-alipay" />
                           <i v-else-if="scope.row.channelType == 'Docker'" class="fa-brands fa-docker" />
                           <i v-else-if="scope.row.channelType == 'Kubernetes'" class="fa-brands fa-wordpress" />
                           <i v-else-if="scope.row.channelType == 'Jira'" class="fa-brands fa-envira" />
                           <i v-else-if="scope.row.channelType == 'Jenkins'" class="fa-brands fa-jenkins" />
                           <i v-else-if="scope.row.channelType == 'Prometheus'" class="fa-brands fa-product-hunt" />
                           <i v-else-if="scope.row.channelType == 'Server'" class="fa-solid fa-server" />
                           <i v-else-if="scope.row.channelType == 'JavaApplication'" class="fa-brands fa-java" />
                           <i v-else-if="scope.row.channelType == 'Tomcat'" class="fa-solid fa-truck-fast" />
                           <i v-else-if="scope.row.channelType == 'Zbox'" class="fa-solid fa-user-shield" />
                        </span>
                 </template>
              </el-table-column>

              <!-- 业务字段-->
              <el-table-column label="类型名称" align="left" width="250" key="channelName" prop="channelName" v-if="columns[0].visible">
                 <template #default="scope">
                     <div>
                        {{ scope.row.channelDesc}} &nbsp;
                     </div>
                     <div style="font-size: 13px;color: #a5a5a5;cursor: pointer;" v-copyText="scope.row.channelCode">
                        调用码: {{ scope.row.channelCode }} <el-icon><CopyDocument /></el-icon>
                     </div>
                 </template>
              </el-table-column>
              <!-- <el-table-column label="类型描述" align="left" key="channelDesc" prop="channelDesc" v-if="columns[0].visible" /> -->

              <el-table-column label="状态" align="center" key="hasStatus" prop="hasStatus" v-if="columns[1].visible" :show-overflow-tooltip="true" >
                 <template #default="scope">
                    <el-button v-if="scope.$index % 2 == 0" type="primary" bg text @click="handleConfigType(scope.row.id , scope.row.criticalCount)"> 
                        <i class="fa-solid fa-link"></i>&nbsp;正常
                    </el-button>
                    <el-button v-if="scope.$index % 2 == 1" type="danger" bg text @click="handleConfigType(scope.row.id , scope.row.criticalCount)"> 
                        <i class="fa-solid fa-link-slash"></i>&nbsp;异常
                    </el-button>
                 </template>
              </el-table-column>
              <el-table-column label="警告" align="center" key="warningCount" prop="warningCount" v-if="columns[1].visible" :show-overflow-tooltip="true" >
                 <template #default="scope">
                    <el-button type="warning" bg text @click="handleConfigType(scope.row.id , scope.row.warningCount)">
                        <i class="fa-solid fa-car-on"></i>&nbsp;{{ scope.row.warningCount }}
                    </el-button>
                 </template>
              </el-table-column>
              <el-table-column label="紧急" align="center" key="criticalCount" prop="criticalCount" v-if="columns[1].visible" :show-overflow-tooltip="true" >
                 <template #default="scope">
                    <el-button type="danger" bg text @click="handleConfigType(scope.row.id , scope.row.criticalCount)"> 
                        <i class="fa-solid fa-truck-medical"></i>&nbsp;{{ scope.row.criticalCount }}
                    </el-button>
                 </template>
              </el-table-column>
              <el-table-column label="告警数" align="center" key="alertCount" prop="alertCount" v-if="columns[2].visible" :show-overflow-tooltip="true">
                 <template #default="scope">
                    <el-button type="success" bg text @click="handleConfigType(scope.row.id , scope.row.criticalCount)"> 
                        <i class="fa-solid fa-bell"></i>&nbsp;{{ scope.row.alertCount }}
                    </el-button>
                 </template>
              </el-table-column>

              <!-- 操作字段  -->
              <el-table-column label="操作" align="center" width="230" class-name="small-padding fixed-width">
                 <template #default="scope">
                    <el-tooltip content="修改" placement="top" v-if="scope.row.id !== 1">
                       <el-button link type="primary" @click="handleUpdate(scope.row)" v-hasPermi="['system:ProjectChannel:edit']">
                           <i class="fa-solid fa-edit"></i>&nbsp;修改
                       </el-button>
                    </el-tooltip>
                    <el-tooltip content="配置" placement="top" v-if="scope.row.id !== 1">
                       <el-button link type="primary" @click="handleUpdate(scope.row)" v-hasPermi="['system:ProjectChannel:edit']">
                           <i class="fa-solid fa-feather"></i>&nbsp;抑制
                       </el-button>
                    </el-tooltip>
                    <el-tooltip content="删除" placement="top" v-if="scope.row.id !== 1">
                        <el-button link type="primary" @click="handleDelete(scope.row)" v-hasPermi="['system:Project:remove']">
                              <i class="fa-solid fa-trash-can"></i>&nbsp;删除
                        </el-button>
                    </el-tooltip>
                 </template>

              </el-table-column>
           </el-table>
           <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
        </el-col>
     </el-row>

     <!-- 添加或修改应用配置对话框 -->
     <el-dialog :title="title" v-model="open" width="900px" append-to-body>
        <el-form :model="form" :rules="rules" ref="databaseRef" label-width="100px">
           <el-row>
              <el-col :span="24">
                 <el-form-item label="类型名称" prop="channelType">
                    <el-select v-model="form.channelType" clearable placeholder="请选择类型名称" style="width: 400px">
                        <el-option
                           v-for="item in channelList"
                           :key="item.channelName"
                           :label="item.channelName+ '('+item.channelDesc+')'"
                           :value="item.channelName"
                        />
                     </el-select>
                 </el-form-item>
              </el-col>
           </el-row>
           <el-row>
              <el-col :span="24">
                 <el-form-item label="类型描述" prop="channelDesc">
                    <el-input v-model="form.channelDesc" placeholder="请输入类型描述" maxlength="256" />
                 </el-form-item>
              </el-col>
           </el-row>
        </el-form>
        <template #footer>
           <div class="dialog-footer">
              <el-button type="primary" @click="submitForm">确 定</el-button>
              <el-button @click="cancel">取 消</el-button>
           </div>
        </template>
     </el-dialog>

  </div>
</template>

<script setup name="ProjectChannel">

import {
  listProjectChannel,
  delProjectChannel,
  getProjectChannel,
  updateProjectChannel,
  addProjectChannel , 
  changStatusField 
} from "@/api/ops/logback/projectChannel";

import {
  listAllChannel,
} from "@/api/ops/logback/channel";

const router = useRouter();
const { proxy } = getCurrentInstance();

// 定义变量
const projectChannelList = ref([]);
const channelList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const postOptions = ref([]);
const roleOptions = ref([]);
const projectId = router.currentRoute.value.params.projectId;

// 列显隐信息
const columns = ref([
  { key: 0, label: `类型名称`, visible: true },
  { key: 1, label: `类型描述`, visible: true },
  { key: 2, label: `表数据量`, visible: true },
  { key: 3, label: `类型`, visible: true },
  { key: 4, label: `类型地址`, visible: true },
  { key: 5, label: `状态`, visible: true },
  { key: 6, label: `更新时间`, visible: true }
]);

const data = reactive({
  form: {},
  queryParams: {
     pageNum: 0,
     pageSize: 20,
     typeName: undefined,
     hasStatus: undefined
  },
  rules: {
     channelType: [{ required: true, message: "渠道类型不能为空", trigger: "blur" }] ,
     channelDesc: [{ required: true, message: "渠道描述不能为空", trigger: "blur" }],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询类型列表 */
function getList() {
  loading.value = true;
  listProjectChannel(proxy.addDateRange(queryParams.value, dateRange.value) , projectId).then(res => {
     loading.value = false;
     projectChannelList.value = res.rows;
     total.value = res.total;
  });
};

/** 列出所有渠道列表 */
function handleListAllChannel() {
  listAllChannel().then(res => {
     channelList.value = res.data ;
  });
};

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
function resetQuery() {
  dateRange.value = [];
  proxy.resetForm("queryRef");
  queryParams.value.deptId = undefined;
  proxy.$refs.deptTreeRef.setCurrentKey(null);
  handleQuery();
};
/** 删除按钮操作 */
function handleDelete(row) {
  const ProjectChannelIds = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除类型编号为"' + ProjectChannelIds + '"的数据项？').then(function () {
     return delProjectChannel(ProjectChannelIds);
  }).then(() => {
     getList();
     proxy.$modal.msgSuccess("删除成功");
  }).catch(() => { });
};

/** 选择条数  */
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 重置操作表单 */
function reset() {
  form.value = {
     id: undefined,
     deptId: undefined,
     ProjectChannelName: undefined,
     alertCount: undefined,
     password: undefined,
     phonenumber: undefined,
     status: "0",
     remark: undefined,
  };
  proxy.resetForm("databaseRef");
};
/** 取消按钮 */
function cancel() {
  open.value = false;
  reset();
};

/** 新增按钮操作 */
function handleAdd() {
  reset();
  handleListAllChannel();
  open.value = true;
  title.value = "添加类型";
};

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const id = row.id || ids.value;
  getProjectChannel(id).then(response => {
     form.value = response.data;
     open.value = true;
     title.value = "修改类型";
  });
};

/** 提交按钮 */
function submitForm() {
  proxy.$refs["databaseRef"].validate(valid => {
     if (valid) {
        if (form.value.id != undefined) {
           updateProjectChannel(form.value).then(response => {
              proxy.$modal.msgSuccess("修改成功");
              open.value = false;
              getList();
           });
        } else {
           addProjectChannel(form.value).then(response => {
              proxy.$modal.msgSuccess("新增成功");
              open.value = false;
              getList();
           });
        }
     }
  });
};

const handleChangStatusField = async(field , value , id) => {
   // 判断tags值 这样就不会进页面时调用了
     const res = await changStatusField({
        field: field,
        value: value?1:0,
        id: id
     }).catch(() => { })
     if (res && res.code == 200) {
        // 刷新表格
        getList()
     }
}

/** 返回上一页 */
function goBack() {
  router.back();
}

getList();

</script>
