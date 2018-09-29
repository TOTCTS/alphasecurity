package org.best.alpha.base;

public interface BaseManager<E, S> {

    void createVerification(E e);

    void updateVerification(E e);

    void queryVerification(S s);

    void pageVerification(S s);

}
