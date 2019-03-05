package gcyl.entity.config.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
 * 异步配置
 *
 * @author lican
 * @date 2019/2/12
 */
@Configuration
public class AsyncConfig {

    @Bean
    @Primary
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setKeepAliveSeconds(60);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("Async-Executor");
//        executor.setRejectedExecutionHandler((r, executor1) -> {});
        return executor;
    }
}
