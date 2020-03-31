package com.joke.jokes4u;

import java.util.List;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class WebController implements WebMvcConfigurer {

    @Autowired
    DBController dbController;
    List<Category> categories;
    ArraySorter sorter = new ArraySorter();

    /**
     * Unnecessary method, mostly used to initialize pages because all pages always
     * need categories, this means less querying for categories
     * 
     * @param model Used only to write the List<Category> to the page
     * @return All current categories
     */
    public List<Category> initPage(Model model) {
        if (categories == null) {
            categories = dbController.queryCategories();
        }
        model.addAttribute("categories", categories);
        return categories;
    }

    /**
     * Present all jokes based on a certain category id.
     * 
     * @param model
     * @param categoryId
     * @param page
     * @param sort
     * @return String of template.
     */
    @GetMapping("/show/{categoryId}")
    public String showJokes(Model model, @PathVariable long categoryId,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "sort", required = false, defaultValue = "descending-difference") String sort) {
        initPage(model);

        List<Joke> jokes;
        if (dbController.findCategory(categoryId) != null) {
            jokes = dbController.queryJokesOfCategory(categoryId);
            model.addAttribute("category", dbController.findCategory(categoryId).getName());
        } else {
            jokes = dbController.queryJokes();
            model.addAttribute("category", "All jokes");
        }

        switch (sort) {
            case "youngest":
                model.addAttribute("jokes", sorter.sortYoungest(jokes, dbController, page));
                break;
            case "ascending-difference":
                model.addAttribute("jokes", sorter.sortAscendingDifference(jokes, dbController, page));
                break;
            case "descending-difference":
                model.addAttribute("jokes", sorter.sortDescendingDifference(jokes, dbController, page));
                break;
            default:
                model.addAttribute("jokes", sorter.sortOldest(jokes, dbController, page));
                break;
        }

        model.addAttribute("maxpage", jokes.size() / 10);
        model.addAttribute("sort", sort);
        model.addAttribute("page", page);
        model.addAttribute("categoryId", categoryId);
        return "show";
    }

    /**
     * Present all jokes.
     * 
     * @param model
     * @param page
     * @return String of template.
     */
    @GetMapping("/")
    public String showAll(Model model, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        initPage(model);
        return showJokes(model, -1, 0, "");
    }

    /**
     * Present home page.
     * 
     * @param model
     * @return String of template.
     */
    @GetMapping("/home")
    public String showHome(Model model) {
        initPage(model);
        return "home";
    }

    /**
     * Present form to add new joke.
     * 
     * @param model
     * @param jokeForm
     * @return String of template.
     */
    @GetMapping("/new")
    public String showForm(Model model, JokeForm jokeForm) {
        initPage(model);
        return "newJoke";
    }

    /**
     * Present success form based on category id.
     * 
     * @param model
     * @param jokeForm
     * @param category
     * @return String of template.
     */
    @GetMapping("/new/{category}")
    public String showSuccesssForm(Model model, JokeForm jokeForm, @PathVariable String category) {
        initPage(model);
        model.addAttribute("success", "Successfully added a new joke to category " + category);
        return "newJoke";
    }

    /**
     * Insert new joke and redirect (either success or error).
     * 
     * @param jokeForm
     * @return String of template.
     */
    @PostMapping("/post")
    public String insertJoke(JokeForm jokeForm) {
        long categoryid = jokeForm.getCategoryId();
        String content = jokeForm.getContent();
        try {
            dbController.insert(categoryid, content);
            return "redirect:/new/" + dbController.findCategory(categoryid).getName();
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/update/{categoryId}/{page}/{sort}/{jokeId}/{increment}")
    public String updateDifference(@PathVariable long categoryId, @PathVariable int page, @PathVariable String sort,
            @PathVariable long jokeId, @PathVariable boolean increment) {
        Joke joke = dbController.getJokeById(jokeId);
        if (increment) {
            joke.setLikes(joke.getLikes() + 1);
        } else {
            joke.setDislikes(joke.getDislikes() + 1);
        }
        dbController.update(joke);
        return "redirect:/show/" + categoryId + "?page=" + page + "&sort=" + sort;
    }

    /**
     * Only used to show a simple error page
     * 
     * @param model
     * @param e
     * @return
     */
    @GetMapping("/error")
    public String showError(Model model, Exception e) {
        model.addAttribute("error", e.getMessage());
        return "error";
    }

}