package com.example.springbootthymeleaf39.web;

import com.example.springbootthymeleaf39.dto.SearchDto;
import com.example.springbootthymeleaf39.dto.ToolDto;
import com.example.springbootthymeleaf39.service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ToolController {

    private final ToolService toolService;

    @GetMapping
    public String getTools(Model model) {
        var all = toolService.findAll();
        model.addAttribute("tools", all);

        return "home";
    }

    @PostMapping("/")
    public String addTool(ToolDto tool,
                          @RequestParam(value = "delivered", required = false) String delivered,
                          Model model) {
        boolean isDelivered = delivered == null || delivered.isBlank() ? false : true;
        tool.setIsDelivered(isDelivered);
        toolService.createTool(tool);
        model.addAttribute("tools", toolService.findAll());

        return "home";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") UUID id,
                       Model model) {
        ToolDto tool = toolService.findById(id);
        model.addAttribute("tool", tool);

        return "edit";
    }

    @PostMapping("/edit")
    public String update(ToolDto tool,
                         @RequestParam(value = "delivered", required = false) String delivered,
                         Model model) {
        addTool(tool, delivered, model);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") UUID id) {
        toolService.deleteTool(id);

        return "redirect:/";
    }

    @GetMapping("/return")
    public String returnTool(@RequestParam(name = "id") UUID id) {
        toolService.returnTool(id);

        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(SearchDto dto,
                         @RequestParam(value = "delivered", required = false) String delivered,
                         Model model){
        boolean isDelivered = delivered == null || delivered.isBlank() ? false : true;
        dto.setIsDelivered(isDelivered);
        List<ToolDto> all = toolService.findAll(dto);
        model.addAttribute("tools", all);

        return "home";
    }
}
