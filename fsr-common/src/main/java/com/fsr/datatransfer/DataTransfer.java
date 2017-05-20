package com.fsr.datatransfer;

import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
public interface DataTransfer<T, E> {
    public List<E> transfer(List<T> list);
}
