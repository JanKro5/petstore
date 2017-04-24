package pl.pcz.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
public class petstore implements EntryPoint {

    private FlexTable table = new FlexTable();
    private Label id = new Label("123");
    private Label name = new Label("Spot");
    private Label category = new Label("reserved");

    public void onModuleLoad() {
	// Sample pet data.
	final Label clickInfo = new HTML("Table Click: \n");
	table.setText(0, 0, "123");
	table.setText(0, 1, "Spot");
	table.addClickHandler(new ClickHandler() {
		int x =0;
	   	public void onClick(ClickEvent event) {
			Cell cell = table.getCellForEvent(event);
			int receiverRowIndex = cell.getRowIndex(); // <- here!
			++x;
			table.setText(x,0,receiverRowIndex+"");
			table.setText(x,1,cell.getElement().getInnerHTML());
	
    		}
	});

	Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {
		int s=0;
		int m=0;
		int h =0;
	        @Override
	    	public boolean execute() {
			++s;
			if(s>60){
				m++;
				s=0;
			}
			if(m>60){
				m=0;
				h++;
			}
			if(h>24){
				h=0;
			}
			clickInfo.setText(h+":"+m+":"+s+"");
			return true;
	        }
	},1000);

	VerticalPanel right = new VerticalPanel();
	FlowPanel f1 = new FlowPanel();
	f1.add(new Label("ID:"));
	f1.add(id);
	FlowPanel f2 = new FlowPanel();
	f2.add(new Label("Name:"));
	f2.add(name);
	FlowPanel f3 = new FlowPanel();
	f3.add(new Label("Category:"));
	f3.add(category);
	right.add(f1);
	right.add(f2);
	right.add(f3);

	HorizontalPanel middle = new HorizontalPanel();
	middle.add(table);
	middle.add(right);
	middle.add(clickInfo);
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
