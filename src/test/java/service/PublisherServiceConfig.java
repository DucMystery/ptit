package service;

import com.ptit.repository.PublisherRepository;
import com.ptit.repository.StoreRepository;
import com.ptit.service.PublisherService;
import com.ptit.service.StoreService;
import com.ptit.service.impl.PublisherServiceImpl;
import com.ptit.service.impl.StoreServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherServiceConfig {

    @Bean
    public PublisherService publisherService(){

        return new PublisherServiceImpl();
    }

    @Bean PublisherRepository publisherRepository(){
        return Mockito.mock(PublisherRepository.class);
    }

    @Bean
    public StoreService storeService(){
        return new StoreServiceImpl();
    }

    @Bean
    public StoreRepository storeRepository(){
        return Mockito.mock(StoreRepository.class);
    }
}
