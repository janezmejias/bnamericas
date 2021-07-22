package com.bnamericas.holidays.service.external;

import com.bnamericas.holidays.model.Holidays;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface HerokuHolidayService {

    @GET("/feriados")
    Call<List<Holidays>> holidays();

}
