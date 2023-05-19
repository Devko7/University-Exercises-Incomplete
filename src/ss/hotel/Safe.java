package ss.hotel;

public class Safe {

    private boolean activation;
    private boolean status;

    public Safe () {
        this.activation = false;
        this.status = false;
    }

    public void activate() {
        this.activation = true;
    }

    public void deactivate() {
        this.status = false;
        this.activation = false;
    }

    public void open() {

        if (this.activation == true) {
            this.status = true;
        }

    }

    public void close() {
        this.status = false;
    }

    public boolean isActive() {

        if (this.activation == true) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {

        if(this.status == true) {
            return true;
        }
        return false;
    }
}
