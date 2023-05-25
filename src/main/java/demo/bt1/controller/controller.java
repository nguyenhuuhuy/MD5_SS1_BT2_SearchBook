package demo.bt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {
    public static List<String> stringList = new ArrayList<>();
    static {
        stringList.add("hello");
        stringList.add("long");
        stringList.add("flower");
        stringList.add("sacred");
    }
    @GetMapping("/search")
    public String search(@RequestParam String word, Model model){
        String result = "";
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).equals(word)){
                 result = stringList.get(i);
            }
        }
        switch (result){
            case "hello":
                model.addAttribute("result","xin chào.");
                break;
            case "long":
                model.addAttribute("result", "dài");
                break;
            case "flower":
                model.addAttribute("result", "hoa");
                break;
            case "sacred":
                model.addAttribute("result", "linh");
                break;
            default:
                model.addAttribute("result", "không tìm thấy kết quả");
        }
        return "search";
    }
}
