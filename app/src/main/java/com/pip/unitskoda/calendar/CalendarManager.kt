package com.pip.unitskoda.calendar

import android.provider.CalendarContract.Calendars
import android.content.Context
import android.util.Log
import it.macisamuele.calendarprovider.CalendarInfo
import it.macisamuele.calendarprovider.EventInfo
import java.util.*


class CalendarManager public @Inject constructor(val context : Context) {

    fun getCalendars(): List<CalendarInfo> {
        return CalendarInfo.getAllCalendars(context)
    }

    fun getCalendarStrings(calendars: List<CalendarInfo>): List<String> {
        return calendars.map { it.displayName }
    }

    fun getCurrentEventsOfCalendar(calendar: CalendarInfo): List<EventInfo> {
        return EventInfo.getEvents(context, Date(), Date(), listOf(calendar.id.toInt()), null)
    }

    fun getAttendeesOfEvent(eventInfo: EventInfo, userModels: List<String>): List<Attendee> {
        return AttendeesContentResolver(context).getAttendees(eventInfo.id, userModels)
    }
}