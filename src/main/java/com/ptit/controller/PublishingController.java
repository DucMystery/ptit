package com.ptit.controller;

import com.ptit.dto.Cart;
import com.ptit.dto.SearchStore;
import com.ptit.model.Publisher;
import com.ptit.model.Store;
import com.ptit.service.PublisherService;
import com.ptit.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class PublishingController {

    @Autowired
    private PublisherService publisherService;

    @Autowired
    StoreService storeService;

    @Autowired
    private HttpSession session;

    @GetMapping("/publisher")
    public ModelAndView viewSearch(){

        return new ModelAndView("/publisher/search");
    }

    @PostMapping("/publisher/search")
    public ModelAndView searchName(@RequestParam("s") Optional<String> name){

        List<Publisher> publishers = publisherService.findAllByName(name.orElse(null));
        ModelAndView modelAndView = new ModelAndView("/publisher/list");
        modelAndView.addObject("publishers", publishers);
        return modelAndView;
    }



    @PostMapping("/publisher/store-list/")
    public ModelAndView getListStore(@RequestParam ("s") Optional<String> name, @RequestParam ("id") Long id){

        List<Store> stores = publisherService.findAllStoreByName(name.orElse(null), id);
        ModelAndView modelAndView = new ModelAndView("/store/list");
        modelAndView.addObject("stores", stores);
        return modelAndView;
    }

    @GetMapping("/publisher/view/{id}")
    public ModelAndView viewSearchStore(@PathVariable Long id){

        Object object = session.getAttribute("cart");
        Cart cart = (Cart) object;
        List<Store> stores = new ArrayList<>();
        if (cart != null) {

            stores = cart.getStores();
        }
        ModelAndView modelAndView = new ModelAndView("/store/search");
        modelAndView.addObject("id", id);
        modelAndView.addObject("stores", stores);
        return modelAndView;
    }


}
