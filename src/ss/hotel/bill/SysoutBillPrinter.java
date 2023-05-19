package ss.hotel.bill;

public class SysoutBillPrinter implements BillPrinter {

    @Override
    public void printLine(String text, double price) {
        System.out.println(format(text, price));
    }

    public static void main(String[] args) {
        SysoutBillPrinter printer = new SysoutBillPrinter();
        printer.printLine("bruh", 2.00);
    }
}
