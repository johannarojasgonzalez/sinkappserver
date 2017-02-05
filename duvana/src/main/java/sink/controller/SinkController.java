package sink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sink.bean.SinkBean;
import sink.services.SinkService;

@RestController
public class SinkController {
	
	@Autowired
	private SinkService sinkService;

	private static final String template = "Hello, %s!";
	
	@RequestMapping("/sink")
	public SinkBean sink(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new SinkBean(String.format(template,name));
	}
	
	@RequestMapping("/save")
	public SinkBean save(@RequestBody SinkBean sinkBean) {
		return sinkService.prepareAndSave(sinkBean);
	}
	
}
