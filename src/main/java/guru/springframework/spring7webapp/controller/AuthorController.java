package guru.springframework.spring7webapp.controller;

import guru.springframework.spring7webapp.repository.AuthorRepository;
import guru.springframework.spring7webapp.service.AuthorService;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class AuthorController {

    public final AuthorService authorService;

    AuthorController(AuthorService authorService) {this.authorService = authorService;}

    @RequestMapping(path = "/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}