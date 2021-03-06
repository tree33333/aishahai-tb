package com.nzonly.tb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nzonly.tb.Constants;
import com.nzonly.tb.service.TaobaoTaskService;

/**
 * @author yinheli
 * @link yinheli@gmail.com
 * @date 2012-7-22 上午10:42:29
 * @version V1.0
 */
@Controller
@RequestMapping("/task")
public class TaskController extends BaseController {
	
	@Autowired
	private TaobaoTaskService taskService;
	
	@RequestMapping(value = {"index", ""})
	public String index(Model model, @RequestParam(defaultValue = "1") int p) {
		PageRequest pageRequest = new PageRequest(p - 1, Constants.PAGE_SIZE);
		model.addAttribute("list", taskService.getByPage(pageRequest));
		return "task/index";
	}

}
