package com.ramadan.notify.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ramadan.notify.R
import com.ramadan.notify.ui.theme.NotifyShape
import com.ramadan.notify.ui.theme.NotifyTheme

@Composable
fun NotifyCard(
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = NotifyShape.shapes.medium,
    color: Color = NotifyTheme.colors.cardBg,
    contentColor: Color = NotifyTheme.colors.textPrimary,
    border: BorderStroke? = null,
    elevation: Dp = 10.dp,
    content: @Composable () -> Unit,
) {
    NotifySurface(
        modifier = modifier,
        shape = shape,
        color = color,
        contentColor = contentColor,
        elevation = elevation,
        border = border,
        content = content
    )
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
private fun CardPreview() {
    NotifyCard {
        Text(text = "Demo",
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)))
    }
}
