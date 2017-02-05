package sink.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_SINK")
public class SinkBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long sinkStatutId;
	private Long sinkTypeId;
	private Long lenght;
	private Long pipeLineDiameter;
	private Long pipeLineLenght;
	private String reference;
	private String imageBefore;
	private String imageAfter;
	private String observations;
	private AddressBean adresse;
	private Date sinkCreationDate;
	private Date sinkUpdateDate;

	public SinkBean() {

	}

	public SinkBean(Long id, String reference) {
		this.id = id;
		this.reference = reference;
	}

	public SinkBean(String reference) {
		this.reference = reference;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SNK_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SNK_REFERENCE", length = 150)
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "SNK_IMAGE_BEFORE", columnDefinition = "ntext")
	public String getImageBefore() {
		return imageBefore;
	}

	public void setImageBefore(String imageBefore) {
		this.imageBefore = imageBefore;
	}

	@Column(name = "SNK_IMAGE_AFTER", columnDefinition = "ntext")
	public String getImageAfter() {
		return imageAfter;
	}

	public void setImageAfter(String imageAfter) {
		this.imageAfter = imageAfter;
	}

	@ManyToOne()
	@JoinColumn(name = "SNK_ADDRESS_ID", nullable = false)
	public AddressBean getAdresse() {
		return adresse;
	}

	public void setAdresse(AddressBean adresse) {
		this.adresse = adresse;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SNK_CREATION_DATE")
	public Date getSinkCreationDate() {
		return sinkCreationDate;
	}

	public void setSinkCreationDate(Date sinkCreationDate) {
		this.sinkCreationDate = sinkCreationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SNK_UPDATE_DATE")
	public Date getSinkUpdateDate() {
		return sinkUpdateDate;
	}

	public void setSinkUpdateDate(Date sinkUpdateDate) {
		this.sinkUpdateDate = sinkUpdateDate;
	}

	@Column(name = "SNK_STATUT_ID")
	public Long getSinkStatutId() {
		return sinkStatutId;
	}

	public void setSinkStatutId(Long sinkStatutId) {
		this.sinkStatutId = sinkStatutId;
	}

	@Column(name = "SNK_TYPE_ID")
	public Long getSinkTypeId() {
		return sinkTypeId;
	}

	public void setSinkTypeId(Long sinkTypeId) {
		this.sinkTypeId = sinkTypeId;
	}

	@Column(name = "SNK_LENGHT")
	public Long getLenght() {
		return lenght;
	}

	public void setLenght(Long lenght) {
		this.lenght = lenght;
	}

	@Column(name = "SNK_PIPELINE_DIAMETER")
	public Long getPipeLineDiameter() {
		return pipeLineDiameter;
	}

	public void setPipeLineDiameter(Long pipeLineDiameter) {
		this.pipeLineDiameter = pipeLineDiameter;
	}

	@Column(name = "SNK_PIPELINE_LENGHT")
	public Long getPipeLineLenght() {
		return pipeLineLenght;
	}

	public void setPipeLineLenght(Long pipeLineLenght) {
		this.pipeLineLenght = pipeLineLenght;
	}

	@Column(name = "SNK_OBSERVATIONS", length = 500)
	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

}
