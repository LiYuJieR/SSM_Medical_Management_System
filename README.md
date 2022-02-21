

# 医疗管理系统

### 业务分析



#### PatientUser:

 -  [x] 注册

 -  [x] 登录 

	功能页：

 -  [x] 自助挂号 

 -  [x] 自助缴费 

 -  [ ] 支付宝整合

 -  [x] 结果查询

 -  [x] 更换手机号 修改密码

​	



#### DoctorUser:

- [x] 登录
- [x] 添加就诊时间 
- [x] 查看挂号病人 
- [x] 病人解除绑定，转移给其他医生
- [x] 备注病人结果 
- [x] 给病人开收费单

#### AdminUser:

 - [x] 管理医生列表 医生注册

### 库表设计

adminuser

![image-20220208202845172](C:\Users\宇\AppData\Roaming\Typora\typora-user-images\image-20220208202845172.png)

doctoruser

![image-20220208203042104](C:\Users\宇\AppData\Roaming\Typora\typora-user-images\image-20220208203042104.png)   

department

![image-20220208203244551](C:\Users\宇\AppData\Roaming\Typora\typora-user-images\image-20220208203244551.png)

doctorgrade

![image-20220210194437834](C:\Users\宇\AppData\Roaming\Typora\typora-user-images\image-20220210194437834.png)

registration

![image-20220210194540788](C:\Users\宇\AppData\Roaming\Typora\typora-user-images\image-20220210194540788.png)

patient

![image-20220211152938991](C:\Users\宇\AppData\Roaming\Typora\typora-user-images\image-20220211152938991.png)



### 如何整合redis

什么人需要消息通知？

​	医生和患者 这两类人的Id是不会重合的 所以redis的key是Id

redis的存储格式是什么

​	消息队列——list

完成什么功能

​	消息队列的增和查和删 先不改

结构

​	dao层 通过id增 通过id正序查 倒序查

​	service层 同dao层 增加风险排查

数据结构：

​	Integer key——人员id

​	List<String> messages——消息

​	Integer haveRead——已读信息条数

### 出现过的问题

Admin显示所有医生的功能，咋都显示不出来

​	1.Sql查询 =》没有问题

​	2.传参=》没有问题

​	3.前端的问题 在MainFrame.jsp中加入了

```
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

好用了



查询出的医生列表id全为null =》*.xml文件将resultType改为resultMap



*.jsp里做if判断

```
                            <c:choose>
                                <c:when test="${regist.registed==false}">
                                    <a href="${pageContext.request.contextPath}/Doctor/DeleteRegis/${regist.id}/${doc.id}">删除</a>
                                </c:when>
                                <c:otherwise>
                                    <input type="button" onclick="disp_confirm()" value="删除"/></input>
                                </c:otherwise>
                            </c:choose>
```



form里的hidden

```
<input type="hidden" name="Did" value=${Docid} />
```



注解IoC不好用 为null的原因 配置文件没有声明组件扫描器

```
<context:component-scan base-package="com.demo.insert"></context:component-scan>
```



找不到包的原因 且pom.xml没有问题 是没把包导入到war中



### TodoList

- [x] 下拉框 value 与department不对应

- [ ] 修改医生信息的时候 下拉框没有默认值

- [x] 登录错误的alert
- [x] 医生注册的重复问题
- [x] admin返回主页的问题 退出登录的问题

- [x] 显示界面 显示部门和等级的名字

参照

```
<c:forEach items="${infoList}" var="info" varStatus="loop">
                <tr>
                 <td>${info.id}</td>
                 <td>${info.zdzName}</td>
                 <td>${info.ztempString}</td>
                 <td>${userNames[loop.count-1].name}</td>
                </tr>
</c:forEach>
```

- [ ] 添加新的挂号信息时，判断时间点 ----直接用Ajax或者Pjax在前端处理掉

- [x] 过时的挂号信息，自动删除

	MySQL 事件

	delete语句：

	```sql
	delete From registration where DATE(concat(day,' ',beginTime)) <= DATE(NOW());
	```

	创建存储过程

	```sql
	DELIMITER $
	CREATE PROCEDURE delDueRegistration()
	   BEGIN
	   delete From registration where DATE(concat(day,' ',beginTime)) <= DATE(NOW());
	   END $
	```

	创建事件

	```sql
	CREATE EVENT `event_auto_del_dueregistration`  
	ON SCHEDULE EVERY 1 hour STARTS '2022-02-21 00:00:00'  
	ON COMPLETION NOT PRESERVE ENABLE DO CALL delDueRegistration();
	```

	开启事件计划（调度器）4种方法。键值1或者ON表示开启；0或者OFF表示关闭：

	```sql
	SET GLOBAL event_scheduler = 1; 
	SET @@global.event_scheduler = 1; 
	SET GLOBAL event_scheduler = ON; 
	SET @@global.event_scheduler = ON;
	```

	事件开启与关闭

	```sql
	ALTER EVENT event_auto_del_memorydata ON COMPLETION PRESERVE ENABLE; //开启某事件
	ALTER EVENT event_auto_del_memorydata ON COMPLETION PRESERVE DISABLE; //关闭某事件
	```

	是否好用：2022.2.20 21：01截图

	![image-20220220210108207](C:\Users\宇\AppData\Roaming\Typora\typora-user-images\image-20220220210108207.png)

	

- [x] 挂号信息如果已经被预约 删除提示

- [x] 病人按科室挂号查看的bug

- [ ] 支付宝支付的整合

- [x] 消息系统整合redis

- [ ] redis的bug (好了 存疑)