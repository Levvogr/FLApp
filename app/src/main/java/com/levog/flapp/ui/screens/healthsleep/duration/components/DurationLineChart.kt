package com.levog.flapp.ui.screens.healthsleep.duration.components

import android.graphics.Typeface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.extensions.formatToSinglePrecision
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.levog.flapp.R
import com.levog.flapp.data.room.sleep.SleepData
import com.levog.flapp.extension.toFormattedTimeString
import com.levog.flapp.extension.toFormattedTimeStringOnlyWeek

@Composable
fun DurationLineChart(
    items: List<SleepData>
){
    val xAxisValues= listOf(
        "",
        items[6].endSleep.toFormattedTimeStringOnlyWeek(),
        items[5].endSleep.toFormattedTimeStringOnlyWeek(),
        items[4].endSleep.toFormattedTimeStringOnlyWeek(),
        items[3].endSleep.toFormattedTimeStringOnlyWeek(),
        items[2].endSleep.toFormattedTimeStringOnlyWeek(),
        items[1].endSleep.toFormattedTimeStringOnlyWeek(),
        items[0].endSleep.toFormattedTimeStringOnlyWeek(),
        ""
    )
    /*val xAxisValues= listOf(
        "",
        "пн",
        "вт",
        "ср",
        "чт",
        "пт",
        "сб",
        "вс",
        ""
    )*/
    val yMinValue: Float = 0f
    val yMaxValue: Float = 24f

    val stepsY = 8
    val xAxisData = AxisData.Builder()
        .axisStepSize(40.dp)
        .steps(8)
        .labelData { i ->xAxisValues[i] }
        .labelAndAxisLinePadding(25.dp)
        .build()
    val yAxisData = AxisData.Builder()
        .steps(stepsY)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = (yMaxValue - yMinValue) / stepsY
            ((i * yScale) + yMinValue).formatToSinglePrecision()
        }.build()

    val data = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = listOf(
                        Point(0f, 0f),
                        Point(0f, 24f)
                    ),
                    LineStyle(color = MaterialTheme.colorScheme.background),
                ),
                Line(
                    dataPoints = listOf(
                        Point(0f, 0f),
                        Point(8f, 0f)
                    ),
                    LineStyle(color = MaterialTheme.colorScheme.background),
                ),
                Line(
                    dataPoints = listOf(
                        Point(1f, 0f),
                        Point(1f, (items[6].endSleep - items[6].startSleep)
                            .toFormattedTimeString()
                            .substring(0,2)
                            .toFloat())
                    ),
                    lineStyle = LineStyle(
                        lineType = LineType.Straight(),
                        color = MaterialTheme.colorScheme.primary
                    )
                ),
                Line(
                    dataPoints = listOf(
                        Point(2f, 0f),
                        Point(2f, (items[5].endSleep - items[5].startSleep)
                            .toFormattedTimeString()
                            .substring(0,2)
                            .toFloat())
                    ),
                    lineStyle = LineStyle(
                        lineType = LineType.Straight(),
                        color = MaterialTheme.colorScheme.primary
                    )
                ),
                Line(
                    dataPoints = listOf(
                        Point(3f, 0f),
                        Point(3f, (items[4].endSleep - items[4].startSleep)
                            .toFormattedTimeString()
                            .substring(0,2)
                            .toFloat())
                    ),
                    lineStyle = LineStyle(
                        lineType = LineType.Straight(),
                        color = MaterialTheme.colorScheme.primary
                    )
                ),
                Line(
                    dataPoints = listOf(
                        Point(4f, 0f),
                        Point(4f, (items[3].endSleep - items[3].startSleep)
                            .toFormattedTimeString()
                            .substring(0,2)
                            .toFloat())
                    ),
                    lineStyle = LineStyle(
                        lineType = LineType.Straight(),
                        color = MaterialTheme.colorScheme.primary
                    )
                ),
                Line(
                    dataPoints = listOf(
                        Point(5f, 0f),
                        Point(5f, (items[2].endSleep - items[2].startSleep)
                            .toFormattedTimeString()
                            .substring(0,2)
                            .toFloat())
                    ),
                    lineStyle = LineStyle(
                        lineType = LineType.Straight(),
                        color = MaterialTheme.colorScheme.primary
                    )
                ),
                Line(
                    dataPoints = listOf(
                        Point(6f, 0f),
                        Point(6f, (items[1].endSleep - items[1].startSleep)
                            .toFormattedTimeString()
                            .substring(0,2)
                            .toFloat())
                    ),
                    lineStyle = LineStyle(
                        lineType = LineType.Straight(),
                        color = MaterialTheme.colorScheme.primary
                    )
                ),
                Line(
                    dataPoints = listOf(
                        Point(7f, 0f),
                        Point(7f, (items[0].endSleep - items[0].startSleep)
                                .toFormattedTimeString()
                                .substring(0,2)
                                .toFloat())
                    ),
                    lineStyle = LineStyle(
                        lineType = LineType.Straight(),
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            )
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(enableVerticalLines = false)
    )

    Column(modifier = Modifier.height(400.dp)) {
        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            lineChartData = data
        )
        Text(
            modifier = Modifier.padding(start = 30.dp,end=15.dp, top=15.dp),
            text = stringResource(R.string.duration_chart_description)+" за последние семь дней")
    }
}