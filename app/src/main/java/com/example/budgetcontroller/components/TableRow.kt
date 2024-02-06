package com.example.budgetcontroller.components

import android.webkit.RenderProcessGoneDetail
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.budgetcontroller.ui.theme.Typography

@Composable
fun TableRow(label: String,modifier: Modifier = Modifier, hasArrow: Boolean = false ,isDestructive:Boolean = false,content: (@Composable RowScope.()->Unit)? = null) {
    val textColor = if(isDestructive == true) Destructive else TextPrimary


Row(modifier   = modifier
    .fillMaxWidth().padding(horizontal = 16.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
) {
    Text(text = label, color = textColor, style = Typography.bodyMedium,modifier = Modifier.padding( vertical = 10.dp),)
    if(hasArrow) {
       Icon(painterResource(id = R.drawable.baseline_arrow_forward_24),contentDescription = "Right Arrow",modifier = Modifier.padding(vertical = 10.dp))
    }
    if (content != null)
    {
        content()
    }

}



}