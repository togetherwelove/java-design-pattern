package design.pattern.app.proxy;

import java.util.List;

public class PrinterProxy implements Printable {
	
	private String printerName;
	private List<Aspect> aspects;

	public PrinterProxy(String printerName, Aspect ...aspects) {
		this.printerName = printerName;
		this.aspects = List.of(aspects);
	}

	@Override
	public String print(String message) {
		Printer printer = new Printer(printerName);
		aspects.forEach(action -> action.before());
		String printedString = printer.print(message);
		aspects.forEach(action -> action.after());
		return printedString;
	}

}
