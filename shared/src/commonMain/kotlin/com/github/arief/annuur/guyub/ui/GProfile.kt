package com.github.arief.annuur.guyub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.arief.annuur.guyub.form.ModifierForm
import com.github.arief.annuur.guyub.model.UIField
import com.seiko.imageloader.rememberImagePainter

@Composable
fun GProfile(data: UIField.Profile) {

    val painterUser = rememberImagePainter(data.userField.imgAvatar)
    LazyColumn {
        item {
            Row (modifier = ModifierForm.padding(top = 8.dp)) {
                Image(
                    painter = painterUser,
                    modifier = Modifier.width(48.dp).height(48.dp)
                        .clip(CircleShape),
                    contentDescription = "avatar"
                )
                Column {
                    Text(
                        text = data.userField.realName,
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.subtitle1
                    )
                    Text(
                        text = data.userField.username,
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }

        items(data.settings) {
            Column (ModifierForm) {
                Row {
                    Text(it)
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "icon"
                    )
                }

                Divider(modifier = Modifier.padding(top = 8.dp), color = Color.Gray, thickness = 0.3.dp)
            }
        }
    }
}