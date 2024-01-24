package com.example.budgetcontroller.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.budgetcontroller.R
import com.example.budgetcontroller.ui.theme.Destructive
import com.example.budgetcontroller.ui.theme.TextPrimary

@Composable
fun TableRow(label: String, hasArrow: Boolean = false ,isDestructive:Boolean = false) {
    val textColor = if(isDestructive == true) Destructive else TextPrimary

Row(modifier   = Modifier
    .fillMaxWidth()
    .padding(horizontal = 16.dp, vertical = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
    Text(text = label, style = TextStyle(fontFamily = FontFamily.Default, color = textColor))
    if(hasArrow) {
       Icon(painterResource(id = R.drawable.baseline_arrow_forward_24),contentDescription = "Right Arrow")
    }
}



}