package com.example.budgetcontroller.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.budgetcontroller.models.Category
import com.example.budgetcontroller.ui.theme.Shapes
import com.example.budgetcontroller.ui.theme.Typography


@Composable
fun CategoryBadge(category: Category,modifier: Modifier = Modifier) {
Surface (
    shape = Shapes.large,
    color = category.color.copy(alpha = 0.25f),
    modifier = modifier
    ){
    Text(category.name, color = category.color, style = Typography.bodySmall)
}

}