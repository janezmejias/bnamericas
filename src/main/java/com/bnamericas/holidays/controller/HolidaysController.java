package com.bnamericas.holidays.controller;

import com.bnamericas.api.Constants;
import com.bnamericas.api.ControllerBase;
import com.bnamericas.holidays.model.Holidays;
import com.bnamericas.holidays.service.HolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.URI_HOLIDAYS)
@Lazy
@CrossOrigin
public class HolidaysController extends ControllerBase<Holidays> {

    @Autowired
    public HolidaysController(HolidaysService service) {
        super(service);
    }
}
