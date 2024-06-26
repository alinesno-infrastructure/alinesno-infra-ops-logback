<template>
  <div class="app-container">
    <el-row :gutter="20">
       <!--应用数据-->
      <el-col :span="24" :xs="24">
        <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">

          <el-form-item label="应用名称" prop="applicationName">
            <el-input v-model="queryParams['condition[applicationName|like]']" placeholder="请输入应用名称" clearable
                      style="width: 240px" @keyup.enter="handleQuery"/>
          </el-form-item>
          <el-form-item label="显示名称" prop="showName" label-width="100px">
            <el-input v-model="queryParams['condition[showName|like]']" placeholder="请输入显示名称" clearable
                      style="width: 240px" @keyup.enter="handleQuery"/>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
            <el-button icon="Refresh" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
                type="primary"
                plain
                icon="Plus"
                @click="handleAdd"
            >新增
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
                type="success"
                plain
                icon="Edit"
                :disabled="single"
                @click="handleUpdate"
                v-hasPermi="['system:DatabaseSqlStat:edit']"
            >修改
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
                type="danger"
                plain
                icon="Delete"
                :disabled="multiple"
                @click="handleDelete"
                v-hasPermi="['system:DatabaseSqlStat:remove']"
            >删除
            </el-button>
          </el-col>

          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList" :columns="columns"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="DatabaseSqlStatList" @selection-change="handleSelectionChange">
          <el-table-column type="index" label="序号" width="50" align="center"/>
          <!-- 
          <el-table-column label="图标" align="center" width="55px" prop="icon" v-if="columns[0].visible">
          </el-table-column> 
          -->
          <el-table-column label="SQL" align="left" key="executeSql" prop="executeSql" v-if="columns[1].visible">
            <template #default="scope">

              <el-popover placement="right" :width="350" trigger="hover">
                <template #reference>
                      <div class="executeSql">
                        {{ scope.row.executeSql }}
                      </div>
                </template>
                <div class="expressInfo">
                  <el-descriptions title="详细信息" :column="1">
                    <el-descriptions-item label="执行SQL">
                      <div v-html="scope.row.executeSql">
                      </div>
                    </el-descriptions-item>
                  </el-descriptions>
                </div>
              </el-popover>

            </template>
          </el-table-column>
          <el-table-column label="执行数" align="center" width="70" key="executeCount" prop="executeCount" v-if="columns[2].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="运行周期" align="center" width="80" key="executeMillisTotal" prop="executeMillisTotal" v-if="columns[3].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="最慢" align="center" width="80" key="executeMillisMax" prop="executeMillisMax" v-if="columns[4].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="事务执行" align="center" width="80" key="inTransactionCount" prop="inTransactionCount" v-if="columns[5].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="错误数" align="center" width="80" key="executeErrorCount" prop="executeErrorCount" v-if="columns[6].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="更新行数" align="center" width="80" key="updateCount" prop="updateCount" v-if="columns[6].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="读取行数" align="center" width="80" key="fetchRowCountMax" prop="fetchRowCountMax" v-if="columns[6].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="最大并发" align="center" width="80" key="concurrentMax" prop="concurrentMax" v-if="columns[6].visible" :show-overflow-tooltip="true"/>
          <el-table-column label="执行时间" align="center" prop="addTime" v-if="columns[7].visible" width="160">
            <template #default="scope">
              <span>{{ parseTime(scope.row.addTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" align="center" width="80" class-name="small-padding fixed-width" v-if="columns[8].visible">
            <template #default="scope">
              <el-tooltip content="修改" placement="top" v-if="scope.row.applicationId !== 1">
                <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)"
                           v-hasPermi="['system:DatabaseSqlStat:edit']"></el-button>
              </el-tooltip>
              <el-tooltip content="删除" placement="top" v-if="scope.row.applicationId !== 1">
                <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)"
                           v-hasPermi="['system:DatabaseSqlStat:remove']"></el-button>
              </el-tooltip>

            </template>
          </el-table-column>
        </el-table>
        <pagination
            v-show="total > 0"
            :total="total"
            v-model:page="queryParams.pageNum"
            v-model:limit="queryParams.pageSize"
            @pagination="getList"
        />
      </el-col>
    </el-row>

    <!-- 添加或修改应用配置对话框 -->
    <el-dialog :title="title" v-model="open" width="900px" append-to-body>
      <el-form :model="form" :rules="rules" ref="DatabaseSqlStatRef" label-width="80px">
        <el-row>
          <el-col :span="24">
            <el-form-item  label="SQL" prop="applicationName">
              <el-input v-model="form.applicationName" placeholder="请输入应用名称" maxlength="50"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="执行数" prop="showName">
              <el-input v-model="form.showName" placeholder="请输入显示名称" maxlength="50"/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="24">
            <el-form-item label="域名" prop="domainName">
              <el-input v-model="form.domainName" placeholder="请输入域名" maxlength="100"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="所属领域" prop="domain">
              <el-input v-model="form.domain" placeholder="请输入所属领域" maxlength="100"/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="24">
            <el-form-item label="安全存储路径" prop="storagePath" label-width="107px">
              <el-input v-model="form.storagePath" placeholder="请输入安全存储路径" maxlength="200"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="应用目标" prop="target">
              <el-input v-model="form.target" placeholder="请输入应用目标" maxlength="20"/>
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

    <!-- 应用导入对话框 -->
    <el-dialog :title="upload.title" v-model="upload.open" width="400px" append-to-body>
      <el-upload
          ref="uploadRef"
          :limit="1"
          accept=".xlsx, .xls"
          :headers="upload.headers"
          :action="upload.url + '?updateSupport=' + upload.updateSupport"
          :disabled="upload.isUploading"
          :on-progress="handleFileUploadProgress"
          :on-success="handleFileSuccess"
          :auto-upload="false"
          drag
      >
        <el-icon class="el-icon--upload">
          <upload-filled/>
        </el-icon>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <template #tip>
          <div class="el-upload__tip text-center">
            <div class="el-upload__tip">
              <el-checkbox v-model="upload.updateSupport"/>
              是否更新已经存在的应用数据
            </div>
            <span>仅允许导入xls、xlsx格式文件。</span>
            <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;"
                     @click="importTemplate">下载模板
            </el-link>
          </div>
        </template>
      </el-upload>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitFileForm">确 定</el-button>
          <el-button @click="upload.open = false">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="DatabaseSqlStat">
import {getToken} from "@/utils/auth";
import {
  listDatabaseSqlStat,
  delDatabaseSqlStat,
  getDatabaseSqlStat,
  updateDatabaseSqlStat,
  addDatabaseSqlStat,
} from "@/api/ops/logback/databaseSqlStat";
import {reactive} from "vue";

const router = useRouter();
const {proxy} = getCurrentInstance();
// const { sys_normal_disable, sys_DatabaseSqlStat_sex } = proxy.useDict("sys_normal_disable", "sys_DatabaseSqlStat_sex");

const DatabaseSqlStatList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");
const dateRange = ref([]);
const deptName = ref("");
const deptOptions = ref(undefined);
const initPassword = ref(undefined);
const postOptions = ref([]);
const roleOptions = ref([]);
/*** 应用导入参数 */
const upload = reactive({
  // 是否显示弹出层（应用导入）
  open: false,
  // 弹出层标题（应用导入）
  title: "",
  // 是否禁用上传
  isUploading: false,
  // 是否更新已经存在的应用数据
  updateSupport: 0,
  // 设置上传的请求头部
  headers: {Authorization: "Bearer " + getToken()},
  // 上传的地址
  url: import.meta.env.VITE_APP_BASE_API + "/system/DatabaseSqlStat/importData"
});
// 列显隐信息
const columns = ref([
  {key: 0, label: `图标`, visible: true},
  {key: 1, label: `应用名称`, visible: true},
  {key: 2, label: `显示名称`, visible: true},
  {key: 3, label: `所属领域`, visible: true},
  {key: 4, label: `域名`, visible: true},
  {key: 5, label: `安全存储路径`, visible: true},
  {key: 6, label: `应用目标`, visible: true},
  {key: 7, label: `创建时间`, visible: true},
  {key: 8, label: `编辑`, visible: true},

]);

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 20,
    DatabaseSqlStatName: undefined,
    applicationName: undefined,
    showName: undefined,
    status: undefined,
    deptId: undefined
  },
  rules: {
    applicationId: [{required: true, message: "应用编号不能为空", trigger: "blur"}],
    applicationName: [{required: true, message: "应用名称不能为空", trigger: "blur"}, {
      min: 2,
      max: 20,
      message: "应用名称长度必须介于 2 和 20 之间",
      trigger: "blur"
    }],
    showName: [{required: true, message: "显示名称不能为空", trigger: "blur"}],
    domain: [{required: true, message: "所属领域不能为空", trigger: "blur"}],
    domainName: [{required: true, message: "域名不能为空", trigger: "blur"}],
    storagePath: [{required: true, message: "安全存储路径不能为空", trigger: "blur"}],
    target: [{required: true, message: "应用目标不能为空", trigger: "blur"}],
  }
});

