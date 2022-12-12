package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entyti.Catalog;
import ra.model.service.CatalogService;

import java.util.List;
@Controller
@RequestMapping("CatalogController")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @RequestMapping(value = "getAll")
    public ModelAndView getAllCatalog(){
        ModelAndView mav = new ModelAndView("/admin/catalog");
        List<Catalog>listCatalog = catalogService.getAll();
        mav.addObject("listcatalog",listCatalog);
        return mav;
    }
    @RequestMapping("initCreate")
    public String initCreate (Model model){
        Catalog catalog = new Catalog();
        model.addAttribute("catalog",catalog);
        return "catalog";
    }
@PostMapping("create")
    public String createCatalog(@ModelAttribute("catalog") Catalog catalog){
        boolean result = catalogService.save(catalog);
        if (result){
            return "redirect:getAll";
        }else {
            return "error";
        }
    }
    @RequestMapping("initUpdate")
    public String initUpdate(Model model,int catalogId){
        Catalog catUpdate = (Catalog) catalogService.getById(catalogId);
        model.addAttribute("catUpdate",catUpdate);
        return "catalogUpdate";
    }
    @PostMapping("update")
    public String updateCatalog(Catalog catUpdate){
        boolean result = catalogService.update(catUpdate);
        if (result){
            return "redirect:getAll";
        }else {
            return "error";
        }
    }
    @GetMapping ("delete")
    public String deleteCatalog(int catalogId){
        boolean result = catalogService.delete(catalogId);
        if (result){
            return "redirect:getAll";
        }else {
            return "error";
        }
    }
}
