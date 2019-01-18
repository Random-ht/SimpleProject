在原来的代码基础上微改       原著是   https://github.com/limedroid/XDroidMvp

## 概述

<p align="center">
	<img src="xdroid_logo_128.png"/>
</p>

**XDroidMvp**是[XDroid](https://github.com/limedroid/XDroid)Android快速开发框架的MVP版本，其使用方式类似于`XDroid`，大部分源码也来自`XDroid`。

**XDroidMvp全新文档**：[https://github.com/limedroid/XDroidMvp/wiki](https://github.com/limedroid/XDroidMvp/wiki)

[![](https://jitpack.io/v/limedroid/XDroidMvp.svg)](https://jitpack.io/#limedroid/XDroidMvp)


`XDroidMvp`主要会有这些特性：

**无需写`Contract`！ 无需写`Present`接口！  无需写`View`接口!**

新增：

* Mvp实现
* `RxJava` & `RxAndroid`
* 权限适配 `RxPermission`
* 事件订阅默认采用 `RxBus`
* 网络交互：
	* `Retrofit` + `rx`
	* `Https`
	* **统一异常处理**
	* 缓存
	* **支持多个baseUrl**
	* 。。。。
* 无需担心rx内存泄漏

保留：

* 提供`XActivity`、`XFragment`、`SimpleRecAdapter`、`SimpleListAdapter`等基类，可快速进行开发
* 完整封装`XRecyclerView`，可实现绝大部分需求
* `XStateController`、`XRecyclerContentLayout`实现loading、error、empty、content四种状态的自由切换
* 实现了`Memory`、`Disk`、`SharedPreferences`三种方式的缓存，可自由扩展
* 内置了`RxBus`，可自由切换到其他事件订阅库
* 内置`Glide`，可自由切换其他图片加载库
* 可输出漂亮的`Log`，支持`Json`、`Xml`、`Throwable`等，蝇量级实现
* 内置链式路由
* 内置常用工具类：`package`、`random`、`file`...,提供的都是非常常用的方法
* 内置加密工具类 `XCodec`，你想要的加密姿势都有


