package lk.ijse.encoreDecore.tm;

public class AvailabilityTm {
    private String date;
    private String name;
    private String event;

    public AvailabilityTm(String date, String name, String event) {
        this.date = date;
        this.name = name;
        this.event = event;
    }

    @Override
    public String toString() {
        return "AvailabilityTm{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", event='" + event + '\'' +
                '}';
    }

    public AvailabilityTm() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
