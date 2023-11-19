package design.pattern.app.proxy;

public class Printer implements Printable {

	private String printerName;

	public Printer(String printerName) {
		this.printerName = printerName;
	}

	@Override
	public String print(String message) {
		String printedString =
				"<" + printerName + ">"  +
				message +
				"</" + printerName + ">";
		return printedString;
	}
}
