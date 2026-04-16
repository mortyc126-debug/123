package org.apache.commons.net.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ListenerList implements Serializable, Iterable<EventListener> {
    private static final long serialVersionUID = -1934227607974228213L;
    private final CopyOnWriteArrayList<EventListener> listeners = new CopyOnWriteArrayList<>();

    public void addListener(EventListener listener) {
        this.listeners.add(listener);
    }

    public int getListenerCount() {
        return this.listeners.size();
    }

    @Override // java.lang.Iterable
    public Iterator<EventListener> iterator() {
        return this.listeners.iterator();
    }

    private void readObject(ObjectInputStream in) {
        throw new UnsupportedOperationException("Serialization is not supported");
    }

    public void removeListener(EventListener listener) {
        this.listeners.remove(listener);
    }

    private void writeObject(ObjectOutputStream out) {
        throw new UnsupportedOperationException("Serialization is not supported");
    }
}
