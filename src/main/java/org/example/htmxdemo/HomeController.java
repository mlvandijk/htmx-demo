package org.example.htmxdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    static List<String> searchResults =
            List.of("one", "two", "three", "four", "five");

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("results", searchResults);
        return "index";
    }

    @GetMapping("/search")
    public String search(String q, Model model) {
        var filtered = searchResults
                .stream()
                .filter(s -> s.startsWith(q.toLowerCase()))
                .toList();

        model.addAttribute("results", filtered);
        return "search :: results";
    }

    @PostMapping("/clicked")
    public String clicked(Model model) {
        model.addAttribute("now", LocalDateTime.now().toString());
        return "clicked :: result";
    }

}
