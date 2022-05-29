package com.ramadan.notify.ui.toDos.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramadan.notify.R
import com.ramadan.notify.domain.model.ToDo
import com.ramadan.notify.ui.components.NotifyCard
import com.ramadan.notify.ui.theme.NotifyTheme


@Composable
fun ToDoItem(
    modifier: Modifier = Modifier,
    toDo: ToDo,
    onMarkClick: (Boolean) -> Unit,
    onDeleteClick: () -> Unit,
) {
    NotifyCard(
        modifier = modifier.padding(
            top = dimensionResource(id = R.dimen.padding_xxsmall),
            bottom = dimensionResource(id = R.dimen.padding_medium),
            start = dimensionResource(id = R.dimen.padding_medium),
            end = dimensionResource(id = R.dimen.padding_medium),
        ),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = dimensionResource(id = R.dimen.padding_medium),
                vertical = dimensionResource(id = R.dimen.padding_xxsmall)
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(8f),
                text = toDo.title,
                color = NotifyTheme.colors.textPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Checkbox(
                modifier = Modifier.weight(1f),
                checked = toDo.isDone,
                enabled = !toDo.isDone,
                onCheckedChange = {
                    toDo.isDone = true
                    onMarkClick.invoke(true)
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = NotifyTheme.colors.icon,
                    uncheckedColor = NotifyTheme.colors.icon,
                    checkmarkColor = NotifyTheme.colors.icon,
                    disabledColor = NotifyTheme.colors.border,
                )
            )

            Icon(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onDeleteClick.invoke() },
                painter = painterResource(id = R.drawable.ic_delete),
                tint = NotifyTheme.colors.error,
                contentDescription = "",
            )
        }
    }
}


@Composable
@Preview("default")
@Preview("dark theme", "rectangle", uiMode = UI_MODE_NIGHT_YES)
fun ToDoPreview() {
    NotifyCard(
        modifier = Modifier.padding(
            start = dimensionResource(id = R.dimen.padding_xxsmall),
            end = dimensionResource(id = R.dimen.padding_xxsmall),
            top = dimensionResource(id = R.dimen.padding_xxsmall),
            bottom = dimensionResource(id = R.dimen.padding_medium)
        ),
        shape = MaterialTheme.shapes.medium,
        elevation = dimensionResource(id = R.dimen.padding_xxsmall)
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = dimensionResource(id = R.dimen.padding_medium),
                vertical = 4.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(8f),
                text = "toDo.title",
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Checkbox(
                modifier = Modifier.weight(1f),
                checked = true, onCheckedChange = {})
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = null,
                )
            }
        }
    }
}

