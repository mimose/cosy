package com.mimose.cosy.monitors;

import com.mimose.cosy.api.function.IFunction;
import com.mimose.cosy.excepitons.utils.Asserts;
import com.mimose.cosy.lang.Objs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.*;

/**
 * @author mimose
 * @description program application timer
 * @date 2021/5/23
 */
public class Timer {

    private ChronoUnit chronoUnit;

    protected LocalDateTime startTime;

    protected LocalDateTime endTime;

    protected Long consuming;

    protected Timer() {}

    private static IFunction<Timer, Long> CAL_CONSUMING = timer -> {
        if(Objs.isNull(timer)) {
            return Long.valueOf(-1);
        }
        if(Objs.isNull(timer.getStartTime()) || Objs.isNull(timer.getEndTime())) {
            return Long.valueOf(-1);
        }
        Period period = Period.between(LocalDate.from(timer.getStartTime()), LocalDate.from(timer.getEndTime()));
        switch (timer.getChronoUnit()) {
            case YEARS:
                return (long) period.getYears();
            case MONTHS:
                return (long) (period.getYears() * 12 + period.getMonths());
            default:
                return timer.getChronoUnit().between(timer.getStartTime(), timer.getEndTime());
        }
    };

    public static Timer open() {
        return open(MILLIS);
    }
    public static Timer open(ChronoUnit chronoUnit) {
        Asserts.notNull(chronoUnit, "Fail to open a Timer, miss ChronoUnit!");
        final Timer timer = new Timer();
        timer.chronoUnit = chronoUnit;
        return timer;
    }

    public Timer watch() {
        this.startTime = LocalDateTime.now();
        return this;
    }

    public Timer stopWatch() {
        this.endTime = LocalDateTime.now();
        this.consuming = CAL_CONSUMING.apply(this);
        return this;
    }

    private ChronoUnit getChronoUnit() {
        return chronoUnit;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Long getConsuming() {
        return consuming;
    }

}
