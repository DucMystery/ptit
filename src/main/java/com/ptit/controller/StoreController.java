package com.ptit.controller;

import com.ptit.dto.Cart;
import com.ptit.model.Store;
import com.ptit.service.PublisherService;
import com.ptit.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @Autowired
    PublisherService publisherService;

    @Autowired
    private HttpSession session;

    @GetMapping("/stores")
    public ModelAndView showSearchStore(){
        return new ModelAndView("/store/search");
    }

    @GetMapping("/store/{id}")
    public ModelAndView finbyId(@PathVariable Long id){

        Store  store = storeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/store/viewUpdate");
        modelAndView.addObject("store", store);
        return modelAndView;
    }

    @PostMapping("/store/add-cart/")
    public String addCartStore(@ModelAttribute("store") Store store){

        Object object = session.getAttribute("cart");

        if (object ==null){
            Cart cart = new Cart();
            List<Store> stores = new ArrayList<>();
            store.setTotal(store.getAmount() * store.getPrice());
            stores.add(store);
            cart.setStores(stores);
            session.setAttribute("cart", cart);
        }else {
            Cart cart = (Cart) object;
            List<Store> stores = cart.getStores();
            store.setTotal(store.getAmount() * store.getPrice());
            stores.add(store);
            cart.setStores(stores);
            Long total = 0L;
            for (Store store1: stores){
                total += store1.getTotal();
            }

            cart.setTotal(total);
            session.setAttribute("cart", cart);
        }

        String id = storeService.findById(store.getId()).getPublisher().getId().toString();

        return "redirect:/publisher/view/"+id;
    }

    @GetMapping("/store/export-cart")
    public ModelAndView exportCart(){

        Object o = session.getAttribute("cart");
        List<Store> stores = new ArrayList<>();
        Cart cart = new Cart();
        if (o != null){
            cart = (Cart) o;
        }
        ModelAndView modelAndView = new ModelAndView("/publisher/viewCart");
        modelAndView.addObject("cart", cart);

        return modelAndView;
    }

    @PostMapping("/store/update")
    public String updateStore(){

        Object o = session.getAttribute("cart");

        if (o != null){
            Cart cart = (Cart) o;
            List<Store> stores = cart.getStores();
            storeService.updateStoreList(stores);
        }
        return "redirect:/publisher";
    }
}
