package com.how2java.springboot.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.pojo.Category; 
@Controller
public class CategoryController {
	@Autowired CategoryDAO categoryDAO;
	
	 @Autowired CategoryMapper categoryMapper;
    
    @RequestMapping("/listCategory")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<Category> cs=categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page", page);         
        return "listCategory";
    }

	@RequestMapping("/addCategory")
    public String addCategory(Category c) throws Exception {
    	categoryDAO.save(c);
    	return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
    	categoryDAO.delete(c);
    	return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
    	categoryDAO.save(c);
    	return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String ediitCategory(int id,Model m) throws Exception {
    	Category c= categoryDAO.getOne(id);
    	m.addAttribute("c", c);
    	return "editCategory";
    }
}

