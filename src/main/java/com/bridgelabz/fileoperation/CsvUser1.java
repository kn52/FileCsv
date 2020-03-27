package com.bridgelabz.fileoperation;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class CsvUser1 {
    @CsvBindByPosition(position = 1)
    public String name;
    @CsvBindByPosition(position = 2)
    public String email;
    @CsvBindByPosition(position = 3)
    public String phoneNo;
    @CsvBindByPosition(position = 4)
    public String country;

}
