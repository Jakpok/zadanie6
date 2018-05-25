package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="hardware.all", query="SELECT h from Hardware h"),
	@NamedQuery(name="hardware.id", query="SELECT FROM Hardware h WHERE h.id=:hardwareID"),
	@NamedQuery(name="hardware.price", query="SELECT DISTINCT h FROM Hardware h WHERE h.priceMin>=:priceMin AND h.priceMax<=:priceMax"),
	@NamedQuery(name="hardware.name", query="SELECT DISTINCT h FROM Hardware h WHERE h.name=:name"),
	@NamedQuery(name="hardware.category", query="SELECT FROM Hardware h WHERE h.category=:category")
})
public class Hardware {
	
	private int id;
	private String name;
	private HardwareType category;
	private List<Comment> comments = new ArrayList<Comment>();
	private float priceMin;
	private float priceMax;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HardwareType getCategory() {
		return category;
	}
	public void setCategory(HardwareType category) {
		this.category = category;
	}
	@XmlTransient
	@OneToMany(mappedBy="hardware")
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comment) {
		this.comments = comment;
	}
	public float getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(float priceMin) {
		this.priceMin = priceMin;
	}
	public float getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(float priceMax) {
		this.priceMax = priceMax;
	}
	
}
