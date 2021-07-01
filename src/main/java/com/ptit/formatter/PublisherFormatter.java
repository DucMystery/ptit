package com.ptit.formatter;

import com.ptit.model.Publisher;
import com.ptit.service.PublisherService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PublisherFormatter implements Formatter<Publisher> {

    private PublisherService publisherService;

    public PublisherFormatter(PublisherService publisherService){
        this.publisherService = publisherService;
    }
    @Override
    public Publisher parse(String text, Locale locale) throws ParseException {
        return publisherService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Publisher object, Locale locale) {
        return "[ "+object.getId()+", "+object.getName()+"]";
    }
}
