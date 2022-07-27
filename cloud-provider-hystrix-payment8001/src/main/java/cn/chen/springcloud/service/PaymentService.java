package cn.chen.springcloud.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String paymentInfo_OK(Long id){
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handle",commandProperties = {
            //设置规定的超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Long id)
    {
        //int timeOut = 5;
        //try { TimeUnit.SECONDS.sleep(timeOut); } catch (InterruptedException e) { e.printStackTrace(); }
        int i = 10/0;
        //return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O，耗费" + timeOut;
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O";
    }

    public String paymentInfo_TimeOut_Handle(Long id){
        int timeOut = 5;
        return "线程池:"+Thread.currentThread().getName()+"服务超时或运行错误，请重试！"+id+"\t"+"(┬┬﹏┬┬)";
    }
}
