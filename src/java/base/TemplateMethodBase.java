package base;

public abstract class TemplateMethodBase {
	public void print() {
		this.doPrint();
	}

	protected abstract void doPrint();
}
