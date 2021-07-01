package service;

import com.ptit.model.Publisher;
import com.ptit.repository.PublisherRepository;
import com.ptit.service.PublisherService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitJupiterConfig(PublisherServiceConfig.class)
public class PublisherServiceTest {

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private PublisherRepository publisherRepository;

    @AfterEach
    private void resetMocks(){
        Mockito.reset(publisherRepository);
    }

    @Test
    void testFindAll(){

        List<Publisher> publishers = new ArrayList<>();
        Publisher publisher = new Publisher();
        publisher.setName("data");
        publisher.setId(1L);
        publishers.add(publisher);

        when(publisherRepository.findAll()).thenReturn(publishers);
        List<Publisher> actual = publisherService.findAll();
        verify(publisherRepository).findAll();
        assertEquals(publishers, actual);
    }

    @Test
    void testFindAllByName(){

        List<Publisher> publishers = new ArrayList<>();
        Publisher publisher = new Publisher();
        publisher.setName("data");
        publisher.setId(1L);
        publishers.add(publisher);
        when(publisherRepository.findAllByN("data")).thenReturn(publishers);

        List<Publisher> actual = publisherService.findAllByName("data");
        verify(publisherRepository).findAllByN("data");
        assertEquals(publishers, actual);

    }

    @Test
    void testFinById(){
        Publisher publisher = new Publisher();
        publisher.setName("data");
        publisher.setId(1L);
        when(publisherRepository.findOne(1L)).thenReturn(publisher);

        Publisher actual = publisherService.findById(1L);
        verify(publisherRepository).findOne(1L);
        assertEquals(publisher, actual);
    }
}
