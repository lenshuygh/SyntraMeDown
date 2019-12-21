package handmedown.repository.implementation;

import handmedown.model.HandMeDown;
import handmedown.model.HandMeDownStatus;
import handmedown.repository.HandMeDownRepository;
import handmedown.repository.HandMeDownStatusSupport;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HandMeDownRepositoryImpl<E extends HandMeDown> implements HandMeDownRepository<E>, HandMeDownStatusSupport<E> {
    /*
        set because:
            no need for key-value pairs, only individual elements
            no need for duplicate support
            performant .contains() check
        */
    Map<HandMeDownStatus,Set<E>> handMeDownStatusMap = null;

    public HandMeDownRepositoryImpl() {
        if(handMeDownStatusMap == null){
            handMeDownStatusMap = new HashMap<>();
            handMeDownStatusMap.put(HandMeDownStatus.AVAILABLE,new HashSet<>());
            handMeDownStatusMap.put(HandMeDownStatus.UNAVAILABLE,new HashSet<>());
        }
    }

    @Override
    public void setStatus(E e, HandMeDownStatus status) {
        switch (status){
            case AVAILABLE:
                handMeDownStatusMap.get(HandMeDownStatus.UNAVAILABLE).remove(e);
                handMeDownStatusMap.get(HandMeDownStatus.AVAILABLE).add(e);
                break;
            case UNAVAILABLE:
                handMeDownStatusMap.get(HandMeDownStatus.AVAILABLE).remove(e);
                handMeDownStatusMap.get(HandMeDownStatus.UNAVAILABLE).add(e);
                break;
        }
    }

    @Override
    public HandMeDownStatus getStatus(E e) {
        if(handMeDownStatusMap.get(HandMeDownStatus.UNAVAILABLE).contains(e)){
            return HandMeDownStatus.UNAVAILABLE;
        }
        return HandMeDownStatus.AVAILABLE;
    }

    @Override
    public void add(E e) {
        handMeDownStatusMap.get(HandMeDownStatus.AVAILABLE).add(e);
    }

    @Override
    public Set<E> getAll() {
        return handMeDownStatusMap.get(HandMeDownStatus.AVAILABLE);
    }

    @Override
    public Set<E> getAll(String searchTerm) {
        final String regex = ".*" + searchTerm.toLowerCase() + ".*";
        return getAll().stream()
                .filter(
                        handMeDown -> handMeDown.getTitle().toLowerCase().matches(regex)
                                || handMeDown.getDescription().toLowerCase().matches(regex)
                )
                .collect(Collectors.toSet());
    }
}
