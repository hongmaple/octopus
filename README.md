# octopus

#### 提供部署，定制服务，有需要的加v mapleCx331

#### 介绍
octopus高校教学综合平台，主要用于对教师，学生，管理的信息管理，课程管理，专业信息管理，班级管理，可以添加题库，可以上传下载教学资料，可以设置考试试卷，可以进行在线考试和自动评分

#### 软件架构
1、系统环境

单体项目

Java EE 8

Servlet 3.0

Apache Maven 3

2、主框架

Spring Boot 2.2.x

Spring Framework 5.2.x

Apache Shiro 1.7 3、持久层

Apache MyBatis 3.5.x

Hibernate Validation 6.0.x

Alibaba Druid 1.2.x

4、视图层

Bootstrap 3.3.7

Thymeleaf 3.0.x

#内置功能

用户管理：用户是系统操作者，该功能主要完成系统用户配置。

部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。

岗位管理：配置系统用户所属担任职务。

菜单管理：配置系统菜单，操作权限，按钮权限标识等。

角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。

字典管理：对系统中经常使用的一些较为固定的数据进行维护。

参数管理：对系统动态配置常用参数。

通知公告：系统通知公告信息发布维护。

操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。

登录日志：系统登录日志记录查询包含登录异常。

在线用户：当前系统中活跃用户状态监控。

定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。

代码生成：前后端代码的生成（java、html、xml、sql)支持CRUD下载 。

系统接口：根据业务代码自动生成相关的api接口文档。

服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。

缓存监控：对系统的缓存查询，查看、清理等操作。

在线构建器：拖动表单元素生成相应的HTML代码。

连接池监视：监视当期系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

教务管理：学生，教师信息处理，班级，课程，专业，教室，题库，考试等功能

#用户类型

管理员，教师，学生


#### 安装教程

下载后用iade打开HtxkEmsm，引入依赖

导入sql HtxkEmsm/sql 创建数据库 数据库名为mapleemsmplus

在application-druid.yml配置数据库连接

在application配置

ruoyi:
  # 名称
  name: RuoYi
  # 版本
  version: 4.1.0
  # 版权年份
  copyrightYear: 2019
  # 实例演示开关
  demoEnabled: false
  # 文件路径 示例（ Windows配置D:/HtxkEmsm/uploadPath，Linux配置 /home/HtxkEmsm/uploadPath）
  profile: E:/GitWarehouse/octopus/files/HtxkEmsm/uploadPath
  # 获取ip地址开关
  addressEnabled: true
4.在logback.xml中配置

  <!-- 日志存放路径 -->
    <property name="log.path" value="/home/HtxkEmsm/logs"/>
5.启动MapleApplication

6.启动成功后访问localhost:8888 管理员admin/admin123

## 联系我，提供部署定制服务
wx: mapleCx331   qq群：[![加入QQ群](https://img.shields.io/badge/628043364-blue.svg)](https://qm.qq.com/q/RuCfOyaOUm) 

## 开源不易，谢谢打赏
<table>
 <td>
   <tr><img src="/image/wxPay.jpg" alt=""/></tr>
   <tr><img src="/image/zfb.jpg" alt=""/></tr>
 </td>
</table>

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

