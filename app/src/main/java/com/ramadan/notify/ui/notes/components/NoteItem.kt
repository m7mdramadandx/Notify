package com.ramadan.notify.ui.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.ramadan.notify.R
import com.ramadan.notify.domain.model.Note
import com.ramadan.notify.ui.theme.NotifyTheme

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    note: Note,
    onDeleteClick: () -> Unit,
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_xxsmall))
    ) {
        NoteItemLayout(modifier = modifier.matchParentSize(), noteColor = note.color)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = dimensionResource(id = R.dimen.padding_xsmall),
                    end = dimensionResource(id = R.dimen.padding_xsmall),
                    top = dimensionResource(id = R.dimen.padding_xsmall)
                ),
        ) {
            Text(
                modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_xxxlarge)),
                text = note.title,
                style = NotifyTheme.typography.titleMedium,
                color = NotifyTheme.colors.textPrimary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xxsmall)))
            Text(
                modifier = Modifier.fillMaxSize(),
                text = note.content,
                style = NotifyTheme.typography.bodyMedium,
                color = NotifyTheme.colors.textPrimary,
                overflow = TextOverflow.Ellipsis
            )
            IconButton(
                onClick = onDeleteClick,
                modifier = modifier.align(Alignment.End)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_delete),
                    tint = NotifyTheme.colors.iconInteractive,
                    contentDescription = null
                )
            }
        }
    }
}