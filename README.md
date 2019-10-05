# 使用SSH开发简易版Web商城

### 登录界面

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190930090116262.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MjUxODk3,size_16,color_FFFFFF,t_70)

### 商城首页

![在这里插入图片描述](https://img-blog.csdnimg.cn/20191002091759706.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MjUxODk3,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20191002091819113.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MjUxODk3,size_16,color_FFFFFF,t_70)

### 购物车

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019100510151679.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MjUxODk3,size_16,color_FFFFFF,t_70)

### 订单详情

![在这里插入图片描述](https://img-blog.csdnimg.cn/20191005101727890.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MjUxODk3,size_16,color_FFFFFF,t_70)

### 数据库

**用户表：t_user**

|字段名|数据类型|约束|描述|
|---------|------------|------|------|
|id|int|主键|用户编号|
|username|varchar(50)|非空|用户名|
|password|varchar(50)|非空|登录密码|
|credit|int|默认值为0|积分|
|mobile|varchar(50)||手机号码|
|address|varchar(200)||收货地址|

![在这里插入图片描述](https://img-blog.csdnimg.cn/20191002104437405.png)

**商品表：t_product**

|字段名|数据类型|约束|描述|
|---------|------------|------|------|
|id|int|主键|商品编号|
|name|varchar(50)|非空|商品名称|
|brand|varchar(50)||品牌|
|price|float(10,2)|非空|单价|
|exchange_credit|int||兑换所需积分|
|exchange_count_limit|int||兑换数量限制|
|stock|int||库存数量|
|credit|int|默认值为0|积分|
|exchange_flag|boolean|默认值false|能否使用积分兑换|
|img_url|varchar(100)||图片路径|
|description|text||商品描述|

![在这里插入图片描述](https://img-blog.csdnimg.cn/20191005095833544.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MjUxODk3,size_16,color_FFFFFF,t_70)

**订单表：t_order**

|字段名|数据类型|约束|描述|
|---------|------------|------|------|
|id|varchar(50)|主键|订单编号|
|user_id|int|外键|用户编号|
|total_amount|float(10,2)||订单总金额|
|actual_total_amount|float(10,2)||实际订单总金额|
|discount_by_credit|float(10,2)||积分抵扣掉的金额|
|payment_gateway|int||支付方式|
|payment_status|int||订单支付状态|
|order_status|int||订单状态|
|use_credit|boolean||是否使用积分|
|create_time|datetime||下单时间|

**订单明细表：t_item**

|字段名|数据类型|约束|描述|
|---------|------------|------|------|
|id|int|主键|项目编号|
|order_id|varchar(50)|外键|订单编号|
|product_id|int|外键|商品编号|
|quality|int||购买数量|

**兑换记录表：t_exchange_records**

|字段名|数据类型|约束|描述|
|---------|------------|------|------|
|id|int|主键|记录编号|
|user_id|int|外键|用户编号|
|product_id|int|外键|商品编号|
|order_id|varchar(50)|外键|订单编号|
|exchange_quantity|int||兑换数量|
|exchange_date|date||兑换日期|

### 参考资料

[[01] springmvc拦截器实现用户登录权限验证](https://www.cnblogs.com/limn/p/8733126.html)

[[02] 拦截器中增加针对静态资源不进行过滤](https://www.cnblogs.com/mophy/p/8465598.html)

[[03] Eclipse安装Hibernate Tools插件](https://blog.csdn.net/wsf408908184/article/details/80839129)

[[04] Hibernate Tools ----Hibernate逆向工程在Eclipse的使用](https://blog.csdn.net/wsf408908184/article/details/80838993)

[[05] Hibernate 运行报错:Error calling Driver#connect](https://blog.csdn.net/slan2069586311/article/details/56840701)

[[06] How to fix 'Problems while reading database schema' from Hibernate Configuration tool](https://stackoverflow.com/questions/56737697)

[[07] You must configure either the server or JDBC driver (via the serverTimezone configuration property)](https://blog.csdn.net/leoma2012/article/details/96348125)

[[08] com.mysql.cj.core.exceptions.InvalidConnectionAttributeException: The server time zone value](https://blog.csdn.net/qq_16166139/article/details/52838025)

[[09] spring整合springmvc和hibernate](https://www.cnblogs.com/sam-uncle/p/8681515.html)

[[10] 整合mybatis时报错：Configuration problem: Unable to locate Spring NamespaceHandler for XML schema namespace [http://www.springframework.org/schema/tx]](https://www.cnblogs.com/mengjinluohua/p/5283182.html)

[[11] Caused by: java.lang.NoClassDefFoundError: org/aspectj/lang/annotation/Around](http://www.mamicode.com/info-detail-2112068.html)

[[12] org.apache.commons.dbcp2.BasicDataSource 找不到](https://blog.csdn.net/u010398232/article/details/90731835)

[[13] NoClassDefFoundError: [Lorg/hibernate/engine/FilterDefinition]](https://blog.csdn.net/shangquan2012/article/details/52468491)

[[14] hibernate4整合spring3  时出现 nested exception is java.lang.NoClassDefFoundError:org/hibernate/engine/SessionFactoryImplementor 异常](https://www.cnblogs.com/Mr-Clint/p/3580287.html)

[[15] Could not obtain transaction-synchronized Session for current thread 原因及解决方案](https://www.cnblogs.com/zeng1994/p/7778145.html)

[[16] org.hibernate.LazyInitializationException: failed to lazily initialize a collection..的解决方案](https://blog.csdn.net/tanga842428/article/details/80277302)

[[17] Hibernate 利用Criteria一次性分页查询数据和总数](https://blog.csdn.net/qq_42891484/article/details/82792133)

[[18] js中session操作](https://www.cnblogs.com/jack-zou/p/8508178.html)

[[19] 网页F12出现favicon.ico not found问题的原因与解决方法](https://blog.csdn.net/qq_39300332/article/details/79440622)

[[20] Bootstrap Table API 中文版 说明文档](https://blog.csdn.net/yapengliu/article/details/80191699)

[[21] 在js中为对象添加和删除属性](https://blog.csdn.net/qq_37899792/article/details/89914010)

[[22] JavaScript parseInt() 函数](https://www.w3school.com.cn/jsref/jsref_parseInt.asp)

[[23] sessionstorage json对象的存储和获取](https://www.cnblogs.com/fanny123/p/9050309.html)

[[24] 退出登录清空session](https://blog.csdn.net/z19799100/article/details/87889852)

[[25] 购物车前端开发](https://www.jb51.net/article/91362.htm)

[[26] bootstraptable删除当前行](https://www.2cto.com/kf/201810/781559.html)

[[27] bootstrap-table](https://www.cnblogs.com/wsblogs/p/7738044.html)

[[28] 在 Bootstraptable 插件基础上新增一行，保存，删除的详解](https://www.cnblogs.com/zsber/p/9560148.html)

[[29] Html页面接收参数](https://blog.csdn.net/weixin_39657319/article/details/91045583)

[[30] eclipse 解决启动慢、运行慢的方法总结](https://blog.csdn.net/weidong_y/article/details/80281230)

[[31] Hibernate各种主键生成策略与配置详解](https://www.cnblogs.com/hoobey/p/5508992.html)

[[32] 错误：MySQL server version for the right syntax to use near](https://www.cnblogs.com/aishangtaxuefeihong/p/7675845.html)

[[33] Spring4+Hibernate4 事务管理 配置 注解 AOP](https://www.cnblogs.com/mxgg/p/7226179.html)

[[34] 解决Hibernate：could not initialize proxy - no Session](https://blog.csdn.net/u010167086/article/details/17029831)

[[35] html网页如何传递接收地址参数?](https://www.cnblogs.com/liuxiaoming123/p/7494125.html)
