package epam.com.java.module2.exception.model;

public class Mark {
    private Subject subject;
    private int mark;

    public Mark(Subject subject, int mark){
        this.subject = subject;
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "subject=" + subject +
                ", mark=" + mark +
                '}';
    }
}
