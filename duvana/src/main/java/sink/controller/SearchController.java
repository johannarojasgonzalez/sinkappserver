package sink.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sink.bean.ClientBean;
import sink.bean.SinkBean;
import sink.services.ClientService;
import sink.services.SinkService;
import sink.view.ExcelView;
import sink.view.bean.ClientViewBean;
import sink.view.bean.CriteriaViewBean;
import sink.view.bean.SinkViewBean;

@Controller
public class SearchController {
	
	@Autowired
	private SinkService		sinkService;
	@Autowired
	private ClientService	clientService;
	@Autowired
	private Mapper				mapper;
	
		
	@RequestMapping(value = "/search", method = RequestMethod.GET) 
	public String search(Model model) {
		CriteriaViewBean criteriaViewBean = new CriteriaViewBean();
		poupulateClients(criteriaViewBean);
		model.addAttribute("criteria", criteriaViewBean);
		model.addAttribute("clients", criteriaViewBean.getClients());
		return "search-form"; 
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String launchSearch(@Valid CriteriaViewBean criteriaViewBean, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "search-form";
		}
		
		DateTime today = new DateTime().withTimeAtStartOfDay();
		
		DateTime startDate = criteriaViewBean.getStartDate() != null ? new DateTime(criteriaViewBean.getStartDate().getTime()).withTimeAtStartOfDay() : today;
		DateTime endDate = criteriaViewBean.getEndDate() != null ? new DateTime(criteriaViewBean.getEndDate().getTime()).withTimeAtStartOfDay() : today;
		
		String clienName = StringUtils.EMPTY;
		
		if (CollectionUtils.isNotEmpty(criteriaViewBean.getClients())) {
			ClientViewBean selectedClient = criteriaViewBean.getClients().iterator().next();
			clienName = selectedClient.getName();
			criteriaViewBean.setSelectedClient(selectedClient);
		}
		ArrayList<SinkBean> sinks = sinkService.findAllSinksByDateAnClientAndReference(startDate.toDate(), endDate.toDate(), clienName,
				criteriaViewBean.getReference() != null ? criteriaViewBean.getReference() : StringUtils.EMPTY);
		List<SinkViewBean> sinkViewBeans = new ArrayList<>();
		for (SinkBean sinkBean : sinks) {
			sinkViewBeans.add(mapper.map(sinkBean, SinkViewBean.class));
		}
		
		model.addAttribute("sinks", sinkViewBeans);
		model.addAttribute("criteria", criteriaViewBean);
		return "search-results";
	}
	
	@RequestMapping(value = "/downloadExcel", method = RequestMethod.POST)
	public ModelAndView downloadExcel(@Valid CriteriaViewBean criteriaViewBean, BindingResult bindingResult, Model model) {
		
		DateTime today = new DateTime().withTimeAtStartOfDay();
		
		DateTime startDate = criteriaViewBean.getStartDate() != null ? new DateTime(criteriaViewBean.getStartDate().getTime()).withTimeAtStartOfDay()
				: today;
		DateTime endDate = criteriaViewBean.getEndDate() != null ? new DateTime(criteriaViewBean.getEndDate().getTime()).withTimeAtStartOfDay() : today;
		
		ArrayList<SinkBean> sinks = sinkService.findAllSinksByDateAnClientAndReference(startDate.toDate(), endDate.toDate(),
				criteriaViewBean.getSelectedClient() != null ? criteriaViewBean.getSelectedClient().getName() : StringUtils.EMPTY,
				criteriaViewBean.getReference() != null ? criteriaViewBean.getReference() : StringUtils.EMPTY);
		// return a view which will be resolved by an excel view resolver
		model.addAttribute("sinks", sinks);
		return new ModelAndView(new ExcelView());
	}
	
	private void poupulateClients(CriteriaViewBean criteriaViewBean) {
		List<ClientViewBean> clientsView = new ArrayList<>();
		ArrayList<ClientBean> clients = clientService.findAll();
		if(CollectionUtils.isNotEmpty(clients)) {
			for(ClientBean client : clients) {
				clientsView.add(mapper.map(client, ClientViewBean.class));
			}
		}
		criteriaViewBean.setClients(clientsView);
	}
	
}
