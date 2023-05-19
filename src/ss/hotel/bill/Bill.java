package ss.hotel.bill;

public class Bill {

    public interface Item {
        double getPrice();
    }

    private Double sum;
    private BillPrinter billP;

    /**
     * Constructs a Bill sending the output to a given Printer.
     * @param billPrinter
     */
    public Bill(BillPrinter billPrinter) {
        this.sum = 0.0;
        this.billP = billPrinter;
    }

    /**
     * Adds an item to this Bill. The item is sent to the printer, and the price is added to the sum of the Bill
     * @param item
     */
    public void addItem(Bill.Item item) {
        billP.printLine(item.toString(), item.getPrice());
        this.sum = this.sum + item.getPrice();
    }

    /**
     * Sends the sum total of the bill to the printer.
     */
    public void close() {
        billP.printLine("Total", sum);
    }

    /**
     * Returns the current sum total of the Bill.
     * @return
     */
    public double getSum() {
        return sum;
    }

}
