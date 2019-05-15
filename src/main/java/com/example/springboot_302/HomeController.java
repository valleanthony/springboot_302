package com.example.springboot_302;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    JobRepo jobRepo;

    @RequestMapping("/")
    public String listjobs(Model model){
        model.addAttribute("jobs",jobRepo.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String jobform(Model model){
        model.addAttribute("job",new Job());
        return "jobform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Job job, BindingResult result){
        if (result.hasErrors()){
            return "jobform";
        }
        jobRepo.save(job);
        return "redirect:/";
    }

}
