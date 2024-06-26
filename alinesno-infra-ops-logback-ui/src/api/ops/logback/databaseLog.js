import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";


// 接口配置项
var prefix = '/api/infra/ops/logback/databaseLog/' ;
var managerUrl = {
  datatables : prefix +"datatables" ,
  createUrl: prefix + 'add' ,
  saveUrl: prefix + 'save' ,
  updateUrl: prefix +"modify" ,
  statusUrl: prefix +"changeStatus" ,
  cleanUrl: prefix + "clean",
  detailUrl: prefix +"detail",
  removeUrl: prefix + "delete" ,
  exportUrl: prefix + "exportExcel",
  changeField: prefix + "changeField",
  downloadfile: prefix + "downloadfile"
}

// 查询应用列表
export function listDatabaseLog(query) {
  return request({
    url: managerUrl.datatables ,
    method: 'post',
    params: query
  })
}

// 查询应用详细
export function getDatabaseLog(id) {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增应用
export function addDatabaseLog(data) {
  return request({
    url: managerUrl.saveUrl ,
    method: 'post',
    data: data
  })
}

// 修改应用
export function updateDatabaseLog(data) {
  return request({
    url: managerUrl.updateUrl ,
    method: 'put',
    data: data
  })
}

// 删除应用
export function delDatabaseLog(id) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  })
}

// 应用密码重置
export function resetDatabaseLogPwd(id, password) {
  const data = {
    id,
    password
  }
  return request({
    url: '/api/infra/base/starter/application/resetPwd',
    method: 'put',
    data: data
  })
}

// 应用状态修改
export function changeDatabaseLogStatus(id, status) {
  const data = {
    id,
    status
  }
  return request({
    url: '/api/infra/base/starter/application/changeStatus',
    method: 'put',
    data: data
  })
}

// 查询部门下拉树结构
export function deptTreeSelect() {
  return request({
    url: '/api/infra/base/starter/application/deptTree',
    method: 'get'
  })
}