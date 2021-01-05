package org.starrier.sky.ladder.distributiion.rxjava.jdk9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author starrier
 * @date 2020/12/28
 */
public class ReactiveStreamJdk9Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveStreamJdk9Test.class);

    public static void main(String[] args) throws InterruptedException {

        subscribeTest();

    }

    // TODO 以下代码需要 JDK 等级 大于等于 9
    public static void subscribeTest() throws InterruptedException {
        // 1.创建 生产者Publisher JDK9自带的 实现了Publisher接口
       /* SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;
            @Override//System.out.println("订阅成功。。");System.out.println("订阅方法里请求一个数据");
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1);
            }
            @SneakyThrows @Override//LOGGER.info("【onNext 接受到数据 item : {}】 ", item);
            public void onNext(Integer item) {
                TimeUnit.SECONDS.sleep(1);
                subscription.request(1);
            }
            @Override //LOGGER.info("【onError 出现异常】");
            public void onError(Throwable throwable) {
                subscription.cancel();
            }
            @Override// LOGGER.info("【onComplete 所有数据接收完成】");
            public void onComplete() {
            }
        };
        //3。发布者和订阅者 建立订阅关系 就是回调订阅者的onSubscribe方法传入订阅合同
        publisher.subscribe(subscriber);
        //4.发布者 生成数据
        IntStream.range(1,5).forEach(i->{ LOGGER.info("【生产数据 {} 】", i);
        //submit是一个阻塞方法，此时会调用订阅者的onNext方法
        publisher.submit(i);});
        //5.发布者 数据都已发布完成后，关闭发送，此时会回调订阅者的onComplete方法
        publisher.close();*/
        //主线程睡一会,模拟耗时操作
        Thread.currentThread().join(100000);
    }

}
