package a2_springmvc_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import a2_springmvc_crud.dao.StudentDao;
import a2_springmvc_crud.dto.StudentDto;

@Controller
public class StudentController {
	@Autowired
	StudentDao dao;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String createAccount(@ModelAttribute StudentDto dto)
	{
//		System.out.println(dto);
		
		String msg=dao.insert(dto);
		System.out.println(msg);
		return msg;
	}
	
	@RequestMapping("/delete")
//	@ResponseBody
//	@RequestParam(int id)
	public ModelAndView deleteAccount(@RequestParam int id)
	{
//		int id=dto.getSid();
		System.out.println(id);
		String msg=dao.deleteById(id);
		
		ModelAndView view=new ModelAndView("index.jsp");
		view.addObject("message", msg);
		return view;
	}
	
	@RequestMapping("/deleteall")
	public String deleteAllAccount(Model model)
	{
		String msg = dao.deleteAll();
//		ModelAndView view=new ModelAndView("index.jsp");
		model.addAttribute("message1", msg);
		return "index.jsp";
	}
	
	@RequestMapping("/fetchbyid")
	public ModelAndView fetchAccount(@ModelAttribute StudentDto dto,ModelAndView view)
	{
		int id=dto.getSid();
		Object data = dao.fetchById(id);
//		ModelAndView view=new ModelAndView("index.jsp");
		view.addObject("message2", data);
		view.setViewName("index.jsp");
		return view;
	}
	
	@RequestMapping("/fetchall")
	public ModelAndView FetchAllAccount(ModelAndView view)
	{
		List<StudentDto> data = dao.fetchAll();
//		ModelAndView view=new ModelAndView("download.jsp");
		view.addObject("message3", data);
		view.setViewName("download.jsp");
		return view;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateAccount(@ModelAttribute StudentDto dto,ModelAndView view)
	{
		int id=dto.getSid();
		String name=dto.getSname();
		dto.setSid(id);
		dto.setSname(name);
		System.out.println(dto);
		String msg = dao.update(dto);
//		ModelAndView view=new ModelAndView("index.jsp");
		view.addObject("message4", msg);
		view.setViewName("index.jsp");
		return view;
	}

}
