package dev.lpa;

import java.time.LocalDate;

public enum Generation {

    GEN_Z(){

        {
            System.out.println("-------Special for " + this + " --------"); //Instance initializer
        }

    },
    MILLENNIAL(1981, 2000),
    GEN_X(1965, 1980),
    BABY_BOOMER(1946, 1964),
    SILENT_GENERATION(1927, 1945),
    GREATEST_GENERATION(1901, 1926);

    private int startYear;
    private int endYear;

    Generation() {
        this(2001, LocalDate.now().getYear());
    }

    Generation(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
        System.out.println(this + " " + startYear + " - " + endYear);
    }
}
