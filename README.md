## 本项目实现的最终作用是基于SSH实现的女装女鞋服装商城网站项目
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 公告管理
 - 品牌管理
 - 商品管理
 - 商品类别管理
 - 定制管理
 - 库存管理
 - 新闻公告管理
 - 用户管理
 - 留言管理
 - 管理员登录
 - 订单管理
 - 财务统计
### 第2个角色为用户角色，实现了如下功能：
 - 加入购物车
 - 提交订单
 - 查看商品详情
 - 查看我的定制需求
 - 查看我的订单
 - 添加定制需求
 - 特价和热销产品查看
 - 用户注册和登录
 - 用户首页
 - 评价订单
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_nvxie_shop

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [t_catelog](#t_catelog) |  |
| [t_ding](#t_ding) |  |
| [t_gonggao](#t_gonggao) |  |
| [t_goods](#t_goods) |  |
| [t_leibie](#t_leibie) |  |
| [t_liuyan](#t_liuyan) |  |
| [t_order](#t_order) |  |
| [t_orderitem](#t_orderitem) |  |
| [t_pinglun](#t_pinglun) |  |
| [t_pingluns](#t_pingluns) |  |
| [t_pinpai](#t_pinpai) |  |
| [t_tupian](#t_tupian) |  |
| [t_user](#t_user) | 用户表 |
| [t_user_goods](#t_user_goods) |  |
| [t_xinwen](#t_xinwen) |  |

**表名：** <a id="t_catelog">t_catelog</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | miaoshu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 描述  |
|  4   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_ding">t_ding</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | goods_id |   int   | 10 |   0    |    N     |  Y   |       | 商品ID  |
|  2   | goods_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | goods_miaoshu |   text   | 65535 |   0    |    Y     |  N   |   NULL    |   |
|  4   | goods_pic |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 商品图片  |
|  5   | goods_yanse |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 颜色  |
|  6   | goods_shichangjia |   int   | 10 |   0    |    Y     |  N   |   NULL    | 市场价  |
|  7   | goods_tejia |   int   | 10 |   0    |    Y     |  N   |   NULL    | 特价  |
|  8   | goods_isnottejia |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 正常价  |
|  9   | goods_isnottuijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否推荐  |
|  10   | goods_catelog_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  11   | goods_kucun |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  12   | goods_Del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  13   | goods_pinpai_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  14   | chubanshe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 出版社  |
|  15   | zuozhe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 作者  |
|  16   | bianhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 编号  |
|  17   | uid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  18   | shenhe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_gonggao">t_gonggao</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | gonggao_id |   int   | 10 |   0    |    N     |  Y   |       | 公告ID  |
|  2   | gonggao_title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公告标题  |
|  3   | gonggao_content |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 公告内容  |
|  4   | gonggao_data |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公告日期  |
|  5   | gonggao_fabuzhe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | gonggao_del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  7   | gonggao_one1 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | gonggao_one2 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | gonggao_one3 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | gonggao_one4 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  11   | gonggao_one5 |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  12   | gonggao_one6 |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  13   | gonggao_one7 |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  14   | gonggao_one8 |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_goods">t_goods</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | goods_id |   int   | 10 |   0    |    N     |  Y   |       | 商品ID  |
|  2   | goods_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | goods_miaoshu |   text   | 65535 |   0    |    Y     |  N   |   NULL    |   |
|  4   | goods_pic |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 商品图片  |
|  5   | goods_yanse |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 颜色  |
|  6   | goods_shichangjia |   int   | 10 |   0    |    Y     |  N   |   NULL    | 市场价  |
|  7   | goods_tejia |   int   | 10 |   0    |    Y     |  N   |   NULL    | 特价  |
|  8   | goods_isnottejia |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 正常价  |
|  9   | goods_isnottuijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否推荐  |
|  10   | goods_catelog_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  11   | goods_kucun |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  12   | goods_Del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |
|  13   | goods_pinpai_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  14   | chubanshe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 出版社  |
|  15   | zuozhe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 作者  |
|  16   | bianhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 编号  |
|  17   | uid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  18   | shenhe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_leibie">t_leibie</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |   0    |   |
|  2   | mingcheng |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名称  |
|  3   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_liuyan">t_liuyan</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  3   | content |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 内容  |
|  4   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 时间  |
|  5   | uid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_order">t_order</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | order_id |   int   | 10 |   0    |    N     |  Y   |       | 订单ID  |
|  2   | order_bianhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | order_date |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | order_zhuangtai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | order_songhuodizhi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | order_fukuangfangshi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | order_jine |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | order_user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  9   | fuid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  10   | shifoufukuan |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  11   | beizhu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="t_orderitem">t_orderitem</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | orderItem_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | order_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 订单ID  |
|  3   | goods_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 商品ID  |
|  4   | goods_quantity |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  5   | fuid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  6   | shifouqueren |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | shifoufukuan |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | beizhu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="t_pinglun">t_pinglun</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | neirong |   varchar   | 5000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 时间  |
|  4   | xinwenId |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  5   | uid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_pingluns">t_pingluns</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | neirong |   varchar   | 5000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 时间  |
|  4   | mid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 会员ID  |
|  5   | uid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_pinpai">t_pinpai</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | miaoshu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 描述  |
|  4   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_tupian">t_tupian</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |   0    |   |
|  2   | xinwen_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | jieshao |   varchar   | 3000 |   0    |    Y     |  N   |   NULL    | 介绍  |
|  4   | fujian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 附件  |

**表名：** <a id="t_user">t_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | loginname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 登录名称  |
|  3   | loginpw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 登录密码  |
|  4   | xingming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 姓名  |
|  5   | xingbie |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 性别  |
|  6   | nianling |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | ADDRESS |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 地址  |
|  8   | dianhua |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  9   | shenhe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | TYPE |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 类型  |
|  11   | typename |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 类型名称  |
|  12   | money |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 金额  |
|  13   | jifen |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  14   | QQ |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | QQ号码  |
|  15   | shenfenzheng |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  16   | touxiang |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 头像  |
|  17   | youxiang |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 邮箱  |
|  18   | chushengnianyue |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  19   | addtime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  20   | beizhu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="t_user_goods">t_user_goods</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | user_id |   int   | 10 |   0    |    N     |  N   |       | 用户ID  |
|  3   | goods_id |   int   | 10 |   0    |    N     |  N   |       | 商品ID  |

**表名：** <a id="t_xinwen">t_xinwen</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | leibieId |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | biaoti |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  4   | neirong |   varchar   | 3000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  5   | fujian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 附件  |
|  6   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 时间  |
|  7   | uid |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  8   | fenlei |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | shenhe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | TYPE |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 类型  |
|  11   | typename |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 类型名称  |
|  12   | beizhu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

