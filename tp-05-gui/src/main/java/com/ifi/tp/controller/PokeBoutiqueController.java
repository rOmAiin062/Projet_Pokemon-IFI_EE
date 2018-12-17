package com.ifi.tp.controller;

import com.ifi.tp.pokeBoutique.bo.PokeBoutique;
import com.ifi.tp.pokeBoutique.services.PokeBoutiqueService;
import com.ifi.tp.trainers.bo.Item;
import com.ifi.tp.trainers.bo.Trainer;
import com.ifi.tp.trainers.services.TrainersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PokeBoutiqueController {

    private PokeBoutiqueService pokeBoutiqueService;
    private TrainersService trainersService;

    @Autowired
    public PokeBoutiqueController(PokeBoutiqueService pokeBoutiqueService, TrainersService trainersService){
        this.pokeBoutiqueService = pokeBoutiqueService;
        this.trainersService = trainersService;
    }


    @GetMapping("/pokeboutique")
    public ModelAndView pokeBoutique()
    {
        ModelAndView modelAndView = new ModelAndView("pokeboutique");
        //HashMap<Item, Integer> products = this.pokeBoutiqueService.listProducts();
        //modelAndView.addObject("products_set", products.entrySet());

        List<Trainer> trainers = this.trainersService.listTrainers();
        modelAndView.addObject("trainers", trainers);
        modelAndView.addObject("login", "login");

        return modelAndView;
    }

    @GetMapping("/pokeboutique/{name}")
    public ModelAndView pokeBoutique(@PathVariable String name)
    {
        ModelAndView modelAndView = new ModelAndView("pokeboutique");
        HashMap<Item, Integer> products = this.pokeBoutiqueService.listProducts();
        Trainer trainer = this.trainersService.getTrainer(name);
        modelAndView.addObject("products_set", products.entrySet());
        modelAndView.addObject("trainer",trainer);
        return modelAndView;
    }

    @GetMapping("pokeboutique/{name}/{product_name}")
    public ModelAndView pokeBoutique(@PathVariable String name, @PathVariable String product_name)
    {
        Trainer trainer = this.trainersService.getTrainer(name);
        HashMap<Item, Integer> products = this.pokeBoutiqueService.listProducts();

        for(Map.Entry<Item, Integer> entry : products.entrySet())
        {
            Item item = entry.getKey();
            Integer quantity = entry.getValue();

            if(item.getName().replaceAll("\\s","").equals(product_name))
            {
                if(item.getBuying_price() <= trainer.getWallet() && quantity > 0)
                {
                    trainer.setWallet(trainer.getWallet() - item.getBuying_price());
                    trainer.getInventory().add(item);
                    this.pokeBoutiqueService.updateItemQuantity(item, quantity -1);
                    this.trainersService.updateTrainer(trainer);
                }
            }
        }
        return new ModelAndView("redirect:/pokeboutique/"+name);
    }

}
