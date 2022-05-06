package com.company.service;

import java.io.IOException;
import java.util.Vector;

public interface GenericCSV<T>{
    void read() throws IOException;
    void write (T object) throws IOException;

}
