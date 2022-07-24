package io.muic.ooc.fab.view;

import io.muic.ooc.fab.Field;

import javax.security.auth.Subject;

public abstract class Observable {

    protected abstract void notifyAllObservers(int count, Field field);

    protected abstract void addObserver(Observer observer);
}

