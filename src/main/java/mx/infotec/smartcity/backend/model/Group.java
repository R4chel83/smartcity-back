
package mx.infotec.smartcity.backend.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "type", "group", "dateCreated", "dateModified"})
public class Group {

  @JsonProperty("id")
  private String id;
  @JsonProperty("type")
  private String type;
  @JsonProperty("group")
  private String group;
  @JsonProperty("dateCreated")
  private Date   dateCreated;
  @JsonProperty("dateModified")
  private Date   dateModified;

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("group")
  public String getGroup() {
    return group;
  }

  @JsonProperty("group")
  public void setGroup(String group) {
    this.group = group;
  }

  @JsonProperty("dateCreated")
  public Date getDateCreated() {
    return dateCreated;
  }

  @JsonProperty("dateCreated")
  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  @JsonProperty("dateModified")
  public Date getDateModified() {
    return dateModified;
  }

  @JsonProperty("dateModified")
  public void setDateModified(Date dateModified) {
    this.dateModified = dateModified;
  }

}