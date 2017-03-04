package sink.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sink.bean.SinkBean;
import sink.bean.UserBean;
import sink.services.SinkService;
import sink.services.UserService;

@RestController
public class SinkController {

	@Autowired
	private SinkService sinkService;

	@Autowired
	private UserService userService;

	private static final String template = "Hello, %s!";

	@RequestMapping("/sink")
	public SinkBean sink(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		sinkService.findAllSinks(null, null);
		return new SinkBean(String.format(template, name));
	}

    @RequestMapping(value = "/saveFromFile/{userImi}", method = RequestMethod.POST)
    @ResponseBody
	public List<String> saveFromFile(@PathVariable("userImi") String userImi, @RequestBody Set<SinkBean> sinks) {

		UserBean user = getSavedUser(userImi);
		if (user != null) {
			return sinkService.prepareAndSave(sinks, user);
		}
		return null;
	}

	@RequestMapping(value = "/save/{userImi}")
	@ResponseBody
	public Long save(@PathVariable("userImi") String userImi, @RequestBody SinkBean sink) {
		UserBean user = getSavedUser(userImi);
		if (user != null) {
			SinkBean savedBean = sinkService.prepareAndSave(sink, user);
			return savedBean.getId();
		}
		return null;
	}
	

	private UserBean getSavedUser(String userImi) {
		return userService.findByImiNumber(userImi);
	}
}
