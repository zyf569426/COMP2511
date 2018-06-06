import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Invoice {
    private List<LineItem> items;
    private List<ChangeListener> listeners;

    public Invoice() {
        items = new ArrayList<LineItem>();
        listeners = new ArrayList<ChangeListener>();
    }

    public void addItem(LineItem item) {
        items.add(item);

        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners)
            listener.stateChanged(event);
    }

    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    public Iterator<LineItem> getItems() {
        return new
                Iterator<LineItem>() {
                    @Override
                    public boolean hasNext() {
                        return current < items.size();
                    }

                    @Override
                    public LineItem next() {
                        return items.get(current++);
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    private int current = 0;
                };
    }

    public String format(InvoiceFormatter formatter) {
        String r = formatter.formatHeader();
        Iterator<LineItem> iter = getItems();
        while (iter.hasNext())
            r += formatter.formatLineItem(iter.next());
        return r + formatter.formatFooter();
    }
}
