package com.example.budgetcontroller.models

sealed class Recurrence(val name: String, val target: String){


    object None: Recurrence("None","None")
    object Daily: Recurrence("Daily","Day")
    object Weekly: Recurrence("Weekly","Week")
    object Monthly: Recurrence("Monthly","Month")
    object Yearly: Recurrence("Yearly","Year")





}

val recurrences = listOf(Recurrence.None,Recurrence.Daily)
val recurrence = recurrences[0]


