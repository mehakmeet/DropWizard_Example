package MainPackage;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class RepresentationClass {

    private long id;

    private String content;

    public RepresentationClass() {

    }


    public RepresentationClass(long id, String content)
    {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
