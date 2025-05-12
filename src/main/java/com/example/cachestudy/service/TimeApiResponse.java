package com.example.cachestudy.service;

public record TimeApiResponse(
        int year,
        int month,
        int day,
        int hour,
        int minute,
        int seconds,
        int milliSeconds,
        String dateTime,
        String date,
        String time,
        String timeZone,
        String dayOfWeek,
        boolean dstActive
) {}
