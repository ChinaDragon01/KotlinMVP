### MVP架构模式
>MVP全称：Model、View、Presenter；

- Model：负责数据的请求、解析、过滤等数据层操作。

- View：负责视图部分展示

- Presenter：View和Model交互的桥梁。

### 本demo演示MVP架构的使用

>- 网络框架1
   >[retrofit2](https://github.com/square/retrofit/) + [协程](https://book.kotlincn.net/text/coroutines-overview.html)
   >[协程上下文与调度器 中文文档](https://book.kotlincn.net/text/coroutine-context-and-dispatchers.html)
   >[协程上下文与调度器 英文文档](https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html#thread-local-data)
>- 网络框架2
   >retrofit2 + Rxjava3 + rxandroid
>- 日志框架
   >[okhttp3:logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
>- 数据库
   >[room](https://developer.android.com/jetpack/androidx/releases/room?hl=en#kts)
>- api
   >[玩Android 开放API](https://www.wanandroid.com/blog/show/2)
>- Gradle依赖统一版本管理
   >[compositebuild](https://docs.gradle.org/current/userguide/composite_builds.html)
>- KSP
   >[从 kapt 迁移到 KSP](https://developer.android.com/build/migrate-to-ksp?hl=zh-cn)
   >[KSP官网文档](https://kotlinlang.org/docs/ksp-quickstart.html)
>- [TextInputEditText](https://developer.android.google.cn/reference/com/google/android/material/textfield/TextInputEditText?hl=en)
>- [ViewBinding](https://developer.android.com/topic/libraries/view-binding?hl=zh-cn)
   >[Android Gradle 插件 3.6.0推出的新特性](https://developer.android.com/build/releases/past-releases/agp-3-6-0-release-notes?hl=zh-cn)
   >[Android Gradle 插件 4.0.0开始放在buildFeatures](https://developer.android.com/build/releases/past-releases/agp-4-0-0-release-notes?hl=zh-cn)

### 提醒
> 网络框架1：retrofit2 + 协程 进行网络请求以及数据处理
> 网络框架2：retrofit2 + Rxjava3 + rxandroid，这个在以往的MVP架构项目里使用的比较多
