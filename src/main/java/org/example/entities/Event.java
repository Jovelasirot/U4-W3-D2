package org.example.entities;

public class Event {

    private long id;
    private String title;
    private String description;

    private typeEvent typeEvent;

    private int maxParticipant;

    public Event(long id, String title, String description, org.example.entities.typeEvent typeEvent, int maxParticipant) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.typeEvent = typeEvent;
        this.maxParticipant = maxParticipant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public org.example.entities.typeEvent getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(org.example.entities.typeEvent typeEvent) {
        this.typeEvent = typeEvent;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", typeEvent=" + typeEvent +
                ", maxParticipant=" + maxParticipant +
                '}';
    }
}