const {queryParams, form, rules} = toRefs(data);


/** 查询应用列表 */
function getList() {
  loading.value = true;
  listDatabaseSqlStat(proxy.addDateRange(queryParams.value, dateRange.value)).then(res => {
    loading.value = false;
    DatabaseSqlStatList.value = res.rows;
    total.value = res.total;
  });
};


/** 搜索按钮操作 */
function handleQuery() {
  console.log(queryParams);
  queryParams.value.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
function resetQuery() {
  dateRange.value = [];
  proxy.resetForm("queryRef");
  queryParams.value.applicationName = undefined;
  queryParams.value.showName = undefined;
  proxy.$refs.deptTreeRef.setCurrentKey(null);
  handleQuery();
};

/** 删除按钮操作 */
function handleDelete(row) {
  const applicationIds = row.id || ids.value;

  proxy.$modal.confirm('是否确认删除应用编号为"' + applicationIds + '"的数据项？').then(function () {
    return delDatabaseSqlStat(applicationIds);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {
  });
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
    applicationId: undefined,
    applicationName: undefined,
    showName: undefined,
    domain: undefined,
    domainName: undefined,
    storagePath: undefined,
    target: undefined,
  };
  proxy.resetForm("DatabaseSqlStatRef");
};

/** 取消按钮 */
function cancel() {
  open.value = false;
  reset();
};

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加应用";
};

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const applicationId = row.id || ids.value;
  getDatabaseSqlStat(applicationId).then(response => {
    form.value = response.data;
    form.value.applicationId = applicationId;
    open.value = true;
    title.value = "修改应用";

  });
};

/** 提交按钮 */
function submitForm() {
  proxy.$refs["DatabaseSqlStatRef"].validate(valid => {
    if (valid) {
      if (form.value.applicationId != undefined) {
        updateDatabaseSqlStat(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addDatabaseSqlStat(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
};

getList();
</script>

<style lang="scss" scoped>

.executeSql{
  width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  cursor: pointer;
}
</style>