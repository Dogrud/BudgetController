
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgetcontroller.models.Expense
import com.example.budgetcontroller.models.Recurrence
import com.example.budgetcontroller.models.groupedByDayOfMonth
import com.example.budgetcontroller.ui.theme.LabelSecondary
import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.yaxis.SimpleYAxisDrawer

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth


@Composable
fun MonthlyChart(expenses: List<Expense>, month: LocalDate) {
  val groupedExpenses = expenses.groupedByDayOfMonth()
  val numberOfDays = YearMonth.of(month.year, month.month).lengthOfMonth()

  BarChart(
    barChartData = BarChartData(
      bars = buildList() {
        for (i in 1..numberOfDays) {
          add(BarChartData.Bar(
            label = "$i",
            value = groupedExpenses[i]?.total?.toFloat()
              ?: 0f,
            color = Color.White,
          ))
        }
      }
    ),
    labelDrawer = LabelDrawer(recurrence = Recurrence.Monthly, lastDay = numberOfDays),
    yAxisDrawer = SimpleYAxisDrawer(
      labelTextColor = LabelSecondary,
      labelValueFormatter = ::simplifyNumber,
      labelRatio = 7,
      labelTextSize = 14.sp
    ),
    barDrawer = BarDrawer(recurrence = Recurrence.Monthly),
    modifier = Modifier.fillMaxWidth()
      .height(height = 150.dp)
      .padding(top = 20.dp, bottom = 20.dp))



}


