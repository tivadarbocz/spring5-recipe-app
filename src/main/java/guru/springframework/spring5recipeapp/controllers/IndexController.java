package guru.springframework.spring5recipeapp.controllers;

import guru.springframework.spring5recipeapp.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

	private final RecipeService recipeService;

	/* @Autowired
	private SpringTemplateEngine engine;*/

	@Autowired
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping(value = { "", "/", "index" })
	public String getIndexPage(Model model/*,   HttpServletRequest request, HttpServletResponse response*/)/* throws IOException*/ {
		log.debug("Getting index page...");
		model.addAttribute("recipes", recipeService.getRecipes());
		//		WebContext webContext = new WebContext(request,response, ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getServletContext());
		//		webContext.setVariable("recipes", recipeService.getRecipes());
		//		TemplateEngine te = new TemplateEngine();
		//
		//
		//		String s = engine.process("index", webContext);
		//		System.out.println(s);
		//		te.process("index", webContext, response.getWriter());

		return "index";
	}
}
