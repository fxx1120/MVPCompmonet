# Master 主分支：

     主分支主要用于合并其他分支打包上线
     *切忌在该分支上编写代码

##### -  项目介绍：


     项目：将严格按照模块化开发，和Android 编程/命名方式。项目采用MVP模式+组件化+Hybrid混合开发。

##### -   组件描述：


    *请developer注意：在新增module时一定要在该处描述module功能

1. appmodule：


    名称：宿主app
    功能：//在宿主 App 中使用 implementation 依赖业务组件, 业务组件的代码就会完全暴露给宿主 App, 不利于代码的隔离
        //使用 runtimeOnly 依赖业务组件, 可实现业务组件的代码在编译时对宿主 App 不可见, 仅在运行时对宿主 App 可见

2.  commonsdk：


    名称：依赖组件
    功能：主要集成第三方依赖库，sdk 等，所有多modeule使用的 依赖均放置该处



3.  commonres：


    名称：资源组件
    功能：主要集成通用布局/图片/大小 等，所有多modeule使用的 布局均放置该处
    资源规则："public_" //给 Module 内的资源名增加前缀, 避免资源名冲突

4.  commonservice：



    名称：服务组件
    功能：主要集成通用服务 等，所有modeule使用的 服务均放置该处



---
    以上归于通用底层组件

---
5.  module-account：


    名称：账户组件
    功能：主要放置包括：登录、注册、修改密码、忘记密码、角色选择切换等
    资源规则："find_" //给 Module 内的资源名增加前缀, 避免资源名冲突


6.  module-main：


    名称：主页组件
    功能：主要放置包括：主页及其fragment
    资源规则："main_" //给 Module 内的资源名增加前缀, 避免资源名冲突

7.  module-find：


    名称：发现组件
    功能：主要放置包括：发现 及其相关页面
    资源规则："find_" //给 Module 内的资源名增加前缀, 避免资源名冲突


##### -   框架已集成：

    框架集成了一些常用依赖 具体参照：
    项目 common_component_build.gradle


##### -   项目编码即命名规则：

    参照：项目下
    Android开发手.pdf