package handmedown.repository;

import handmedown.model.HandMeDown;
import handmedown.model.HandMeDownStatus;

public interface HandMeDownStatusSupport<E extends HandMeDown> {
    void setStatus(E e, HandMeDownStatus status);

    HandMeDownStatus getStatus(E e);
}
