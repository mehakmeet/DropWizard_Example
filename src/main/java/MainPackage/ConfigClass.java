package MainPackage;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;

public class ConfigClass extends Configuration {

    @NotEmpty
    private String template; //Hello
    @NotEmpty
    private String defName = "Stranger"; // Hello Stranger

    @JsonProperty
    public String getTemplate() {
        return template;
    }
    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }
    @JsonProperty
    public String getDefName() {
        return defName;
    }
    @JsonProperty
    public void setDefName(String defName) {
        this.defName = defName;
    }

}
