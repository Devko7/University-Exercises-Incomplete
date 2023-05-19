package ss.hotel.bill;

public interface BillPrinter {
    void printLine(String text, double price);

    default String format (String text, double price) {
        return String.format("%1$-20s %2$8.2f\n",text, price);

    }
}
