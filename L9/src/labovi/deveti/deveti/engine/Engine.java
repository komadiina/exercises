package labovi.deveti.deveti.engine;

public abstract class Engine {
    private Integer priority;
    private Boolean required;

    public Engine(Integer priority) {
        super();

        this.priority = priority;
        this.required = true;
    }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    public Boolean isRequired() { return this.required; }
    public void setRequired(Boolean required) { this.required = required; }
}
