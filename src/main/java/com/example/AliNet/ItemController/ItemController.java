package com.example.AliNet.ItemController;

import com.example.AliNet.Item.Item;
import com.example.AliNet.repository.ExamRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ExamRepository examRepository;

    @GetMapping(value = "/")
    public String indexPage(@NotNull Model model){
        List<Item> items = examRepository.findAll();
        model.addAttribute("items",items);

        ArrayList<String> programingLanguage = new ArrayList<>();
        programingLanguage.add("Java");
        programingLanguage.add("Python");
        programingLanguage.add("C++");
        programingLanguage.add("C#");
        model.addAttribute("language",programingLanguage);
        return "index";
    }

    @GetMapping("/addItemForm")
    public String showAddItem(){
        return "addItemForm";
    }

    @PostMapping("/addItem")
    public String addItem(@RequestParam String name, @RequestParam String description ,
                          @RequestParam double price){
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);



        examRepository.save(item);
        return "redirect:/";
    }


    @GetMapping("/text")
    public String get_text(){
        return "text";
    }
    /*@GetMapping(value = "/")
    public String indexPage(@NotNull Model model){
        List<Item> items = examRepository.findAll();
        model.addAttribute("items", items);
        return "index";
    }

    @GetMapping("/addItemForm")
    public String showAddItemForm() {
        return "addItemForm";
    }

    @PostMapping("/addItem")
    public String addItem(@RequestParam String name, @RequestParam String description,
                          @RequestParam double price){
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);

        examRepository.save(item);
        return "redirect:/";
    }*/

}
