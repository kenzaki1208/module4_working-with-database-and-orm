package org.example.week2working_with_database_and_orm.working_with_database_and_orm.practice.p1.controller;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.practice.p1.model.Customer;
import org.example.week2working_with_database_and_orm.working_with_database_and_orm.practice.p1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/working_with_database_and_orm/practice/p1/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "/working_with_database_and_orm/practice/p1/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/working_with_database_and_orm/practice/p1/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/working_with_database_and_orm/practice/p1/customers";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/working_with_database_and_orm/practice/p1/update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.save(customer);
        return "redirect:/working_with_database_and_orm/practice/p1/customers";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/working_with_database_and_orm/practice/p1/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/working_with_database_and_orm/practice/p1/customers";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/working_with_database_and_orm/practice/p1/view";
    }
}
