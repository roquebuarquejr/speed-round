/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.ListItemDto
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun CardItemList(items: List<ListItemDto>) {
    val listState = rememberLazyListState()
    val chunkedItems = items.chunked(2)
    LazyRow(
        state = listState,
        contentPadding = PaddingValues(start = 16.dp)
    ) {
        itemsIndexed(chunkedItems) { _, chunk ->
            Column {
                chunk.forEach { item ->
                    CardItem(item)
                    Spacer(Modifier.size(8.dp))
                }
            }
            Spacer(Modifier.size(8.dp))
        }
    }
}

@Composable
fun CardItem(favoriteItem: ListItemDto) {
    Card(
        modifier = Modifier
            .width(192.dp)
            .height(56.dp),
        elevation = 0.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(favoriteItem.image),
                contentDescription = "Item Image",
                contentScale = ContentScale.FillBounds,
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp),
                text = favoriteItem.title,
                color = MaterialTheme.colors.onSurface,
                style = typography.h3
            )
        }
    }
}
