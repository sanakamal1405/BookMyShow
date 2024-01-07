package com.bms.BookMyShow.strategies;

import com.bms.BookMyShow.entities.ShowSeats;
import com.bms.BookMyShow.execeptions.NoSuchMovie;

import java.util.List;

public interface PricingStrategy {

    Double calculate(List<ShowSeats> showSeats) throws NoSuchMovie;
}
