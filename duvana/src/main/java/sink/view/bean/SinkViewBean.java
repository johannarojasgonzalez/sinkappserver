package sink.view.bean;

import java.util.Date;

import sink.enums.SinkDiameterEnum;
import sink.enums.SinkPlumbOptionEnum;
import sink.enums.SinkStatusEnum;
import sink.enums.SinkTypeEnum;

public class SinkViewBean {
	
	private String						sinkStatus;
	private SinkTypeEnum				sinkType;
	private SinkStatusEnum			status;
	private SinkDiameterEnum		diameter;
	private SinkPlumbOptionEnum	plumbOption;
	private String						length;
	private String						pipeLineLength;
	private String						reference;
	private String						observations;
	private String						fileName;
	private String						address;
	private String						client;
	private Date						sinkCreationDate;
	
	public String getSinkStatus() {
		return sinkStatus;
	}
	
	public void setSinkStatus(String sinkStatus) {
		this.sinkStatus = sinkStatus;
	}
	
	public SinkTypeEnum getSinkType() {
		return sinkType;
	}
	
	public void setSinkType(SinkTypeEnum sinkType) {
		this.sinkType = sinkType;
	}
	
	public String getLength() {
		return length;
	}
	
	public void setLength(String length) {
		this.length = length;
	}
	
	public String getPipeLineLength() {
		return pipeLineLength;
	}
	
	public void setPipeLineLength(String pipeLineLength) {
		this.pipeLineLength = pipeLineLength;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public String getObservations() {
		return observations;
	}
	
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}
	
	public Date getSinkCreationDate() {
		return sinkCreationDate;
	}
	
	public void setSinkCreationDate(Date sinkCreationDate) {
		this.sinkCreationDate = sinkCreationDate;
	}
	
	public SinkStatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(SinkStatusEnum status) {
		this.status = status;
	}
	
	public SinkDiameterEnum getDiameter() {
		return diameter;
	}
	
	public void setDiameter(SinkDiameterEnum diameter) {
		this.diameter = diameter;
	}
	
	public SinkPlumbOptionEnum getPlumbOption() {
		return plumbOption;
	}
	
	public void setPlumbOption(SinkPlumbOptionEnum plumbOption) {
		this.plumbOption = plumbOption;
	}
	
}
