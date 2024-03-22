package com.example.budgetcontroller.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.budgetcontroller.models.Expense
import com.example.budgetcontroller.ui.theme.LabelSecondary
import com.example.budgetcontroller.ui.theme.Typography
import com.nikolovlazar.goodbyemoney.utils.formatDayForRange
import java.text.DecimalFormat
import java.time.format.DateTimeFormatter


@Composable
fun ExpenseRow(expense: Expense, modifier: Modifier = Modifier) {

    Column (modifier = modifier, ){
        Row(modifier = Modifier.fillMaxWidth(),Arrangement.SpaceBetween){
            Text(text = expense.note ?: expense.category.name, style = Typography.headlineMedium)
            Text(text = "USD ${DecimalFormat("0.#").format(expense.amount)}", style = Typography.headlineMedium)


        }

        Row (modifier = Modifier.fillMaxWidth().padding(top = 6.dp),Arrangement.SpaceBetween){
            CategoryBadge(category = expense.category)
            Text(text =expense.date.format(DateTimeFormatter.ofPattern("HH:mm")), style = Typography.bodyMedium, color = LabelSecondary )

        }
    }


}