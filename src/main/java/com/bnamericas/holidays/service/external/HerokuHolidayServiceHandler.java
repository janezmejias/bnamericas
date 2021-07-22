package com.bnamericas.holidays.service.external;

import com.bnamericas.api.BaseAPIService;
import com.bnamericas.holidays.model.Holidays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Lazy
public class HerokuHolidayServiceHandler extends BaseAPIService {

    private HerokuHolidayService caller;

    @PostConstruct
    private void init() {
        caller = this.createService(HerokuHolidayService.class);
    }

    public List<Holidays> holidays() throws Exception {
        Call<List<Holidays>> retrofitCall = caller.holidays();
        return retrofitCall.execute().body();
    }

    @Override
    @Value("${external.api}")
    public void setUrl(String url) {
        this.url = url;
    }

}
