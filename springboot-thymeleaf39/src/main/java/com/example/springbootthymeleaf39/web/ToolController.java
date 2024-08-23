package com.example.springbootthymeleaf39.web;

import com.example.springbootthymeleaf39.domain.ToolEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ToolController {


    private final SessionFactory sessionFactory;

    @GetMapping
    public String getTools( Model model){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<ToolEntity> tools = session.createQuery("FROM ToolEntity ", ToolEntity.class)
                .stream()
                .collect(Collectors.toList());
        model.addAttribute("tools", tools);
        transaction.commit();
        session.close();

        return "home";
    }

    @PostMapping("/")
    public String addTool(ToolEntity tool,
                          @RequestParam(value = "delivered", required = false) String delivered,
                          Model model){
        boolean isDelivered = delivered == null || delivered.isBlank() ? false : true;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        tool.setIsDelivered(isDelivered);
        session.save(tool);
        List<ToolEntity> tools = session.createQuery("FROM ToolEntity ", ToolEntity.class)
                .stream()
                .collect(Collectors.toList());
        model.addAttribute("tools", tools);
        transaction.commit();
        session.close();

        return "home";
    }

    @GetMapping("/edit{id}")
    public String edit (@RequestParam (name = "id") UUID id,
                        Model model) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ToolEntity tool = session.createQuery("FROM ToolEntity ", ToolEntity.class)
                .stream()
                .filter(toolEntity -> toolEntity.getId().equals(id))
                .findFirst()
                .get();
        model.addAttribute("tool",tool);
        transaction.commit();
        session.close();

        return "edit";
    }

    @PostMapping("/edit{id}")
    public String update (@RequestParam(name = "id") UUID id,
                          @RequestParam(value = "delivered", required = false) String delivered,
                          @ModelAttribute ToolEntity tool) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        boolean isDelivered = delivered == null || delivered.isBlank() ? false : true;
        tool.setIsDelivered(isDelivered);
        session.update(tool);
        transaction.commit();
        session.close();

        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable(name = "id") UUID id,
                         Model model){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ToolEntity tool = session.createQuery("FROM ToolEntity ", ToolEntity.class)
                .stream()
                .filter(toolEntity -> toolEntity.getId().equals(id))
                .findFirst()
                .get();
        tool.setDeleted(true);
        session.update(tool);
        model.addAttribute("tool", tool);

        transaction.commit();
        session.close();
        return "redirect:/";
    }

    @GetMapping("{id}/return")
    public String reternTool(@PathVariable(name = "id") UUID id,
                             Model model){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ToolEntity tool = session.createQuery("FROM ToolEntity ", ToolEntity.class)
                .stream()
                .filter(toolEntity -> toolEntity.getId().equals(id))
                .findFirst()
                .get();
        tool.setDeleted(false);
        session.update(tool);
        model.addAttribute("tool", tool);

        transaction.commit();
        session.close();
        return "redirect:/";
    }

}
