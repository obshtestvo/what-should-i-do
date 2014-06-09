package bg.obshtestvo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tags")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long tagId;
	@ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
	private List<Item> itemIds;
	@Column(name = "tag_name", nullable = false, unique = true)
	@NotNull
	private String tagName;

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public List<Item> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Item> itemIds) {
		this.itemIds = itemIds;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}
