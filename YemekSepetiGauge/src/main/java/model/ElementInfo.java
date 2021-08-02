package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
public class ElementInfo
{
  @SerializedName("key")
  @Expose
  private String key;
  @SerializedName("value")
  @Expose
  private String value;
  @SerializedName("type")
  @Expose
  private String type;
  @SerializedName("index")
  @Expose
  private int index;
}
