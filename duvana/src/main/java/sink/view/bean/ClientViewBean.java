package sink.view.bean;

import java.io.Serializable;

public class ClientViewBean implements Serializable {
	
	private Long	id;
	private String	name;
	
	public ClientViewBean() {
	}
	
	public ClientViewBean(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  name ;
	}
	
	
	
	
	
}
