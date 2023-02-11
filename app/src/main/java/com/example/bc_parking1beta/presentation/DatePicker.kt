package com.example.bc_parking1beta.presentation

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.DateFormat
import java.util.Calendar

class DatePicker: DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c :Calendar = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(),this ,year, month, day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val c :Calendar = Calendar.getInstance()
        c.set(Calendar.YEAR, year)
        c.set(Calendar.MONTH, month)
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        val stringOfDate = DateFormat.getDateInstance().format(c.time)

    }

//    val datePicker =
//        MaterialDatePicker.Builder.datePicker()
//            .setTitleText("Select date")
//            // Opens the date picker with today's date selected.
//            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
//            .build()
//
//    datePicker.show()


}