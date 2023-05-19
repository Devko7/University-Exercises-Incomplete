package ss.hotel.bill;

public class StringBillPrinter implements BillPrinter {

    private String init;

    public StringBillPrinter() {
        this.init = "";
    }
    public void printLine(String text, double price) {
        init = init + format(text, price);
    }

    public String getResult() {
        return init;
    }

}
