package com.gaofei.web.filter;

import com.alibaba.dubbo.rpc.*;

import java.util.Objects;

/**
 * Created by GaoQingming on 2017/9/8 0008.
 */
public class MyFilterTest implements Filter{
    /* 这里如果需要引用dubbo服务，需要写出来setter方法
    只能用setter方法注入，好像不能用注解
    private ClassService classService;

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }*/

    //Result 没有提供setValue方法，所以对于返回final类型的值，如String，不能修改返回值。
    //不过对于引用类型的值是可以操作的，比如下面注释那些。
    //其实网上的例子不是用来修改返回结果的，而是白名单，要么能访问，要么不能访问。
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String methodName = invocation.getMethodName();
        Result result = invoker.invoke(invocation);
        if (result == null) return result;

        if (Objects.equals(methodName,"sayHello")) {
            String s = (String)result.getValue();
            System.out.println("filter come");
            s = s + "filter";                           //这里修改后是不能返回的。
            return result;
        }
        return result;
    }

    /*
    * String methodName = invocation.getMethodName();
        Result result = invoker.invoke(invocation);
        if(Objects.equals(methodName, "queryTeacherClass")) {
            List<ClassInfoDTO> classList = (List<ClassInfoDTO>) result.getValue();
            Iterator<ClassInfoDTO> it = classList.iterator();
            while (it.hasNext()) {
                ClassInfoDTO dto = it.next();
                if (classService.isWalkingClassId(dto.getClassId())) {
                    it.remove();
                }
            }
        }
        return result;*/
}
