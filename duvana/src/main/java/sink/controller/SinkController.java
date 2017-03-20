package sink.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;
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

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SinkController.class);

	@Autowired
	private SinkService sinkService;

	@Autowired
	private UserService userService;

	private static final String template = "Hello, %s!";

	@RequestMapping("/sink")
	public SinkBean sink(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		sinkService.findAllSinksByDate(null, null);
		return new SinkBean(String.format(template, name));
	}

	@RequestMapping(value = "/saveFromFile/{userImi}", method = RequestMethod.POST)
	@ResponseBody
	public List<String> saveFromFile(@PathVariable("userImi") String userImi,
			@RequestBody Set<SinkBean> sinks) {

		UserBean user = getSavedUser(userImi);
		if (user != null) {
			return sinkService.prepareAndSave(sinks, user);
		}
		return null;
	}

	@RequestMapping(value = "/save/{userImi}/{checkReferenceExits}")
	@ResponseBody
	public Long save(@PathVariable("userImi") String userImi,
			@PathVariable("checkReferenceExits") String checkReferenceExits,
			@RequestBody SinkBean sink) {
		// check if reference exists
		if (Boolean.valueOf(checkReferenceExits)
				&& sinkService.checkReferenceExists(sink)) {
			return 0L;
		}
		UserBean user = getSavedUser(userImi);
		if (user != null) {
			SinkBean createdSink = sinkService.prepareAndSave(sink, user);
			return createdSink != null ? createdSink.getId() : null;
		}
		LOGGER.warn(String.format("The user %s is not known", userImi));
		return null;
	}

	@RequestMapping(value = "/search/{startDate}/{endDate}")
	@ResponseBody
	public SinkBean[] search(
			@PathVariable("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
			@PathVariable("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate) {
		// check if reference exists
		if (startDate == null) {
			return null;
		}

		if (endDate == null) {
			endDate = new DateTime().plusDays(1).withTimeAtStartOfDay()
					.toDate();
		}
		ArrayList<SinkBean> results = sinkService.findAllSinksByDate(startDate, endDate);
		if(CollectionUtils.isEmpty(results)) {
			return null;
		}
		return  results.toArray(new SinkBean[results.size()]);
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Boolean delete(@RequestBody SinkBean sink) {
		if(sink == null) {
			return false;
		}
		return sinkService.deleteSink(sink);
	}

	private UserBean getSavedUser(String userImi) {
		return userService.findByImiNumber(userImi);
	}
}
