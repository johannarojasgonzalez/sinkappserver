package sink.view.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class CriteriaViewBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	
	private String						reference;
	private ClientViewBean			client;
	private List<ClientViewBean>	clients;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date						startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date						endDate;
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public List<ClientViewBean> getClients() {
		return clients;
	}
	
	public void setClients(List<ClientViewBean> clients) {
		this.clients = clients;
	}

	public ClientViewBean getClient() {
		return client;
	}

	public void setClient(ClientViewBean client) {
		this.client = client;
	}
	
	
	
}
