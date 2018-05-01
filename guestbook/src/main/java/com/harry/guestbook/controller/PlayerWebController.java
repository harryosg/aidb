package com.harry.guestbook.controller;

import com.harry.guestbook.domain.PlayerEntry;
import com.harry.guestbook.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PlayerWebController {
    @Autowired
    private PlayerService playerService;

    private static final String GUESTBOOK_TEMPLATE = "players";
    private static final String HOMEPAGE_REDIRECT = "redirect:/";
    private static final String ENTRIES_TEMPLATE_ID = "players";
    private static final String NEW_ENTRY_TEMPLATE_ID = "newEntry";
    private static final String GUESTBOOK_FORM_HEADER_ID = "formHeader";

    @GetMapping ("/")
    public String displayGuestBook (Model model) {
        model.addAttribute (GUESTBOOK_FORM_HEADER_ID, "Add a New Player");
        model.addAttribute (ENTRIES_TEMPLATE_ID, this.playerService.findAllEntries ());
        model.addAttribute(NEW_ENTRY_TEMPLATE_ID, new PlayerEntry());
        return GUESTBOOK_TEMPLATE;
    }
    @GetMapping ("/delete/{id}")
    public String deleteComment (@PathVariable Integer id) {
        this.playerService.deletePlayerById(id);
        return "redirect:/";
    }
    @PostMapping ("update/{id}")
    public String addComment (Model model,
                              @Valid @ModelAttribute (NEW_ENTRY_TEMPLATE_ID)
                                      PlayerEntry newEntry,
                                      BindingResult bindingResult) {
        if (!bindingResult.hasErrors ()) {
            this.playerService.save (newEntry);
            return HOMEPAGE_REDIRECT;
        }
        else {
            model.addAttribute (GUESTBOOK_FORM_HEADER_ID, "Please Correct the input");
            model.addAttribute (ENTRIES_TEMPLATE_ID, this.playerService.findAllEntries ());
            return GUESTBOOK_TEMPLATE;
        }

    }
    @GetMapping ("update/{id}")
    public String editComment (Model model, @PathVariable Integer id) {
        model.addAttribute (ENTRIES_TEMPLATE_ID, this.playerService.findAllEntries ());
        model.addAttribute (GUESTBOOK_FORM_HEADER_ID, "Please Change the input");
        model.addAttribute (NEW_ENTRY_TEMPLATE_ID, this.playerService.findOne (id));
        return GUESTBOOK_TEMPLATE;
    }
}
