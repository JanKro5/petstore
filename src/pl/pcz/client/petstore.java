package pl.pcz.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class petstore implements EntryPoint {

    private FlexTable table = new FlexTable();
    private Label id = new Label("123");
    private Label name = new Label("Spot");
    private Label category = new Label("reserved");

    public void onModuleLoad() {
	// Sample pet data.
	table.setText(0, 0, "123");
	table.setText(0, 1, "Spot");

	VerticalPanel right = new VerticalPanel();
	FlowPanel f1 = new FlowPanel();
	f1.add(new Label("ID:"));
	f1.add(id);
	FlowPanel f2 = new FlowPanel();
	f1.add(new Label("Name:"));
	f1.add(name);
	FlowPanel f3 = new FlowPanel();
	f1.add(new Label("Category:"));
	f1.add(category);
	right.add(f1);
	right.add(f2);
	right.add(f3);

	HorizontalPanel middle = new HorizontalPanel();
	middle.add(table);
	middle.add(right);
	middle.addStyleName("middle");
	Label header = new Label("Petstore");
	header.addStyleName("header");
	FlowPanel footer = new FlowPanel();
	footer.add(new Label("Kontakt: "));
	footer.add(new Anchor("office@petstore.pcz.pl",
			      "mailto: office@petstore.pcz.pl"));

	footer.addStyleName("footer");
	VerticalPanel vp = new VerticalPanel();
	vp.add(header);
	vp.add(middle);
	vp.add(footer);
	vp.addStyleName("page");
	RootPanel.get().add(vp);
    }
}
