package com.finanza.cc_backend.domain.service;

import com.finanza.cc_backend.domain.model.Rate;

import java.util.List;

public interface RateService {
    List<Rate> getRatesByTermAndValue(double term, double value, String currency);
}
